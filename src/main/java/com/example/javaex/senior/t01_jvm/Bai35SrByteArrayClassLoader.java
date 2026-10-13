package com.example.javaex.senior.t01_jvm;

import com.example.javaex.Todo;

import java.util.Map;

/**
 * Bài 35. ClassLoader tự viết  [Cấp độ: Senior]  (SR-04)
 * Chủ đề: JVM và bộ nhớ
 * Chạy: mvn -q test -Dtest=Bai35SrByteArrayClassLoaderTest
 *
 * MỤC TIÊU: Cài ClassLoader nạp lớp từ bytecode có sẵn trong bộ nhớ.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Hai lớp cùng tên nhưng nạp bởi hai ClassLoader khác nhau có phải là cùng một kiểu không?
 *     - Nếu parent loader tìm thấy lớp thì findClass của bạn có được gọi không?
 *     - Define cùng một lớp hai lần trong một loader gây lỗi gì?
 *  2. CODE
 *     - Nạp lớp từ Map<tên lớp, byte[]>. Ghi đè findClass(String) để defineClass khi tên có trong map, ngược lại ném ClassNotFoundException.
 *     - Giữ nguyên mô hình parent-delegation (KHÔNG ghi đè loadClass).
 *     - Test nạp Greeter qua loader này với parent là platform loader, rồi khẳng định lớp nạp ra KHÁC Greeter.class dù cùng tên, và vẫn gọi được hàm bằng reflection.
 *     - Gợi ý: lưu map ở constructor (copy). Chú ý LinkageError nếu define lớp hai lần.
 *  3. GIẢI THÍCH
 *     - Giải thích parent delegation và vì sao tồn tại (bảo mật, tránh trùng lớp).
 *     - Giải thích vì sao ép kiểu giữa hai lớp cùng tên khác loader gây ClassCastException.
 *  4. MỞ RỘNG
 *     - Ứng dụng: hot reload, plugin, Tomcat, OSGi.
 *     - Class unloading và Metaspace leak.
 *
 * CÂU HỎI
 *  - Parent delegation model và vì sao tồn tại?
 *  - Bootstrap / Platform / Application loader?
 *  - Hai lớp cùng tên khác loader có ép kiểu cho nhau được không?
 *  - Class unloading và Metaspace leak?
 *
 * TỪ KHOÁ: ClassLoader, parent delegation, defineClass, findClass, Metaspace, hot reload, OSGi
 *
 * Xong → nhắn "review SR-04"
 */
public class Bai35SrByteArrayClassLoader extends ClassLoader {

    public Bai35SrByteArrayClassLoader(ClassLoader parent, Map<String, byte[]> classBytes) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw Todo.todo("SR-04");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
