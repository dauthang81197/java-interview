package com.example.javaex.junior.t04_collections;

import com.example.javaex.Todo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Bài 10. Collections cơ bản: List/Set/Map, Comparable  [Cấp độ: Junior]  (JR-10)
 * Chủ đề: Collections và Generics
 * Chạy: mvn -q test -Dtest=Bai10JrCollectionsBasicsTest
 *
 * MỤC TIÊU: Chọn đúng List/Set/Map cho từng bài toán nhỏ và dùng Comparable/Comparator.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Muốn bỏ trùng nhưng giữ thứ tự xuất hiện: dùng Set loại nào?
 *     - Vừa duyệt for-each vừa list.remove(x) thì chuyện gì xảy ra? Cách an toàn?
 *     - Comparable và Comparator khác nhau ở đâu?
 *  2. CODE
 *     - removeDuplicatesKeepOrder(items): trả danh sách mới bỏ trùng, giữ thứ tự đầu tiên; không sửa danh sách gốc.
 *     - countWords(words): Map từ -> số lần, thứ tự theo lần xuất hiện đầu tiên.
 *     - sortedByLengthThenAlpha(words): danh sách mới sắp xếp theo độ dài tăng dần rồi theo alphabet.
 *     - removeShorterThan(words, minLength): xoá TẠI CHỖ các từ ngắn hơn minLength một cách an toàn, trả về số từ đã xoá.
 *     - hasDuplicates(numbers): true nếu có số lặp.
 *     - Person.compareTo: so theo tuổi tăng dần rồi tên; sortNatural(people): trả danh sách mới đã sắp xếp theo thứ tự tự nhiên.
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao chọn HashSet/LinkedHashSet/TreeSet, HashMap/LinkedHashMap/TreeMap trong từng hàm.
 *     - Giải thích cách xoá an toàn khi duyệt (Iterator.remove, removeIf).
 *  4. MỞ RỘNG
 *     - Độ phức tạp của các thao tác chính trên ArrayList, LinkedList, HashSet, TreeMap.
 *     - Vì sao khoá HashMap cần equals/hashCode đúng?
 *
 * CÂU HỎI
 *  - ArrayList và LinkedList khác nhau thế nào?
 *  - HashSet, LinkedHashSet, TreeSet khác nhau ở đâu?
 *  - Comparable và Comparator?
 *  - Vì sao xoá phần tử khi duyệt for-each gây ConcurrentModificationException?
 *
 * TỪ KHOÁ: List Set Map, LinkedHashMap, TreeSet, Comparable, Comparator, Iterator.remove, removeIf
 *
 * Xong → nhắn "review JR-10"
 */
public final class Bai10JrCollectionsBasics {
    private Bai10JrCollectionsBasics() {
    }

    public static final class Person implements Comparable<Person> {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name() {
            return name;
        }

        public int age() {
            return age;
        }

        @Override
        public int compareTo(Person other) {
            throw Todo.todo("JR-10");
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static List<String> removeDuplicatesKeepOrder(List<String> items) {
        throw Todo.todo("JR-10");
    }

    public static Map<String, Integer> countWords(List<String> words) {
        throw Todo.todo("JR-10");
    }

    public static List<String> sortedByLengthThenAlpha(Collection<String> words) {
        throw Todo.todo("JR-10");
    }

    public static int removeShorterThan(List<String> words, int minLength) {
        throw Todo.todo("JR-10");
    }

    public static boolean hasDuplicates(List<Integer> numbers) {
        throw Todo.todo("JR-10");
    }

    public static List<Person> sortNatural(List<Person> people) {
        throw Todo.todo("JR-10");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
