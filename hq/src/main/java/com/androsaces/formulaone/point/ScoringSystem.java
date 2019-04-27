/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import com.androsaces.formulaone.pilot.Pilot;

/**
 * This interface should be implemented by any class that represents a Formula
 * 1&trade; point scoring system.
 *
 * @author Andrew Kearney
 * @since 1.0
 */
public interface ScoringSystem {
    /**
     * Returns the {@link FastestLap} used in the season.
     */
    FastestLap getFastestLap();

    /**
     * Returns the {@link PolePosition} used in the season.
     */
    PolePosition getPolePosition();

    /**
     * Returns the number of points awarded to the {@link Pilot} who finished
     * in that provided position.
     *
     * @param position the position the pilot was in
     * @return the number of driver points awarded
     */
    int getPilotPointsAwarded(int position);

    /**
     * Returns the number of points awarded to the Constructor who finished
     * in that provided position.
     *
     * @param position the position the pilot was in
     * @return the number of constructor points awarded
     */
    int getConstructorPointsAwarded(int position);

    ScoringSystem NULL = new ScoringSystem() {
        @Override public FastestLap getFastestLap() { return FastestLap.NOT_AWARDED; }
        @Override public PolePosition getPolePosition() { return PolePosition.NOT_AWARDED; }
        @Override public int getPilotPointsAwarded(int position) { return 0; }
        @Override public int getConstructorPointsAwarded(int position) { return 0; }
        @Override public String toString() { return ScoringSystem.class.getSimpleName().concat(".NULL"); }
    };
}
