# java-ex - Bài tập ôn Java từ Junior đến Senior

Bộ bài tập dạng stub: mỗi bài là một file Java có `TODO` và đề bài ở đầu file (DỰ ĐOÁN, CODE, GIẢI THÍCH, MỞ RỘNG, CÂU HỎI),
kèm JUnit 5 để tự chấm. Tổng cộng 43 bài, đánh số `Bai01`..`Bai43` theo thứ tự nên học.

## Ba cấp độ và lộ trình gợi ý
| Cấp độ | Package | Bài | Mã | Nội dung |
|---|---|---|---|---|
| Junior | `com.example.javaex.junior.*` | Bai01-Bai15 | JR-01..JR-15 | Nền tảng hay bị hỏi: kiểu nguyên thủy, boxing, String, pass-by-value, OOP, exception, enum/record, collections, generics, lambda, Optional, thread và race condition |
| Mid | `com.example.javaex.mid.*` | Bai16-Bai31 | MID-01..MID-16 | String pool, equals/hashCode, immutable, closure, exception chaining, Comparator, ArrayList, Generics/PECS, Stream, LRU, sealed/pattern matching, volatile, singleton, wait/notify, Atomic/CAS, ExecutorService |
| Senior | `com.example.javaex.senior.*` | Bai32-Bai43 | SR-01..SR-12 | JVM/bộ nhớ/GC, HashMap nội bộ, đa luồng (deadlock, blocking queue, executor, CompletableFuture), ClassLoader |

Lộ trình: làm hết Junior (Bai01 -> Bai15), rồi Mid (Bai16 -> Bai31), rồi Senior (Bai32 -> Bai43). Trong mỗi cấp, bài xếp từ dễ đến khó.
Tên class có cấp độ: `Bai17MidMoney`, `Bai36SrSimpleHashMap`, `Bai02JrBoxing`; test cùng tên + `Test`.

## Cấu trúc thư mục
Mỗi cấp chia thành thư mục chủ đề có tiền tố thứ tự (`t01_`, `t02_`, ...). Đi theo thứ tự bảng chữ cái
(cấp -> thư mục chủ đề -> file) chính là thứ tự Bai01..Bai43. `src/test` có cấu trúc giống hệt.
```
src/main/java/com/example/javaex/
  junior/  t01_coban (Bai01-05)  t02_oop (06-08)  t03_exception (09)  t04_collections (10-11)  t05_functional (12-13)  t06_concurrency (14-15)
  mid/     t01_core (16-19)  t02_exception (20)  t03_collections (21-25)  t04_modern (26)  t05_concurrency (27-31)
  senior/  t01_jvm (32-35)  t02_collections (36)  t03_concurrency (37-43)
```
Package tương ứng, ví dụ `com.example.javaex.mid.t03_collections`. Tiện ích dùng chung: `Todo` (main), `support/GcTestSupport` (test).

## Yêu cầu
- JDK 21, Maven 3.9+
- Python 3 (chỉ cần cho phần theo dõi tiến độ Excel)

## Làm bài
1. Mở bài trong `src/main/java/com/example/javaex/<cấp>/<chủ đề>/` và đọc phần đề ở đầu file.
2. Ghi dự đoán của bạn vào khu vực ghi chú cuối file TRƯỚC khi code.
3. Thay các `throw Todo.todo(...)` bằng code của bạn.
4. Chạy test của riêng bài đó:
   ```
   mvn -q test -Dtest=Bai01JrPrimitivesTest
   ```
   Tên test có trong dòng "Chạy:" ở đầu file và trong cột "Test" của Excel.
5. Chạy toàn bộ: `mvn test`.

Lưu ý: `mvn test` fail trên các bài chưa làm là CHỦ ĐÍCH (stub ném "TODO: chưa làm bài ..."). `mvn -q compile` và `mvn -q test-compile` luôn phải thành công.

## Theo dõi tiến độ (Excel)
Cài một lần:
```
python3 -m venv .venv
.venv/bin/pip install openpyxl
```
File: `tracker/bai-tap-java.xlsx` (cột STT, Mã bài, Cấp độ, Chủ đề, Tên bài, File, Test, Độ khó, Mức hay hỏi, Trạng thái, Ngày hoàn thành, Ghi chú).
Sau khi test xanh VÀ Claude đã review bài (nhắn `review JR-01`):
```
.venv/bin/python tracker/mark_done.py JR-01 --reviewed
.venv/bin/python tracker/mark_done.py JR-01 JR-02 --reviewed   # nhiều bài
.venv/bin/python tracker/mark_done.py JR-01 --undo             # đặt lại "Chưa làm"
```
Script từ chối nếu thiếu `--reviewed` hoặc test của bài chưa xanh (tự chạy `mvn`, tối đa 600s).
Sinh lại file Excel (giữ trạng thái cũ) khi thêm bài: `.venv/bin/python tracker/build_tracker.py`.
