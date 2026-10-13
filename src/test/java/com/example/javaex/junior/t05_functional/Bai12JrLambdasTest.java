package com.example.javaex.junior.t05_functional;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class Bai12JrLambdasTest {

    @Test
    void adderCapturesVariable() {
        assertEquals(15, Bai12JrLambdas.adder(5).apply(10));
        assertEquals(7, Bai12JrLambdas.adder(-3).apply(10));
    }

    @Test
    void longerThanPredicate() {
        assertTrue(Bai12JrLambdas.longerThan(3).test("abcd"));
        assertFalse(Bai12JrLambdas.longerThan(3).test("abc"));
    }

    @Test
    void filterWithoutStreams() {
        assertEquals(List.of("abcd", "xyzzy"), Bai12JrLambdas.filter(List.of("a", "abcd", "xy", "xyzzy"), Bai12JrLambdas.longerThan(3)));
        assertEquals(List.of(2, 4), Bai12JrLambdas.filter(List.of(1, 2, 3, 4), n -> n % 2 == 0));
    }

    @Test
    void counterKeepsState() {
        Supplier<Integer> c1 = Bai12JrLambdas.counter();
        Supplier<Integer> c2 = Bai12JrLambdas.counter();
        assertEquals(1, c1.get());
        assertEquals(2, c1.get());
        assertEquals(1, c2.get());
        assertEquals(3, c1.get());
    }

    @Test
    void composeAppliesFirstThenSecond() {
        var f = Bai12JrLambdas.<Integer, Integer, String>compose(x -> x + 1, x -> "v" + x * 2);
        assertEquals("v8", f.apply(3));
    }

    @Test
    void sortByLength() {
        List<String> in = List.of("ccc", "a", "bb", "dd");
        assertEquals(List.of("a", "bb", "dd", "ccc"), Bai12JrLambdas.sortByLength(in));
        assertEquals("ccc", in.get(0));
    }
}
