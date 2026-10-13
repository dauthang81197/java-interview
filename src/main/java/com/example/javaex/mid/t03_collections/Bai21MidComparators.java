package com.example.javaex.mid.t03_collections;

import com.example.javaex.Todo;

import java.util.Comparator;
import java.util.List;

/**
 * Bài 21. Comparator chaining và sắp xếp ổn định  [Cấp độ: Mid]  (MID-06)
 * Chủ đề: Collections, Stream và Generics
 * Chạy: mvn -q test -Dtest=Bai21MidComparatorsTest
 *
 * MỤC TIÊU: Sắp xếp nhiều khoá bằng Comparator, xử lý null và hiểu tính ổn định của List.sort.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Sắp xếp theo phòng ban rồi lương giảm dần: viết Comparator thế nào?
 *     - Hai phần tử bằng nhau theo comparator: List.sort giữ nguyên thứ tự gốc không?
 *     - Comparator xử lý null như thế nào?
 *  2. CODE
 *     - sortByDeptThenSalaryDesc(employees): danh sách mới sắp xếp theo dept tăng, salary giảm; bằng nhau thì giữ thứ tự gốc.
 *     - sortNamesNullsLastIgnoreCase(names): sắp xếp không phân biệt hoa thường, null xếp cuối.
 *     - sortByDeptKeepingOrder(employees): chỉ sắp xếp theo dept; các phần tử cùng dept giữ thứ tự gốc (sắp xếp ổn định).
 *     - bySalaryDescThenNameAsc(): trả Comparator<Employee> theo lương giảm dần rồi tên tăng dần.
 *     - Không sửa danh sách đầu vào (có thể bất biến).
 *  3. GIẢI THÍCH
 *     - Giải thích Comparator.comparing, thenComparing, reversed, nullsLast.
 *     - Giải thích vì sao tính ổn định quan trọng khi sắp xếp nhiều lượt.
 *  4. MỞ RỘNG
 *     - Vì sao reversed() ở cuối chuỗi có thể sai ý định? Dùng comparing(..., reverseOrder()).
 *     - Sắp xếp mảng nguyên thủy (dual-pivot quicksort) vs đối tượng (TimSort): ổn định không?
 *
 * CÂU HỎI
 *  - Comparable vs Comparator?
 *  - List.sort có ổn định không và dùng thuật toán gì?
 *  - Hợp đồng compare (đối xứng, bắc cầu) bị vi phạm thì sao (Comparison method violates its general contract)?
 *
 * TỪ KHOÁ: Comparator, thenComparing, nullsLast, stable sort, TimSort, reversed
 *
 * Xong → nhắn "review MID-06"
 */
public final class Bai21MidComparators {
    private Bai21MidComparators() {
    }

    public record Employee(String name, String dept, double salary, int age) {
    }

    public static List<Employee> sortByDeptThenSalaryDesc(List<Employee> employees) {
        throw Todo.todo("MID-06");
    }

    public static List<String> sortNamesNullsLastIgnoreCase(List<String> names) {
        throw Todo.todo("MID-06");
    }

    public static List<Employee> sortByDeptKeepingOrder(List<Employee> employees) {
        throw Todo.todo("MID-06");
    }

    public static Comparator<Employee> bySalaryDescThenNameAsc() {
        throw Todo.todo("MID-06");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
