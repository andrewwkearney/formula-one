package com.androsaces.formulaone.pilot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link Pilot} class.
 *
 * @author Andrew Kearney
 */
class PilotTest {
    @Test
    @DisplayName("ID cannot be null")
    void idCannotBeNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withId(null).build());
        assertEquals("id cannot be null", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("First name cannot be null")
    void firstNameCannotBeNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withFirstName(null).build());
        assertEquals("first_name cannot be null", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Last name cannot be null")
    void lastNameCannotBeNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withLastName(null).build());
        assertEquals("last_name cannot be null", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Timing loop abbreviation cannot be null")
    void tlaCannotBeNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withTla(null).build());
        assertEquals("tla cannot be null", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Nationality cannot be null")
    void nationalityCannotBeNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withNationality(null).build());
        assertEquals("nationality cannot be null", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Driver number cannot be negative")
    void driverNumberCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withNumber(-5).build());
    }

    @Test
    @DisplayName("Driver number cannot be greater than 100")
    void driverNumberCannotBeGreaterThanOeHundred() {
        assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withNumber(205).build());
    }

    @Test
    @DisplayName("Cannot create pilot with invalid nationality")
    void nationalityCannotBeInvalidEnum() {
        assertThrows(IllegalArgumentException.class, () -> createPilotBuilder().withNationality("XXX").build());
    }

    private PilotBuilder createPilotBuilder() {
        return new PilotBuilder()
            .withId("1950_FAN")
            .withFirstName("Juan Manuel")
            .withLastName("Fangio")
            .withTla("FAN")
            .withNumber(5)
            .withNationality("ARG");
    }
}
