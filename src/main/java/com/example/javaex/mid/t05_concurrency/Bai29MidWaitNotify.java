package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 29. wait/notify: hộp thư một ô (producer-consumer đơn giản)  [Cấp độ: Mid]  (MID-14)
 * Chủ đề: Concurrency cơ bản
 * Chạy: mvn -q test -Dtest=Bai29MidWaitNotifyTest
 *
 * MỤC TIÊU: Cài hộp thư một ô thread-safe bằng wait/notifyAll (hoặc Lock + Condition) với vòng while bảo vệ khỏi spurious wakeup.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Vì sao điều kiện chờ phải nằm trong vòng while chứ không phải if?
 *     - wait() phải được gọi trong ngữ cảnh nào? Gọi ngoài synchronized thì có lỗi gì?
 *     - Dùng notify() thay notifyAll() với nhiều producer và consumer có thể kẹt ở kịch bản nào?
 *  2. CODE
 *     - SimpleMailbox<T> chứa tối đa MỘT phần tử. put(item) chặn khi hộp đầy; take() chặn khi hộp rỗng; phần tử null bị từ chối bằng NullPointerException.
 *     - poll(timeoutMs): chờ tối đa timeoutMs; trả phần tử nếu có, trả null khi hết thời gian (phải tính thời gian còn lại đúng khi bị đánh thức sớm - dùng deadline).
 *     - put/take/poll phải phản hồi interrupt (ném InterruptedException).
 *     - Chỉ dùng synchronized + wait/notifyAll HOẶC ReentrantLock + Condition; không sleep để điều phối, không busy-wait; không dùng các BlockingQueue có sẵn.
 *     - Đúng thứ tự FIFO với một producer; không mất hoặc trùng phần tử với nhiều producer/consumer.
 *  3. GIẢI THÍCH
 *     - Giải thích spurious wakeup và vì sao luôn kiểm tra lại điều kiện sau khi thức dậy.
 *     - Giải thích khi nào dùng notify, khi nào notifyAll, hoặc hai Condition notFull/notEmpty.
 *  4. MỞ RỘNG
 *     - So sánh wait/notify với Condition (nhiều hàng đợi chờ, awaitNanos, fairness) và với BlockingQueue.
 *     - Thiết kế bài tiếp theo (Bai BoundedBlockingQueue mức Senior): nhiều ô, hiệu năng, tránh thundering herd.
 *
 * CÂU HỎI
 *  - Vì sao dùng while thay vì if quanh wait()?
 *  - wait() nhả khoá không, sleep() có nhả khoá không?
 *  - notify vs notifyAll?
 *  - synchronized vs ReentrantLock + Condition?
 *  - Làm sao xử lý InterruptedException đúng cách?
 *
 * TỪ KHOÁ: wait notify, notifyAll, spurious wakeup, Condition, producer consumer, monitor, timeout deadline
 *
 * Xong → nhắn "review MID-14"
 */
public final class Bai29MidWaitNotify {
    private Bai29MidWaitNotify() {
    }

    public static class SimpleMailbox<T> {
        public void put(T item) throws InterruptedException {
            throw Todo.todo("MID-14");
        }

        public T take() throws InterruptedException {
            throw Todo.todo("MID-14");
        }

        public T poll(long timeoutMs) throws InterruptedException {
            throw Todo.todo("MID-14");
        }
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
