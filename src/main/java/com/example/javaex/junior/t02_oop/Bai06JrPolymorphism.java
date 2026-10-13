package com.example.javaex.junior.t02_oop;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 06. Kế thừa, đa hình, override và overload  [Cấp độ: Junior]  (JR-06)
 * Chủ đề: OOP
 * Chạy: mvn -q test -Dtest=Bai06JrPolymorphismTest
 *
 * MỤC TIÊU: Cài các lớp hình học kế thừa Shape và phân biệt override (runtime) với overload (compile-time).
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Shape s = new Circle(1); gọi which(s) với hai hàm which(Shape) và which(Circle): hàm nào chạy? Vì sao?
 *     - Shape s = new Square(2); s.name() trả về gì (getClass().getSimpleName())?
 *     - Square extends Rectangle: gọi area() sẽ chạy mã của lớp nào?
 *  2. CODE
 *     - Circle(radius): area() = PI * r * r. Rectangle(width, height): area() = width * height. (Square cho sẵn, kế thừa Rectangle.)
 *     - totalArea(List<? extends Shape>): tổng diện tích; danh sách rỗng -> 0.
 *     - which(Shape) trả "shape"; which(Circle) trả "circle".
 *     - overloadByStaticType(): khai báo Shape s = new Circle(1) rồi trả which(s) (kết quả thực).
 *     - overrideByRuntimeType(): khai báo Shape s = new Square(2) rồi trả s.name().
 *  3. GIẢI THÍCH
 *     - Giải thích overload được chọn lúc biên dịch theo kiểu khai báo, còn override chọn lúc chạy theo kiểu thực.
 *     - Giải thích vì sao Square dùng lại được Rectangle (và khi nào kế thừa này sai về thiết kế).
 *  4. MỞ RỘNG
 *     - Vấn đề hình vuông - hình chữ nhật (nguyên lý thay thế Liskov).
 *     - Composition over inheritance: khi nào nên dùng?
 *
 * CÂU HỎI
 *  - Override và overload khác nhau thế nào?
 *  - Dynamic dispatch là gì?
 *  - Static method và field có đa hình không?
 *  - abstract class có constructor không?
 *
 * TỪ KHOÁ: inheritance, polymorphism, override, overload, dynamic dispatch, Liskov
 *
 * Xong → nhắn "review JR-06"
 */
public final class Bai06JrPolymorphism {
    private Bai06JrPolymorphism() {
    }

    public abstract static class Shape {
        public abstract double area();

        public String name() {
            return getClass().getSimpleName();
        }
    }

    public static class Circle extends Shape {
        public Circle(double radius) {
            throw Todo.todo("JR-06");
        }

        @Override
        public double area() {
            throw Todo.todo("JR-06");
        }
    }

    public static class Rectangle extends Shape {
        public Rectangle(double width, double height) {
            throw Todo.todo("JR-06");
        }

        @Override
        public double area() {
            throw Todo.todo("JR-06");
        }
    }

    /** Cho sẵn: hình vuông là hình chữ nhật đặc biệt. */
    public static class Square extends Rectangle {
        public Square(double side) {
            super(side, side);
        }
    }

    public static double totalArea(List<? extends Shape> shapes) {
        throw Todo.todo("JR-06");
    }

    public static String which(Shape s) {
        throw Todo.todo("JR-06");
    }

    public static String which(Circle c) {
        throw Todo.todo("JR-06");
    }

    public static String overloadByStaticType() {
        throw Todo.todo("JR-06");
    }

    public static String overrideByRuntimeType() {
        throw Todo.todo("JR-06");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
