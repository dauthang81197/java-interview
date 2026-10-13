package com.example.javaex.support;

import java.lang.ref.WeakReference;

/** Tiện ích test: ép GC có giới hạn để chờ một WeakReference bị xoá. */
public final class GcTestSupport {
    private GcTestSupport() {
    }

    public static boolean awaitCleared(WeakReference<?> ref) throws InterruptedException {
        for (int i = 0; i < 50 && ref.get() != null; i++) {
            System.gc();
            Thread.sleep(50);
            try {
                // gây áp lực nhẹ lên heap để GC chắc chắn chạy
                byte[] junk = new byte[1 << 20];
                junk[0] = 1;
            } catch (OutOfMemoryError ignored) {
            }
        }
        return ref.get() == null;
    }
}
