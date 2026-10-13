package com.example.javaex.junior.t01_coban;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai04JrPassByValueTest {

    @Test
    void fillChangesCallersArray() {
        int[] a = {1, 2, 3};
        Bai04JrPassByValue.fill(a, 7);
        assertArrayEquals(new int[]{7, 7, 7}, a);
    }

    @Test
    void reassigningParameterDoesNotAffectCaller() {
        int[] a = {1, 2, 3};
        Bai04JrPassByValue.tryReassign(a);
        assertArrayEquals(new int[]{1, 2, 3}, a);
    }

    @Test
    void stringIsImmutable() {
        String s = "hi";
        assertEquals("hi!", Bai04JrPassByValue.appendBang(s));
        assertEquals("hi", s);
    }

    @Test
    void stringBuilderIsMutated() {
        StringBuilder sb = new StringBuilder("hi");
        Bai04JrPassByValue.appendBang(sb);
        assertEquals("hi!", sb.toString());
    }

    @Test
    void swappedCopyLeavesOriginal() {
        int[] pair = {1, 2};
        int[] r = Bai04JrPassByValue.swappedCopy(pair);
        assertArrayEquals(new int[]{2, 1}, r);
        assertArrayEquals(new int[]{1, 2}, pair);
        assertNotSame(pair, r);
        assertThrows(IllegalArgumentException.class, () -> Bai04JrPassByValue.swappedCopy(new int[]{1, 2, 3}));
    }

    @Test
    void addItemMutatesCallersList() {
        List<String> l = new ArrayList<>();
        Bai04JrPassByValue.addItem(l, "x");
        assertEquals(List.of("x"), l);
    }
}
