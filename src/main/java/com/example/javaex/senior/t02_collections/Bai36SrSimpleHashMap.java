package com.example.javaex.senior.t02_collections;

import com.example.javaex.Todo;

/**
 * Bài 36. HashMap tự viết  [Cấp độ: Senior]  (SR-05)
 * Chủ đề: Collections nội bộ
 * Chạy: mvn -q test -Dtest=Bai36SrSimpleHashMapTest
 *
 * MỤC TIÊU: Cài HashMap đơn giản dùng bảng băm + chaining, có resize.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Hai khoá khác nhau có cùng hashCode thì chuyện gì xảy ra trong bucket?
 *     - Vì sao dung lượng bảng thường là luỹ thừa của 2 và chỉ số bucket tính bằng (hash & (capacity - 1))?
 *     - Khi nào bảng 16 bucket phải nhân đôi? Sau khi nhân đôi, các phần tử có phải rehash không?
 *  2. CODE
 *     - Dung lượng ban đầu 16, luôn là luỹ thừa của 2; chỉ số bucket = (hash & (capacity - 1)).
 *     - Khi size > 0.75 * capacity sau một lần thêm khoá MỚI thì nhân đôi dung lượng và rehash (12 phần tử vẫn là 16, phần tử thứ 13 làm dung lượng thành 32).
 *     - Hỗ trợ khoá null.
 *     - put trả giá trị cũ (hoặc null). Ghi đè khoá đã có không tăng size.
 *     - remove trả giá trị bị xoá (hoặc null).
 *     - Gợi ý: làm nhiễu hash như JDK: h ^ (h >>> 16). Dùng Objects.equals khi so khoá.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao dùng luỹ thừa của 2 và mặt nạ bit thay cho phép chia dư.
 *     - Giải thích load factor 0.75 là sự đánh đổi giữa gì và gì.
 *  4. MỞ RỘNG
 *     - Java 8 treeify bucket khi nào (ngưỡng 8) và vì sao?
 *     - Mô phỏng lỗi resize đồng thời khi dùng HashMap nhiều luồng.
 *
 * CÂU HỎI
 *  - Vì sao dung lượng là luỹ thừa 2?
 *  - Java 8 thay đổi gì khi bucket quá dài (treeify, ngưỡng 8)?
 *  - Vì sao HashMap không thread-safe, resize đồng thời gây hại gì?
 *  - ConcurrentHashMap khác gì?
 *
 * TỪ KHOÁ: HashMap internals, chaining, load factor, rehash, treeify, ConcurrentHashMap
 *
 * Xong → nhắn "review SR-05"
 */
public class Bai36SrSimpleHashMap<K, V> {

    public Bai36SrSimpleHashMap() {
        throw Todo.todo("SR-05");
    }

    public V put(K key, V value) {
        throw Todo.todo("SR-05");
    }

    public V get(K key) {
        throw Todo.todo("SR-05");
    }

    public V remove(K key) {
        throw Todo.todo("SR-05");
    }

    public boolean containsKey(K key) {
        throw Todo.todo("SR-05");
    }

    public int size() {
        throw Todo.todo("SR-05");
    }

    /** Số bucket hiện tại. */
    public int capacity() {
        throw Todo.todo("SR-05");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
