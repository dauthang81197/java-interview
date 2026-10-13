package com.example.javaex.mid.t05_concurrency;

import com.example.javaex.Todo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Bài 28. Singleton lazy thread-safe  [Cấp độ: Mid]  (MID-13)
 * Chủ đề: Concurrency cơ bản
 * Chạy: mvn -q test -Dtest=Bai28MidLazyConfigTest
 *
 * MỤC TIÊU: Cài getInstance lazy và thread-safe bằng double-checked locking đúng cách.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Singleton khởi tạo bằng static field có phải là lazy không?
 *     - Double-checked locking thiếu volatile có thể trả về object "nửa vời" như thế nào (reordering)?
 *     - Nếu 64 luồng gọi getInstance cùng lúc, constructor chạy mấy lần?
 *  2. CODE
 *     - Đối tượng chỉ được tạo khi gọi getInstance() lần đầu (lazy) - không tạo lúc nạp lớp.
 *     - Dù nhiều luồng gọi đồng thời, constructor chạy đúng một lần và mọi luồng thấy cùng một instance đã khởi tạo đầy đủ.
 *     - Cài bằng double-checked locking (đúng cách).
 *     - Gợi ý: vì sao field instance của DCL phải volatile? Điều gì xảy ra nếu thiếu (gán tham chiếu trước khi constructor xong).
 *  3. GIẢI THÍCH
 *     - Giải thích Java Memory Model và happens-before trong ngữ cảnh DCL.
 *     - Tự viết thêm biến thể "holder idiom" ở lớp phụ và so sánh.
 *  4. MỞ RỘNG
 *     - Enum singleton: vì sao an toàn với serialization và reflection?
 *     - Holder idiom hoạt động nhờ đảm bảo gì của class loading?
 *
 * CÂU HỎI
 *  - Java Memory Model và happens-before?
 *  - Vì sao DCL không volatile bị lỗi?
 *  - Enum singleton và serialization/reflection?
 *  - Holder idiom hoạt động nhờ đảm bảo gì của class loading?
 *
 * TỪ KHOÁ: double-checked locking, volatile, singleton, Java Memory Model, holder idiom, enum singleton
 *
 * Xong → nhắn "review MID-13"
 */
public final class Bai28MidLazyConfig {

    /** Đếm số lần constructor chạy (cho test). */
    static final AtomicInteger CREATED = new AtomicInteger();

    private Bai28MidLazyConfig() {
        CREATED.incrementAndGet();
    }

    public static Bai28MidLazyConfig getInstance() {
        throw Todo.todo("MID-13");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
