- source_spec: `_bmad-output/implementation-artifacts/spec-java-senior-interview-exercises.md`
  summary: Một số yêu cầu bài tập (JVM-07 hard-code, Stream không dùng vòng for, LRU không LinkedHashMap, PingPong đơn luồng) không ép được bằng test.
  evidence: Giải sai vẫn xanh; phải dựa vào bước Claude review trước khi đánh dấu "Đã làm".
- source_spec: `_bmad-output/implementation-artifacts/spec-java-senior-interview-exercises.md`
  summary: Các test dựa vào thời gian/activeCount (Con01, Con03, Con04, Con05) có thể flaky trên máy tải nặng.
  evidence: Ngưỡng ms cố định và Thread.activeCount phụ thuộc môi trường; chưa quan sát fail thực tế (unverified).
