package com.example.javaex.mid.t01_core;

import com.example.javaex.Todo;

import java.util.Date;
import java.util.List;

/**
 * Bài 18. Thiết kế lớp bất biến  [Cấp độ: Mid]  (MID-03)
 * Chủ đề: Nền tảng nâng cao
 * Chạy: mvn -q test -Dtest=Bai18MidImmutableBookingTest
 *
 * MỤC TIÊU: Biến lớp thành immutable thật sự, với sao chép phòng thủ.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Lớp có mọi field final nhưng một field là Date hoặc List thì có immutable không?
 *     - Getter trả thẳng tham chiếu tới List bên trong thì gây hại gì?
 *     - Vì sao java.time ra đời thay cho Date?
 *  2. CODE
 *     - Lớp final, mọi field private final, bạn tự khai báo field. Constructor nhận (String owner, Date start, List<String> guests).
 *     - Sao chép phòng thủ (defensive copy) start và guests khi nhận vào.
 *     - getStart() trả bản sao mới; getGuests() trả danh sách không sửa được (thêm phần tử ném UnsupportedOperationException).
 *     - Constructor ném NullPointerException nếu bất kỳ tham số nào null (hoặc guests chứa null).
 *     - withGuest(String) trả đối tượng MỚI có thêm khách, đối tượng cũ không đổi.
 *     - Thêm getOwner().
 *     - Gợi ý: List.copyOf đã bất biến và từ chối null.
 *  3. GIẢI THÍCH
 *     - Giải thích 5 bước tạo immutable class.
 *     - Giải thích lợi ích với đa luồng (final field semantics trong JMM).
 *  4. MỞ RỘNG
 *     - Record có đủ immutable không (shallow)?
 *     - Vì sao String immutable (string pool, hashCode cache, bảo mật)?
 *
 * CÂU HỎI
 *  - 5 bước tạo immutable class?
 *  - Lợi ích với đa luồng (an toàn không cần khoá)?
 *  - Record có đủ immutable không?
 *  - Vì sao String immutable?
 *
 * TỪ KHOÁ: immutable class, defensive copy, final field, List.copyOf, java.time, record
 *
 * Xong → nhắn "review MID-03"
 */
public class Bai18MidImmutableBooking {

    public Bai18MidImmutableBooking(String owner, Date start, List<String> guests) {
        throw Todo.todo("MID-03");
    }

    public String getOwner() {
        throw Todo.todo("MID-03");
    }

    public Date getStart() {
        throw Todo.todo("MID-03");
    }

    public List<String> getGuests() {
        throw Todo.todo("MID-03");
    }

    public Bai18MidImmutableBooking withGuest(String guest) {
        throw Todo.todo("MID-03");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
