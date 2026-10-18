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
        for(int i=0; i<arr.length; i++) {
            arr[i] = value;
        }
    }

    public static void tryReassign(int[] arr) {
        arr = new int[]{9, 9, 9};
    }

    public static String appendBang(String s) {
        return s + "!";
    }

    public static void appendBang(StringBuilder sb) {
        sb.append("!");
    }

    public static int[] swappedCopy(int[] pair) {
        if (pair.length != 2) {
            throw new IllegalArgumentException("pair must have exactly 2 elements");
        }
        return new int[]{pair[1], pair[0]};
    }

    public static void addItem(List<String> list, String item) {
        list.add(item);
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
// - Gán lại tham số mảng (arr = new int[]{...}): mảng của người gọi KHÔNG đổi.
// - Sửa phần tử arr[0]: người gọi CÓ thấy. Hai kết quả khác nhau vì tham số arr là bản sao
//   của tham chiếu; cả hai cùng trỏ tới một mảng trên heap. Sửa phần tử = đi theo tham chiếu
//   rồi sửa mảng đó; gán lại = chỉ đổi bản sao tham chiếu, mảng gốc và biến của người gọi giữ nguyên.
// - appendBang(String): KHÔNG đổi String của người gọi, vì String bất biến, "+" tạo object mới.
//
// GIẢI THÍCH:
// Java luôn pass-by-value: tham số nhận một BẢN SAO của giá trị đối số.
// - Với primitive, giá trị là chính số đó.
// - Với object/mảng, giá trị là tham chiếu (địa chỉ); bản sao tham chiếu vẫn trỏ tới cùng object trên heap.
//
// Sơ đồ stack/heap cho tryReassign:
//   Trước khi gọi:   main: a ──► [1,2,3]  (heap)
//   Trong hàm:       main: a ──► [1,2,3]
//                    tryReassign: arr ──► [1,2,3]      (arr là bản sao của a)
//   Sau arr = new int[]{9,9,9}:
//                    main: a ──► [1,2,3]
//                    tryReassign: arr ──► [9,9,9]      (chỉ arr đổi hướng)
//   Hàm kết thúc: frame tryReassign bị bỏ khỏi stack, [9,9,9] không còn ai trỏ tới → GC thu hồi.
//   Mỗi lần gọi hàm tạo một stack frame riêng, bỏ đi khi hàm kết thúc. Object trên heap sống
//   tới khi không còn tham chiếu nào (GC dọn), không phụ thuộc hàm kết thúc.
//
// MỞ RỘNG:
// - swap(int a, int b) không viết được: a, b là bản sao của primitive, đổi chúng không ảnh hưởng
//   biến gốc. Cách khác: dùng mảng và đổi phần tử, hoặc trả về cặp mới (như swappedCopy), hoặc object bọc.
// - final parameter chỉ cấm gán lại tham số; KHÔNG cấm sửa nội dung object nó trỏ tới
//   (final List<String> l; l.add("x") vẫn được).
//
// TRẢ LỜI CÂU HỎI:
// - Java là pass-by-value (giá trị của tham chiếu), không phải pass-by-reference.
// - String bất biến: không có phương thức nào sửa nội dung tại chỗ, mọi thao tác đều tạo String mới,
//   nên hàm nhận String không thể làm đổi String của người gọi.
// - Gán lại tham số: chỉ đổi bản sao tham chiếu trong stack, không ảnh hưởng người gọi.
//   Sửa nội dung object: đổi dữ liệu trên heap, người gọi thấy vì cùng trỏ tới object đó.
