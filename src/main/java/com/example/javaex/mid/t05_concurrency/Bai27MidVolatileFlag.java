package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 27. volatile, visibility và happens-before  [Cấp độ: Mid]  (MID-12)
 * Chủ đề: Concurrency cơ bản
 * Chạy: mvn -q test -Dtest=Bai27MidVolatileFlagTest
 *
 * MỤC TIÊU: Dùng volatile cho cờ dừng và publish dữ liệu giữa các thread, và hiểu volatile KHÔNG làm count++ nguyên tử.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Thread worker lặp while (running) {...}; thread khác đặt running = false: nếu running không volatile thì worker có thể không bao giờ dừng không? Vì sao?
 *     - Ghi dữ liệu thường rồi ghi biến volatile; thread khác đọc biến volatile thấy true rồi đọc dữ liệu: có thấy giá trị mới không?
 *     - volatile int count; count++ từ nhiều thread có chính xác không?
 *  2. CODE
 *     - StoppableWorker: start() tạo và chạy một thread lặp trong khi cờ chạy còn bật và tăng bộ đếm; iterations() trả bộ đếm (phải đọc được giá trị mới từ thread khác); stopAndAwait(timeoutMs) tắt cờ, join tối đa timeoutMs và trả true nếu thread đã kết thúc. Gọi stopAndAwait nhiều lần phải an toàn.
 *     - publishAndRead(): một thread ghi dữ liệu (chuỗi "hello", KHÔNG volatile) rồi đặt cờ volatile ready = true; thread khác chờ (vòng lặp kiểm tra cờ, có thể kèm Thread.onSpinWait hoặc yield) đến khi ready rồi đọc và trả dữ liệu. Chỉ volatile ở cờ.
 *     - volatileIncrementRace(threads, perThread): nhiều thread cùng tăng một biến int VOLATILE bằng ++ perThread lần; join và trả giá trị cuối (thường nhỏ hơn threads * perThread - hãy giải thích vì sao).
 *  3. GIẢI THÍCH
 *     - Giải thích volatile đảm bảo gì (visibility, ngăn reorder quanh nó) và KHÔNG đảm bảo gì (atomicity của thao tác ghép).
 *     - Giải thích happens-before: ghi volatile happens-before đọc volatile sau đó.
 *  4. MỞ RỘNG
 *     - Vẽ các quan hệ happens-before trong Java Memory Model: monitor unlock/lock, volatile, Thread.start/join, final field.
 *     - Double-checked locking cần volatile vì sao (liên hệ bài LazyConfig)? Cache coherence và memory barrier hoạt động thế nào ở mức phần cứng?
 *
 * CÂU HỎI
 *  - volatile làm gì? Khi nào đủ, khi nào không đủ?
 *  - Java Memory Model và happens-before là gì?
 *  - Vì sao vòng lặp chờ cờ không volatile có thể treo vĩnh viễn (JIT hoisting)?
 *  - volatile vs synchronized vs Atomic?
 *  - Safe publication là gì?
 *
 * TỪ KHOÁ: volatile, visibility, happens-before, Java Memory Model, safe publication, memory barrier, stop flag
 *
 * Xong → nhắn "review MID-12"
 */
public final class Bai27MidVolatileFlag {
    private Bai27MidVolatileFlag() {
    }

    public static class StoppableWorker {
        public void start() {
            throw Todo.todo("MID-12");
        }

        public boolean stopAndAwait(long timeoutMs) throws InterruptedException {
            throw Todo.todo("MID-12");
        }

        public long iterations() {
            throw Todo.todo("MID-12");
        }
    }

    public static String publishAndRead() throws InterruptedException {
        throw Todo.todo("MID-12");
    }

    public static int volatileIncrementRace(int threads, int perThread) throws InterruptedException {
        throw Todo.todo("MID-12");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
