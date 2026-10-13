package com.example.javaex.mid.t03_collections;

import com.example.javaex.Todo;

import java.util.Iterator;

/**
 * Bài 22. ArrayList tự viết + iterator fail-fast  [Cấp độ: Mid]  (MID-07)
 * Chủ đề: Collections, Stream và Generics
 * Chạy: mvn -q test -Dtest=Bai22MidMyArrayListTest
 *
 * MỤC TIÊU: Cài danh sách dựa trên mảng tự mở rộng, có iterator fail-fast và Iterator.remove.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Vừa duyệt for-each vừa gọi list.remove(...) thì chuyện gì xảy ra? Vì sao?
 *     - Sau khi remove, ô cuối của mảng nếu không gán null thì gây hại gì?
 *     - Tăng dung lượng gấp đôi hay 1.5 lần: độ phức tạp amortized của add là bao nhiêu?
 *  2. CODE
 *     - Lưu trữ bằng mảng tự mở rộng khi đầy (không dùng ArrayList/Arrays.asList để lưu trữ).
 *     - add(e) cuối danh sách; get(i); remove(i) trả phần tử bị xoá và dồn mảng; size().
 *     - Index sai ném IndexOutOfBoundsException.
 *     - iterator() fail-fast: nếu danh sách bị sửa cấu trúc (add/remove) ngoài iterator khi đang duyệt thì next() ném ConcurrentModificationException.
 *     - Iterator.remove() được hỗ trợ và KHÔNG gây CME cho chính iterator đó; gọi remove hai lần liên tiếp ném IllegalStateException.
 *     - Sau khi remove, ô cuối của mảng phải được gán null (tránh giữ tham chiếu thừa).
 *     - Gợi ý: biến đếm modCount ở list và expectedModCount ở iterator.
 *  3. GIẢI THÍCH
 *     - Giải thích modCount/expectedModCount hoạt động ra sao.
 *     - Giải thích vì sao fail-fast chỉ là "best effort".
 *  4. MỞ RỘNG
 *     - So sánh với CopyOnWriteArrayList (fail-safe) và đánh đổi của nó.
 *     - Khi nào LinkedList thật sự đáng dùng (hầu như không)?
 *
 * CÂU HỎI
 *  - Chiến lược tăng dung lượng của ArrayList (1.5x) và độ phức tạp amortized của add?
 *  - Fail-fast vs fail-safe (CopyOnWriteArrayList)?
 *  - Vì sao fail-fast chỉ là "best effort"?
 *  - Khi nào dùng LinkedList?
 *
 * TỪ KHOÁ: ArrayList internals, modCount, ConcurrentModificationException, fail-fast, CopyOnWriteArrayList
 *
 * Xong → nhắn "review MID-07"
 */
public class Bai22MidMyArrayList<E> implements Iterable<E> {

    public void add(E element) {
        throw Todo.todo("MID-07");
    }

    public E get(int index) {
        throw Todo.todo("MID-07");
    }

    public E remove(int index) {
        throw Todo.todo("MID-07");
    }

    public int size() {
        throw Todo.todo("MID-07");
    }

    @Override
    public Iterator<E> iterator() {
        throw Todo.todo("MID-07");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
