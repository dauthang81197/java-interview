package com.example.javaex.junior.t01_coban;

import com.example.javaex.Todo;

import java.util.EnumMap;
import java.util.List;

/**
 * Bài 05. Enum, switch expression và record  [Cấp độ: Junior]  (JR-05)
 * Chủ đề: Cơ bản
 * Chạy: mvn -q test -Dtest=Bai05JrEnumRecordTest
 *
 * MỤC TIÊU: Dùng enum với switch expression, EnumMap và record có compact constructor.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - switch expression trên enum có cần default không nếu đã liệt kê hết hằng số?
 *     - Level.valueOf("low") hoạt động hay lỗi? Lỗi gì?
 *     - record Point(int x, int y): toString, equals, hashCode có sẵn không? Có thể thêm kiểm tra dữ liệu ở đâu?
 *  2. CODE
 *     - label(Level): LOW -> "thấp", MEDIUM -> "vừa", HIGH -> "cao" (dùng switch expression).
 *     - parse(text): chuyển chuỗi thành Level, bỏ khoảng trắng, không phân biệt hoa thường; không hợp lệ ném IllegalArgumentException.
 *     - next(level): LOW -> MEDIUM -> HIGH -> LOW (vòng tròn).
 *     - countByLevel(list): EnumMap đủ 3 khoá, giá trị là số lần xuất hiện (khoá vắng mặt = 0).
 *     - Point: compact constructor ném IllegalArgumentException nếu x hoặc y âm; origin() = (0,0); distanceTo(other) = khoảng cách Euclid.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao EnumMap hiệu quả hơn HashMap cho khoá enum.
 *     - Giải thích record là gì và nó cho sẵn những gì.
 *  4. MỞ RỘNG
 *     - enum có thể có phương thức trừu tượng theo từng hằng số (constant-specific body).
 *     - record có thể implements interface, có static factory; khác lớp thường ở chỗ nào?
 *
 * CÂU HỎI
 *  - enum là gì, có thể kế thừa không?
 *  - record khác class thường thế nào?
 *  - EnumSet/EnumMap dùng khi nào?
 *  - switch expression khác switch statement thế nào?
 *
 * TỪ KHOÁ: enum, switch expression, EnumMap, record, compact constructor, valueOf
 *
 * Xong → nhắn "review JR-05"
 */
public final class Bai05JrEnumRecord {
    private Bai05JrEnumRecord() {
    }

    public enum Level {
        LOW(1), MEDIUM(5), HIGH(10);

        private final int weight;

        Level(int weight) {
            this.weight = weight;
        }

        public int weight() {
            return weight;
        }
    }

    public record Point(int x, int y) {
        public Point {
            // TODO: kiểm tra x, y >= 0 (ném IllegalArgumentException nếu âm)
        }

        public double distanceTo(Point other) {
            throw Todo.todo("JR-05");
        }

        public static Point origin() {
            throw Todo.todo("JR-05");
        }
    }

    public static String label(Level level) {
        throw Todo.todo("JR-05");
    }

    public static Level parse(String text) {
        throw Todo.todo("JR-05");
    }

    public static Level next(Level level) {
        throw Todo.todo("JR-05");
    }

    public static EnumMap<Level, Integer> countByLevel(List<Level> levels) {
        throw Todo.todo("JR-05");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
