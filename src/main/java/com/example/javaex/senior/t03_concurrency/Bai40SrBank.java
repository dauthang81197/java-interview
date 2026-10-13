package com.example.javaex.senior.t03_concurrency;

import com.example.javaex.Todo;

/**
 * Bài 40. Chuyển tiền không deadlock  [Cấp độ: Senior]  (SR-09)
 * Chủ đề: Đa luồng
 * Chạy: mvn -q test -Dtest=Bai40SrBankTest
 *
 * MỤC TIÊU: Cài transfer thread-safe và KHÔNG deadlock khi hai luồng chuyển tiền chéo nhau (A->B và B->A).
 *
 * CÁC BƯỚC
 *  1. DỰ ĐOÁN
 *     - Nếu transfer khoá from rồi khoá to, hai luồng chuyển chéo nhau thì xảy ra gì?
 *     - Bốn điều kiện cần để deadlock xảy ra là gì? Bạn sẽ phá điều kiện nào?
 *     - Chuyển tiền cho chính mình mà khoá hai lần cùng một lock thì sao?
 *  2. CODE
 *     - Số dư không được âm: nếu không đủ tiền, trả false và không đổi gì.
 *     - Chuyển cho chính mình: trả true, không đổi gì.
 *     - Tổng tiền toàn hệ thống luôn bảo toàn. amount <= 0 ném IllegalArgumentException.
 *     - Account cho sẵn KHÔNG thread-safe; bạn chịu trách nhiệm khoá. Mọi truy cập balance phải được bảo vệ cùng một cơ chế khoá (kể cả balanceOf).
 *     - Gợi ý: phá điều kiện "chờ vòng" bằng cách luôn khoá theo một thứ tự toàn cục (ví dụ theo id).
 *  3. GIẢI THÍCH
 *     - Giải thích vì sao thứ tự khoá toàn cục ngăn deadlock.
 *     - Giải thích vì sao balanceOf cũng phải khoá.
 *  4. MỞ RỘNG
 *     - Cài biến thể dùng tryLock với timeout và so sánh.
 *     - Làm sao phát hiện deadlock bằng jstack hoặc ThreadMXBean (liên hệ SR-06)?
 *
 * CÂU HỎI
 *  - 4 điều kiện của deadlock (Coffman)?
 *  - Cách phát hiện deadlock (jstack, ThreadMXBean)?
 *  - tryLock với timeout như phương án khác?
 *  - Livelock và starvation là gì?
 *
 * TỪ KHOÁ: deadlock, lock ordering, Coffman conditions, tryLock, livelock, starvation
 *
 * Xong → nhắn "review SR-09"
 */
public class Bai40SrBank {

    /** Tài khoản cho sẵn - KHÔNG thread-safe. */
    public static final class Account {
        private final long id;
        private long balance;

        public Account(long id, long balance) {
            this.id = id;
            this.balance = balance;
        }

        public long id() {
            return id;
        }

        public long balance() {
            return balance;
        }

        public void add(long delta) {
            balance += delta;
        }
    }

    public boolean transfer(Account from, Account to, long amount) {
        throw Todo.todo("SR-09");
    }

    /** Đọc số dư an toàn (cùng cơ chế khoá với transfer). */
    public long balanceOf(Account account) {
        throw Todo.todo("SR-09");
    }
}

// ===== KHU VỰC GHI CHÚ CỦA BẠN =====
// DỰ ĐOÁN:
//
//
// GIẢI THÍCH:
//
//
