package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

import java.util.function.Function;

/**
 * Bài 42. Memoizer thread-safe  [Cấp độ: Senior]  (SR-11)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai42SrMemoizerTest
 *
 * MỤC TIÊU: Cài bộ nhớ đệm kết quả hàm sao cho mỗi khoá chỉ tính một lần dù nhiều luồng gọi đồng thời.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Dùng containsKey rồi put trên ConcurrentHashMap có an toàn không? Vì sao?
 *     - Khoá toàn cục (synchronized cả hàm get) có vấn đề gì khi hàm tính chậm?
 *     - Nếu hàm tính ném exception, có nên lưu lỗi vào cache không?
 *  2. CODE
 *     - get(key) tính function.apply(key) và nhớ kết quả.
 *     - Với mỗi khoá, hàm chỉ được tính ĐÚNG MỘT LẦN dù nhiều luồng gọi cùng lúc (các luồng khác chờ kết quả).
 *     - Hai khoá KHÁC nhau phải được tính song song (không dùng một khoá toàn cục khi đang tính).
 *     - Nếu hàm ném exception, không cache kết quả lỗi: lần gọi sau thử lại.
 *     - Gợi ý: mẫu của Goetz (Java Concurrency in Practice, 5.6): ConcurrentHashMap<K, Future<V>> + putIfAbsent + FutureTask.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao check-then-act rời rạc là sai (atomicity).
 *     - Giải thích vì sao lưu Future thay vì lưu giá trị.
 *  4. MỞ RỘNG
 *     - computeIfAbsent của ConcurrentHashMap có thoả yêu cầu thứ hai không? Rủi ro khi hàm tính chậm hoặc đệ quy?
 *     - Thêm cơ chế hết hạn (TTL) cho entry.
 *
 * CÂU HỎI
 *  - computeIfAbsent của ConcurrentHashMap có thoả yêu cầu song song không và rủi ro khi hàm chậm hoặc đệ quy?
 *  - Atomicity vs visibility?
 *  - ConcurrentHashMap đảm bảo gì với thao tác tổ hợp?
 *
 * TỪ KHOÁ: memoization, check-then-act, ConcurrentHashMap, FutureTask, putIfAbsent, computeIfAbsent
 *
 * Xong → nhắn "review SR-11"
 */
public class Bai42SrMemoizer<K, V> {

    public Bai42SrMemoizer(Function<K, V> function) {
        throw Todo.todo("SR-11");
    }

    public V get(K key) {
        throw Todo.todo("SR-11");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
