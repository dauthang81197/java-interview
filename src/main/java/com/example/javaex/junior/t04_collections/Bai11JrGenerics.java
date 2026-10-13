package com.example.javaex.junior.t04_collections;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 11. Generics cơ bản  [Cấp độ: Junior]  (JR-11)
 * Chủ đề: Collections và Generics
 * Chạy: mvn -q test -Dtest=Bai11JrGenericsTest
 *
 * MỤC TIÊU: Viết lớp và hàm generic đơn giản: Box, Pair, firstOrNull, swap, maxOf.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Box<String> b; b.set(5) có biên dịch không? Lợi ích so với Object?
 *     - Có viết được new T() hoặc new T[10] trong lớp generic không?
 *     - Vì sao maxOf cần ràng buộc T extends Comparable<T>?
 *  2. CODE
 *     - Box<T>: constructor nhận giá trị; get(), set(value), isEmpty() (true khi giá trị là null).
 *     - Pair<A, B>: first(), second(), swapped() trả Pair<B, A> mới.
 *     - firstOrNull(list): phần tử đầu hoặc null nếu rỗng.
 *     - swap(list, i, j): đổi chỗ hai phần tử; index sai ném IndexOutOfBoundsException.
 *     - maxOf(a, b): trả phần tử lớn hơn theo compareTo (bằng nhau trả a).
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao generics giúp an toàn kiểu ngay lúc biên dịch.
 *     - Giải thích type erasure ở mức đơn giản.
 *  4. MỞ RỘNG
 *     - Thử viết hàm generic với ràng buộc T extends Number & Comparable<T>.
 *     - Đọc trước bài Generics và PECS (bài sau) để hiểu wildcard.
 *
 * CÂU HỎI
 *  - Generics để làm gì?
 *  - Type erasure là gì?
 *  - List<Object> có phải là cha của List<String> không?
 *  - Bounded type parameter là gì?
 *
 * TỪ KHOÁ: generics, type parameter, bounded type, type erasure, Pair, Box
 *
 * Xong → nhắn "review JR-11"
 */
public final class Bai11JrGenerics {
    private Bai11JrGenerics() {
    }

    public static class Box<T> {
        public Box(T value) {
            throw Todo.todo("JR-11");
        }

        public T get() {
            throw Todo.todo("JR-11");
        }

        public void set(T value) {
            throw Todo.todo("JR-11");
        }

        public boolean isEmpty() {
            throw Todo.todo("JR-11");
        }
    }

    public static class Pair<A, B> {
        public Pair(A first, B second) {
            throw Todo.todo("JR-11");
        }

        public A first() {
            throw Todo.todo("JR-11");
        }

        public B second() {
            throw Todo.todo("JR-11");
        }

        public Pair<B, A> swapped() {
            throw Todo.todo("JR-11");
        }
    }

    public static <T> T firstOrNull(List<T> list) {
        throw Todo.todo("JR-11");
    }

    public static <T> void swap(List<T> list, int i, int j) {
        throw Todo.todo("JR-11");
    }

    public static <T extends Comparable<T>> T maxOf(T a, T b) {
        throw Todo.todo("JR-11");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
