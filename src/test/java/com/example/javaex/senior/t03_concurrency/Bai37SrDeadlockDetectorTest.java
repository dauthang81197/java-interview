package com.example.javaex.senior.t03_concurrency;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Bai37SrDeadlockDetectorTest {

    @Test
    @Order(1)
    void noDeadlockReturnsEmptyList() {
        // Có thể JVM đã có deadlock rò từ test khác: so với baseline thay vì khẳng định rỗng tuyệt đối.
        assertEquals(baselineNames(), Bai37SrDeadlockDetector.findDeadlockedThreadNames());
    }

    @Test
    @Order(2)
    void detectsSynchronizedDeadlock() throws Exception {
        Object l1 = new Object(), l2 = new Object();
        CountDownLatch bothHoldFirst = new CountDownLatch(2);
        Thread a = new Thread(() -> {
            synchronized (l1) {
                bothHoldFirst.countDown();
                await(bothHoldFirst);
                synchronized (l2) {
                    // không bao giờ tới
                }
            }
        }, "dl-sync-A");
        Thread b = new Thread(() -> {
            synchronized (l2) {
                bothHoldFirst.countDown();
                await(bothHoldFirst);
                synchronized (l1) {
                }
            }
        }, "dl-sync-B");
        a.setDaemon(true);
        b.setDaemon(true);
        a.start();
        b.start();
        List<String> names = waitForDeadlock("dl-sync-A", "dl-sync-B");
        assertTrue(names.containsAll(List.of("dl-sync-A", "dl-sync-B")), names.toString());
    }

    @Test
    @Order(3)
    void detectsLockDeadlock() throws Exception {
        ReentrantLock l1 = new ReentrantLock(), l2 = new ReentrantLock();
        CountDownLatch bothHoldFirst = new CountDownLatch(2);
        Thread a = new Thread(() -> {
            l1.lock();
            bothHoldFirst.countDown();
            await(bothHoldFirst);
            l2.lock();
        }, "dl-lock-A");
        Thread b = new Thread(() -> {
            l2.lock();
            bothHoldFirst.countDown();
            await(bothHoldFirst);
            l1.lock();
        }, "dl-lock-B");
        a.setDaemon(true);
        b.setDaemon(true);
        a.start();
        b.start();
        List<String> names = waitForDeadlock("dl-lock-A", "dl-lock-B");
        assertTrue(names.containsAll(List.of("dl-lock-A", "dl-lock-B")), names.toString());
        assertEquals(names.stream().sorted().toList(), names, "phải sắp xếp tăng dần");
    }

    private static List<String> baselineNames() {
        java.lang.management.ThreadMXBean b = java.lang.management.ManagementFactory.getThreadMXBean();
        long[] ids = b.findDeadlockedThreads();
        if (ids == null) return List.of();
        return java.util.Arrays.stream(b.getThreadInfo(ids)).filter(java.util.Objects::nonNull)
                .map(java.lang.management.ThreadInfo::getThreadName).sorted().toList();
    }

    private static List<String> waitForDeadlock(String... expected) throws InterruptedException {
        List<String> names = List.of();
        for (int i = 0; i < 100; i++) {
            names = Bai37SrDeadlockDetector.findDeadlockedThreadNames();
            if (names.containsAll(List.of(expected))) break;
            Thread.sleep(50);
        }
        return names;
    }

    private static void await(CountDownLatch l) {
        try {
            l.await();
        } catch (InterruptedException ignored) {
        }
    }
}
