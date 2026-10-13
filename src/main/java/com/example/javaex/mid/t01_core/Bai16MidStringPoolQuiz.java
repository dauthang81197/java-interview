package com.example.javaex.mid.t01_core;

import com.example.javaex.Todo;

/**
 * Bài 16. String pool và so sánh tham chiếu  [Cấp độ: Mid]  (MID-01)
 * Chủ đề: Nền tảng nâng cao
 * Chạy: mvn -q test -Dtest=Bai16MidStringPoolQuizTest
 *
 * MỤC TIÊU: Tự viết code để quan sát kết quả so sánh tham chiếu (==) giữa các chuỗi và giải thích vì sao.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - "a" == "a" ra gì? new String("x") == "x" ra gì?
 *     - Chuỗi ghép lúc chạy từ biến không final có == với literal không? Còn với biến final String hằng?
 *     - intern() trả về tham chiếu nào?
 *  2. CODE
 *     - Mỗi hàm TRẢ VỀ kết quả thực của phép so sánh == mô tả trong tên hàm; tự viết mã tạo các chuỗi, chạy, giải thích bằng comment.
 *     - twoLiterals: hai literal giống nhau.
 *     - literalVsNew: một literal và new String cùng nội dung.
 *     - literalVsIntern: literal và new String(...).intern().
 *     - literalVsRuntimeConcat: literal "ab" và chuỗi ghép lúc chạy từ biến KHÔNG final ("a" + b).
 *     - literalVsConstantConcat: literal "ab" và ghép hai biến final String hằng ("a" + "b").
 *     - Gợi ý: compile-time constant được trình biên dịch gộp sẵn; ghép chuỗi runtime hiện đại dùng invokedynamic (StringConcatFactory).
 *  3. GIẢI THÍCH
 *     - Giải thích từng dòng vì sao ra kết quả đó (viết vào khu vực GIẢI THÍCH cuối file).
 *     - Giải thích String pool nằm ở đâu từ Java 7.
 *  4. MỞ RỘNG
 *     - intern() dùng khi nào / rủi ro?
 *     - StringBuilder vs StringBuffer vs ghép bằng + trong vòng lặp; String dedup của G1.
 *
 * CÂU HỎI
 *  - String pool nằm ở đâu từ Java 7 (heap)?
 *  - intern() dùng khi nào / rủi ro?
 *  - Vì sao nên so sánh String bằng equals?
 *  - StringBuilder vs StringBuffer vs ghép bằng + trong vòng lặp?
 *  - String dedup của G1?
 *
 * TỪ KHOÁ: String pool, intern, compile-time constant, StringConcatFactory, StringBuilder, string dedup
 *
 * Xong → nhắn "review MID-01"
 */
public final class Bai16MidStringPoolQuiz {
    private Bai16MidStringPoolQuiz() {
    }

    public static boolean twoLiterals() {
        throw Todo.todo("MID-01");
    }

    public static boolean literalVsNew() {
        throw Todo.todo("MID-01");
    }

    public static boolean literalVsIntern() {
        throw Todo.todo("MID-01");
    }

    public static boolean literalVsRuntimeConcat() {
        throw Todo.todo("MID-01");
    }

    public static boolean literalVsConstantConcat() {
        throw Todo.todo("MID-01");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
