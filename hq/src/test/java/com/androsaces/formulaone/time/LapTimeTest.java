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
    @DisplayName("Lap time string parameter cannot be null")
    void cannotHaveNullLapTimeString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new LapTime(null));
        assertEquals("lapTime cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Creating lap times and lap time as string")
    void testGetLapTime() {
        assertAll("lap time string",
            () -> assertEquals("0:00.000", new LapTime(0L).getTimeString()),
            () -> assertEquals("0:00.001", new LapTime(1L).getTimeString()),
            () -> assertEquals("0:00.010", new LapTime(10L).getTimeString()),
            () -> assertEquals("0:00.100", new LapTime(100L).getTimeString()),
            () -> assertEquals("0:00.200", new LapTime(200L).getTimeString()),
            () -> assertEquals("0:00.225", new LapTime(225L).getTimeString()),
            () -> assertEquals("0:00.250", new LapTime(250L).getTimeString()),
            () -> assertEquals("0:00.275", new LapTime(275L).getTimeString()),
            () -> assertEquals("0:01.000", new LapTime(1000L).getTimeString()),
            () -> assertEquals("0:01.001", new LapTime(1001L).getTimeString()),
            () -> assertEquals("0:01.002", new LapTime(1002L).getTimeString()),
            () -> assertEquals("0:01.010", new LapTime(1010L).getTimeString()),
            () -> assertEquals("0:01.100", new LapTime(1100L).getTimeString()),
            () -> assertEquals("0:01.200", new LapTime(1200L).getTimeString()),
            () -> assertEquals("0:01.400", new LapTime(1400L).getTimeString()),
            () -> assertEquals("0:01.600", new LapTime(1600L).getTimeString()),
            () -> assertEquals("0:01.800", new LapTime(1800L).getTimeString()),
            () -> assertEquals("0:02.000", new LapTime(2000L).getTimeString()),
            () -> assertEquals("1:23.644", new LapTime(83644L).getTimeString()),
            () -> assertEquals("1:25.836", new LapTime(85836L).getTimeString()),
            () -> assertEquals("2:03.957", new LapTime(123957L).getTimeString()),
            () -> assertEquals("21:07.534", new LapTime(1267534L).getTimeString())
        );
    }

    @Test
    @DisplayName("")
    void testGetLapTimeCreatedFromString() {
        assertAll("lap time string",
            () -> assertEquals(new LapTime("0:00.000").getTime(), 0L),
            () -> assertEquals(new LapTime("0:00.001").getTime(), 1L),
            () -> assertEquals(new LapTime("0:00.010").getTime(), 10L),
            () -> assertEquals(new LapTime("0:00.100").getTime(), 100L),
            () -> assertEquals(new LapTime("0:00.200").getTime(), 200L),
            () -> assertEquals(new LapTime("0:00.225").getTime(), 225L),
            () -> assertEquals(new LapTime("0:00.250").getTime(), 250L),
            () -> assertEquals(new LapTime("0:00.275").getTime(), 275L),
            () -> assertEquals(new LapTime("0:01.000").getTime(), 1000L),
            () -> assertEquals(new LapTime("0:01.001").getTime(), 1001L),
            () -> assertEquals(new LapTime("0:01.002").getTime(), 1002L),
            () -> assertEquals(new LapTime("0:01.010").getTime(), 1010L),
            () -> assertEquals(new LapTime("0:01.100").getTime(), 1100L),
            () -> assertEquals(new LapTime("0:01.200").getTime(), 1200L),
            () -> assertEquals(new LapTime("0:01.400").getTime(), 1400L),
            () -> assertEquals(new LapTime("0:01.600").getTime(), 1600L),
            () -> assertEquals(new LapTime("0:01.800").getTime(), 1800L),
            () -> assertEquals(new LapTime("0:02.000").getTime(), 2000L),
            () -> assertEquals(new LapTime("1:23.644").getTime(), 83644L),
            () -> assertEquals(new LapTime("1:25.836").getTime(), 85836L),
            () -> assertEquals(new LapTime("2:03.957").getTime(), 123957L),
            () -> assertEquals(new LapTime("21:07.534").getTime(), 1267534L)
        );
    }
}
