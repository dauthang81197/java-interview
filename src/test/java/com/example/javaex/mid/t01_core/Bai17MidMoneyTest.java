package com.example.javaex.mid.t01_core;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Bai17MidMoneyTest {

    @Test
    void equalsIsReflexiveSymmetricTransitive() {
        Bai17MidMoney a = new Bai17MidMoney(100, "USD");
        Bai17MidMoney b = new Bai17MidMoney(100, "usd");
        Bai17MidMoney c = new Bai17MidMoney(100, "Usd");
        assertEquals(a, a);
        assertEquals(a, b);
        assertEquals(b, a);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    @Test
    void differentValuesNotEqual() {
        assertNotEquals(new Bai17MidMoney(100, "USD"), new Bai17MidMoney(101, "USD"));
        assertNotEquals(new Bai17MidMoney(100, "USD"), new Bai17MidMoney(100, "EUR"));
    }

    @Test
    void nullAndOtherTypes() {
        Bai17MidMoney m = new Bai17MidMoney(1, "USD");
        assertFalse(m.equals(null));
        assertFalse(m.equals("1 USD"));
    }

    @Test
    void nullCurrencyAllowed() {
        assertEquals(new Bai17MidMoney(5, null), new Bai17MidMoney(5, null));
        assertEquals(new Bai17MidMoney(5, null).hashCode(), new Bai17MidMoney(5, null).hashCode());
        assertNotEquals(new Bai17MidMoney(5, null), new Bai17MidMoney(5, "USD"));
        assertNotEquals(new Bai17MidMoney(5, "USD"), new Bai17MidMoney(5, null));
    }

    @Test
    void equalObjectsHaveEqualHashCodes() {
        assertEquals(new Bai17MidMoney(100, "USD").hashCode(), new Bai17MidMoney(100, "usd").hashCode());
    }

    @Test
    void worksInHashCollections() {
        Set<Bai17MidMoney> set = new HashSet<>();
        set.add(new Bai17MidMoney(10, "VND"));
        set.add(new Bai17MidMoney(10, "vnd"));
        set.add(new Bai17MidMoney(11, "VND"));
        assertEquals(2, set.size());
        Map<Bai17MidMoney, String> map = new HashMap<>();
        map.put(new Bai17MidMoney(1, "EUR"), "one");
        assertEquals("one", map.get(new Bai17MidMoney(1, "eur")));
    }

    @Test
    void toStringFormat() {
        assertEquals("100 USD", new Bai17MidMoney(100, "usd").toString());
        assertEquals("100 ?", new Bai17MidMoney(100, null).toString());
    }

    @Test
    void currencyNormalisationIsLocaleIndependent() {
        java.util.Locale old = java.util.Locale.getDefault();
        try {
            java.util.Locale.setDefault(java.util.Locale.forLanguageTag("tr-TR"));
            assertEquals(new Bai17MidMoney(1, "id"), new Bai17MidMoney(1, "ID"));
            assertEquals("1 ID", new Bai17MidMoney(1, "id").toString());
        } finally {
            java.util.Locale.setDefault(old);
        }
    }
}
