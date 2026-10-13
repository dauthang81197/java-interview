package com.example.javaex.junior.t04_collections;

import com.example.javaex.junior.t04_collections.Bai10JrCollectionsBasics.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Bai10JrCollectionsBasicsTest {

    @Test
    void removeDuplicatesKeepOrder() {
        List<String> in = List.of("b", "a", "b", "c", "a");
        assertEquals(List.of("b", "a", "c"), Bai10JrCollectionsBasics.removeDuplicatesKeepOrder(in));
        assertEquals(5, in.size());
    }

    @Test
    void countWordsKeepsFirstAppearanceOrder() {
        Map<String, Integer> m = Bai10JrCollectionsBasics.countWords(List.of("to", "be", "or", "not", "to", "be"));
        assertEquals(List.of("to", "be", "or", "not"), List.copyOf(m.keySet()));
        assertEquals(2, m.get("to"));
        assertEquals(1, m.get("not"));
    }

    @Test
    void sortedByLengthThenAlpha() {
        assertEquals(List.of("a", "bb", "cc", "ddd"),
                Bai10JrCollectionsBasics.sortedByLengthThenAlpha(Set.of("ddd", "cc", "a", "bb")));
    }

    @Test
    void removeShorterThanInPlaceWithoutCme() {
        List<String> l = new ArrayList<>(List.of("a", "bbb", "cc", "dddd"));
        assertEquals(2, Bai10JrCollectionsBasics.removeShorterThan(l, 3));
        assertEquals(List.of("bbb", "dddd"), l);
    }

    @Test
    void hasDuplicates() {
        assertTrue(Bai10JrCollectionsBasics.hasDuplicates(Arrays.asList(1, 2, 1)));
        assertFalse(Bai10JrCollectionsBasics.hasDuplicates(List.of(1, 2, 3)));
        assertFalse(Bai10JrCollectionsBasics.hasDuplicates(List.of()));
    }

    @Test
    void personNaturalOrderIsAgeThenName() {
        List<Person> in = List.of(new Person("Lan", 30), new Person("An", 30), new Person("Binh", 25));
        List<Person> out = Bai10JrCollectionsBasics.sortNatural(in);
        assertEquals("[Binh(25), An(30), Lan(30)]", out.toString());
        assertEquals("Lan", in.get(0).name());
        assertTrue(new Person("A", 1).compareTo(new Person("A", 2)) < 0);
        assertEquals(0, new Person("A", 1).compareTo(new Person("A", 1)));
    }
}
