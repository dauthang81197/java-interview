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
        Integer a = 127;
        Integer b = 127;
        return a == b; // return true because Integer cache values from -128 to 127
      // so a and b reference the same object
    }

    public static boolean integerCacheLarge() {
        Integer a = 128;
        Integer b = 128;
        return a == b; // return false because Integer cache values from -128 to 127
    }

    public static boolean longEqualsInt() {
        return Long.valueOf(1L).equals(1); // false
        // Because method equals cannot accept primitive types, so
        // Java automatically convert 1 to a Integer Object

    }

    public static boolean unboxNullThrows() {
        Integer x = null;
        try {
            int y = x;
            // Unboxing o day se chuyen tu Integer sang int, nhung x null thif se bi loi
            return false;
        } catch (NullPointerException e) {
            return true;
        }

    }

    public static boolean nanPrimitiveEqualsItself() {
            double x = Double.NaN;
            return x == x; // false , NaN không bằng bất kỳ giá trị nào, kể cả chính nó.
    }

    public static boolean nanBoxedEqualsItself() {
        Double x = Double.valueOf(Double.NaN);
        return x.equals(x);
    }

    public static int sumIgnoringNulls(List<Integer> numbers) {
        int sum = 0;

        for (Integer x : numbers) {
            if (x != null) {
                sum += x;
            }
        }

        return sum;
    }

    public static boolean sameValue(Integer a, Integer b) {
        return java.util.Objects.equals(a, b);
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
// false
// false, equals 1L, because different type
// int x = (Integer) null Throw null point exception , Double.NaN == Double.NaN khong biet
// GIẢI THÍCH:
//
//
