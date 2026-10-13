package com.example.javaex.mid.t03_collections;

import com.example.javaex.Todo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Bài 24. Stream và Collectors  [Cấp độ: Mid]  (MID-09)
 * Chủ đề: Collections, Stream và Generics
 * Chạy: mvn -q test -Dtest=Bai24MidStreamExercisesTest
 *
 * MỤC TIÊU: Giải các bài xử lý dữ liệu CHỈ bằng Stream API (không vòng for/while).
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Stream lazy nghĩa là gì: dòng map(...) không có thao tác kết thúc thì có chạy không?
 *     - map và flatMap khác nhau thế nào với List<List<Integer>>?
 *     - Collectors.groupingBy trả Map loại nào, thứ tự khoá có đảm bảo không?
 *  2. CODE
 *     - groupByFirstLetter: nhóm từ theo chữ cái đầu (viết HOA) -> danh sách từ giữ nguyên thứ tự gốc. Bỏ qua chuỗi rỗng.
 *     - topNWords: tách văn bản theo mọi ký tự không phải chữ cái (chữ cái = \p{L}), đưa về chữ thường, đếm tần suất, trả n từ nhiều nhất (bằng nhau thì theo thứ tự alphabet). Văn bản rỗng (hoặc không có từ) -> danh sách rỗng; n < 0 ném IllegalArgumentException.
 *     - averageSalaryByDept: lương trung bình theo phòng ban.
 *     - highestPaid: nhân viên lương cao nhất (Optional rỗng nếu danh sách rỗng).
 *     - joinNames: tên sắp xếp tăng dần, nối bằng ", ".
 *     - flattenDistinctSorted: gộp danh sách lồng, bỏ trùng, sắp xếp tăng dần.
 *     - Gợi ý: Collectors.groupingBy với downstream collector, flatMap, Comparator.comparing(...).thenComparing(...), Collectors.averagingDouble.
 *  3. GIẢI THÍCH
 *     - Phân biệt thao tác trung gian và thao tác kết thúc, nêu ví dụ.
 *     - Giải thích vì sao một Stream không dùng lại được.
 *  4. MỞ RỘNG
 *     - Khi nào KHÔNG nên dùng parallelStream (common ForkJoinPool, thứ tự, chi phí)?
 *     - Viết Collector tuỳ biến bằng Collector.of.
 *
 * CÂU HỎI
 *  - Stream lazy nghĩa là gì, thao tác trung gian vs kết thúc?
 *  - map vs flatMap?
 *  - Khi nào KHÔNG nên dùng parallelStream?
 *  - Stream có tái sử dụng được không?
 *  - toList() (Java 16) khác Collectors.toList() ra sao?
 *
 * TỪ KHOÁ: Stream API, Collectors.groupingBy, flatMap, Comparator.thenComparing, parallelStream
 *
 * Xong → nhắn "review MID-09"
 */
public final class Bai24MidStreamExercises {
    private Bai24MidStreamExercises() {
    }

    public record Employee(String name, String dept, double salary) {
    }

    public static Map<String, List<String>> groupByFirstLetter(List<String> words) {
        throw Todo.todo("MID-09");
    }

    public static List<String> topNWords(String text, int n) {
        throw Todo.todo("MID-09");
    }

    public static Map<String, Double> averageSalaryByDept(List<Employee> employees) {
        throw Todo.todo("MID-09");
    }

    public static Optional<Employee> highestPaid(List<Employee> employees) {
        throw Todo.todo("MID-09");
    }

    public static String joinNames(List<Employee> employees) {
        throw Todo.todo("MID-09");
    }

    public static List<Integer> flattenDistinctSorted(List<List<Integer>> nested) {
        throw Todo.todo("MID-09");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
