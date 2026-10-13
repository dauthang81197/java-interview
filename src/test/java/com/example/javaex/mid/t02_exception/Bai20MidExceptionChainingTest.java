package com.example.javaex.mid.t02_exception;

import com.example.javaex.mid.t02_exception.Bai20MidExceptionChaining.UserLoadException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Bai20MidExceptionChainingTest {

    @Test
    void userLoadExceptionKeepsMessageAndCause() {
        IOException io = new IOException("disk");
        UserLoadException e = new UserLoadException(5, io);
        assertEquals("Không tải được user 5", e.getMessage());
        assertSame(io, e.getCause());
    }

    @Test
    void checkedExceptionIsWrappedWithCause() {
        IOException io = new IOException("disk");
        UserLoadException e = assertThrows(UserLoadException.class,
                () -> Bai20MidExceptionChaining.loadUser(id -> {
                    throw io;
                }, 9));
        assertSame(io, e.getCause());
        assertTrue(e.getMessage().contains("9"));
    }

    @Test
    void uncheckedExceptionPropagatesUnchanged() {
        IllegalArgumentException bad = new IllegalArgumentException("id");
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Bai20MidExceptionChaining.loadUser(id -> {
                    throw bad;
                }, 1));
        assertSame(bad, e);
    }

    @Test
    void successReturnsValue() {
        assertEquals("user-3", Bai20MidExceptionChaining.loadUser(id -> "user-" + id, 3));
    }

    @Test
    void rootCauseWalksChain() {
        Throwable root = new IllegalStateException("root");
        Throwable mid = new RuntimeException("mid", root);
        Throwable top = new Exception("top", mid);
        assertSame(root, Bai20MidExceptionChaining.rootCause(top));
        assertSame(root, Bai20MidExceptionChaining.rootCause(root));
    }

    @Test
    void rootCauseSurvivesCycles() {
        Exception a = new Exception("a");
        Exception b = new Exception("b");
        a.initCause(b);
        b.initCause(a);
        assertNotNull(assertTimeoutPreemptively(java.time.Duration.ofSeconds(5),
                () -> Bai20MidExceptionChaining.rootCause(a)));
    }

    @Test
    void closeFailureIsSuppressedNotLost() {
        assertEquals(1, Bai20MidExceptionChaining.suppressedCount());
    }
}
