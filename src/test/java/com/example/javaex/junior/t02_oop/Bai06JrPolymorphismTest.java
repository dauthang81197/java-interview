package com.example.javaex.junior.t02_oop;

import com.example.javaex.junior.t02_oop.Bai06JrPolymorphism.Circle;
import com.example.javaex.junior.t02_oop.Bai06JrPolymorphism.Rectangle;
import com.example.javaex.junior.t02_oop.Bai06JrPolymorphism.Shape;
import com.example.javaex.junior.t02_oop.Bai06JrPolymorphism.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai06JrPolymorphismTest {

    @Test
    void areas() {
        assertEquals(Math.PI, new Circle(1).area(), 1e-9);
        assertEquals(6.0, new Rectangle(2, 3).area(), 1e-9);
        assertEquals(9.0, new Square(3).area(), 1e-9);
    }

    @Test
    void squareIsARectangle() {
        Rectangle r = new Square(2);
        assertEquals(4.0, r.area(), 1e-9);
        assertEquals("Square", r.name());
    }

    @Test
    void totalAreaThroughBaseType() {
        List<Shape> shapes = List.of(new Rectangle(2, 3), new Square(2), new Circle(0));
        assertEquals(10.0, Bai06JrPolymorphism.totalArea(shapes), 1e-9);
        assertEquals(0.0, Bai06JrPolymorphism.totalArea(List.of()), 1e-9);
    }

    @Test
    void overloadIsChosenAtCompileTime() {
        Circle c = new Circle(1);
        Shape s = c;
        assertEquals("circle", Bai06JrPolymorphism.which(c));
        assertEquals("shape", Bai06JrPolymorphism.which(s));
        assertEquals("shape", Bai06JrPolymorphism.overloadByStaticType());
    }

    @Test
    void overrideIsChosenAtRuntime() {
        assertEquals("Square", Bai06JrPolymorphism.overrideByRuntimeType());
    }
}
