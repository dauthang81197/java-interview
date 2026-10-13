package com.example.javaex.junior.t06_concurrency;

import com.example.javaex.junior.t06_concurrency.Bai15JrRaceCondition.SyncBlockCounter;
import com.example.javaex.junior.t06_concurrency.Bai15JrRaceCondition.SyncMethodCounter;
import com.example.javaex.junior.t06_concurrency.Bai15JrRaceCondition.UnsafeCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 60, unit = TimeUnit.SECONDS)
class Bai15JrRaceConditionTest {

    @Test
    void synchronizedMethodCounterIsExact() throws Exception {
        assertEquals(400_000, Bai15JrRaceCondition.runConcurrently(new SyncMethodCounter(), 8, 50_000));
    }

    @Test
    void synchronizedBlockCounterIsExact() throws Exception {
        assertEquals(400_000, Bai15JrRaceCondition.runConcurrently(new SyncBlockCounter(), 8, 50_000));
    }

    @Test
    void unsafeCounterNeverExceedsButMayLose() throws Exception {
        int r = Bai15JrRaceCondition.runConcurrently(new UnsafeCounter(), 8, 50_000);
        assertTrue(r > 0 && r <= 400_000, "kết quả " + r);
    }

    @Test
    void singleThreadIsAlwaysExact() throws Exception {
        assertEquals(1000, Bai15JrRaceCondition.runConcurrently(new UnsafeCounter(), 1, 1000));
        assertEquals(0, Bai15JrRaceCondition.runConcurrently(new SyncBlockCounter(), 4, 0));
    }

    @Test
    void synchronizedMethodAndSynchronizedThisShareTheSameLock() throws Exception {
        assertTrue(Bai15JrRaceCondition.methodAndThisBlockShareLock());
    }

    @Test
    void staticAndInstanceSynchronizationUseDifferentLocks() throws Exception {
        assertTrue(Bai15JrRaceCondition.staticAndInstanceLocksAreDifferent());
    }
}
