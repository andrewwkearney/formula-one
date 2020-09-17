package com.androsaces.formulaone.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Kearney
 */
class PilotKeyTest {
    @Test
    @DisplayName("Driver name cannot be null")
    void driverNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new PilotKey(1, null));
    }

    @Test
    @DisplayName("Driver number cannot be less than 1")
    void driverNumberNotLessThanOne() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> new PilotKey(0, "Driver Name")),
            () -> assertThrows(IllegalArgumentException.class, () -> new PilotKey(-1, "Driver Name"))
        );
    }

    @Test
    @DisplayName("Driver number cannot be greater than 99")
    void driverNumberNotGreaterThanHundred() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> new PilotKey(100, "Driver Name")),
            () -> assertThrows(IllegalArgumentException.class, () -> new PilotKey(999, "Driver Name"))
        );
    }
}