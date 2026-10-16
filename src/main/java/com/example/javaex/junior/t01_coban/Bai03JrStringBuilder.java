package com.example.javaex.junior.t01_coban;

import com.example.javaex.Todo;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
       StringBuilder sb = new StringBuilder();
       if( times < 0){
           throw new IllegalArgumentException("times must be >= 0");
       }
        sb.repeat(String.valueOf(s), Math.max(0, times));
       return sb.toString();
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // bỏ qua ký tự không phải chữ/số ở cả hai phía (dùng while để bỏ qua nhiều ký tự liên tiếp)
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static Map<Character, Integer> charFrequency(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

    public static String capitalizeWords(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
    }

    public static int countOccurrences(String text, String sub) {
        if(text == null || sub == null || sub.isEmpty()) {
            return 0;
        }
        // text = abcdabc , sub = abc;
        int index = text.indexOf(sub);
        int count = 0;
        while(index >= 0) {
            count++;
            text = text.substring(index + sub.length());
            index = text.indexOf(sub);
        }
        return count;
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
// Because String is immutable, cannot change content when create,
// We should use string builder
// s.toUpperCase() can't change value of s
// Khoong bieest A man, a plan, a canal: Panama
// String is imumtable, so repeated concatenation may create many intermediate objects
// StringBuilder is more efficient for repeared concatenation in a loop
// GIẢI THÍCH:
// String is immtable because
// public final class String {          // final: không ai kế thừa để "lách" được
//    private final byte[] value;      // private + final: không truy cập/gán lại từ ngoài
//    private int hash;                // cache hashCode (nói ở dưới)
//    ...
//} String a = "java";
//String b = "java";  a==b because a and b use same String Pool
// if String c = new String("java") so a != c because c create a new Object on heap, so diffrent and create new object in poo;

// hashCode with O(n), so String never change value so HashCode never change
// Thread safe can readd multi thread becauase String never change value
// String is immutable, so String Pool can save memory
// String builder and StringBuffer are same about change value, because StringBuilder don't safe for thread
// and StringBuffer can safe thread with synchronized
// With Performance, StringBuilder faster than StringBuffer

