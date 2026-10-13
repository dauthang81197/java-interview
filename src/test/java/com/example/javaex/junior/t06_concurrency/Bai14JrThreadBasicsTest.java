package com.example.javaex.junior.t06_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai14JrThreadBasicsTest {

    @Test
    void runExecutesOnCallerThread() {
        assertEquals(Thread.currentThread().getName(), Bai14JrThreadBasics.threadNameOfRun());
    }

    @Test
    void startExecutesOnNewThread() throws Exception {
        assertEquals("worker-1", Bai14JrThreadBasics.threadNameOfStart());
    }

    @Test
    void lifecycleStates() {
        assertEquals(List.of(Thread.State.NEW, Thread.State.WAITING, Thread.State.TERMINATED), Bai14JrThreadBasics.lifecycle());
    }

    @Test
    void daemonFlag() throws Exception {
        assertFalse(Bai14JrThreadBasics.newThreadIsDaemon());
        assertTrue(Bai14JrThreadBasics.childOfDaemonIsDaemon());
    }

    @Test
    void sumWithTwoThreads() {
        assertEquals(55, Bai14JrThreadBasics.sumWithTwoThreads(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(6, Bai14JrThreadBasics.sumWithTwoThreads(new int[]{1, 2, 3}));
        assertEquals(7, Bai14JrThreadBasics.sumWithTwoThreads(new int[]{7}));
        assertEquals(0, Bai14JrThreadBasics.sumWithTwoThreads(new int[0]));
    }

    @Test
    void uncaughtExceptionIsCapturedByHandler() {
        Throwable t = Bai14JrThreadBasics.uncaughtFromThread();
        assertInstanceOf(IllegalStateException.class, t);
        assertEquals("boom", t.getMessage());
    }
}
