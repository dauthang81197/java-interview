package com.example.javaex.junior.t01_coban;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Bai03JrStringBuilderTest {

    @Test
    void repeat() {
        assertEquals("ababab", Bai03JrStringBuilder.repeat("ab", 3));
        assertEquals("", Bai03JrStringBuilder.repeat("ab", 0));
        assertThrows(IllegalArgumentException.class, () -> Bai03JrStringBuilder.repeat("a", -1));
    }

    @Test
    void reverse() {
        assertEquals("cba", Bai03JrStringBuilder.reverse("abc"));
        assertEquals("", Bai03JrStringBuilder.reverse(""));
    }

    @Test
    void palindrome() {
        assertTrue(Bai03JrStringBuilder.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(Bai03JrStringBuilder.isPalindrome(""));
        assertFalse(Bai03JrStringBuilder.isPalindrome("hello"));
    }

    @Test
    void charFrequencyKeepsFirstOccurrenceOrder() {
        Map<Character, Integer> m = Bai03JrStringBuilder.charFrequency("banana");
        assertEquals(List.of('b', 'a', 'n'), List.copyOf(m.keySet()));
        assertEquals(1, m.get('b'));
        assertEquals(3, m.get('a'));
        assertEquals(2, m.get('n'));
    }

    @Test
    void capitalizeWords() {
        assertEquals("Xin Chao The Gioi", Bai03JrStringBuilder.capitalizeWords("xIN chao tHE gioi"));
        assertEquals("", Bai03JrStringBuilder.capitalizeWords(""));
        assertEquals("A", Bai03JrStringBuilder.capitalizeWords("a"));
    }

    @Test
    void countOccurrencesNonOverlapping() {
        assertEquals(2, Bai03JrStringBuilder.countOccurrences("abcabc", "abc"));
        assertEquals(1, Bai03JrStringBuilder.countOccurrences("aaa", "aa"));
        assertEquals(0, Bai03JrStringBuilder.countOccurrences("abc", "x"));
    }
}
