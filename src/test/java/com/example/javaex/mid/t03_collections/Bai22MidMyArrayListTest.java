package com.example.javaex.mid.t03_collections;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class Bai22MidMyArrayListTest {

    private static Bai22MidMyArrayList<Integer> listOf(int n) {
        Bai22MidMyArrayList<Integer> l = new Bai22MidMyArrayList<>();
        for (int i = 0; i < n; i++) l.add(i);
        return l;
    }

    @Test
    void addGetGrowth() {
        Bai22MidMyArrayList<Integer> l = listOf(1000);
        assertEquals(1000, l.size());
        for (int i = 0; i < 1000; i++) assertEquals(i, l.get(i));
    }

    @Test
    void removeShiftsElements() {
        Bai22MidMyArrayList<Integer> l = listOf(5);
        assertEquals(2, l.remove(2));
        assertEquals(4, l.size());
        assertEquals(3, l.get(2));
        assertEquals(4, l.remove(3));
        assertEquals(0, l.remove(0));
    }

    @Test
    void indexChecks() {
        Bai22MidMyArrayList<Integer> l = listOf(3);
        assertThrows(IndexOutOfBoundsException.class, () -> l.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> l.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> l.remove(3));
    }

    @Test
    void iteratesInOrder() {
        int expected = 0;
        for (int v : listOf(20)) assertEquals(expected++, v);
        assertEquals(20, expected);
    }

    @Test
    void failFastOnAddDuringIteration() {
        Bai22MidMyArrayList<Integer> l = listOf(5);
        assertThrows(ConcurrentModificationException.class, () -> {
            for (Integer v : l) {
                if (v == 1) l.add(99);
            }
        });
    }

    @Test
    void failFastOnRemoveDuringIteration() {
        Bai22MidMyArrayList<Integer> l = listOf(5);
        Iterator<Integer> it = l.iterator();
        it.next();
        l.remove(0);
        assertThrows(ConcurrentModificationException.class, it::next);
    }

    @Test
    void iteratorRemoveWorks() {
        Bai22MidMyArrayList<Integer> l = listOf(6);
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove();
        }
        assertEquals(3, l.size());
        assertEquals(1, l.get(0));
        assertEquals(3, l.get(1));
        assertEquals(5, l.get(2));
    }

    @Test
    void iteratorRemoveTwiceOrBeforeNextFails() {
        Bai22MidMyArrayList<Integer> l = listOf(3);
        Iterator<Integer> it = l.iterator();
        assertThrows(IllegalStateException.class, it::remove);
        it.next();
        it.remove();
        assertThrows(IllegalStateException.class, it::remove);
    }

    @Test
    void nextPastEndThrows() {
        Iterator<Integer> it = listOf(1).iterator();
        it.next();
        assertThrows(java.util.NoSuchElementException.class, it::next);
    }

    @Test
    void removedElementBecomesCollectable() throws Exception {
        Bai22MidMyArrayList<Object> l = new Bai22MidMyArrayList<>();
        l.add(new Object());
        l.add(new Object());
        java.lang.ref.WeakReference<Object> ref = new java.lang.ref.WeakReference<>(l.remove(1));
        assertTrue(com.example.javaex.support.GcTestSupport.awaitCleared(ref), "ô cuối sau remove phải gán null");
        assertEquals(1, l.size());
    }
}
