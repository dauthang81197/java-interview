package com.example.javaex.senior.t01_jvm;

import com.example.javaex.Todo;

import java.util.List;

/**
 * Bài 33. Quan sát heap và GC  [Cấp độ: Senior]  (SR-02)
 * Chủ đề: JVM và bộ nhớ
 * Chạy: mvn -q test -Dtest=Bai33SrJvmInfoTest
 *
 * MỤC TIÊU: Đọc thông tin heap và GC của JVM bằng Management API.
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Dùng, committed và max của heap khác nhau thế nào?
 *     - Cờ -Xmx64m thay đổi giá trị nào trong kết quả?
 *     - Đổi sang -XX:+UseZGC hoặc -XX:+UseSerialGC thì tên các GC thay đổi ra sao?
 *  2. CODE
 *     - heapUsage(): trả HeapSnapshot (used, committed, max, đơn vị byte) của HEAP lấy từ MemoryMXBean.
 *     - gcNames(): tên các bộ thu gom rác đang chạy (từ GarbageCollectorMXBean), sắp xếp tăng dần.
 *     - gcCountAfterGc(): tổng số lần GC (cộng getCollectionCount() của mọi collector) SAU khi gọi System.gc() một lần; chỉ cần trả số >= 1 khi GC thật sự chạy.
 *     - Gợi ý: dùng ManagementFactory; chạy thử với các cờ -XX:+UseG1GC, -XX:+UseZGC, -Xmx64m.
 *  3. GIẢI THÍCH
 *     - Giải thích phân vùng bộ nhớ JVM (heap young/old, metaspace, stack, code cache).
 *     - Giải thích Minor / Major / Full GC và stop-the-world.
 *  4. MỞ RỘNG
 *     - G1 vs ZGC vs Parallel: chọn thế nào theo latency/throughput?
 *     - Đọc GC log (-Xlog:gc) và các cờ -Xms, -Xmx, -XX:MaxMetaspaceSize.
 *
 * CÂU HỎI
 *  - Phân vùng bộ nhớ JVM?
 *  - G1 vs ZGC vs Parallel: chọn thế nào?
 *  - Minor / Major / Full GC và stop-the-world?
 *  - OOM các loại và cách xử lý?
 *  - Đọc GC log thế nào?
 *
 * TỪ KHOÁ: MemoryMXBean, GarbageCollectorMXBean, G1, ZGC, Xmx, Metaspace, GC log
 *
 * Xong → nhắn "review SR-02"
 */
public final class Bai33SrJvmInfo {
    private Bai33SrJvmInfo() {
    }

    public record HeapSnapshot(long used, long committed, long max) {
    }

    public static HeapSnapshot heapUsage() {
        throw Todo.todo("SR-02");
    }

    public static List<String> gcNames() {
        throw Todo.todo("SR-02");
    }

    public static long gcCountAfterGc() {
        throw Todo.todo("SR-02");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
