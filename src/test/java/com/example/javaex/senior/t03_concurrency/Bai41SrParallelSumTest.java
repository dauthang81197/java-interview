package com.example.javaex.senior.t03_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai41SrParallelSumTest {

    private static int[] randomInts(int n) {
        Random r = new Random(1);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt();
        return a;
    }

    @Test
    void parallelSumMatchesSequential() {
        int[] data = randomInts(1_000_003);
        long expected = Arrays.stream(data).asLongStream().sum();
        for (int threads : new int[]{1, 2, 4, 7, 8}) {
            assertEquals(expected, Bai41SrParallelSum.parallelSum(data, threads), "threads=" + threads);
        }
    }

    @Test
    void parallelSumNoIntOverflow() {
        int[] data = new int[10];
        Arrays.fill(data, Integer.MAX_VALUE);
        assertEquals(10L * Integer.MAX_VALUE, Bai41SrParallelSum.parallelSum(data, 3));
    }

    @Test
    void parallelSumEdgeCases() {
        assertEquals(0, Bai41SrParallelSum.parallelSum(new int[0], 4));
        assertEquals(6, Bai41SrParallelSum.parallelSum(new int[]{1, 2, 3}, 16));
        assertThrows(IllegalArgumentException.class, () -> Bai41SrParallelSum.parallelSum(new int[]{1}, 0));
    }

    @Test
    void parallelSumDoesNotLeakThreads() throws Exception {
        int before = Thread.activeCount();
        for (int i = 0; i < 20; i++) Bai41SrParallelSum.parallelSum(randomInts(1000), 8);
        Thread.sleep(300);
        assertTrue(Thread.activeCount() <= before + 2,
                "Executor phải được shutdown; threads trước=" + before + " sau=" + Thread.activeCount());
    }

    @Test
    void forkJoinSumMatchesSequential() {
        Random r = new Random(2);
        long[] data = new long[2_000_001];
        for (int i = 0; i < data.length; i++) data[i] = r.nextInt(1000);
        long expected = Arrays.stream(data).sum();
        assertEquals(expected, Bai41SrParallelSum.forkJoinSum(data, 10_000));
        assertEquals(expected, Bai41SrParallelSum.forkJoinSum(data, 1_000_000_000));
        assertEquals(0, Bai41SrParallelSum.forkJoinSum(new long[0], 10));
        assertEquals(5, Bai41SrParallelSum.forkJoinSum(new long[]{5}, 1));
    }

    @Test
    void forkJoinInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> Bai41SrParallelSum.forkJoinSum(new long[]{1}, 0));
        assertThrows(NullPointerException.class, () -> Bai41SrParallelSum.forkJoinSum(null, 10));
    }
}
