package com.example.javaex.senior.t01_jvm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai33SrJvmInfoTest {

    @Test
    void heapUsageIsConsistent() {
        Bai33SrJvmInfo.HeapSnapshot h = Bai33SrJvmInfo.heapUsage();
        assertTrue(h.used() > 0);
        assertTrue(h.used() <= h.committed());
        if (h.max() != -1) {
            assertTrue(h.committed() <= h.max());
            assertEquals(Runtime.getRuntime().maxMemory(), h.max(), Runtime.getRuntime().maxMemory() * 0.2);
        }
    }

    @Test
    void gcNamesSortedAndNonEmpty() {
        List<String> names = Bai33SrJvmInfo.gcNames();
        assertFalse(names.isEmpty());
        assertEquals(names.stream().sorted().toList(), names);
        assertTrue(names.stream().noneMatch(String::isBlank));
    }

    @Test
    void gcCountAfterExplicitGc() {
        assertTrue(Bai33SrJvmInfo.gcCountAfterGc() >= 1);
    }
}
