package com.example.javaex.mid.t02_exception;

import com.example.javaex.Todo;

import java.io.IOException;

/**
 * Bài 20. Exception chaining, custom exception, suppressed  [Cấp độ: Mid]  (MID-05)
 * Chủ đề: Exception
 * Chạy: mvn -q test -Dtest=Bai20MidExceptionChainingTest
 *
 * MỤC TIÊU: Bọc checked exception thành unchecked giữ nguyên cause, tìm root cause và hiểu suppressed exception.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Bọc IOException vào RuntimeException mà không truyền cause thì mất gì khi debug?
 *     - try-with-resources: thân ném A, close() ném B. Exception nào được ném ra ngoài, B đi đâu?
 *     - Chuỗi cause có thể bị vòng (a -> b -> a) không? Duyệt đến cùng sẽ gặp vấn đề gì?
 *  2. CODE
 *     - UserLoadException(int id, Throwable cause): extends RuntimeException; message "Không tải được user <id>" và giữ cause.
 *     - loadUser(loader, id): gọi loader.load(id); IOException được bọc thành UserLoadException (giữ cause); exception unchecked khác truyền nguyên vẹn; thành công trả giá trị.
 *     - rootCause(t): đi theo getCause() đến cuối; phải an toàn với chuỗi cause bị vòng (không lặp vô hạn).
 *     - suppressedCount(): dùng try-with-resources với FailingResource (cho sẵn, close() ném IllegalStateException) và thân ném RuntimeException; bắt exception và trả số lượng suppressed (kỳ vọng 1).
 *  3. GIẢI THÍCH
 *     - Giải thích khi nào nên bọc exception và khi nào để nguyên.
 *     - Giải thích addSuppressed và vì sao try-with-resources dùng nó.
 *  4. MỞ RỘNG
 *     - Thiết kế phân cấp exception cho một lớp dịch vụ (exception nghiệp vụ vs kỹ thuật).
 *     - Anti-pattern: catch (Exception e) {} và log rồi throw lại.
 *
 * CÂU HỎI
 *  - Khi nào dùng custom exception?
 *  - Cause và suppressed khác nhau thế nào?
 *  - Vì sao không nên nuốt exception?
 *  - Checked exception: ưu và nhược điểm?
 *
 * TỪ KHOÁ: exception chaining, cause, suppressed, try-with-resources, custom exception, root cause
 *
 * Xong → nhắn "review MID-05"
 */
public final class Bai20MidExceptionChaining {
    private Bai20MidExceptionChaining() {
    }

    public interface Loader {
        String load(int id) throws IOException;
    }

    public static class UserLoadException extends RuntimeException {
        public UserLoadException(int id, Throwable cause) {
            super();
            throw Todo.todo("MID-05");
        }
    }

    /** Tài nguyên cho sẵn: close() luôn ném IllegalStateException. */
    public static class FailingResource implements AutoCloseable {
        @Override
        public void close() {
            throw new IllegalStateException("close failed");
        }
    }

    public static String loadUser(Loader loader, int id) {
        throw Todo.todo("MID-05");
    }

    public static Throwable rootCause(Throwable t) {
        throw Todo.todo("MID-05");
    }

    public static int suppressedCount() {
        throw Todo.todo("MID-05");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
