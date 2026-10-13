package com.example.javaex.junior.t01_coban;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai01JrPrimitivesTest {

    @Test
    void overflowWrapsAround() {
        assertEquals(Integer.MIN_VALUE, Bai01JrPrimitives.intMaxPlusOne());
    }

    @Test
    void narrowingToByte() {
        assertEquals((byte) -56, Bai01JrPrimitives.toByte(200));
        assertEquals((byte) 127, Bai01JrPrimitives.toByte(-129));
        assertEquals((byte) 5, Bai01JrPrimitives.toByte(5));
    }

    @Test
    void charArithmetic() {
        assertEquals('c', Bai01JrPrimitives.shiftChar('a', 2));
        assertEquals('A', Bai01JrPrimitives.shiftChar('D', -3));
    }

    @Test
    void productDoesNotOverflow() {
        assertEquals(10_000_000_000L, Bai01JrPrimitives.product(100_000, 100_000));
        assertEquals(-4_611_686_016_279_904_256L, Bai01JrPrimitives.product(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void safeAddDetectsOverflow() {
        assertEquals(3, Bai01JrPrimitives.safeAdd(1, 2));
        assertThrows(ArithmeticException.class, () -> Bai01JrPrimitives.safeAdd(Integer.MAX_VALUE, 1));
        assertThrows(ArithmeticException.class, () -> Bai01JrPrimitives.safeAdd(Integer.MIN_VALUE, -1));
    }

    @Test
    void floatingPointIsNotExact() {
        assertFalse(Bai01JrPrimitives.pointOnePlusPointTwoEqualsPointThree());
    }

    @Test
    void doubleDivisionByZeroIsInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, Bai01JrPrimitives.divideByZero());
    }

    @Test
    void integerDivisionTruncatesTowardZero() {
        assertEquals(3, Bai01JrPrimitives.integerDivision(7, 2));
        assertEquals(-3, Bai01JrPrimitives.integerDivision(-7, 2));
        assertThrows(ArithmeticException.class, () -> Bai01JrPrimitives.integerDivision(1, 0));
    }

    @Test
    void doubleToIntTruncatesAndSaturates() {
        assertEquals(3, Bai01JrPrimitives.truncateToInt(3.99));
        assertEquals(-3, Bai01JrPrimitives.truncateToInt(-3.99));
        assertEquals(Integer.MAX_VALUE, Bai01JrPrimitives.truncateToInt(1e20));
        assertEquals(0, Bai01JrPrimitives.truncateToInt(Double.NaN));
    }
}
