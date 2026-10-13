package com.example.javaex.senior.t03_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai39SrBoundedBlockingQueueTest {

    @Test
    void fifoSingleThread() throws Exception {
        Bai39SrBoundedBlockingQueue<Integer> q = new Bai39SrBoundedBlockingQueue<>(3);
        q.put(1);
        q.put(2);
        q.put(3);
        assertEquals(3, q.size());
        assertEquals(1, q.take());
        assertEquals(2, q.take());
        assertEquals(1, q.size());
    }

    @Test
    void invalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Bai39SrBoundedBlockingQueue<Integer>(0));
    }

    @Test
    void takeBlocksUntilPut() throws Exception {
        Bai39SrBoundedBlockingQueue<String> q = new Bai39SrBoundedBlockingQueue<>(1);
        List<String> got = new ArrayList<>();
        Thread t = new Thread(() -> {
            try {
                String s = q.take();
                synchronized (got) {
                    got.add(s);
                }
            } catch (InterruptedException ignored) {
            }
        });
        t.start();
        Thread.sleep(200);
        assertTrue(t.isAlive(), "take() phải chặn khi queue rỗng");
        q.put("x");
        t.join(5000);
        assertFalse(t.isAlive());
        assertEquals(List.of("x"), got);
    }

    @Test
    void putBlocksWhenFull() throws Exception {
        Bai39SrBoundedBlockingQueue<Integer> q = new Bai39SrBoundedBlockingQueue<>(2);
        q.put(1);
        q.put(2);
        Thread t = new Thread(() -> {
            try {
                q.put(3);
            } catch (InterruptedException ignored) {
            }
        });
        t.start();
        Thread.sleep(200);
        assertTrue(t.isAlive(), "put() phải chặn khi queue đầy");
        assertEquals(2, q.size());
        assertEquals(1, q.take());
        t.join(5000);
        assertFalse(t.isAlive());
        assertEquals(2, q.take());
        assertEquals(3, q.take());
    }

    @Test
    void blockedTakeRespondsToInterrupt() throws Exception {
        Bai39SrBoundedBlockingQueue<Integer> q = new Bai39SrBoundedBlockingQueue<>(1);
        boolean[] interrupted = new boolean[1];
        Thread t = new Thread(() -> {
            try {
                q.take();
            } catch (InterruptedException e) {
                interrupted[0] = true;
            }
        });
        t.start();
        Thread.sleep(200);
        t.interrupt();
        t.join(5000);
        assertFalse(t.isAlive());
        assertTrue(interrupted[0]);
    }

    @Test
    void manyProducersManyConsumers() throws Exception {
        final int producers = 4, consumers = 4, perProducer = 20_000;
        Bai39SrBoundedBlockingQueue<Integer> q = new Bai39SrBoundedBlockingQueue<>(8);
        AtomicLong sum = new AtomicLong();
        AtomicLong count = new AtomicLong();
        List<Thread> threads = new ArrayList<>();
        for (int p = 0; p < producers; p++) {
            Thread t = new Thread(() -> {
                try {
                    for (int i = 1; i <= perProducer; i++) q.put(i);
                } catch (InterruptedException ignored) {
                }
            });
            threads.add(t);
        }
        int total = producers * perProducer;
        List<Thread> cons = new ArrayList<>();
        for (int c = 0; c < consumers; c++) {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        if (count.incrementAndGet() > total) return;
                        sum.addAndGet(q.take());
                    }
                } catch (InterruptedException ignored) {
                }
            });
            cons.add(t);
        }
        threads.forEach(Thread::start);
        cons.forEach(Thread::start);
        for (Thread t : threads) t.join();
        for (Thread t : cons) t.join();
        long expected = (long) producers * perProducer * (perProducer + 1) / 2;
        assertEquals(expected, sum.get());
        assertEquals(0, q.size());
    }
}
