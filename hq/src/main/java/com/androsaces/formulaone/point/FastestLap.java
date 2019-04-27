/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import com.androsaces.formulaone.pilot.Pilot;

/**
 * This enumeration determines whether points were awarded to drivers who
 * recorded the fastest lap of an event.
 *
 * @author Andrew Kearney
 * @since 1.0
 */
public enum FastestLap {
    /**
     * Points were not awarded to the {@link Pilot} who recorded the fastest
     * lap of the race.
     */
    NOT_AWARDED(0, false),

    /**
     * Points were awarded to the {@link Pilot} who recorded the fastest lap
     * of the race.
     */
    AWARDED(1, false),

    /**
     * Points were awarded to the {@link Pilot} who recorded the fastest lap of
     * the race and finished within the first ten positions.
     */
    AWARDED_TOP_TEN(1, true);

    private final int mPoints;
    private final boolean mConditional;

    FastestLap(int points, boolean conditional) {
        mPoints = points;
        mConditional = conditional;
    }

    public int getPoints() {
        return mPoints;
    }

    public boolean isConditional() {
        return mConditional;
    }
}
