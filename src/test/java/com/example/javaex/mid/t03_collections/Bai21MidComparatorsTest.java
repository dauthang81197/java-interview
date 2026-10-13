package com.example.javaex.mid.t03_collections;

import com.example.javaex.mid.t03_collections.Bai21MidComparators.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai21MidComparatorsTest {

    private final List<Employee> emps = List.of(
            new Employee("Lan", "IT", 3000, 30),
            new Employee("An", "HR", 2000, 25),
            new Employee("Binh", "IT", 5000, 41),
            new Employee("Chi", "HR", 2000, 35),
            new Employee("Dung", "IT", 3000, 28));

    private static List<String> names(List<Employee> l) {
        return l.stream().map(Employee::name).toList();
    }

    @Test
    void deptThenSalaryDesc() {
        // HR: An(2000), Chi(2000) giữ thứ tự gốc; IT: Binh, rồi Lan/Dung (3000) giữ thứ tự gốc
        assertEquals(List.of("An", "Chi", "Binh", "Lan", "Dung"),
                names(Bai21MidComparators.sortByDeptThenSalaryDesc(emps)));
        assertEquals("Lan", emps.get(0).name());
    }

    @Test
    void nullsLastIgnoreCase() {
        List<String> in = Arrays.asList("banana", null, "Apple", "cherry", null, "apple2");
        assertEquals(Arrays.asList("Apple", "apple2", "banana", "cherry", null, null),
                Bai21MidComparators.sortNamesNullsLastIgnoreCase(in));
    }

    @Test
    void sortingByDeptIsStable() {
        assertEquals(List.of("An", "Chi", "Lan", "Binh", "Dung"),
                names(Bai21MidComparators.sortByDeptKeepingOrder(emps)));
    }

    @Test
    void comparatorBySalaryDescThenName() {
        List<Employee> sorted = emps.stream().sorted(Bai21MidComparators.bySalaryDescThenNameAsc()).toList();
        assertEquals(List.of("Binh", "Dung", "Lan", "An", "Chi"), names(sorted));
    }
}
