package com.example.javaex.mid.t03_collections;

import com.example.javaex.Todo;

/**
 * Bài 25. LRU Cache  [Cấp độ: Mid]  (MID-10)
 * Chủ đề: Collections, Stream và Generics
 * Chạy: mvn -q test -Dtest=Bai25MidLruCacheTest
 *
 * MỤC TIÊU: Cài cache LRU (Least Recently Used) có dung lượng cố định, get/put O(1).
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Cache dung lượng 2: put a, put b, get a, put c. Phần tử nào bị loại? Vì sao?
 *     - put lại một khoá đã có thì thứ tự "mới dùng" thay đổi thế nào?
 *     - Cấu trúc dữ liệu nào cho phép vừa tra cứu O(1) vừa di chuyển phần tử về đầu O(1)?
 *  2. CODE
 *     - Khi put làm số phần tử vượt capacity, loại phần tử lâu nhất chưa được dùng.
 *     - Cả get và put đều tính là "đã dùng". get/put phải O(1).
 *     - get trả null nếu không có khoá.
 *     - containsKey KHÔNG làm thay đổi thứ tự.
 *     - Constructor ném IllegalArgumentException nếu capacity <= 0.
 *     - Gợi ý: HashMap + danh sách liên kết đôi tự viết. LinkedHashMap (accessOrder, removeEldestEntry) là cách ngắn, nhưng hãy tự viết bản đầy đủ trước và không dùng LinkedHashMap trong bản chính.
 *  3. GIẢI THÍCH
 *     - Vì sao cần danh sách liên kết ĐÔI mà không phải đơn?
 *     - Mô tả vì sao mỗi thao tác là O(1).
 *  4. MỞ RỘNG
 *     - Làm cache này thread-safe thế nào (lock toàn cục vs. striped)?
 *     - So sánh với LinkedHashMap kiểu LRU có sẵn.
 *
 * CÂU HỎI
 *  - Vì sao cần danh sách liên kết ĐÔI?
 *  - Làm cache này thread-safe thế nào (lock toàn cục vs. striped)?
 *  - Khác gì Caffeine/Guava cache (W-TinyLFU)?
 *
 * TỪ KHOÁ: LRU cache, LinkedHashMap accessOrder, removeEldestEntry, doubly linked list, Caffeine W-TinyLFU
 *
 * Xong → nhắn "review MID-10"
 */
public class Bai25MidLruCache<K, V> {

    public Bai25MidLruCache(int capacity) {
        throw Todo.todo("MID-10");
    }

    public V get(K key) {
        throw Todo.todo("MID-10");
    }

    public void put(K key, V value) {
        throw Todo.todo("MID-10");
    }

    public boolean containsKey(K key) {
        throw Todo.todo("MID-10");
    }

    public int size() {
        throw Todo.todo("MID-10");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
