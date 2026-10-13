package com.example.javaex.mid.t03_collections;

import com.example.javaex.Todo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Bài 23. Generics và PECS  [Cấp độ: Mid]  (MID-08)
 * Chủ đề: Collections, Stream và Generics
 * Chạy: mvn -q test -Dtest=Bai23MidGenericsExercisesTest
 *
 * MỤC TIÊU: Cài các hàm generic và giải thích được vì sao từng wildcard/bound ở chữ ký là đúng.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Vì sao List<Integer> không phải là List<Number>?
 *     - Có thể gọi copy(List<Object> dst, List<Integer> src) không? Chữ ký nào cho phép?
 *     - Vì sao max cần Comparable<? super T> thay vì Comparable<T>?
 *  2. CODE
 *     - Chữ ký generic đã được cho sẵn (để test biên dịch được). Nhiệm vụ: cài thân hàm.
 *     - copy: chép mọi phần tử từ src sang cuối dst.
 *     - max: phần tử lớn nhất; ném NoSuchElementException nếu rỗng.
 *     - sum: tổng giá trị double của collection các Number bất kỳ.
 *     - keyOfMaxValue: khoá có giá trị lớn nhất trong map (null nếu map rỗng).
 *     - Gợi ý: Producer Extends, Consumer Super.
 *  3. GIẢI THÍCH
 *     - Thử đổi từng wildcard thành dạng hẹp hơn và xem test nào không biên dịch được; giải thích vì sao.
 *     - Phát biểu quy tắc PECS bằng lời của bạn.
 *  4. MỞ RỘNG
 *     - Viết một hàm generic dùng bounded type có nhiều ràng buộc (T extends A & B).
 *     - Vì sao không thể new T[] và cách vòng qua?
 *
 * CÂU HỎI
 *  - Type erasure là gì, hệ quả (không new T[], không instanceof List<String>)?
 *  - Vì sao List<Integer> không phải List<Number>?
 *  - Bridge method là gì?
 *  - Heap pollution và @SafeVarargs?
 *
 * TỪ KHOÁ: generics, PECS, wildcard, bounded type, type erasure, bridge method
 *
 * Xong → nhắn "review MID-08"
 */
public final class Bai23MidGenericsExercises {
    private Bai23MidGenericsExercises() {
    }

    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        throw Todo.todo("MID-08");
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> items) {
        throw Todo.todo("MID-08");
    }

    public static double sum(Collection<? extends Number> numbers) {
        throw Todo.todo("MID-08");
    }

    public static <K, V extends Comparable<? super V>> K keyOfMaxValue(Map<K, V> map) {
        throw Todo.todo("MID-08");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
