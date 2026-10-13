package com.example.javaex.mid.t03_collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Bai23MidGenericsExercisesTest {

    static class Fruit implements Comparable<Fruit> {
        final int weight;

        Fruit(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Fruit o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static class Apple extends Fruit {
        Apple(int weight) {
            super(weight);
        }
    }

    @Test
    void copyIntegersIntoObjectList() {
        List<Object> dst = new ArrayList<>(List.of("x"));
        List<Integer> src = List.of(1, 2, 3);
        Bai23MidGenericsExercises.copy(dst, src);
        assertEquals(List.of("x", 1, 2, 3), dst);
    }

    @Test
    void copyIntoNumberList() {
        List<Number> dst = new ArrayList<>();
        Bai23MidGenericsExercises.copy(dst, List.of(1, 2));
        Bai23MidGenericsExercises.copy(dst, List.of(2.5));
        assertEquals(List.of(1, 2, 2.5), dst);
    }

    @Test
    void maxOfApples() {
        Apple heavy = new Apple(9);
        List<Apple> apples = List.of(new Apple(3), heavy, new Apple(5));
        Apple m = Bai23MidGenericsExercises.max(apples);
        assertSame(heavy, m);
    }

    @Test
    void maxOfStringsAndEmpty() {
        assertEquals("pear", Bai23MidGenericsExercises.max(List.of("apple", "pear", "fig")));
        assertThrows(NoSuchElementException.class, () -> Bai23MidGenericsExercises.max(new ArrayList<Integer>()));
    }

    @Test
    void sumMixedNumbers() {
        assertEquals(6.5, Bai23MidGenericsExercises.sum(List.of(1, 2, 3.5)), 1e-9);
        List<Integer> ints = List.of(1, 2, 3);
        assertEquals(6.0, Bai23MidGenericsExercises.sum(ints), 1e-9);
        assertEquals(0.0, Bai23MidGenericsExercises.sum(List.of()), 1e-9);
    }

    @Test
    void keyOfMaxValue() {
        Map<String, Integer> m = new HashMap<>();
        m.put("a", 3);
        m.put("b", 10);
        m.put("c", 7);
        assertEquals("b", Bai23MidGenericsExercises.keyOfMaxValue(m));
        assertNull(Bai23MidGenericsExercises.keyOfMaxValue(new HashMap<String, Integer>()));
    }
}
