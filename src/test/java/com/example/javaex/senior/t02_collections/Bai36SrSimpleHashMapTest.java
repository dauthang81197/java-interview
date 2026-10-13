package com.example.javaex.senior.t02_collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai36SrSimpleHashMapTest {

    static final class BadKey {
        final int id;

        BadKey(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof BadKey b && b.id == id;
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }

    @Test
    void putGetRemove() {
        Bai36SrSimpleHashMap<String, Integer> m = new Bai36SrSimpleHashMap<>();
        assertNull(m.put("a", 1));
        assertEquals(1, m.put("a", 2));
        assertEquals(1, m.size());
        assertEquals(2, m.get("a"));
        assertTrue(m.containsKey("a"));
        assertEquals(2, m.remove("a"));
        assertNull(m.remove("a"));
        assertNull(m.get("a"));
        assertEquals(0, m.size());
    }

    @Test
    void nullKeySupported() {
        Bai36SrSimpleHashMap<String, String> m = new Bai36SrSimpleHashMap<>();
        m.put(null, "x");
        assertEquals("x", m.get(null));
        assertTrue(m.containsKey(null));
        assertEquals("x", m.remove(null));
        assertFalse(m.containsKey(null));
    }

    @Test
    void containsKeyWithNullValue() {
        Bai36SrSimpleHashMap<String, String> m = new Bai36SrSimpleHashMap<>();
        m.put("k", null);
        assertTrue(m.containsKey("k"));
        assertEquals(1, m.size());
    }

    @Test
    void resizesAtLoadFactor() {
        Bai36SrSimpleHashMap<Integer, Integer> m = new Bai36SrSimpleHashMap<>();
        assertEquals(16, m.capacity());
        for (int i = 0; i < 12; i++) m.put(i, i);
        assertEquals(16, m.capacity());
        m.put(12, 12);
        assertEquals(32, m.capacity());
        m.put(0, 99); // ghi đè không làm tăng size
        assertEquals(13, m.size());
    }

    @Test
    void collidingKeysStillWork() {
        Bai36SrSimpleHashMap<BadKey, Integer> m = new Bai36SrSimpleHashMap<>();
        for (int i = 0; i < 200; i++) m.put(new BadKey(i), i);
        assertEquals(200, m.size());
        for (int i = 0; i < 200; i++) assertEquals(i, m.get(new BadKey(i)));
        assertEquals(50, m.remove(new BadKey(50)));
        assertNull(m.get(new BadKey(50)));
        assertEquals(199, m.size());
    }

    @Test
    void tenThousandEntries() {
        Bai36SrSimpleHashMap<Integer, String> m = new Bai36SrSimpleHashMap<>();
        for (int i = 0; i < 10_000; i++) m.put(i, "v" + i);
        assertEquals(10_000, m.size());
        for (int i = 0; i < 10_000; i++) assertEquals("v" + i, m.get(i));
        assertTrue(m.capacity() >= 10_000 / 0.75 / 2);
    }
}
