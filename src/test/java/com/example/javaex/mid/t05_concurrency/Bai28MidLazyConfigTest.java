package com.example.javaex.mid.t05_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai28MidLazyConfigTest {

    @Test
    void lazyAndCreatedExactlyOnce() throws Exception {
        assertEquals(0, Bai28MidLazyConfig.CREATED.get(), "chưa gọi getInstance thì chưa được tạo (lazy)");
        int threads = 64;
        CountDownLatch start = new CountDownLatch(1);
        Bai28MidLazyConfig[] seen = new Bai28MidLazyConfig[threads];
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            final int idx = i;
            Thread t = new Thread(() -> {
                try {
                    start.await();
                } catch (InterruptedException e) {
                    return;
                }
                seen[idx] = Bai28MidLazyConfig.getInstance();
            });
            ts.add(t);
            t.start();
        }
        start.countDown();
        for (Thread t : ts) t.join();
        assertEquals(1, Bai28MidLazyConfig.CREATED.get());
        for (Bai28MidLazyConfig c : seen) assertSame(seen[0], c);
        assertNotNull(seen[0]);
    }
}
