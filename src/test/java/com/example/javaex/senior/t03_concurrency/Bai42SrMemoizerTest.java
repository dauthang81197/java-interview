package com.example.javaex.senior.t03_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai42SrMemoizerTest {

    @Test
    void computesOncePerKeyUnderContention() throws Exception {
        AtomicInteger calls = new AtomicInteger();
        Bai42SrMemoizer<Integer, Integer> m = new Bai42SrMemoizer<>(k -> {
            calls.incrementAndGet();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return k * 2;
        });
        int threads = 16;
        CountDownLatch start = new CountDownLatch(1);
        List<Thread> ts = new ArrayList<>();
        AtomicInteger wrong = new AtomicInteger();
        for (int t = 0; t < threads; t++) {
            Thread th = new Thread(() -> {
                try {
                    start.await();
                } catch (InterruptedException e) {
                    return;
                }
                for (int k = 0; k < 10; k++) {
                    if (m.get(k) != k * 2) wrong.incrementAndGet();
                }
            });
            ts.add(th);
            th.start();
        }
        start.countDown();
        for (Thread t : ts) t.join();
        assertEquals(0, wrong.get());
        assertEquals(10, calls.get(), "mỗi khoá chỉ được tính một lần");
    }

    @Test
    void differentKeysComputeInParallel() throws Exception {
        Bai42SrMemoizer<String, String> m = new Bai42SrMemoizer<>(k -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return k.toUpperCase();
        });
        long start = System.nanoTime();
        Thread t1 = new Thread(() -> m.get("a"));
        Thread t2 = new Thread(() -> m.get("b"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertTrue(ms < 700, "hai khoá khác nhau phải tính song song, thực tế " + ms + "ms");
        assertEquals("A", m.get("a"));
    }

    @Test
    void exceptionsAreNotCached() {
        AtomicInteger calls = new AtomicInteger();
        Bai42SrMemoizer<String, String> m = new Bai42SrMemoizer<>(k -> {
            if (calls.incrementAndGet() == 1) throw new IllegalStateException("lần đầu lỗi");
            return "ok";
        });
        assertThrows(RuntimeException.class, () -> m.get("k"));
        assertEquals("ok", m.get("k"));
        assertEquals("ok", m.get("k"));
        assertEquals(2, calls.get());
    }
}
