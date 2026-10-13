package com.example.javaex.junior.t03_exception;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 09. Exception: checked, unchecked, finally, try-with-resources  [Cấp độ: Junior]  (JR-09)
 * Chủ đề: Exception
 * Chạy: mvn -q test -Dtest=Bai09JrExceptionsTest
 *
 * MỤC TIÊU: Phân biệt checked/unchecked và nắm thứ tự thực thi của try/catch/finally/try-with-resources.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - IOException và IllegalArgumentException cái nào là checked? Error thì sao?
 *     - try { return x; } finally { x = 2; } trả về giá trị nào?
 *     - try-with-resources mở A rồi B: đóng theo thứ tự nào?
 *  2. CODE
 *     - parseIntOrDefault(s, def): parse Integer, lỗi định dạng (kể cả s == null) trả def.
 *     - finallyOrder(fail): trả danh sách sự kiện: ["try", "finally"] nếu fail=false; ["try", "catch", "finally"] nếu fail=true (ném và bắt một exception ở try).
 *     - closeOrder(): dùng try-with-resources mở Resource "A" rồi "B" (class Resource cho sẵn, ghi vào log); trả log: open A, open B, close B, close A.
 *     - isChecked(type): true nếu type là checked exception (Throwable nhưng không phải RuntimeException hay Error hay lớp con của chúng).
 *     - tryFinallyReturn(): int x = 1; try { return x; } finally { x = 2; } và trả giá trị thực.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao tryFinallyReturn trả 1.
 *     - Giải thích khi nào dùng checked, khi nào dùng unchecked.
 *  4. MỞ RỘNG
 *     - Chuyện gì xảy ra nếu finally có return hoặc ném exception?
 *     - Multi-catch và bắt exception theo thứ tự lớp con trước lớp cha.
 *
 * CÂU HỎI
 *  - Checked và unchecked exception khác nhau thế nào?
 *  - finally có luôn chạy không (System.exit, vô hạn)?
 *  - try-with-resources yêu cầu gì (AutoCloseable)?
 *  - Error và Exception khác nhau thế nào?
 *
 * TỪ KHOÁ: checked exception, unchecked, finally, try-with-resources, AutoCloseable, Error
 *
 * Xong → nhắn "review JR-09"
 */
public final class Bai09JrExceptions {
    private Bai09JrExceptions() {
    }

    /** Tài nguyên cho sẵn: ghi "open X" khi tạo và "close X" khi đóng. */
    public static class Resource implements AutoCloseable {
        private final String name;
        private final List<String> log;

        public Resource(String name, List<String> log) {
            this.name = name;
            this.log = log;
            log.add("open " + name);
        }

        @Override
        public void close() {
            log.add("close " + name);
        }
    }

    public static int parseIntOrDefault(String s, int defaultValue) {
        throw Todo.todo("JR-09");
    }

    public static List<String> finallyOrder(boolean fail) {
        throw Todo.todo("JR-09");
    }

    public static List<String> closeOrder() {
        throw Todo.todo("JR-09");
    }

    public static boolean isChecked(Class<? extends Throwable> type) {
        throw Todo.todo("JR-09");
    }

    public static int tryFinallyReturn() {
        throw Todo.todo("JR-09");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
