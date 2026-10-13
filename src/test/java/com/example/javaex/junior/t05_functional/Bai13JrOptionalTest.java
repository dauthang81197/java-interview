package com.example.javaex.junior.t05_functional;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Bai13JrOptionalTest {

    @Test
    void findFirstLongerThan() {
        assertEquals(Optional.of("abcd"), Bai13JrOptional.findFirstLongerThan(List.of("a", "abcd", "xyzzy"), 3));
        assertEquals(Optional.empty(), Bai13JrOptional.findFirstLongerThan(List.of("a"), 3));
    }

    @Test
    void displayName() {
        assertEquals("Lan", Bai13JrOptional.displayName(Optional.of("Lan")));
        assertEquals("ẩn danh", Bai13JrOptional.displayName(Optional.empty()));
    }

    @Test
    void parse() {
        assertEquals(Optional.of(42), Bai13JrOptional.parse("42"));
        assertEquals(Optional.empty(), Bai13JrOptional.parse("abc"));
        assertEquals(Optional.empty(), Bai13JrOptional.parse(null));
    }

    @Test
    void lengthOrZero() {
        assertEquals(3, Bai13JrOptional.lengthOrZero("abc"));
        assertEquals(0, Bai13JrOptional.lengthOrZero(null));
    }

    @Test
    void firstNonBlank() {
        assertEquals(Optional.of("x"), Bai13JrOptional.firstNonBlank(null, "  ", "x", "y"));
        assertEquals(Optional.empty(), Bai13JrOptional.firstNonBlank(null, ""));
        assertEquals(Optional.empty(), Bai13JrOptional.firstNonBlank());
    }

    @Test
    void requireValue() {
        assertEquals("v", Bai13JrOptional.requireValue(Optional.of("v")));
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> Bai13JrOptional.requireValue(Optional.empty()));
        assertEquals("thiếu giá trị", e.getMessage());
        assertFalse(NoSuchElementException.class.isInstance(e));
    }
}
