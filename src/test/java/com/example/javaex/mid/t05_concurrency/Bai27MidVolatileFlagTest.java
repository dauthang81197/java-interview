package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.mid.t05_concurrency.Bai27MidVolatileFlag.StoppableWorker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai27MidVolatileFlagTest {

    @Test
    void workerSeesStopFlagFromAnotherThread() throws Exception {
        StoppableWorker w = new StoppableWorker();
        w.start();
        long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
        while (w.iterations() == 0 && System.nanoTime() < deadline) {
            Thread.sleep(10);
        }
        assertTrue(w.iterations() > 0, "worker phải chạy và iterations() phải thấy được từ luồng khác");
        assertTrue(w.stopAndAwait(10_000), "worker phải dừng sau khi stop");
    }

    @Test
    void stopOnIdleWorkerIsSafe() throws Exception {
        StoppableWorker w = new StoppableWorker();
        w.start();
        assertTrue(w.stopAndAwait(10_000));
        assertTrue(w.stopAndAwait(10_000));
    }

    @Test
    void dataWrittenBeforeVolatileWriteIsVisibleAfterVolatileRead() throws Exception {
        for (int i = 0; i < 50; i++) {
            assertEquals("hello", Bai27MidVolatileFlag.publishAndRead());
        }
    }

    @Test
    void volatileIncrementIsNotAtomic() throws Exception {
        int r = Bai27MidVolatileFlag.volatileIncrementRace(8, 50_000);
        assertTrue(r > 0 && r <= 400_000, "kết quả " + r);
        assertEquals(1000, Bai27MidVolatileFlag.volatileIncrementRace(1, 1000));
    }
}
