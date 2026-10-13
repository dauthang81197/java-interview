package com.example.javaex.mid.t01_core;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Bai18MidImmutableBookingTest {

    @Test
    void classAndFieldsAreFinal() {
        assertTrue(Modifier.isFinal(Bai18MidImmutableBooking.class.getModifiers()), "lớp phải final");
        Field[] fields = Bai18MidImmutableBooking.class.getDeclaredFields();
        assertTrue(fields.length >= 3, "cần khai báo field cho owner, start, guests");
        for (Field f : fields) {
            if (f.isSynthetic() || Modifier.isStatic(f.getModifiers())) continue;
            assertTrue(Modifier.isFinal(f.getModifiers()), "field " + f.getName() + " phải final");
            assertTrue(Modifier.isPrivate(f.getModifiers()), "field " + f.getName() + " phải private");
        }
    }

    @Test
    void constructorMakesDefensiveCopies() {
        Date start = new Date(1_000_000L);
        List<String> guests = new ArrayList<>(List.of("an", "binh"));
        Bai18MidImmutableBooking b = new Bai18MidImmutableBooking("lan", start, guests);
        start.setTime(0);
        guests.add("hacker");
        assertEquals(1_000_000L, b.getStart().getTime());
        assertEquals(List.of("an", "binh"), b.getGuests());
        assertEquals("lan", b.getOwner());
    }

    @Test
    void gettersDoNotExposeInternals() {
        Bai18MidImmutableBooking b = new Bai18MidImmutableBooking("lan", new Date(5_000L), List.of("an"));
        b.getStart().setTime(0);
        assertEquals(5_000L, b.getStart().getTime());
        assertNotSame(b.getStart(), b.getStart());
        assertThrows(UnsupportedOperationException.class, () -> b.getGuests().add("x"));
        assertThrows(UnsupportedOperationException.class, () -> b.getGuests().remove(0));
    }

    @Test
    void withGuestReturnsNewInstance() {
        Bai18MidImmutableBooking b = new Bai18MidImmutableBooking("lan", new Date(1L), List.of("an"));
        Bai18MidImmutableBooking b2 = b.withGuest("binh");
        assertNotSame(b, b2);
        assertEquals(List.of("an"), b.getGuests());
        assertEquals(List.of("an", "binh"), b2.getGuests());
        assertEquals("lan", b2.getOwner());
        assertEquals(1L, b2.getStart().getTime());
    }

    @Test
    void rejectsNulls() {
        assertThrows(NullPointerException.class, () -> new Bai18MidImmutableBooking(null, new Date(), List.of()));
        assertThrows(NullPointerException.class, () -> new Bai18MidImmutableBooking("a", null, List.of()));
        assertThrows(NullPointerException.class, () -> new Bai18MidImmutableBooking("a", new Date(), null));
        assertThrows(NullPointerException.class,
                () -> new Bai18MidImmutableBooking("a", new Date(), Arrays.asList("x", null)));
    }
}
