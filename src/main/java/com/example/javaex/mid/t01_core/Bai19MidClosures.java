package com.example.javaex.mid.t01_core;

import com.example.javaex.Todo;

import java.util.List;
import java.util.function.Supplier;

/**
 * Bài 19. Inner class, anonymous class và lambda capture  [Cấp độ: Mid]  (MID-04)
 * Chủ đề: Nền tảng nâng cao
 * Chạy: mvn -q test -Dtest=Bai19MidClosuresTest
 *
 * MỤC TIÊU: Phân biệt this trong lambda và anonymous class, inner class dùng chung trạng thái outer, và bẫy bắt biến vòng lặp.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Trong lambda, this trỏ tới đâu? Trong anonymous class thì sao?
 *     - Vòng for (int i...) tạo lambda dùng i: có biên dịch được không? Cách đúng?
 *     - Inner class (không static) có giữ tham chiếu ẩn tới outer không? Hệ quả với GC?
 *  2. CODE
 *     - makeSquares(n): trả danh sách n Supplier<Integer>; Supplier thứ i trả i * i (cẩn thận bắt biến vòng lặp).
 *     - Outer.lambdaSupplier(): trả Supplier<String> dạng lambda, get() trả "lambda:" + this (this là Outer).
 *     - Outer.anonymousSupplier(): trả anonymous class implements Supplier<String>, get() trả "anon:" + (this instanceof Supplier) (kỳ vọng "anon:true").
 *     - Outer.newCounter() trả Counter (inner class không static); Counter.inc() tăng bộ đếm total của chính Outer tạo ra nó; Outer.total() trả giá trị hiện tại.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao lambda chỉ bắt biến effectively final.
 *     - Giải thích inner class giữ outer ngầm và nguy cơ rò rỉ bộ nhớ.
 *  4. MỞ RỘNG
 *     - Dùng static nested class thay inner class khi nào?
 *     - Giải thích biên dịch lambda bằng invokedynamic vs anonymous class tạo file .class.
 *
 * CÂU HỎI
 *  - Lambda và anonymous class khác nhau thế nào (this, scope, biên dịch)?
 *  - Inner, static nested, local, anonymous class khác nhau thế nào?
 *  - Vì sao inner class có thể gây memory leak?
 *
 * TỪ KHOÁ: inner class, anonymous class, lambda capture, effectively final, this, invokedynamic
 *
 * Xong → nhắn "review MID-04"
 */
public final class Bai19MidClosures {
    private Bai19MidClosures() {
    }

    public static class Outer {
        private final String name;
        private int total;

        public Outer(String name) {
            this.name = name;
        }

        public class Counter {
            public void inc() {
                throw Todo.todo("MID-04");
            }
        }

        public Counter newCounter() {
            throw Todo.todo("MID-04");
        }

        public int total() {
            throw Todo.todo("MID-04");
        }

        public Supplier<String> lambdaSupplier() {
            throw Todo.todo("MID-04");
        }

        public Supplier<String> anonymousSupplier() {
            throw Todo.todo("MID-04");
        }

        @Override
        public String toString() {
            return "Outer(" + name + ")";
        }
    }

    public static List<Supplier<Integer>> makeSquares(int n) {
        throw Todo.todo("MID-04");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
