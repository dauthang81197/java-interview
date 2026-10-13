package com.example.javaex.junior.t01_coban;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 02. ==, equals, autoboxing, Integer cache  [Cấp độ: Junior]  (JR-02)
 * Chủ đề: Cơ bản
 * Chạy: mvn -q test -Dtest=Bai02JrBoxingTest
 *
 * MỤC TIÊU: Hiểu bẫy của == với wrapper, Integer cache, unboxing null và so sánh NaN.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Integer a = 127, b = 127; a == b ra gì? Còn với 128?
 *     - Long.valueOf(1).equals(1) ra true hay false? Vì sao?
 *     - int x = (Integer) null; ném lỗi gì? Double.NaN == Double.NaN ra gì?
 *  2. CODE
 *     - Mỗi hàm bool bên dưới phải TÍNH THẬT biểu thức mô tả trong tên hàm rồi trả kết quả (không return hằng số), kèm comment giải thích:
 *     - integerCacheSmall(): hai Integer cùng giá trị 127 so sánh bằng ==.
 *     - integerCacheLarge(): hai Integer cùng giá trị 128 (autobox riêng) so sánh bằng ==.
 *     - longEqualsInt(): Long.valueOf(1L).equals(1).
 *     - unboxNullThrows(): thử unbox một Integer null, trả true nếu có NullPointerException.
 *     - nanPrimitiveEqualsItself(): double NaN == NaN. nanBoxedEqualsItself(): Double.valueOf(NaN).equals(NaN).
 *     - sumIgnoringNulls(List<Integer>): cộng các phần tử, bỏ qua null.
 *     - sameValue(Integer a, Integer b): so sánh đúng nghĩa, null-safe (null và null là bằng nhau).
 *  3. GIẢI THÍCH
 *     - Giải thích Integer cache hoạt động thế nào (-128..127) và có chỉnh được không.
 *     - Giải thích autoboxing/unboxing xảy ra ở đâu trong sumIgnoringNulls.
 *  4. MỞ RỘNG
 *     - Chi phí hiệu năng của autoboxing trong vòng lặp lớn và cách tránh (IntStream, mảng nguyên thủy).
 *     - Vì sao Double.equals khác == với NaN và -0.0?
 *
 * CÂU HỎI
 *  - == và equals khác nhau thế nào?
 *  - Integer cache là gì, bẫy gì khi so sánh Integer?
 *  - Autoboxing có thể gây NullPointerException ở đâu?
 *  - Vì sao Long.equals(Integer) là false?
 *
 * TỪ KHOÁ: autoboxing, Integer cache, == vs equals, unboxing NPE, NaN, valueOf
 *
 * Xong → nhắn "review JR-02"
 */
public final class Bai02JrBoxing {
    private Bai02JrBoxing() {
    }

    public static boolean integerCacheSmall() {
        throw Todo.todo("JR-02");
    }

    public static boolean integerCacheLarge() {
        throw Todo.todo("JR-02");
    }

    public static boolean longEqualsInt() {
        throw Todo.todo("JR-02");
    }

    public static boolean unboxNullThrows() {
        throw Todo.todo("JR-02");
    }

    public static boolean nanPrimitiveEqualsItself() {
        throw Todo.todo("JR-02");
    }

    public static boolean nanBoxedEqualsItself() {
        throw Todo.todo("JR-02");
    }

    public static int sumIgnoringNulls(List<Integer> numbers) {
        throw Todo.todo("JR-02");
    }

    public static boolean sameValue(Integer a, Integer b) {
        throw Todo.todo("JR-02");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
