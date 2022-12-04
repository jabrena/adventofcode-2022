package com.putoet.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void of() {
        final Range range = Range.of("12-28");
        assertEquals(12, range.lower());
        assertEquals(28, range.upper());

        assertThrows(AssertionError.class, () -> Range.of("13-5"));
        assertThrows(IllegalArgumentException.class, () -> Range.of("a-5"));
    }
}