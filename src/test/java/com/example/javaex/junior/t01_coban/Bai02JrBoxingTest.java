package com.example.javaex.junior.t01_coban;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai02JrBoxingTest {

    @Test
    void integerCache() {
        assertTrue(Bai02JrBoxing.integerCacheSmall());
        assertFalse(Bai02JrBoxing.integerCacheLarge());
    }

    @Test
    void longNeverEqualsInteger() {
        assertFalse(Bai02JrBoxing.longEqualsInt());
    }

    @Test
    void unboxingNullThrows() {
        assertTrue(Bai02JrBoxing.unboxNullThrows());
    }

    @Test
    void nan() {
        assertFalse(Bai02JrBoxing.nanPrimitiveEqualsItself());
        assertTrue(Bai02JrBoxing.nanBoxedEqualsItself());
    }

    @Test
    void sumIgnoringNulls() {
        assertEquals(6, Bai02JrBoxing.sumIgnoringNulls(Arrays.asList(1, null, 2, 3, null)));
        assertEquals(0, Bai02JrBoxing.sumIgnoringNulls(List.of()));
    }

    @Test
    void sameValueIsNullSafeAndUsesEquals() {
        assertTrue(Bai02JrBoxing.sameValue(1000, 1000));
        assertTrue(Bai02JrBoxing.sameValue(null, null));
        assertFalse(Bai02JrBoxing.sameValue(1, null));
        assertFalse(Bai02JrBoxing.sameValue(null, 1));
        assertFalse(Bai02JrBoxing.sameValue(1, 2));
    }
}
