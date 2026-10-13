package com.example.javaex.junior.t02_oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Bai08JrInitOrderTest {

    @Test
    void staticBlocksRunOnceInstanceBlocksEveryTime() {
        List<String> first = Bai08JrInitOrder.createChild();
        assertEquals(List.of("Parent static", "Child static",
                "Parent instance", "Parent constructor",
                "Child instance", "Child constructor"), first);
        List<String> second = Bai08JrInitOrder.createChild();
        assertEquals(List.of("Parent instance", "Parent constructor",
                "Child instance", "Child constructor"), second);
    }
}
