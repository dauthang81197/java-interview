package com.example.javaex.senior.t03_concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS)
class Bai38SrPingPongTest {

    @Test
    void alternatesStrictly() throws Exception {
        List<String> r = Bai38SrPingPong.run(5);
        assertEquals(List.of("ping", "pong", "ping", "pong", "ping", "pong", "ping", "pong", "ping", "pong"), r);
    }

    @Test
    void zeroRounds() throws Exception {
        assertEquals(List.of(), Bai38SrPingPong.run(0));
    }

    @Test
    void stableOverManyRuns() throws Exception {
        for (int run = 0; run < 200; run++) {
            List<String> r = Bai38SrPingPong.run(100);
            assertEquals(200, r.size());
            for (int i = 0; i < r.size(); i++) {
                assertEquals(i % 2 == 0 ? "ping" : "pong", r.get(i), "run " + run + " vị trí " + i);
            }
        }
    }

    @Test
    void negativeRoundsRejected() {
        assertThrows(IllegalArgumentException.class, () -> Bai38SrPingPong.run(-1));
    }
}
