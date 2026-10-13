package com.example.javaex.junior.t02_oop;

import com.example.javaex.Todo;

/**
 * Bài 07. Abstract class và interface  [Cấp độ: Junior]  (JR-07)
 * Chủ đề: OOP
 * Chạy: mvn -q test -Dtest=Bai07JrInterfacesTest
 *
 * MỤC TIÊU: Dùng abstract class (template method) và interface có default method, giải quyết xung đột default.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Hai interface cùng có default method move() mà class implements cả hai: có biên dịch được không?
 *     - Employee.pay() là final và gọi base() + bonus(): lớp con muốn đổi cách tính tiền phải làm gì?
 *     - Có thể new Employee() không? Vì sao?
 *  2. CODE
 *     - Duck implements Flyer, Swimmer (cả hai có default move()): move() phải trả "fly and swim" bằng cách gọi Flyer.super.move() và Swimmer.super.move().
 *     - Manager extends Employee: base() = 1000, bonus() = 500. Intern extends Employee: base() = 300 (giữ bonus mặc định = 0).
 *     - Employee (cho sẵn) là abstract với template method final pay() = base() + bonus().
 *  3. GIẢI THÍCH
 *     - Giải thích khi nào dùng abstract class, khi nào dùng interface.
 *     - Giải thích quy tắc giải quyết xung đột default method (diamond).
 *  4. MỞ RỘNG
 *     - Interface có static method, private method (Java 9) dùng để làm gì?
 *     - sealed interface (Java 17) khác interface thường ra sao?
 *
 * CÂU HỎI
 *  - abstract class và interface khác nhau thế nào (Java 8+)?
 *  - Default method sinh ra để làm gì?
 *  - Một class implements hai interface cùng default method thì sao?
 *  - Template method pattern là gì?
 *
 * TỪ KHOÁ: abstract class, interface, default method, diamond problem, template method
 *
 * Xong → nhắn "review JR-07"
 */
public final class Bai07JrInterfaces {
    private Bai07JrInterfaces() {
    }

    public interface Flyer {
        default String move() {
            return "fly";
        }
    }

    public interface Swimmer {
        default String move() {
            return "swim";
        }
    }

    public static class Duck implements Flyer, Swimmer {
        @Override
        public String move() {
            throw Todo.todo("JR-07");
        }
    }

    public abstract static class Employee {
        public final double pay() {
            return base() + bonus();
        }

        public abstract double base();

        public double bonus() {
            return 0;
        }
    }

    public static class Manager extends Employee {
        @Override
        public double base() {
            throw Todo.todo("JR-07");
        }

        @Override
        public double bonus() {
            throw Todo.todo("JR-07");
        }
    }

    public static class Intern extends Employee {
        @Override
        public double base() {
            throw Todo.todo("JR-07");
        }
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
