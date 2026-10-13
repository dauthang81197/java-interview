package com.example.javaex.mid.t04_modern;

import com.example.javaex.Todo;

/**
 * Bài 26. Sealed, record và pattern matching (Java 21)  [Cấp độ: Mid]  (MID-11)
 * Chủ đề: Java 21 hiện đại
 * Chạy: mvn -q test -Dtest=Bai26MidSealedPatternsTest
 *
 * MỤC TIÊU: Dùng sealed interface, record, switch pattern matching với guard và record deconstruction.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - switch trên sealed interface đã liệt kê hết các lớp con có cần default không?
 *     - case Integer i when i > 10 nghĩa là gì? Thứ tự các case ảnh hưởng thế nào?
 *     - Record pattern Rect(var w, var h) làm gì?
 *  2. CODE
 *     - area(shape): tính diện tích bằng switch pattern matching, không có default: Circle = PI*r*r, Rect = w*h, Tri = base*height/2.
 *     - classify(shape): dùng record deconstruction: Circle bán kính 0 -> "điểm"; Circle -> "tròn"; Rect w==h -> "vuông"; Rect -> "chữ nhật"; Tri -> "tam giác".
 *     - describe(Object): Integer > 10 -> "số lớn"; Integer khác -> "số"; String blank -> "chuỗi rỗng"; String khác -> "chuỗi dài N" (N là độ dài); null -> "null"; còn lại -> "khác".
 *  3. GIẢI THÍCH
 *     - Giải thích lợi ích của sealed khi thêm lớp con mới (trình biên dịch nhắc cập nhật switch).
 *     - Giải thích case null và dominance trong switch pattern.
 *  4. MỞ RỘNG
 *     - Thêm một hình mới vào sealed interface và quan sát lỗi biên dịch ở switch.
 *     - So sánh với visitor pattern.
 *
 * CÂU HỎI
 *  - sealed class/interface dùng để làm gì?
 *  - Pattern matching for switch khác switch cũ thế nào?
 *  - Record pattern (deconstruction) là gì?
 *  - Exhaustiveness checking là gì?
 *
 * TỪ KHOÁ: sealed interface, record, pattern matching, switch guard, record pattern, Java 21
 *
 * Xong → nhắn "review MID-11"
 */
public final class Bai26MidSealedPatterns {
    private Bai26MidSealedPatterns() {
    }

    public sealed interface Shape permits Circle, Rect, Tri {
    }

    public record Circle(double r) implements Shape {
    }

    public record Rect(double w, double h) implements Shape {
    }

    public record Tri(double base, double height) implements Shape {
    }

    public static double area(Shape shape) {
        throw Todo.todo("MID-11");
    }

    public static String classify(Shape shape) {
        throw Todo.todo("MID-11");
    }

    public static String describe(Object o) {
        throw Todo.todo("MID-11");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
