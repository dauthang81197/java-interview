package com.example.javaex.senior.t01_jvm;

import com.example.javaex.support.GcTestSupport;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;

import static org.junit.jupiter.api.Assertions.*;

class Bai34SrWeakValueCacheTest {

    @Test
    void returnsValueWhileStronglyReferenced() throws Exception {
        Bai34SrWeakValueCache<String, Object> c = new Bai34SrWeakValueCache<>();
        Object v = new Object();
        c.put("k", v);
        System.gc();
        Thread.sleep(50);
        assertSame(v, c.get("k"));
        assertEquals(1, c.size());
        assertNull(c.get("missing"));
        assertNotNull(v);
    }

    @Test
    void entryDisappearsWhenValueCollected() throws Exception {
        Bai34SrWeakValueCache<String, Object> c = new Bai34SrWeakValueCache<>();
        Object v = new Object();
        WeakReference<Object> probe = new WeakReference<>(v);
        c.put("k", v);
        c.put("other", new Object());
        v = null;
        assertTrue(GcTestSupport.awaitCleared(probe), "cache đang giữ giá trị bằng tham chiếu mạnh");
        assertNull(c.get("k"));
        // size chỉ đếm các mục còn sống ("other" cũng không còn ai tham chiếu nên có thể đã chết)
        for (int i = 0; i < 50 && c.size() > 0; i++) {
            System.gc();
            Thread.sleep(50);
        }
        assertEquals(0, c.size());
    }
}
