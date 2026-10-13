package com.example.javaex;

/**
 * Tiện ích cho các bài tập: ném lỗi rõ ràng khi bài chưa được làm.
 * Khi làm bài, hãy xoá lời gọi {@link #todo(String)} và thay bằng code của bạn.
 */
public final class Todo {
    private Todo() {
    }

    public static UnsupportedOperationException todo(String bai) {
        return new UnsupportedOperationException("TODO: chưa làm bài " + bai);
    }
}
