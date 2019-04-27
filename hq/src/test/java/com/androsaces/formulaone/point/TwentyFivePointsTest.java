package com.androsaces.formulaone.point;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link TwentyFivePoints} class.
 *
 * @author Andrew Kearney
 */
class TwentyFivePointsTest {
    @Test
    @DisplayName("Exception thrown for negative position")
    void exceptionForNegativePosition() {
        IllegalArgumentException pilotException = assertThrows(IllegalArgumentException.class, () -> new TwentyFivePoints().getPilotPointsAwarded(-1));
        assertEquals("parameter -1 cannot be less than zero", pilotException.getMessage());

        IllegalArgumentException constructorException = assertThrows(IllegalArgumentException.class, () -> new TwentyFivePoints().getConstructorPointsAwarded(-1));
        assertEquals("parameter -1 cannot be less than zero", constructorException.getMessage());

    }

    @Test
    @DisplayName("Correct points awarded for each driver position")
    void correctPilotPointsAwarded() {
        TwentyFivePoints pointsSystem = new TwentyFivePoints();

        assertAll("correct_points",
            () -> assertEquals(25, pointsSystem.getPilotPointsAwarded(1)),
            () -> assertEquals(18, pointsSystem.getPilotPointsAwarded(2)),
            () -> assertEquals(15, pointsSystem.getPilotPointsAwarded(3)),
            () -> assertEquals(12, pointsSystem.getPilotPointsAwarded(4)),
            () -> assertEquals(10, pointsSystem.getPilotPointsAwarded(5)),
            () -> assertEquals(8, pointsSystem.getPilotPointsAwarded(6)),
            () -> assertEquals(6, pointsSystem.getPilotPointsAwarded(7)),
            () -> assertEquals(4, pointsSystem.getPilotPointsAwarded(8)),
            () -> assertEquals(2, pointsSystem.getPilotPointsAwarded(9)),
            () -> assertEquals(1, pointsSystem.getPilotPointsAwarded(10)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(11)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(12)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(13)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(14)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(15)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(16)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(17)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(18)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(19)),
            () -> assertEquals(0, pointsSystem.getPilotPointsAwarded(20))
        );
    }

    @Test
    @DisplayName("Correct points awarded for each constructor position")
    void correctConstructorPointsAwarded() {
        TwentyFivePoints pointsSystem = new TwentyFivePoints();
        System.out.println(pointsSystem.toString());

        assertAll("correct_points",
            () -> assertEquals(25, pointsSystem.getConstructorPointsAwarded(1)),
            () -> assertEquals(18, pointsSystem.getConstructorPointsAwarded(2)),
            () -> assertEquals(15, pointsSystem.getConstructorPointsAwarded(3)),
            () -> assertEquals(12, pointsSystem.getConstructorPointsAwarded(4)),
            () -> assertEquals(10, pointsSystem.getConstructorPointsAwarded(5)),
            () -> assertEquals(8, pointsSystem.getConstructorPointsAwarded(6)),
            () -> assertEquals(6, pointsSystem.getConstructorPointsAwarded(7)),
            () -> assertEquals(4, pointsSystem.getConstructorPointsAwarded(8)),
            () -> assertEquals(2, pointsSystem.getConstructorPointsAwarded(9)),
            () -> assertEquals(1, pointsSystem.getConstructorPointsAwarded(10)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(11)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(12)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(13)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(14)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(15)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(16)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(17)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(18)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(19)),
            () -> assertEquals(0, pointsSystem.getConstructorPointsAwarded(20))
        );
    }

    @Test
    @DisplayName("Fastest lap returned")
    void correctFastestLap() {
        assertEquals(FastestLap.NOT_AWARDED, new TwentyFivePoints().getFastestLap());
    }

    @Test
    @DisplayName("Pole position returned")
    void correctPolePosition() {
        assertEquals(PolePosition.NOT_AWARDED, new TwentyFivePoints().getPolePosition());
    }
}
