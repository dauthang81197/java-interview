package com.example.javaex.junior.t02_oop;

import com.example.javaex.junior.t02_oop.Bai07JrInterfaces.Duck;
import com.example.javaex.junior.t02_oop.Bai07JrInterfaces.Employee;
import com.example.javaex.junior.t02_oop.Bai07JrInterfaces.Intern;
import com.example.javaex.junior.t02_oop.Bai07JrInterfaces.Manager;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class Bai07JrInterfacesTest {

    @Test
    void duckResolvesDiamondOfDefaultMethods() {
        assertEquals("fly and swim", new Duck().move());
    }

    @Test
    void templateMethodWithAbstractClass() {
        assertTrue(Modifier.isAbstract(Employee.class.getModifiers()));
        assertEquals(1500.0, new Manager().pay(), 1e-9);
        assertEquals(300.0, new Intern().pay(), 1e-9);
    }

    @Test
    void polymorphicCall() {
        Employee e = new Manager();
        assertEquals(1000.0, e.base(), 1e-9);
        assertEquals(500.0, e.bonus(), 1e-9);
        assertEquals(0.0, new Intern().bonus(), 1e-9);
    }
}
