package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/**
 * Bài 43. CompletableFuture  [Cấp độ: Senior]  (SR-12)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai43SrAsyncAggregatorTest
 *
 * MỤC TIÊU: Ghép và điều phối tác vụ bất đồng bộ bằng CompletableFuture.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - supplyAsync không truyền executor thì chạy trên pool nào? Có vấn đề gì với tác vụ IO?
 *     - Một trong nhiều future lỗi thì allOf hoàn thành thế nào?
 *     - Exception ném trong supplier xuất hiện ra ngoài dưới dạng nào (CompletionException, ExecutionException)?
 *  2. CODE
 *     - Không gọi join()/get() bên trong các hàm này (trừ khi cần); mọi tác vụ chạy trên executor được truyền vào.
 *     - fetchAll: chạy song song mọi task, kết quả theo ĐÚNG thứ tự đầu vào. Nếu một task lỗi, future kết quả hoàn thành exceptionally.
 *     - withFallback: nếu task ném exception, trả fallback.
 *     - withTimeout: nếu task chưa xong sau timeoutMs thì trả fallback (không chờ task chậm xong).
 *     - firstOf: kết quả của task xong ĐẦU TIÊN. Danh sách rỗng -> future hoàn thành lỗi với NoSuchElementException (trực tiếp hoặc là cause của CompletionException/ExecutionException).
 *     - Gợi ý: supplyAsync(supplier, executor), allOf, anyOf, exceptionally/handle, completeOnTimeout/orTimeout.
 *  3. GIẢI THÍCH
 *     - Giải thích khác nhau giữa thenApply, thenCompose, thenCombine.
 *     - Giải thích cách exception được bọc trong CompletionException.
 *  4. MỞ RỘNG
 *     - Huỷ các task còn lại khi firstOf đã có kết quả.
 *     - Thay executor bằng virtual thread per task và so sánh.
 *
 * CÂU HỎI
 *  - thenApply vs thenCompose vs thenCombine?
 *  - Hậu quả khi dùng chung ForkJoinPool.commonPool cho tác vụ IO?
 *  - Khác nhau giữa hậu tố Async và không Async?
 *  - Exception được bọc trong CompletionException thế nào?
 *  - Khi nào nên dùng virtual thread thay thế?
 *
 * TỪ KHOÁ: CompletableFuture, allOf, anyOf, thenCompose, orTimeout, commonPool, CompletionException
 *
 * Xong → nhắn "review SR-12"
 */
public final class Bai43SrAsyncAggregator {
    private Bai43SrAsyncAggregator() {
    }

    public static CompletableFuture<List<String>> fetchAll(List<Supplier<String>> tasks, Executor executor) {
        throw Todo.todo("SR-12");
    }

    public static CompletableFuture<String> withFallback(Supplier<String> task, Executor executor, String fallback) {
        throw Todo.todo("SR-12");
    }

    public static CompletableFuture<String> withTimeout(Supplier<String> task, Executor executor,
                                                        long timeoutMs, String fallback) {
        throw Todo.todo("SR-12");
    }

    public static CompletableFuture<String> firstOf(List<Supplier<String>> tasks, Executor executor) {
        throw Todo.todo("SR-12");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
