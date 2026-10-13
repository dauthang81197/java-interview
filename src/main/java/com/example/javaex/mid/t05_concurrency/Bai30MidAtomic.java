package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 30. Atomic, CAS và lock-free  [Cấp độ: Mid]  (MID-15)
 * Chủ đề: Concurrency cơ bản
 * Chạy: mvn -q test -Dtest=Bai30MidAtomicTest
 *
 * MỤC TIÊU: Dùng AtomicLong/LongAdder, viết vòng lặp compareAndSet cho bộ theo dõi giá trị lớn nhất và stack lock-free, hiểu ABA.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - AtomicLong.incrementAndGet() khác long++ trong synchronized ở điểm nào về cơ chế và khi tranh chấp cao?
 *     - compareAndSet(expected, new) thất bại khi nào và xử lý ra sao?
 *     - Giá trị đổi A -> B -> A giữa hai lần đọc, CAS có phát hiện được không?
 *  2. CODE
 *     - incrementWithAtomicLong(threads, perThread): nhiều thread cùng incrementAndGet trên một AtomicLong; join và trả giá trị (kỳ vọng chính xác threads * perThread).
 *     - incrementWithLongAdder(threads, perThread): tương tự với LongAdder (dùng add/increment và sum()).
 *     - MaxTracker: get() ban đầu là Integer.MIN_VALUE; update(candidate) cập nhật giá trị lớn nhất bằng VÒNG LẶP compareAndSet (đọc, so, CAS, thử lại), không dùng synchronized.
 *     - CasStack<T>: stack lock-free kiểu Treiber dùng AtomicReference tới nút đỉnh; push, pop (null nếu rỗng), isEmpty; không mất hay trùng phần tử khi nhiều thread push/pop.
 *     - abaDetectedByStamp(): dùng AtomicStampedReference: khởi tạo "A" (stamp 0), đổi A -> B -> A (tăng stamp), rồi thử compareAndSet với expectedStamp cũ 0; trả true nếu lần CAS cuối thất bại (ABA bị phát hiện).
 *  3. GIẢI THÍCH
 *     - Giải thích CAS dựa trên lệnh phần cứng (cmpxchg) và vòng lặp thử lại; thế nào là lock-free vs wait-free.
 *     - Giải thích ABA problem và cách AtomicStampedReference xử lý.
 *  4. MỞ RỘNG
 *     - So sánh khoá và CAS khi tranh chấp thấp và cao (spin, cache-line bouncing); vì sao LongAdder nhanh hơn AtomicLong khi tranh chấp cao (cell striping) nhưng sum() không nguyên tử tức thời.
 *     - VarHandle và Unsafe; false sharing và @Contended.
 *
 * CÂU HỎI
 *  - Atomic hoạt động thế nào (CAS)?
 *  - Lock-free khác non-blocking khác wait-free ra sao?
 *  - ABA problem là gì?
 *  - AtomicLong vs LongAdder?
 *  - Khi nào khoá tốt hơn CAS?
 *
 * TỪ KHOÁ: Atomic, CAS, compareAndSet, lock-free, Treiber stack, ABA, AtomicStampedReference, LongAdder, false sharing
 *
 * Xong → nhắn "review MID-15"
 */
public final class Bai30MidAtomic {
    private Bai30MidAtomic() {
    }

    public static long incrementWithAtomicLong(int threads, int perThread) throws InterruptedException {
        throw Todo.todo("MID-15");
    }

    public static long incrementWithLongAdder(int threads, int perThread) throws InterruptedException {
        throw Todo.todo("MID-15");
    }

    public static class MaxTracker {
        public void update(int candidate) {
            throw Todo.todo("MID-15");
        }

        public int get() {
            throw Todo.todo("MID-15");
        }
    }

    public static class CasStack<T> {
        public void push(T item) {
            throw Todo.todo("MID-15");
        }

        public T pop() {
            throw Todo.todo("MID-15");
        }

        public boolean isEmpty() {
            throw Todo.todo("MID-15");
        }
    }

    public static boolean abaDetectedByStamp() {
        throw Todo.todo("MID-15");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
