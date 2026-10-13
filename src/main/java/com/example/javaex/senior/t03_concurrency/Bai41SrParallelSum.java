package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 41. Tổng song song: Executor và Fork/Join  [Cấp độ: Senior]  (SR-10)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai41SrParallelSumTest
 *
 * MỤC TIÊU: Tính tổng mảng song song bằng ExecutorService và bằng ForkJoin RecursiveTask.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Với mảng nhỏ, chia ra nhiều luồng có nhanh hơn không? Vì sao?
 *     - Mảng 10 phần tử chia cho 3 luồng: đoạn cuối dài bao nhiêu? Cần xử lý ranh giới thế nào?
 *     - Tổng nhiều int cộng bằng int sẽ gặp vấn đề gì?
 *  2. CODE
 *     - parallelSum(int[], int threads): chia mảng thành threads đoạn, mỗi đoạn một task nộp vào ExecutorService cố định, gom kết quả bằng Future.
 *     - Phải shutdown executor (kể cả khi lỗi). Kết quả kiểu long (tránh tràn int).
 *     - Mảng rỗng -> 0. threads > length vẫn đúng. threads <= 0 ném IllegalArgumentException.
 *     - forkJoinSum(long[], int threshold): dùng RecursiveTask; chia đôi đến khi đoạn <= threshold thì cộng tuần tự; fork() một nhánh và compute() nhánh còn lại.
 *     - forkJoinSum: threshold <= 0 ném IllegalArgumentException; data == null ném NullPointerException.
 *     - Gợi ý: cẩn thận ranh giới khi length không chia hết cho threads; Future.get() ném ExecutionException - bọc lại thành unchecked có ý nghĩa.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao phải shutdown executor và điều gì xảy ra nếu quên.
 *     - Giải thích work-stealing.
 *  4. MỞ RỘNG
 *     - Chọn kích thước thread pool thế nào cho CPU-bound vs IO-bound?
 *     - Thử virtual thread (Java 21) cho tác vụ IO và so sánh.
 *
 * CÂU HỎI
 *  - Chọn kích thước thread pool thế nào (CPU-bound vs IO-bound)?
 *  - Work-stealing là gì?
 *  - Các tham số của ThreadPoolExecutor và hàng đợi unbounded gây hại gì?
 *  - Virtual thread (Java 21) thay đổi điều gì?
 *
 * TỪ KHOÁ: ExecutorService, Future, ForkJoinPool, RecursiveTask, work stealing, ThreadPoolExecutor, virtual thread
 *
 * Xong → nhắn "review SR-10"
 */
public final class Bai41SrParallelSum {
    private Bai41SrParallelSum() {
    }

    public static long parallelSum(int[] data, int threads) {
        throw Todo.todo("SR-10");
    }

    public static long forkJoinSum(long[] data, int threshold) {
        throw Todo.todo("SR-10");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
