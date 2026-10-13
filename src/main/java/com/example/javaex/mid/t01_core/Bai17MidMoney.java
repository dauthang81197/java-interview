package com.example.javaex.mid.t01_core;

import com.example.javaex.Todo;

/**
 * Bài 17. equals/hashCode đúng hợp đồng  [Cấp độ: Mid]  (MID-02)
 * Chủ đề: Nền tảng nâng cao
 * Chạy: mvn -q test -Dtest=Bai17MidMoneyTest
 *
 * MỤC TIÊU: Cài equals, hashCode, toString cho Money sao cho dùng được làm khoá HashMap/HashSet.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Override equals mà quên hashCode thì cho 2 object bằng nhau vào HashSet sẽ ra sao?
 *     - Nếu thay đổi field của một khoá đang nằm trong HashMap thì get có tìm thấy nữa không?
 *     - equals dùng instanceof hay getClass() sẽ khác nhau thế nào khi có lớp con?
 *  2. CODE
 *     - Hai Money bằng nhau khi cùng amount và cùng currency.
 *     - So sánh currency không phân biệt hoa thường ("usd" == "USD"); currency có thể null.
 *     - Chuẩn hoá hoa/thường bằng toUpperCase(Locale.ROOT) để không phụ thuộc locale máy (vd locale Thổ Nhĩ Kỳ).
 *     - toString dạng "100 USD", currency luôn in hoa; nếu null thì "100 ?".
 *     - Các object bằng nhau PHẢI có cùng hashCode.
 *     - Gợi ý: nhớ đủ 5 tính chất của equals (phản xạ, đối xứng, bắc cầu, nhất quán, với null). Chuẩn hoá currency một lần trong constructor có thể làm mọi thứ đơn giản hơn.
 *  3. GIẢI THÍCH
 *     - Liệt kê 5 tính chất của equals và nêu một ví dụ vi phạm.
 *     - Giải thích hợp đồng giữa equals và hashCode.
 *  4. MỞ RỘNG
 *     - Record sinh equals/hashCode thế nào? Có đủ cho mọi trường hợp không?
 *     - Thiết kế equals khi có kế thừa (Liskov) và tradeoff của getClass() vs instanceof.
 *
 * CÂU HỎI
 *  - Điều gì xảy ra nếu override equals mà quên hashCode?
 *  - Dùng object mutable làm khoá HashMap rồi đổi field thì sao?
 *  - getClass() vs instanceof trong equals - tradeoff với kế thừa?
 *  - Record sinh equals/hashCode thế nào?
 *
 * TỪ KHOÁ: equals hashCode contract, Objects.hash, Locale.ROOT, record, mutable key
 *
 * Xong → nhắn "review MID-02"
 */
public class Bai17MidMoney {
    private final long amount;
    private final String currency;

    public Bai17MidMoney(long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        throw Todo.todo("MID-02");
    }

    @Override
    public int hashCode() {
        throw Todo.todo("MID-02");
    }

    @Override
    public String toString() {
        throw Todo.todo("MID-02");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
