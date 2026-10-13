package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 37. Phát hiện deadlock bằng ThreadMXBean  [Cấp độ: Senior]  (SR-06)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai37SrDeadlockDetectorTest
 *
 * MỤC TIÊU: Trả về tên các thread đang deadlock bằng java.lang.management.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - findDeadlockedThreads trả null khi nào?
 *     - Deadlock do synchronized và do java.util.concurrent.locks khác nhau thế nào với API này?
 *     - Thread dump (jstack) cho thấy deadlock ở phần nào?
 *  2. CODE
 *     - findDeadlockedThreadNames() trả danh sách TÊN các thread đang deadlock, sắp xếp tăng dần; rỗng nếu không có.
 *     - Xét cả deadlock do synchronized lẫn java.util.concurrent.locks.
 *     - Gợi ý: ManagementFactory.getThreadMXBean(), findDeadlockedThreads() (khác findMonitorDeadlockedThreads), rồi getThreadInfo(ids). Lưu ý kết quả có thể là null.
 *  3. GIẢI THÍCH
 *     - Giải thích khác biệt hai phương thức findDeadlockedThreads và findMonitorDeadlockedThreads.
 *     - Giải thích các trạng thái thread BLOCKED / WAITING / TIMED_WAITING.
 *  4. MỞ RỘNG
 *     - Dựng deadlock thật và đọc bằng jstack/jcmd.
 *     - Dùng JFR hoặc VisualVM để quan sát.
 *
 * CÂU HỎI
 *  - Đọc thread dump (jstack) thế nào để thấy deadlock?
 *  - Các trạng thái thread (BLOCKED / WAITING / TIMED_WAITING)?
 *  - Tooling: jcmd, VisualVM, JFR?
 *  - Vì sao thread dump nhiều lần cách nhau hữu ích?
 *
 * TỪ KHOÁ: ThreadMXBean, findDeadlockedThreads, jstack, thread dump, jcmd, JFR
 *
 * Xong → nhắn "review SR-06"
 */
public final class Bai37SrDeadlockDetector {
    private Bai37SrDeadlockDetector() {
    }

    public static List<String> findDeadlockedThreadNames() {
        throw Todo.todo("SR-06");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
