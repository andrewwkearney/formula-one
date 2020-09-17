package com.androsaces.formulaone.time;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Kearney
 */
class DepartsLaneTimeTest {
    @Test
    @DisplayName("Departs lane time parameter cannot be less than zero")
    void cannotHaveNegativeDepartsTime() {
        var illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new DepartsLaneTime(-1L));
        assertEquals("parameter -1 cannot be less than zero", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Creating departs lane time and time as string")
    void getTimeStringReturnsCorrectValues() {
        assertAll("departs lane time string",
            () -> assertEquals("00:00:00", new DepartsLaneTime(0L).getTimeString()),
            () -> assertEquals("00:00:01", new DepartsLaneTime(1000L).getTimeString()),
            () -> assertEquals("12:00:00", new DepartsLaneTime(43200000L).getTimeString()),
            () -> assertEquals("12:00:59", new DepartsLaneTime(43259000L).getTimeString()),
            () -> assertEquals("12:01:00", new DepartsLaneTime(43260000L).getTimeString())
        );
    }

    @Test
    @DisplayName("Creating departs lane time with string")
    void getTimeReturnsCorrectValues() {
        assertAll("departs lane time string",
            () -> assertEquals(43200000L, new DepartsLaneTime("12:00:00").getTime()),
            () -> assertEquals(43259000L, new DepartsLaneTime("12:00:59").getTime()),
            () -> assertEquals(43260000L, new DepartsLaneTime("12:01:00").getTime()),
            () -> assertEquals(43450000L, new DepartsLaneTime("12:04:10").getTime())
        );
    }

    @Test
    @DisplayName("Compare to function")
    void compareToReturnsCorrectValues() {
        assertAll("compare to",
            () -> assertEquals(-1, new DepartsLaneTime(0L).compareTo(new DepartsLaneTime(1L))),
            () -> assertEquals(0, new DepartsLaneTime(0L).compareTo(new DepartsLaneTime(0L))),
            () -> assertEquals(1, new DepartsLaneTime(1L).compareTo(new DepartsLaneTime(0L)))
        );
    }
}