package com.example.javaex.senior.t01_jvm;

import com.example.javaex.Todo;

/**
 * Bài 34. Cache giá trị tham chiếu yếu  [Cấp độ: Senior]  (SR-03)
 * Chủ đề: JVM và bộ nhớ
 * Chạy: mvn -q test -Dtest=Bai34SrWeakValueCacheTest
 *
 * MỤC TIÊU: Cài cache khoá -> giá trị mà cache không giữ giá trị sống, dùng WeakReference.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - WeakHashMap yếu theo khoá hay theo giá trị? Bài này cần cái nào?
 *     - Giá trị chỉ còn WeakReference trỏ tới thì khi nào bị thu hồi?
 *     - System.gc() có đảm bảo thu hồi ngay không?
 *  2. CODE
 *     - Nếu không còn ai tham chiếu mạnh tới giá trị thì GC được phép thu hồi, và get khi đó trả null.
 *     - size() chỉ đếm các mục còn sống (dọn các mục đã chết).
 *     - Dùng WeakReference (nên dùng ReferenceQueue hoặc dọn khi truy cập).
 *     - Gợi ý: phân biệt Strong / Soft / Weak / Phantom reference.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao cần dọn các entry đã chết (nếu không map phình ra).
 *     - Giải thích khác biệt WeakHashMap (yếu theo khoá) và bài này (yếu theo giá trị).
 *  4. MỞ RỘNG
 *     - Khi nào dùng SoftReference (cache nhạy bộ nhớ)?
 *     - Phantom reference và Cleaner thay finalize thế nào?
 *
 * CÂU HỎI
 *  - Khi nào dùng SoftReference vs WeakReference?
 *  - Phantom reference và Cleaner thay thế finalize thế nào? Vì sao finalize bị deprecate?
 *  - System.gc() có đảm bảo thu hồi không?
 *
 * TỪ KHOÁ: WeakReference, SoftReference, PhantomReference, ReferenceQueue, WeakHashMap, Cleaner
 *
 * Xong → nhắn "review SR-03"
 */
public class Bai34SrWeakValueCache<K, V> {

    public void put(K key, V value) {
        throw Todo.todo("SR-03");
    }

    public V get(K key) {
        throw Todo.todo("SR-03");
    }

    public int size() {
        throw Todo.todo("SR-03");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
