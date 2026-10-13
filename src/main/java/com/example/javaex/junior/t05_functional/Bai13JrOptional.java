package com.example.javaex.junior.t05_functional;

import com.example.javaex.Todo;

import java.util.List;
import java.util.Optional;

/**
 * Bài 13. Optional cơ bản  [Cấp độ: Junior]  (JR-13)
 * Chủ đề: Lambda và Optional
 * Chạy: mvn -q test -Dtest=Bai13JrOptionalTest
 *
 * MỤC TIÊU: Dùng Optional để biểu diễn giá trị có thể vắng mặt, thay cho null.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Optional.of(null) và Optional.ofNullable(null) khác nhau thế nào?
 *     - orElse(x) và orElseGet(() -> x) khác nhau ở điểm nào về việc tính x?
 *     - Có nên dùng Optional làm tham số hoặc field không?
 *  2. CODE
 *     - findFirstLongerThan(words, n): Optional của từ đầu tiên dài hơn n (dùng stream hoặc vòng lặp).
 *     - displayName(name): trả giá trị hoặc "ẩn danh" nếu rỗng.
 *     - parse(text): Optional<Integer>; rỗng nếu text null hoặc không phải số.
 *     - lengthOrZero(nullableText): dùng Optional.ofNullable + map để trả độ dài hoặc 0.
 *     - firstNonBlank(String... candidates): Optional của chuỗi đầu tiên không null và không blank.
 *     - requireValue(value): trả giá trị hoặc ném IllegalStateException("thiếu giá trị").
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao Optional chủ yếu dùng cho kiểu trả về.
 *     - Giải thích map và flatMap của Optional.
 *  4. MỞ RỘNG
 *     - Viết lại một chuỗi if (x != null) lồng nhau bằng Optional.
 *     - OptionalInt, OptionalDouble dùng khi nào?
 *
 * CÂU HỎI
 *  - Optional sinh ra để làm gì?
 *  - Optional.get() có vấn đề gì?
 *  - Optional có nên là field/tham số không?
 *  - map và flatMap trong Optional?
 *
 * TỪ KHOÁ: Optional, ofNullable, orElse, orElseGet, orElseThrow, map, flatMap
 *
 * Xong → nhắn "review JR-13"
 */
public final class Bai13JrOptional {
    private Bai13JrOptional() {
    }

    public static Optional<String> findFirstLongerThan(List<String> words, int n) {
        throw Todo.todo("JR-13");
    }

    public static String displayName(Optional<String> name) {
        throw Todo.todo("JR-13");
    }

    public static Optional<Integer> parse(String text) {
        throw Todo.todo("JR-13");
    }

    public static int lengthOrZero(String nullableText) {
        throw Todo.todo("JR-13");
    }

    public static Optional<String> firstNonBlank(String... candidates) {
        throw Todo.todo("JR-13");
    }

    public static String requireValue(Optional<String> value) {
        throw Todo.todo("JR-13");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
