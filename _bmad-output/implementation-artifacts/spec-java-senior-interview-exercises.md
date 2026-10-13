---
title: 'Bộ bài tập ôn Java senior (5+ năm) kèm theo dõi bằng Excel'
type: 'feature'
created: '2026-10-08'
status: 'done'
route: 'dispatch'
baseline_commit: 'NO_VCS'
review_loop_iteration: 0
context: []
---

<frozen-after-approval reason="human-owned intent — do not modify unless human renegotiates">

## Intent

**Problem:** Người dùng cần ôn lại toàn bộ Java ở mức phỏng vấn senior (5+ năm), vừa code vừa ôn, nhưng chưa có bộ bài tập có cấu trúc và chưa có cách theo dõi tiến độ.

**Approach:** Sinh sẵn một project Java (Maven, JDK 21) gồm các file bài tập theo chủ đề, mỗi file có tài liệu lý thuyết/đề bài trong Javadoc để người dùng tự làm. Có bộ kiểm tra tự động để chạy xác minh, và một file Excel liệt kê mọi bài, đánh dấu "đã làm" sau khi bài đã chạy đúng và được Claude kiểm tra lại.

## Boundaries & Constraints

**Always:** Mọi doc, đề bài và ghi chú viết bằng tiếng Việt. Chủ đề hay bị hỏi phỏng vấn (concurrency, JVM/GC, collections nội bộ, Stream, generics...) có nhiều bài hơn và đi sâu hơn. Mỗi bài có đề, gợi ý, tiêu chí đạt và câu hỏi phỏng vấn liên quan. Excel chỉ đánh dấu hoàn thành khi test xanh và Claude đã review.

**Never:** Không viết sẵn lời giải trong file bài tập. Không dùng framework ngoài JDK ngoài JUnit 5 cho phần test. Không tự đánh dấu "đã làm" khi người dùng chưa làm xong.

**Decisions (từ người dùng):** (1) Bài dạng stub có `TODO` + JUnit 5 chấm tự động qua `mvn test`; Claude vẫn review lại trước khi đánh dấu. (2) Lượt này chỉ sinh khung project + Excel + 3 module trọng tâm: Collections, Concurrency, JVM/Memory; các module khác thêm sau. (3) Excel cập nhật bằng script Python + `openpyxl` (một lệnh sau khi test xanh).

</frozen-after-approval>

## Code Map

- `/Users/darius/project/java-ex` -- thư mục rỗng, chưa có source, build file hay git. Chỉ có `.idea`, `_bmad`, `.claude`
- JDK 21 (Temurin), Maven và Gradle đã cài, `python3` có nhưng chưa có `openpyxl`

## Tasks & Acceptance

**Execution:**
- [ ] `pom.xml` -- Maven, Java 21, JUnit 5 -- nền để build/chạy test
- [ ] `src/main/java/.../<module>/*.java` -- file bài tập kèm Javadoc đề bài -- người dùng tự điền
- [ ] `src/test/java/.../<module>/*Test.java` -- test chấm bài -- xác minh tự động
- [ ] `tracker/bai-tap-java.xlsx` -- danh sách bài: module, tên, độ khó, mức hay hỏi, trạng thái -- theo dõi tiến độ
- [ ] `tracker/mark_done.py` -- script `openpyxl` đánh dấu bài đã làm theo mã bài -- cập nhật bằng một lệnh

**Acceptance Criteria:**
- Given project vừa sinh, when chạy `mvn -q compile`, then biên dịch thành công
- Given bài chưa làm, when chạy test của bài đó, then test fail rõ ràng chứ không lỗi biên dịch
- Given bài đã làm đúng và đã review, when cập nhật tiến độ, then dòng tương ứng trong Excel là "Đã làm"
