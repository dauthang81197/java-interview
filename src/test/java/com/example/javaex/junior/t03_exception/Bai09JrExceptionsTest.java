package com.example.javaex.junior.t03_exception;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai09JrExceptionsTest {

    @Test
    void parseIntOrDefault() {
        assertEquals(12, Bai09JrExceptions.parseIntOrDefault("12", 0));
        assertEquals(5, Bai09JrExceptions.parseIntOrDefault("x", 5));
        assertEquals(7, Bai09JrExceptions.parseIntOrDefault(null, 7));
        assertEquals(-3, Bai09JrExceptions.parseIntOrDefault("-3", 1));
    }

    @Test
    void finallyAlwaysRuns() {
        assertEquals(List.of("try", "finally"), Bai09JrExceptions.finallyOrder(false));
        assertEquals(List.of("try", "catch", "finally"), Bai09JrExceptions.finallyOrder(true));
    }

    @Test
    void tryWithResourcesClosesInReverseOrder() {
        assertEquals(List.of("open A", "open B", "close B", "close A"), Bai09JrExceptions.closeOrder());
    }

    @Test
    void checkedVsUnchecked() {
        assertTrue(Bai09JrExceptions.isChecked(IOException.class));
        assertTrue(Bai09JrExceptions.isChecked(Exception.class));
        assertTrue(Bai09JrExceptions.isChecked(Throwable.class));
        assertFalse(Bai09JrExceptions.isChecked(RuntimeException.class));
        assertFalse(Bai09JrExceptions.isChecked(IllegalArgumentException.class));
        assertFalse(Bai09JrExceptions.isChecked(Error.class));
        assertFalse(Bai09JrExceptions.isChecked(OutOfMemoryError.class));
    }

    @Test
    void returnValueIsFixedBeforeFinally() {
        assertEquals(1, Bai09JrExceptions.tryFinallyReturn());
    }
}
