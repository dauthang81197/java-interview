package com.example.javaex.mid.t03_collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai25MidLruCacheTest {

    @Test
    void evictsLeastRecentlyUsed() {
        Bai25MidLruCache<String, Integer> c = new Bai25MidLruCache<>(2);
        c.put("a", 1);
        c.put("b", 2);
        assertEquals(1, c.get("a"));
        c.put("c", 3);
        assertNull(c.get("b"));
        assertEquals(1, c.get("a"));
        assertEquals(3, c.get("c"));
        assertEquals(2, c.size());
    }

    @Test
    void putExistingKeyUpdatesAndRefreshes() {
        Bai25MidLruCache<String, Integer> c = new Bai25MidLruCache<>(2);
        c.put("a", 1);
        c.put("b", 2);
        c.put("a", 10);
        c.put("c", 3);
        assertEquals(10, c.get("a"));
        assertNull(c.get("b"));
        assertEquals(2, c.size());
    }

    @Test
    void containsKeyDoesNotChangeOrder() {
        Bai25MidLruCache<String, Integer> c = new Bai25MidLruCache<>(2);
        c.put("a", 1);
        c.put("b", 2);
        assertTrue(c.containsKey("a"));
        c.put("c", 3);
        assertFalse(c.containsKey("a"));
        assertTrue(c.containsKey("b"));
    }

    @Test
    void capacityOne() {
        Bai25MidLruCache<Integer, Integer> c = new Bai25MidLruCache<>(1);
        c.put(1, 1);
        c.put(2, 2);
        assertNull(c.get(1));
        assertEquals(2, c.get(2));
    }

    @Test
    void invalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Bai25MidLruCache<String, String>(0));
    }

    @Test
    void manyOperationsKeepSize() {
        Bai25MidLruCache<Integer, Integer> c = new Bai25MidLruCache<>(100);
        for (int i = 0; i < 100_000; i++) c.put(i, i);
        assertEquals(100, c.size());
        assertEquals(99_999, c.get(99_999));
        assertNull(c.get(0));
    }

    @Test
    void operationsAreConstantTime() {
        org.junit.jupiter.api.Assertions.assertTimeoutPreemptively(java.time.Duration.ofSeconds(5), () -> {
            int cap = 100_000;
            Bai25MidLruCache<Integer, Integer> c = new Bai25MidLruCache<>(cap);
            for (int i = 0; i < cap; i++) c.put(i, i);
            for (int i = 0; i < 1_000_000; i++) {
                c.get(i % cap);
                if (i % 4 == 0) c.put(cap + i, i);
            }
            assertEquals(cap, c.size());
        });
    }
}
