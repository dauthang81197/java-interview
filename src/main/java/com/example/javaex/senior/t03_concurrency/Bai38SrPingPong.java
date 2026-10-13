package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 38. Ping-pong hai luồng  [Cấp độ: Senior]  (SR-07)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai38SrPingPongTest
 *
 * MỤC TIÊU: Điều phối hai luồng in xen kẽ ping, pong mà không dùng sleep hay busy-wait.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Nếu hai luồng cùng add vào ArrayList không đồng bộ thì có thể sai những gì?
 *     - Join một luồng đảm bảo điều gì về những gì luồng đó đã ghi?
 *     - Dùng boolean thường làm cờ lượt (không volatile) thì có thể hỏng thế nào?
 *  2. CODE
 *     - run(n) khởi động HAI luồng: một luồng thêm "ping", luồng kia thêm "pong" vào cùng một danh sách kết quả.
 *     - Đúng thứ tự xen kẽ ping, pong, ping, pong... mỗi bên n lần (tổng 2n phần tử, luôn bắt đầu bằng ping). n < 0 ném IllegalArgumentException.
 *     - Hàm chờ cả hai luồng kết thúc rồi trả danh sách.
 *     - Không dùng sleep để điều phối; không busy-wait.
 *     - Danh sách kết quả phải được truy cập an toàn (visibility!).
 *     - Gợi ý: hai Semaphore, hoặc lock + condition + biến lượt, hoặc Exchanger/Phaser.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao Thread.join tạo happens-before.
 *     - Giải thích khi nào cần volatile và khi nào volatile KHÔNG đủ (i++).
 *  4. MỞ RỘNG
 *     - Mở rộng thành ba luồng xoay vòng.
 *     - So sánh CountDownLatch, CyclicBarrier, Phaser.
 *
 * CÂU HỎI
 *  - volatile đảm bảo gì và KHÔNG đảm bảo gì (i++)?
 *  - Semaphore vs Lock?
 *  - CountDownLatch vs CyclicBarrier vs Phaser?
 *  - Thread.join tạo happens-before thế nào?
 *
 * TỪ KHOÁ: Semaphore, volatile, happens-before, Thread.join, CountDownLatch, CyclicBarrier, Phaser
 *
 * Xong → nhắn "review SR-07"
 */
public final class Bai38SrPingPong {
    private Bai38SrPingPong() {
    }

    public static List<String> run(int n) throws InterruptedException {
        throw Todo.todo("SR-07");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
