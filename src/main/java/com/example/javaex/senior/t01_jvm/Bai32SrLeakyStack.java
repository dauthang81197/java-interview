package com.example.javaex.senior.t01_jvm;

import com.example.javaex.Todo;

/**
 * Bài 32. Stack không rò rỉ bộ nhớ  [Cấp độ: Senior]  (SR-01)
 * Chủ đề: JVM và bộ nhớ
 * Chạy: mvn -q test -Dtest=Bai32SrLeakyStackTest
 *
 * MỤC TIÊU: Cài stack dựa trên mảng mà không giữ tham chiếu thừa tới phần tử đã pop.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Java có GC, vậy stack dựa trên mảng có thể rò rỉ bộ nhớ không? Ở đâu?
 *     - Sau pop, chỉ số size giảm nhưng ô mảng vẫn trỏ tới object. Object đó có bị GC thu hồi không?
 *     - Làm sao kiểm chứng bằng code rằng một object đã được thu hồi?
 *  2. CODE
 *     - Stack dựa trên mảng tự mở rộng: push, pop, peek, size.
 *     - pop/peek trên stack rỗng ném EmptyStackException.
 *     - Sau pop, đối tượng vừa lấy ra KHÔNG được còn bị stack giữ tham chiếu (test dùng WeakReference + GC để kiểm tra).
 *     - Gợi ý: đây là ví dụ memory leak kinh điển trong Effective Java (Item 7).
 *  3. GIẢI THÍCH
 *     - Giải thích GC root là gì và vì sao tham chiếu từ mảng giữ object sống.
 *     - Giải thích vì sao test dùng WeakReference.
 *  4. MỞ RỘNG
 *     - Liệt kê các nguồn rò rỉ khác: static collection, listener không huỷ đăng ký, ThreadLocal trong thread pool, inner class giữ outer.
 *     - Cách điều tra rò rỉ bằng heap dump.
 *
 * CÂU HỎI
 *  - Java có GC mà vẫn rò rỉ bộ nhớ thế nào?
 *  - GC root là gì?
 *  - Cách điều tra (heap dump, MAT, jmap)?
 *
 * TỪ KHOÁ: memory leak, GC root, WeakReference, Effective Java Item 7, heap dump, MAT
 *
 * Xong → nhắn "review SR-01"
 */
public class Bai32SrLeakyStack<E> {

    public void push(E item) {
        throw Todo.todo("SR-01");
    }

    public E pop() {
        throw Todo.todo("SR-01");
    }

    public E peek() {
        throw Todo.todo("SR-01");
    }

    public int size() {
        throw Todo.todo("SR-01");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
