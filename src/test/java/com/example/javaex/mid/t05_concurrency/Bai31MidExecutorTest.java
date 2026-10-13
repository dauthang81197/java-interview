package com.example.javaex.mid.t05_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 60, unit = TimeUnit.SECONDS)
class Bai31MidExecutorTest {

    @Test
    void squareAllKeepsOrder() {
        assertEquals(List.of(1, 4, 9, 16, 25, 36, 49, 64, 81, 100),
                Bai31MidExecutor.squareAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3));
        assertEquals(List.of(), Bai31MidExecutor.squareAll(List.of(), 2));
    }

    @Test
    void squareAllDoesNotLeakThreads() throws Exception {
        int before = Thread.activeCount();
        for (int i = 0; i < 20; i++) Bai31MidExecutor.squareAll(List.of(1, 2, 3), 4);
        Thread.sleep(500);
        assertTrue(Thread.activeCount() <= before + 2, "executor phải được shutdown");
    }

    @Test
    void runAllKeepsOrderOfTasks() {
        List<Callable<String>> tasks = List.of(
                () -> {
                    Thread.sleep(150);
                    return "a";
                },
                () -> "b",
                () -> "c");
        assertEquals(List.of("a", "b", "c"), Bai31MidExecutor.runAll(tasks, 3));
    }

    @Test
    void runAllPropagatesFailure() {
        List<Callable<String>> tasks = List.of(() -> "ok", () -> {
            throw new IllegalStateException("boom");
        });
        assertThrows(RuntimeException.class, () -> Bai31MidExecutor.runAll(tasks, 2));
    }

    @Test
    void failureMessageComesFromExecutionExceptionCause() {
        assertEquals("boom", Bai31MidExecutor.resultOrFailureMessage(() -> {
            throw new IllegalStateException("boom");
        }));
        assertEquals("fine", Bai31MidExecutor.resultOrFailureMessage(() -> "fine"));
    }

    @Test
    void gracefulShutdownWhenTasksFinish() throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.submit(() -> 1);
        assertTrue(Bai31MidExecutor.shutdownGracefully(ex, 5000));
        assertTrue(ex.isShutdown());
        assertTrue(ex.isTerminated());
    }

    @Test
    void forcedShutdownWhenTasksHang() throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(1);
        CountDownLatch started = new CountDownLatch(1);
        ex.submit(() -> {
            started.countDown();
            try {
                Thread.sleep(60_000);
            } catch (InterruptedException ignored) {
            }
        });
        assertTrue(started.await(10, TimeUnit.SECONDS));
        assertFalse(Bai31MidExecutor.shutdownGracefully(ex, 200));
        assertTrue(ex.isShutdown());
        assertTrue(ex.awaitTermination(10, TimeUnit.SECONDS), "shutdownNow phải ngắt task đang treo");
    }

    @Test
    void namedDaemonPoolThreads() throws Exception {
        ExecutorService ex = Bai31MidExecutor.namedDaemonPool(2, "worker");
        try {
            CountDownLatch both = new CountDownLatch(2);
            List<String> names = java.util.Collections.synchronizedList(new ArrayList<>());
            List<Boolean> daemons = java.util.Collections.synchronizedList(new ArrayList<>());
            for (int i = 0; i < 2; i++) {
                ex.submit(() -> {
                    names.add(Thread.currentThread().getName());
                    daemons.add(Thread.currentThread().isDaemon());
                    both.countDown();
                    try {
                        both.await(10, TimeUnit.SECONDS);
                    } catch (InterruptedException ignored) {
                    }
                });
            }
            assertTrue(both.await(10, TimeUnit.SECONDS));
            assertEquals(2, names.size());
            assertEquals(2, new java.util.HashSet<>(names).size(), "hai thread phải khác tên");
            for (String n : names) assertTrue(n.startsWith("worker-"), n);
            assertTrue(daemons.stream().allMatch(b -> b));
        } finally {
            ex.shutdownNow();
        }
    }

    @Test
    void submitAfterShutdownIsRejected() {
        assertTrue(Bai31MidExecutor.rejectedAfterShutdown());
    }
}
