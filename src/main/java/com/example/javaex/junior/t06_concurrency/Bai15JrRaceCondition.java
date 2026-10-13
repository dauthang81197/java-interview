package com.example.javaex.junior.t06_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 15. Race condition và synchronized  [Cấp độ: Junior]  (JR-15)
 * Chủ đề: Thread và đồng bộ cơ bản
 * Chạy: mvn -q test -Dtest=Bai15JrRaceConditionTest
 *
 * MỤC TIÊU: Thấy mất cập nhật khi nhiều thread cùng count++, sửa bằng synchronized (method và block) và hiểu khoá nào đang được dùng.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - 8 thread mỗi thread tăng một biến int 50.000 lần: kết quả cuối có chắc bằng 400.000 không? Vì sao count++ không nguyên tử?
 *     - synchronized trên phương thức instance khoá đối tượng nào? Trên phương thức static thì sao?
 *     - Hai thread, một giữ synchronized(obj) và một gọi phương thức synchronized của obj: thread sau bị gì?
 *  2. CODE
 *     - runConcurrently(counter, threads, perThread): khởi động threads thread, mỗi thread gọi counter.increment() perThread lần, join tất cả rồi trả counter.get().
 *     - SyncMethodCounter: tự khai báo field đếm; increment() và get() dùng synchronized method.
 *     - SyncBlockCounter: dùng synchronized block trên một đối tượng khoá private final riêng (không phải this).
 *     - UnsafeCounter đã cho sẵn (count++ không đồng bộ): hãy chạy thử qua runConcurrently và quan sát kết quả nhỏ hơn kỳ vọng (không cần test cứng).
 *     - methodAndThisBlockShareLock(): một thread giữ synchronized(target) (chờ một latch), thread thứ hai gọi target.instanceMethod(); đợi (có giới hạn thời gian) tới khi thread thứ hai ở trạng thái BLOCKED, rồi mở latch, join; trả true nếu đã quan sát BLOCKED.
 *     - staticAndInstanceLocksAreDifferent(): một thread giữ synchronized(target), thread thứ hai gọi Target.staticMethod(); nó KHÔNG bị chặn (kết thúc trong thời hạn rộng, ví dụ join 5 giây); trả true nếu thread hai kết thúc khi khoá instance vẫn đang bị giữ.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao count++ gồm 3 bước (đọc, cộng, ghi) và kịch bản xen kẽ làm mất cập nhật.
 *     - Giải thích monitor/khoá nội tại: this, đối tượng khoá riêng và Class object.
 *  4. MỞ RỘNG
 *     - Vì sao nên dùng khoá private thay vì synchronized(this) trong thư viện?
 *     - Giải thích synchronized đảm bảo cả loại trừ lẫn visibility (happens-before) theo Java Memory Model; so sánh với ReentrantLock.
 *
 * CÂU HỎI
 *  - Race condition và data race khác nhau thế nào?
 *  - synchronized trên method static và instance khác nhau ra sao?
 *  - synchronized có reentrant không, ví dụ?
 *  - Vì sao count++ trên volatile vẫn sai?
 *  - Khi nào dùng Atomic thay synchronized?
 *
 * TỪ KHOÁ: race condition, count++, lost update, synchronized, monitor, intrinsic lock, reentrant, happens-before
 *
 * Xong → nhắn "review JR-15"
 */
public final class Bai15JrRaceCondition {
    private Bai15JrRaceCondition() {
    }

    public interface Counter {
        void increment();

        int get();
    }

    /** Cho sẵn: KHÔNG thread-safe, dùng để quan sát lỗi mất cập nhật. */
    public static class UnsafeCounter implements Counter {
        private int count;

        @Override
        public void increment() {
            count++;
        }

        @Override
        public int get() {
            return count;
        }
    }

    public static class SyncMethodCounter implements Counter {
        @Override
        public void increment() {
            throw Todo.todo("JR-15");
        }

        @Override
        public int get() {
            throw Todo.todo("JR-15");
        }
    }

    public static class SyncBlockCounter implements Counter {
        @Override
        public void increment() {
            throw Todo.todo("JR-15");
        }

        @Override
        public int get() {
            throw Todo.todo("JR-15");
        }
    }

    /** Cho sẵn: một phương thức synchronized instance và một phương thức synchronized static. */
    public static class Target {
        public synchronized void instanceMethod() {
        }

        public static synchronized void staticMethod() {
        }
    }

    public static int runConcurrently(Counter counter, int threads, int perThread) throws InterruptedException {
        throw Todo.todo("JR-15");
    }

    public static boolean methodAndThisBlockShareLock() throws InterruptedException {
        throw Todo.todo("JR-15");
    }

    public static boolean staticAndInstanceLocksAreDifferent() throws InterruptedException {
        throw Todo.todo("JR-15");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
