package com.example.javaex.mid.t01_core;

import com.example.javaex.mid.t01_core.Bai19MidClosures.Outer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class Bai19MidClosuresTest {

    @Test
    void makeSquaresCapturesEachIteration() {
        List<Supplier<Integer>> s = Bai19MidClosures.makeSquares(5);
        assertEquals(5, s.size());
        for (int i = 0; i < 5; i++) assertEquals(i * i, s.get(i).get());
        assertEquals(List.of(), Bai19MidClosures.makeSquares(0));
    }

    @Test
    void thisInLambdaIsOuterButInAnonymousClassIsTheAnonymousObject() {
        Outer o = new Outer("x");
        assertEquals("lambda:Outer(x)", o.lambdaSupplier().get());
        assertEquals("anon:true", o.anonymousSupplier().get());
    }

    @Test
    void innerClassSharesOuterState() {
        Outer o = new Outer("x");
        Outer.Counter c1 = o.newCounter();
        Outer.Counter c2 = o.newCounter();
        c1.inc();
        c1.inc();
        c2.inc();
        assertEquals(3, o.total());
        assertEquals(0, new Outer("y").total());
    }
}
