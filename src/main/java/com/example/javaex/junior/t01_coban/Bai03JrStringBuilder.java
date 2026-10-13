package com.example.javaex.junior.t01_coban;

import com.example.javaex.Todo;

import java.util.Map;

/**
 * Bài 03. String bất biến và StringBuilder  [Cấp độ: Junior]  (JR-03)
 * Chủ đề: Cơ bản
 * Chạy: mvn -q test -Dtest=Bai03JrStringBuilderTest
 *
 * MỤC TIÊU: Làm các thao tác chuỗi phổ biến, hiểu String bất biến và khi nào dùng StringBuilder.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Nối chuỗi bằng + trong vòng lặp 100.000 lần có vấn đề gì? Dùng gì thay thế?
 *     - s.toUpperCase() có làm đổi s không?
 *     - "A man, a plan, a canal: Panama" có phải palindrome nếu bỏ ký tự không phải chữ/số và không phân biệt hoa thường?
 *  2. CODE
 *     - repeat(s, times): lặp chuỗi (dùng StringBuilder); times < 0 ném IllegalArgumentException.
 *     - reverse(s): đảo ngược chuỗi KHÔNG dùng StringBuilder.reverse() (dùng char[] hoặc vòng lặp).
 *     - isPalindrome(s): bỏ ký tự không phải chữ/số, không phân biệt hoa thường; chuỗi rỗng là palindrome.
 *     - charFrequency(s): Map ký tự -> số lần, giữ thứ tự xuất hiện đầu tiên (LinkedHashMap).
 *     - capitalizeWords(s): các từ cách nhau bằng 1 dấu cách; mỗi từ viết hoa chữ đầu, còn lại viết thường; rỗng -> rỗng.
 *     - countOccurrences(text, sub): đếm số lần sub xuất hiện, không chồng lấn ("aaa", "aa" -> 1).
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao String bất biến và hệ quả (thread-safe, cache hashCode, string pool).
 *     - Giải thích StringBuilder vs StringBuffer.
 *  4. MỞ RỘNG
 *     - Dùng regex/Pattern cho isPalindrome và so sánh với cách thủ công.
 *     - Xử lý chuỗi Unicode (surrogate pair, codePoints) khi đảo ngược.
 *
 * CÂU HỎI
 *  - String, StringBuilder, StringBuffer khác nhau thế nào?
 *  - Vì sao String bất biến?
 *  - Nối chuỗi trong vòng lặp bằng + có chậm không, trình biên dịch tối ưu ra sao?
 *  - equals() vs == với String?
 *
 * TỪ KHOÁ: String immutable, StringBuilder, StringBuffer, palindrome, LinkedHashMap, codePoints
 *
 * Xong → nhắn "review JR-03"
 */
public final class Bai03JrStringBuilder {
    private Bai03JrStringBuilder() {
    }

    public static String repeat(String s, int times) {
        throw Todo.todo("JR-03");
    }

    public static String reverse(String s) {
        throw Todo.todo("JR-03");
    }

    public static boolean isPalindrome(String s) {
        throw Todo.todo("JR-03");
    }

    public static Map<Character, Integer> charFrequency(String s) {
        throw Todo.todo("JR-03");
    }

    public static String capitalizeWords(String s) {
        throw Todo.todo("JR-03");
    }

    public static int countOccurrences(String text, String sub) {
        throw Todo.todo("JR-03");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
