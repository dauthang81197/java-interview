package com.example.javaex.senior.t01_jvm;

import com.example.javaex.support.GcTestSupport;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class Bai32SrLeakyStackTest {

    @Test
    void lifoAndGrowth() {
        Bai32SrLeakyStack<Integer> s = new Bai32SrLeakyStack<>();
        for (int i = 0; i < 1000; i++) s.push(i);
        assertEquals(1000, s.size());
        assertEquals(999, s.peek());
        for (int i = 999; i >= 0; i--) assertEquals(i, s.pop());
        assertEquals(0, s.size());
    }

    @Test
    void emptyStackThrows() {
        Bai32SrLeakyStack<String> s = new Bai32SrLeakyStack<>();
        assertThrows(EmptyStackException.class, s::pop);
        assertThrows(EmptyStackException.class, s::peek);
    }

    @Test
    void poppedObjectIsNotRetained() throws Exception {
        Bai32SrLeakyStack<Object> s = new Bai32SrLeakyStack<>();
        s.push(new Object());
        s.push(new Object());
        WeakReference<Object> ref = new WeakReference<>(s.pop());
        assertTrue(GcTestSupport.awaitCleared(ref), "stack vẫn giữ tham chiếu tới phần tử đã pop (memory leak)");
        assertEquals(1, s.size());
    }
}
