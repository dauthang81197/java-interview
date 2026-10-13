package com.example.javaex.junior.t06_concurrency;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 14. Thread: start() vs run(), vòng đời, daemon  [Cấp độ: Junior]  (JR-14)
 * Chủ đề: Thread và đồng bộ cơ bản
 * Chạy: mvn -q test -Dtest=Bai14JrThreadBasicsTest
 *
 * MỤC TIÊU: Hiểu Thread/Runnable, khác biệt start() và run(), join, các trạng thái thread và thread daemon qua các hàm nhỏ.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Gọi thread.run() trực tiếp thì mã chạy trên thread nào? start() thì sao?
 *     - Một thread đang chờ CountDownLatch.await() ở trạng thái nào (NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED)?
 *     - Thread con tạo bởi một daemon thread có là daemon không? Daemon thread có chặn JVM thoát không?
 *  2. CODE
 *     - threadNameOfRun(): tạo Thread tên "worker-1" chạy một Runnable ghi lại Thread.currentThread().getName(); gọi run() (KHÔNG phải start()) và trả tên đã ghi.
 *     - threadNameOfStart(): như trên nhưng gọi start() rồi join(); trả tên đã ghi (kỳ vọng "worker-1").
 *     - lifecycle(): trả danh sách trạng thái quan sát được của một thread: NEW (trước start), WAITING (khi đang await một CountDownLatch; hãy đợi bằng vòng lặp có giới hạn thời gian cho tới khi state == WAITING), TERMINATED (sau khi mở latch và join).
 *     - newThreadIsDaemon(): tạo thread mới (không set gì) và trả isDaemon().
 *     - childOfDaemonIsDaemon(): trong một thread daemon, tạo một thread con (không set gì), trả isDaemon() của thread con (join để lấy kết quả an toàn).
 *     - sumWithTwoThreads(data): hai thread cộng hai nửa mảng, join cả hai rồi trả tổng; mảng rỗng -> 0.
 *     - uncaughtFromThread(): thread ném IllegalStateException("boom"); dùng setUncaughtExceptionHandler để bắt và trả Throwable đó (sau khi join).
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao join() cũng tạo happens-before nên đọc kết quả sau join là an toàn.
 *     - Vẽ sơ đồ vòng đời thread và nêu hàm nào chuyển trạng thái nào.
 *  4. MỞ RỘNG
 *     - Thread vs Runnable vs Callable; extends Thread có nhược điểm gì? Virtual thread (Java 21) khác platform thread ở đâu?
 *     - Interrupt hoạt động thế nào (cờ interrupted, InterruptedException) và vì sao không nên nuốt nó?
 *
 * CÂU HỎI
 *  - start() và run() khác nhau thế nào?
 *  - Các trạng thái của Thread? BLOCKED khác WAITING ra sao?
 *  - Daemon thread là gì, dùng khi nào?
 *  - Điều gì xảy ra khi thread ném exception không bắt?
 *  - Một thread có thể start() hai lần không?
 *
 * TỪ KHOÁ: Thread, Runnable, start vs run, join, Thread.State, daemon, UncaughtExceptionHandler, virtual thread
 *
 * Xong → nhắn "review JR-14"
 */
public final class Bai14JrThreadBasics {
    private Bai14JrThreadBasics() {
    }

    public static String threadNameOfRun() {
        throw Todo.todo("JR-14");
    }

    public static String threadNameOfStart() {
        throw Todo.todo("JR-14");
    }

    public static List<Thread.State> lifecycle() {
        throw Todo.todo("JR-14");
    }

    public static boolean newThreadIsDaemon() {
        throw Todo.todo("JR-14");
    }

    public static boolean childOfDaemonIsDaemon() {
        throw Todo.todo("JR-14");
    }

    public static int sumWithTwoThreads(int[] data) {
        throw Todo.todo("JR-14");
    }

    public static Throwable uncaughtFromThread() {
        throw Todo.todo("JR-14");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
