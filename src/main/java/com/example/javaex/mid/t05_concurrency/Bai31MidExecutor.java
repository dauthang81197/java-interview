package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.Todo;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Bài 31. ExecutorService cơ bản  [Cấp độ: Mid]  (MID-16)
 * Chủ đề: Concurrency cơ bản
 * Chạy: mvn -q test -Dtest=Bai31MidExecutorTest
 *
 * MỤC TIÊU: Dùng thread pool cố định, Callable/Future, invokeAll, đóng pool đúng cách và xử lý exception của task qua Future.get.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Exception ném trong task submit(Callable) xuất hiện ở đâu và dưới dạng nào?
 *     - shutdown() và shutdownNow() khác nhau thế nào? awaitTermination làm gì?
 *     - submit task sau khi pool đã shutdown thì chuyện gì xảy ra?
 *  2. CODE
 *     - squareAll(numbers, threads): pool cố định threads, submit một Callable cho mỗi số, trả danh sách bình phương theo ĐÚNG thứ tự đầu vào; luôn shutdown pool (kể cả khi lỗi); danh sách rỗng -> rỗng.
 *     - runAll(tasks, threads): dùng invokeAll, trả danh sách kết quả theo thứ tự task; nếu có task lỗi thì ném RuntimeException bọc cause; luôn shutdown pool.
 *     - resultOrFailureMessage(task): submit vào pool, nếu Future.get() thành công trả kết quả, nếu ném ExecutionException trả getCause().getMessage(); luôn shutdown pool.
 *     - shutdownGracefully(executor, timeoutMs): shutdown(); awaitTermination(timeoutMs); nếu hết thời gian mà chưa xong thì shutdownNow() và trả false; nếu xong đúng hạn trả true.
 *     - namedDaemonPool(threads, prefix): pool cố định có ThreadFactory đặt tên prefix-1, prefix-2, ... và đặt daemon.
 *     - rejectedAfterShutdown(): tạo pool, shutdown(), thử submit và trả true nếu nhận RejectedExecutionException.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao phải shutdown executor và hậu quả của việc quên (thread không-daemon giữ JVM sống).
 *     - Giải thích ExecutionException bọc exception thật của task.
 *  4. MỞ RỘNG
 *     - Chọn kích thước thread pool: CPU-bound ~ số core, IO-bound lớn hơn (công thức Little: N = cores * (1 + wait/compute)); vì sao Executors.newFixedThreadPool dùng hàng đợi không giới hạn nguy hiểm?
 *     - Các RejectedExecutionHandler (Abort, CallerRuns, Discard, DiscardOldest) và khi nào dùng; ThreadPoolExecutor: core/max/queue/keepAlive; virtual thread executor (Java 21).
 *
 * CÂU HỎI
 *  - submit vs execute khác nhau thế nào?
 *  - Future.get() chặn và ném exception gì?
 *  - Cách chọn kích thước thread pool?
 *  - Rejected execution policy là gì?
 *  - shutdown vs shutdownNow vs awaitTermination?
 *
 * TỪ KHOÁ: ExecutorService, Callable, Future, invokeAll, shutdown, awaitTermination, ThreadFactory, RejectedExecutionException, thread pool sizing
 *
 * Xong → nhắn "review MID-16"
 */
public final class Bai31MidExecutor {
    private Bai31MidExecutor() {
    }

    public static List<Integer> squareAll(List<Integer> numbers, int threads) {
        throw Todo.todo("MID-16");
    }

    public static List<String> runAll(List<Callable<String>> tasks, int threads) {
        throw Todo.todo("MID-16");
    }

    public static String resultOrFailureMessage(Callable<String> task) {
        throw Todo.todo("MID-16");
    }

    public static boolean shutdownGracefully(ExecutorService executor, long timeoutMs) throws InterruptedException {
        throw Todo.todo("MID-16");
    }

    public static ExecutorService namedDaemonPool(int threads, String prefix) {
        throw Todo.todo("MID-16");
    }

    public static boolean rejectedAfterShutdown() {
        throw Todo.todo("MID-16");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
