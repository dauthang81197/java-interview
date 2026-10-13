package com.example.javaex.junior.t01_coban;

import com.example.javaex.Todo;

/**
 * Bài 01. Kiểu nguyên thủy, tràn số, ép kiểu  [Cấp độ: Junior]  (JR-01)
 * Chủ đề: Cơ bản
 * Chạy: mvn -q test -Dtest=Bai01JrPrimitivesTest
 *
 * MỤC TIÊU: Nắm hành vi tràn số, ép kiểu ngầm/tường minh, char và dấu phẩy động qua các hàm nhỏ.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Integer.MAX_VALUE + 1 bằng bao nhiêu? Có ném exception không?
 *     - (byte) 200 bằng bao nhiêu? (int) 3.99 và (int) -3.99 bằng bao nhiêu?
 *     - 0.1 + 0.2 == 0.3 ra true hay false? 1.0 / 0 và 1 / 0 khác nhau thế nào?
 *  2. CODE
 *     - intMaxPlusOne(): tính Integer.MAX_VALUE + 1 bằng int và trả về kết quả thực.
 *     - toByte(int): ép kiểu về byte. shiftChar(c, n): trả (char)(c + n).
 *     - product(a, b): nhân hai int ra long mà KHÔNG tràn số.
 *     - safeAdd(a, b): cộng hai int, ném ArithmeticException nếu tràn (dùng Math.addExact hoặc tự kiểm tra).
 *     - pointOnePlusPointTwoEqualsPointThree(): tính thật 0.1 + 0.2 == 0.3 với double và trả kết quả.
 *     - divideByZero(): trả 1.0 / 0. integerDivision(a, b): trả a / b (b == 0 ném ArithmeticException).
 *     - truncateToInt(double): ép kiểu (int); xem hành vi với số âm, rất lớn và NaN.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao int tràn không báo lỗi (bù hai) và cách phát hiện.
 *     - Giải thích vì sao so sánh double nên dùng sai số epsilon hoặc BigDecimal.
 *  4. MỞ RỘNG
 *     - Khi nào dùng BigDecimal? Vì sao không dùng double cho tiền?
 *     - Phép toán với byte/short/char được thăng kiểu lên int như thế nào (binary numeric promotion)?
 *
 * CÂU HỎI
 *  - int tràn số thì xảy ra gì?
 *  - Khác nhau giữa chia số nguyên và chia số thực?
 *  - Vì sao 0.1 + 0.2 != 0.3?
 *  - Ép kiểu thu hẹp (narrowing) mất gì?
 *
 * TỪ KHOÁ: overflow, two's complement, narrowing cast, char arithmetic, floating point, NaN, Math.addExact
 *
 * Xong → nhắn "review JR-01"
 */
public final class Bai01JrPrimitives {
    private static final int MAX_INT = Integer.MAX_VALUE;
    private Bai01JrPrimitives() {
    }

    public static int intMaxPlusOne() {
        int max = MAX_INT + 1;
        System.out.println("max = " + max + "");
        return max;
    }

    public static byte toByte(int value) {
        return (byte) value;
    }

    public static char shiftChar(char c, int n) {
        return (char) (c + n);
    }

    public static long product(int a, int b) {
        return (long) a * b;
    }

    public static int safeAdd(int a, int b) {
        return Math.addExact(a, b);
    }

    public static boolean pointOnePlusPointTwoEqualsPointThree() {
        return 0.1 + 0.2 == 0.3;
    }

    public static double divideByZero() {
        return 1.0 / 0;
    }

    public static int integerDivision(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static int truncateToInt(double d) {
        return (int) d;
    }

    public static void main(String[] args) {
        System.out.println(Bai01JrPrimitives.intMaxPlusOne());
        System.out.println(Bai01JrPrimitives.toByte(128));
    }
}



// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
// Khoong bieest
//
// GIẢI THÍCH:
// An int has a fixed number of bit. The hardware adds the bit and simply discards the carry
// So the result around
// Use an epsilon when small error are acceptable and use Bigdecimal when you exact presion
//
