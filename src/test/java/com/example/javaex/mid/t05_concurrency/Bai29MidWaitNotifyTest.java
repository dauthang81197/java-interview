package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.mid.t05_concurrency.Bai29MidWaitNotify.SimpleMailbox;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 60, unit = TimeUnit.SECONDS)
class Bai29MidWaitNotifyTest {

    @Test
    void itemsArriveInOrder() throws Exception {
        SimpleMailbox<Integer> box = new SimpleMailbox<>();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 1000; i++) box.put(i);
            } catch (InterruptedException ignored) {
            }
        });
        producer.start();
        List<Integer> got = new ArrayList<>();
        for (int i = 0; i < 1000; i++) got.add(box.take());
        producer.join();
        for (int i = 0; i < 1000; i++) assertEquals(i + 1, got.get(i));
    }

    @Test
    void takeBlocksUntilPut() throws Exception {
        SimpleMailbox<String> box = new SimpleMailbox<>();
        List<String> got = new ArrayList<>();
        Thread t = new Thread(() -> {
            try {
                String s = box.take();
                synchronized (got) {
                    got.add(s);
                }
            } catch (InterruptedException ignored) {
            }
        });
        t.start();
        Thread.sleep(300);
        assertTrue(t.isAlive(), "take() phải chặn khi hộp rỗng");
        box.put("x");
        t.join(10_000);
        assertFalse(t.isAlive());
        assertEquals(List.of("x"), got);
    }

    @Test
    void putBlocksWhenFull() throws Exception {
        SimpleMailbox<Integer> box = new SimpleMailbox<>();
        box.put(1);
        Thread t = new Thread(() -> {
            try {
                box.put(2);
            } catch (InterruptedException ignored) {
            }
        });
        t.start();
        Thread.sleep(300);
        assertTrue(t.isAlive(), "put() phải chặn khi hộp đầy (1 ô)");
        assertEquals(1, box.take());
        t.join(10_000);
        assertFalse(t.isAlive());
        assertEquals(2, box.take());
    }

    @Test
    void pollTimesOutWithNull() throws Exception {
        SimpleMailbox<String> box = new SimpleMailbox<>();
        long start = System.nanoTime();
        assertNull(box.poll(200));
        assertTrue((System.nanoTime() - start) / 1_000_000 >= 150, "poll phải chờ gần đủ timeout");
    }

    @Test
    void pollReturnsValueArrivingDuringWait() throws Exception {
        SimpleMailbox<String> box = new SimpleMailbox<>();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(150);
                box.put("late");
            } catch (InterruptedException ignored) {
            }
        });
        t.start();
        assertEquals("late", box.poll(20_000));
        t.join();
    }

    @Test
    void nullItemRejected() {
        assertThrows(NullPointerException.class, () -> new SimpleMailbox<String>().put(null));
    }

    @Test
    void blockedTakeRespondsToInterrupt() throws Exception {
        SimpleMailbox<String> box = new SimpleMailbox<>();
        boolean[] interrupted = new boolean[1];
        Thread t = new Thread(() -> {
            try {
                box.take();
            } catch (InterruptedException e) {
                interrupted[0] = true;
            }
        });
        t.start();
        Thread.sleep(200);
        t.interrupt();
        t.join(10_000);
        assertFalse(t.isAlive());
        assertTrue(interrupted[0]);
    }

    @Test
    void manyProducersAndConsumers() throws Exception {
        SimpleMailbox<Integer> box = new SimpleMailbox<>();
        AtomicLong sum = new AtomicLong();
        List<Thread> ts = new ArrayList<>();
        for (int p = 0; p < 3; p++) {
            ts.add(new Thread(() -> {
                try {
                    for (int i = 1; i <= 1000; i++) box.put(i);
                } catch (InterruptedException ignored) {
                }
            }));
        }
        for (int c = 0; c < 3; c++) {
            ts.add(new Thread(() -> {
                try {
                    for (int i = 0; i < 1000; i++) sum.addAndGet(box.take());
                } catch (InterruptedException ignored) {
                }
            }));
        }
        ts.forEach(Thread::start);
        for (Thread t : ts) t.join();
        assertEquals(3L * 1000 * 1001 / 2, sum.get());
    }
}
