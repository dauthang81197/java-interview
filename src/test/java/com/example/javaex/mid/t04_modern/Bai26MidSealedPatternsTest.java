package com.example.javaex.mid.t04_modern;

import com.example.javaex.mid.t04_modern.Bai26MidSealedPatterns.Circle;
import com.example.javaex.mid.t04_modern.Bai26MidSealedPatterns.Rect;
import com.example.javaex.mid.t04_modern.Bai26MidSealedPatterns.Tri;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bai26MidSealedPatternsTest {

    @Test
    void area() {
        assertEquals(Math.PI * 4, Bai26MidSealedPatterns.area(new Circle(2)), 1e-9);
        assertEquals(6.0, Bai26MidSealedPatterns.area(new Rect(2, 3)), 1e-9);
        assertEquals(6.0, Bai26MidSealedPatterns.area(new Tri(3, 4)), 1e-9);
    }

    @Test
    void classifyWithRecordPatterns() {
        assertEquals("điểm", Bai26MidSealedPatterns.classify(new Circle(0)));
        assertEquals("tròn", Bai26MidSealedPatterns.classify(new Circle(1)));
        assertEquals("vuông", Bai26MidSealedPatterns.classify(new Rect(2, 2)));
        assertEquals("chữ nhật", Bai26MidSealedPatterns.classify(new Rect(2, 3)));
        assertEquals("tam giác", Bai26MidSealedPatterns.classify(new Tri(1, 1)));
    }

    @Test
    void describeWithTypePatternsAndGuards() {
        assertEquals("số lớn", Bai26MidSealedPatterns.describe(11));
        assertEquals("số", Bai26MidSealedPatterns.describe(10));
        assertEquals("chuỗi rỗng", Bai26MidSealedPatterns.describe("   "));
        assertEquals("chuỗi dài 3", Bai26MidSealedPatterns.describe("abc"));
        assertEquals("null", Bai26MidSealedPatterns.describe(null));
        assertEquals("khác", Bai26MidSealedPatterns.describe(2.5));
    }
}
