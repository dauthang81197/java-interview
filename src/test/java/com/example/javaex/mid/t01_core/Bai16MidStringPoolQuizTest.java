package com.example.javaex.mid.t01_core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai16MidStringPoolQuizTest {

    @Test
    void twoLiterals() {
        assertTrue(Bai16MidStringPoolQuiz.twoLiterals());
    }

    @Test
    void literalVsNew() {
        assertFalse(Bai16MidStringPoolQuiz.literalVsNew());
    }

    @Test
    void literalVsIntern() {
        assertTrue(Bai16MidStringPoolQuiz.literalVsIntern());
    }

    @Test
    void literalVsRuntimeConcat() {
        assertFalse(Bai16MidStringPoolQuiz.literalVsRuntimeConcat());
    }

    @Test
    void literalVsConstantConcat() {
        assertTrue(Bai16MidStringPoolQuiz.literalVsConstantConcat());
    }
}
