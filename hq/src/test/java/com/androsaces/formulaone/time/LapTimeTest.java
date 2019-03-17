package com.androsaces.formulaone.time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link LapTime} class.
 *
 * @author Andrew Kearney
 */
class LapTimeTest {
    @Test
    @DisplayName("Lap time parameter cannot be less than zero")
    void cannotHaveNegativeLapTime() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new LapTime(-100L));
        assertEquals("parameter -100 cannot be less than zero", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Creating lap times and lap time as string")
    void testGetLapTime() {
        assertAll("lap time string",
            () -> assertEquals("0:00.000", new LapTime(0L).getLapTimeAsString()),
            () -> assertEquals("0:00.001", new LapTime(1L).getLapTimeAsString()),
            () -> assertEquals("0:00.010", new LapTime(10L).getLapTimeAsString()),
            () -> assertEquals("0:00.100", new LapTime(100L).getLapTimeAsString()),
            () -> assertEquals("0:00.200", new LapTime(200L).getLapTimeAsString()),
            () -> assertEquals("0:00.225", new LapTime(225L).getLapTimeAsString()),
            () -> assertEquals("0:00.250", new LapTime(250L).getLapTimeAsString()),
            () -> assertEquals("0:00.275", new LapTime(275L).getLapTimeAsString()),
            () -> assertEquals("0:01.000", new LapTime(1000L).getLapTimeAsString()),
            () -> assertEquals("0:01.001", new LapTime(1001L).getLapTimeAsString()),
            () -> assertEquals("0:01.002", new LapTime(1002L).getLapTimeAsString()),
            () -> assertEquals("0:01.010", new LapTime(1010L).getLapTimeAsString()),
            () -> assertEquals("0:01.100", new LapTime(1100L).getLapTimeAsString()),
            () -> assertEquals("0:01.200", new LapTime(1200L).getLapTimeAsString()),
            () -> assertEquals("0:01.400", new LapTime(1400L).getLapTimeAsString()),
            () -> assertEquals("0:01.600", new LapTime(1600L).getLapTimeAsString()),
            () -> assertEquals("0:01.800", new LapTime(1800L).getLapTimeAsString()),
            () -> assertEquals("0:02.000", new LapTime(2000L).getLapTimeAsString()),
            () -> assertEquals("1:23.644", new LapTime(83644L).getLapTimeAsString()),
            () -> assertEquals("1:25.836", new LapTime(85836L).getLapTimeAsString()),
            () -> assertEquals("2:03.957", new LapTime(123957L).getLapTimeAsString())
        );
    }
}