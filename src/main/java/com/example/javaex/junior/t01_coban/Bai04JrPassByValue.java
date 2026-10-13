package com.example.javaex.junior.t01_coban;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 04. Truyền tham số: pass-by-value  [Cấp độ: Junior]  (JR-04)
 * Chủ đề: Cơ bản
 * Chạy: mvn -q test -Dtest=Bai04JrPassByValueTest
 *
 * MỤC TIÊU: Hiểu Java luôn truyền tham số theo giá trị (giá trị của tham chiếu), thông qua các hàm nhỏ.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Gọi hàm gán lại tham số mảng (arr = new int[]{...}) thì mảng của người gọi có đổi không?
 *     - Gọi hàm sửa phần tử arr[0] thì người gọi có thấy không? Vì sao hai kết quả này khác nhau?
 *     - Hàm nhận String và nối thêm "!" có làm đổi String của người gọi không?
 *  2. CODE
 *     - fill(arr, value): gán mọi phần tử của mảng bằng value (người gọi thấy thay đổi).
 *     - tryReassign(arr): bên trong gán arr = new int[]{9, 9, 9}; mảng của người gọi KHÔNG được thay đổi.
 *     - appendBang(String s): trả về s + "!"; String gốc không đổi.
 *     - appendBang(StringBuilder sb): nối "!" vào chính sb (người gọi thấy thay đổi).
 *     - swappedCopy(pair): pair luôn có 2 phần tử (khác thì ném IllegalArgumentException); trả về mảng MỚI đã đảo chỗ, mảng gốc không đổi.
 *     - addItem(list, item): thêm item vào danh sách của người gọi.
 *  3. GIẢI THÍCH
 *     - Giải thích bằng lời: "Java truyền tham số theo giá trị, với object thì giá trị là bản sao của tham chiếu".
 *     - Vẽ sơ đồ stack/heap cho tryReassign.
 *  4. MỞ RỘNG
 *     - Vì sao không thể viết hàm swap(int a, int b) trong Java? Cách làm khác?
 *     - Tham số final có ngăn sửa nội dung object không?
 *
 * CÂU HỎI
 *  - Java là pass-by-value hay pass-by-reference?
 *  - Vì sao String được coi là "bất biến" khi truyền vào hàm?
 *  - Sự khác nhau giữa gán lại tham số và sửa nội dung object tham chiếu?
 *
 * TỪ KHOÁ: pass by value, reference, stack heap, immutability, final parameter
 *
 * Xong → nhắn "review JR-04"
 */
public final class Bai04JrPassByValue {
    private Bai04JrPassByValue() {
    }

    public static void fill(int[] arr, int value) {
        throw Todo.todo("JR-04");
    }

    public static void tryReassign(int[] arr) {
        throw Todo.todo("JR-04");
    }

    public static String appendBang(String s) {
        throw Todo.todo("JR-04");
    }

    public static void appendBang(StringBuilder sb) {
        throw Todo.todo("JR-04");
    }

    public static int[] swappedCopy(int[] pair) {
        throw Todo.todo("JR-04");
    }

    public static void addItem(List<String> list, String item) {
        throw Todo.todo("JR-04");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
