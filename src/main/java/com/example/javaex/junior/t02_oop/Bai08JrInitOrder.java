package com.example.javaex.junior.t02_oop;

import com.example.javaex.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Bài 08. Thứ tự khởi tạo: static, instance, constructor  [Cấp độ: Junior]  (JR-08)
 * Chủ đề: OOP
 * Chạy: mvn -q test -Dtest=Bai08JrInitOrderTest
 *
 * MỤC TIÊU: Tự viết hai lớp cha/con có khối static, khối instance, constructor và quan sát thứ tự chạy.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - new Child() lần đầu: các khối static của Parent và Child chạy khi nào, theo thứ tự nào?
 *     - Giữa khối instance và constructor của Parent, cái nào chạy trước? Còn Child?
 *     - new Child() lần thứ hai: khối static có chạy lại không?
 *  2. CODE
 *     - Sửa hai lớp lồng Parent và Child (đã khai báo sẵn, Child extends Parent) thêm: một khối static, một khối instance và một constructor mặc định cho mỗi lớp.
 *     - Mỗi khối ghi vào LOG (có sẵn) đúng chuỗi: "Parent static", "Child static", "Parent instance", "Parent constructor", "Child instance", "Child constructor".
 *     - createChild(): xoá LOG, gọi new Child(), trả về bản sao của LOG.
 *     - Kỳ vọng: lần gọi đầu có đủ 6 mục theo đúng thứ tự trên; lần gọi thứ hai chỉ có 4 mục (không còn static).
 *  3. GIẢI THÍCH
 *     - Giải thích thứ tự: static cha, static con, instance cha, constructor cha, instance con, constructor con.
 *     - Giải thích khi nào lớp được nạp và khởi tạo (class initialization).
 *  4. MỞ RỘNG
 *     - Chuyện gì xảy ra nếu constructor cha gọi một phương thức bị con override và dùng field của con?
 *     - Khởi tạo static của hằng số compile-time có kích hoạt khởi tạo lớp không?
 *
 * CÂU HỎI
 *  - Thứ tự khởi tạo khi tạo đối tượng con?
 *  - Khối static chạy khi nào và mấy lần?
 *  - Vì sao không nên gọi phương thức overridable trong constructor?
 *  - Initialization-on-demand holder dựa vào đâu?
 *
 * TỪ KHOÁ: static block, instance initializer, constructor order, class initialization, overridable method in constructor
 *
 * Xong → nhắn "review JR-08"
 */
public final class Bai08JrInitOrder {
    private Bai08JrInitOrder() {
    }

    /** Nơi các khối khởi tạo ghi lại dấu vết (cho sẵn). */
    static final List<String> LOG = new ArrayList<>();

    static class Parent {
    }

    static class Child extends Parent {
    }

    public static List<String> createChild() {
        throw Todo.todo("JR-08");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
