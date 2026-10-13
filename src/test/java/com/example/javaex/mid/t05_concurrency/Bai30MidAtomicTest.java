package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.mid.t05_concurrency.Bai30MidAtomic.CasStack;
import com.example.javaex.mid.t05_concurrency.Bai30MidAtomic.MaxTracker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 60, unit = TimeUnit.SECONDS)
class Bai30MidAtomicTest {

    @Test
    void atomicLongAndLongAdderAreExact() throws Exception {
        assertEquals(800_000L, Bai30MidAtomic.incrementWithAtomicLong(8, 100_000));
        assertEquals(800_000L, Bai30MidAtomic.incrementWithLongAdder(8, 100_000));
        assertEquals(0L, Bai30MidAtomic.incrementWithAtomicLong(4, 0));
    }

    @Test
    void maxTrackerStartsAtMinValue() {
        assertEquals(Integer.MIN_VALUE, new MaxTracker().get());
    }

    @Test
    void maxTrackerSingleThread() {
        MaxTracker m = new MaxTracker();
        m.update(5);
        m.update(3);
        m.update(9);
        m.update(-1);
        assertEquals(9, m.get());
    }

    @Test
    void maxTrackerUnderContention() throws Exception {
        MaxTracker m = new MaxTracker();
        int threads = 8;
        int[][] data = new int[threads][20_000];
        int expected = Integer.MIN_VALUE;
        for (int t = 0; t < threads; t++) {
            Random r = new Random(t);
            for (int i = 0; i < data[t].length; i++) {
                data[t][i] = r.nextInt();
                expected = Math.max(expected, data[t][i]);
            }
        }
        List<Thread> ts = new ArrayList<>();
        for (int t = 0; t < threads; t++) {
            final int[] mine = data[t];
            ts.add(new Thread(() -> {
                for (int v : mine) m.update(v);
            }));
        }
        ts.forEach(Thread::start);
        for (Thread t : ts) t.join();
        assertEquals(expected, m.get());
    }

    @Test
    void stackIsLifoSingleThread() {
        CasStack<Integer> s = new CasStack<>();
        assertTrue(s.isEmpty());
        assertNull(s.pop());
        s.push(1);
        s.push(2);
        s.push(3);
        assertFalse(s.isEmpty());
        assertEquals(3, s.pop());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    void stackLosesNothingUnderContention() throws Exception {
        CasStack<Integer> s = new CasStack<>();
        int producers = 4, per = 5000;
        List<Thread> ts = new ArrayList<>();
        for (int p = 0; p < producers; p++) {
            final int base = p * per;
            ts.add(new Thread(() -> {
                for (int i = 0; i < per; i++) s.push(base + i);
            }));
        }
        ts.forEach(Thread::start);
        for (Thread t : ts) t.join();
        ConcurrentLinkedQueue<Integer> popped = new ConcurrentLinkedQueue<>();
        List<Thread> cs = new ArrayList<>();
        for (int c = 0; c < 4; c++) {
            cs.add(new Thread(() -> {
                Integer v;
                while ((v = s.pop()) != null) popped.add(v);
            }));
        }
        cs.forEach(Thread::start);
        for (Thread t : cs) t.join();
        Set<Integer> distinct = new HashSet<>(popped);
        assertEquals(producers * per, popped.size());
        assertEquals(producers * per, distinct.size());
        assertTrue(s.isEmpty());
    }

    @Test
    void stampedReferenceDetectsAba() {
        assertTrue(Bai30MidAtomic.abaDetectedByStamp());
    }
}
