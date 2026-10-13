package com.example.javaex.mid.t03_collections;

import com.example.javaex.mid.t03_collections.Bai24MidStreamExercises.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Bai24MidStreamExercisesTest {

    private final List<Employee> emps = List.of(
            new Employee("Lan", "IT", 3000),
            new Employee("An", "IT", 5000),
            new Employee("Binh", "HR", 2000),
            new Employee("Chi", "HR", 2500),
            new Employee("Dung", "OPS", 4000));

    @Test
    void groupByFirstLetter() {
        Map<String, List<String>> r = Bai24MidStreamExercises.groupByFirstLetter(List.of("apple", "Avocado", "banana", "", "blueberry", "cherry"));
        assertEquals(Map.of("A", List.of("apple", "Avocado"), "B", List.of("banana", "blueberry"), "C", List.of("cherry")), r);
    }

    @Test
    void topNWords() {
        String text = "The cat and the dog. The END, and the cat!";
        assertEquals(List.of("the", "and", "cat"), Bai24MidStreamExercises.topNWords(text, 3));
        assertEquals(List.of("the"), Bai24MidStreamExercises.topNWords(text, 1));
        assertEquals(List.of(), Bai24MidStreamExercises.topNWords("", 3));
    }

    @Test
    void averageSalaryByDept() {
        Map<String, Double> r = Bai24MidStreamExercises.averageSalaryByDept(emps);
        assertEquals(3, r.size());
        assertEquals(4000.0, r.get("IT"), 1e-9);
        assertEquals(2250.0, r.get("HR"), 1e-9);
        assertEquals(4000.0, r.get("OPS"), 1e-9);
    }

    @Test
    void highestPaid() {
        assertEquals("An", Bai24MidStreamExercises.highestPaid(emps).orElseThrow().name());
        assertEquals(Optional.empty(), Bai24MidStreamExercises.highestPaid(List.of()));
    }

    @Test
    void joinNames() {
        assertEquals("An, Binh, Chi, Dung, Lan", Bai24MidStreamExercises.joinNames(emps));
        assertEquals("", Bai24MidStreamExercises.joinNames(List.of()));
    }

    @Test
    void flattenDistinctSorted() {
        assertEquals(List.of(1, 2, 3, 5, 9),
                Bai24MidStreamExercises.flattenDistinctSorted(List.of(List.of(5, 3, 1), List.of(9, 3), List.of(), List.of(2, 1))));
    }

    @Test
    void topNWordsEdgeCases() {
        assertEquals(List.of(), Bai24MidStreamExercises.topNWords("123 ... !!", 3));
        assertThrows(IllegalArgumentException.class, () -> Bai24MidStreamExercises.topNWords("a b", -1));
        assertEquals(List.of("việt", "đẹp"), Bai24MidStreamExercises.topNWords("Việt đẹp, đẹp Việt", 5).stream().sorted().toList());
    }
}
