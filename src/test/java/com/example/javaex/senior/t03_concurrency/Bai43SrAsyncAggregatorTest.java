package com.example.javaex.senior.t03_concurrency;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai43SrAsyncAggregatorTest {

    private static final ExecutorService EX = Executors.newCachedThreadPool(r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    @AfterAll
    static void shutdown() {
        EX.shutdownNow();
    }

    private static Supplier<String> slow(String value, long ms) {
        return () -> {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return value;
        };
    }

    @Test
    void fetchAllKeepsOrderAndRunsInParallel() throws Exception {
        List<Supplier<String>> tasks = List.of(slow("a", 400), slow("b", 100), slow("c", 300), slow("d", 200));
        long start = System.nanoTime();
        List<String> r = Bai43SrAsyncAggregator.fetchAll(tasks, EX).get(5, TimeUnit.SECONDS);
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertEquals(List.of("a", "b", "c", "d"), r);
        assertTrue(ms < 900, "phải chạy song song, thực tế " + ms + "ms");
    }

    @Test
    void fetchAllFailsIfAnyFails() {
        List<Supplier<String>> tasks = List.of(slow("a", 10), () -> {
            throw new IllegalStateException("boom");
        });
        CompletableFuture<List<String>> f = Bai43SrAsyncAggregator.fetchAll(tasks, EX);
        ExecutionException e = assertThrows(ExecutionException.class, () -> f.get(5, TimeUnit.SECONDS));
        assertTrue(f.isCompletedExceptionally());
        assertNotNull(e.getCause());
    }

    @Test
    void fetchAllEmpty() throws Exception {
        assertEquals(List.of(), Bai43SrAsyncAggregator.fetchAll(List.of(), EX).get(5, TimeUnit.SECONDS));
    }

    @Test
    void fallbackOnException() throws Exception {
        Supplier<String> bad = () -> {
            throw new RuntimeException("x");
        };
        assertEquals("fb", Bai43SrAsyncAggregator.withFallback(bad, EX, "fb").get(5, TimeUnit.SECONDS));
        assertEquals("ok", Bai43SrAsyncAggregator.withFallback(slow("ok", 10), EX, "fb").get(5, TimeUnit.SECONDS));
    }

    @Test
    void timeoutReturnsFallbackQuickly() throws Exception {
        long start = System.nanoTime();
        String r = Bai43SrAsyncAggregator.withTimeout(slow("late", 3000), EX, 150, "fb").get(2, TimeUnit.SECONDS);
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertEquals("fb", r);
        assertTrue(ms < 1500, "không được chờ task chậm, thực tế " + ms + "ms");
        assertEquals("fast", Bai43SrAsyncAggregator.withTimeout(slow("fast", 10), EX, 2000, "fb").get(5, TimeUnit.SECONDS));
    }

    @Test
    void firstOfReturnsFastest() throws Exception {
        long start = System.nanoTime();
        String r = Bai43SrAsyncAggregator.firstOf(List.of(slow("slow", 2000), slow("fast", 100), slow("mid", 800)), EX)
                .get(5, TimeUnit.SECONDS);
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertEquals("fast", r);
        assertTrue(ms < 1000);
    }

    @Test
    void firstOfEmptyFails() {
        CompletableFuture<String> f = Bai43SrAsyncAggregator.firstOf(List.of(), EX);
        Throwable e = assertThrows(ExecutionException.class, () -> f.get(5, TimeUnit.SECONDS));
        Throwable c = e.getCause();
        if (c instanceof CompletionException && c.getCause() != null) c = c.getCause();
        assertInstanceOf(java.util.NoSuchElementException.class, c);
    }
}
