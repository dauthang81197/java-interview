package com.example.javaex.junior.t01_coban;

import com.example.javaex.junior.t01_coban.Bai05JrEnumRecord.Level;
import com.example.javaex.junior.t01_coban.Bai05JrEnumRecord.Point;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai05JrEnumRecordTest {

    @Test
    void label() {
        assertEquals("thấp", Bai05JrEnumRecord.label(Level.LOW));
        assertEquals("vừa", Bai05JrEnumRecord.label(Level.MEDIUM));
        assertEquals("cao", Bai05JrEnumRecord.label(Level.HIGH));
    }

    @Test
    void parseIgnoresCaseAndSpaces() {
        assertEquals(Level.HIGH, Bai05JrEnumRecord.parse(" high "));
        assertEquals(Level.LOW, Bai05JrEnumRecord.parse("Low"));
        assertThrows(IllegalArgumentException.class, () -> Bai05JrEnumRecord.parse("extreme"));
    }

    @Test
    void nextIsCyclic() {
        assertEquals(Level.MEDIUM, Bai05JrEnumRecord.next(Level.LOW));
        assertEquals(Level.HIGH, Bai05JrEnumRecord.next(Level.MEDIUM));
        assertEquals(Level.LOW, Bai05JrEnumRecord.next(Level.HIGH));
    }

    @Test
    void countByLevelContainsAllKeys() {
        EnumMap<Level, Integer> m = Bai05JrEnumRecord.countByLevel(List.of(Level.HIGH, Level.LOW, Level.HIGH));
        assertEquals(2, m.get(Level.HIGH));
        assertEquals(1, m.get(Level.LOW));
        assertEquals(0, m.get(Level.MEDIUM));
        assertEquals(3, m.size());
    }

    @Test
    void recordBasics() {
        assertEquals(new Point(0, 0), Point.origin());
        assertEquals(5.0, new Point(0, 0).distanceTo(new Point(3, 4)), 1e-9);
        assertEquals("Point[x=1, y=2]", new Point(1, 2).toString());
        assertEquals(new Point(1, 2).hashCode(), new Point(1, 2).hashCode());
    }

    @Test
    void recordValidatesInCompactConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Point(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Point(0, -1));
    }
}
