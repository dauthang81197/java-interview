package com.example.javaex.junior.t05_functional;

import com.example.javaex.Todo;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Bài 12. Lambda và functional interface cơ bản  [Cấp độ: Junior]  (JR-12)
 * Chủ đề: Lambda và Optional
 * Chạy: mvn -q test -Dtest=Bai12JrLambdasTest
 *
 * MỤC TIÊU: Viết và sử dụng Function, Predicate, Supplier, closure bắt biến bên ngoài.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Lambda có thể sửa biến local int của hàm bao ngoài không? Vì sao?
 *     - Mỗi lần gọi counter() có chia sẻ bộ đếm với lần gọi trước không?
 *     - Function<A,B> và Function<B,C> ghép lại thành gì?
 *  2. CODE
 *     - adder(n): trả Function cộng n vào đối số.
 *     - longerThan(n): trả Predicate<String> true khi độ dài > n.
 *     - filter(items, condition): lọc bằng vòng lặp (không dùng Stream), trả danh sách mới.
 *     - counter(): trả Supplier<Integer> mỗi lần get() trả 1, 2, 3, ... (mỗi Supplier có bộ đếm riêng; gợi ý AtomicInteger hoặc mảng 1 phần tử).
 *     - compose(first, second): trả hàm áp dụng first rồi second (không dùng andThen).
 *     - sortByLength(words): trả danh sách mới sắp xếp theo độ dài tăng dần bằng lambda comparator (sắp xếp ổn định).
 *  3. GIẢI THÍCH
 *     - Giải thích "effectively final" và vì sao lambda chỉ bắt được biến như vậy.
 *     - Giải thích functional interface và @FunctionalInterface.
 *  4. MỞ RỘNG
 *     - Method reference có mấy loại? Viết lại longerThan bằng method reference nếu được.
 *     - So sánh lambda với anonymous class (this, tạo lớp).
 *
 * CÂU HỎI
 *  - Functional interface là gì? Kể tên vài cái trong java.util.function.
 *  - Lambda bắt biến local thế nào?
 *  - Method reference khác lambda ở đâu?
 *  - Lambda có tạo ra lớp mới lúc biên dịch không (invokedynamic)?
 *
 * TỪ KHOÁ: lambda, Function, Predicate, Supplier, closure, effectively final, method reference
 *
 * Xong → nhắn "review JR-12"
 */
public final class Bai12JrLambdas {
    private Bai12JrLambdas() {
    }

    public static Function<Integer, Integer> adder(int n) {
        throw Todo.todo("JR-12");
    }

    public static Predicate<String> longerThan(int n) {
        throw Todo.todo("JR-12");
    }

    public static <T> List<T> filter(List<T> items, Predicate<T> condition) {
        throw Todo.todo("JR-12");
    }

    public static Supplier<Integer> counter() {
        throw Todo.todo("JR-12");
    }

    public static <A, B, C> Function<A, C> compose(Function<A, B> first, Function<B, C> second) {
        throw Todo.todo("JR-12");
    }

    public static List<String> sortByLength(List<String> words) {
        throw Todo.todo("JR-12");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
