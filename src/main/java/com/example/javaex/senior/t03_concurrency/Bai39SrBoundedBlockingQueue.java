package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 39. Blocking queue (producer-consumer)  [Cấp độ: Senior]  (SR-08)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai39SrBoundedBlockingQueueTest
 *
 * MỤC TIÊU: Cài hàng đợi FIFO có dung lượng cố định, thread-safe, put chặn khi đầy và take chặn khi rỗng.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Vì sao kiểm tra điều kiện chờ bằng while chứ không phải if?
 *     - Nếu dùng notify() thay vì notifyAll() với nhiều producer và consumer thì có thể treo ở kịch bản nào?
 *     - Một luồng đang chờ trong wait() bị interrupt thì chuyện gì xảy ra?
 *  2. CODE
 *     - Hàng đợi FIFO có dung lượng cố định; put chặn (block) khi đầy, take chặn khi rỗng.
 *     - KHÔNG dùng các lớp kiểu BlockingQueue trong java.util.concurrent; chỉ dùng synchronized + wait/notify HOẶC ReentrantLock + Condition.
 *     - put/take phải phản hồi interrupt (ném InterruptedException).
 *     - Constructor ném IllegalArgumentException nếu capacity <= 0.
 *     - Không mất/trùng phần tử với nhiều producer/consumer, không deadlock.
 *     - Gợi ý: luôn kiểm tra điều kiện trong vòng while; cân nhắc notify vs notifyAll (hoặc hai Condition notFull/notEmpty).
 *  3. GIẢI THÍCH
 *     - Giải thích spurious wakeup và vì sao cần while.
 *     - Giải thích happens-before giữa put và take.
 *  4. MỞ RỘNG
 *     - Viết lại bằng ReentrantLock + hai Condition và so sánh.
 *     - Thêm put/take có timeout (offer/poll).
 *
 * CÂU HỎI
 *  - Spurious wakeup là gì? Vì sao dùng while?
 *  - notify vs notifyAll - khi nào notify gây treo?
 *  - synchronized vs ReentrantLock (fairness, tryLock, nhiều Condition)?
 *  - Giải thích happens-before giữa put và take.
 *
 * TỪ KHOÁ: wait notify, spurious wakeup, ReentrantLock Condition, producer consumer, happens-before
 *
 * Xong → nhắn "review SR-08"
 */
public class Bai39SrBoundedBlockingQueue<E> {

    public Bai39SrBoundedBlockingQueue(int capacity) {
        throw Todo.todo("SR-08");
    }

    public void put(E item) throws InterruptedException {
        throw Todo.todo("SR-08");
    }

    public E take() throws InterruptedException {
        throw Todo.todo("SR-08");
    }

    public int size() {
        throw Todo.todo("SR-08");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
