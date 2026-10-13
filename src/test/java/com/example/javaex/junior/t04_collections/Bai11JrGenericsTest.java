package com.example.javaex.junior.t04_collections;

import com.example.javaex.junior.t04_collections.Bai11JrGenerics.Box;
import com.example.javaex.junior.t04_collections.Bai11JrGenerics.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai11JrGenericsTest {

    @Test
    void box() {
        Box<String> b = new Box<>("x");
        assertEquals("x", b.get());
        assertFalse(b.isEmpty());
        b.set(null);
        assertTrue(b.isEmpty());
        assertNull(b.get());
    }

    @Test
    void pairSwapped() {
        Pair<String, Integer> p = new Pair<>("a", 1);
        Pair<Integer, String> s = p.swapped();
        assertEquals(1, s.first());
        assertEquals("a", s.second());
        assertEquals("a", p.first());
    }

    @Test
    void firstOrNull() {
        assertEquals("a", Bai11JrGenerics.firstOrNull(List.of("a", "b")));
        assertNull(Bai11JrGenerics.firstOrNull(new ArrayList<String>()));
    }

    @Test
    void swap() {
        List<Integer> l = new ArrayList<>(List.of(1, 2, 3));
        Bai11JrGenerics.swap(l, 0, 2);
        assertEquals(List.of(3, 2, 1), l);
        assertThrows(IndexOutOfBoundsException.class, () -> Bai11JrGenerics.swap(l, 0, 3));
    }

    @Test
    void maxOf() {
        assertEquals(5, Bai11JrGenerics.maxOf(3, 5));
        assertEquals("pear", Bai11JrGenerics.maxOf("apple", "pear"));
        assertEquals("a", Bai11JrGenerics.maxOf("a", "a"));
    }
}
