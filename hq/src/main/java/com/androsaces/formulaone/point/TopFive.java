/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import com.androsaces.buckaroo.EmptyArrays;
import com.androsaces.buckaroo.Params;

/**
 * This points scoring system was used from the start of the championship until
 * 1953. Points were awarded to the top five finishers, while their four best
 * results counted in the drivers championship, no points were awarded to
 * constructors. One point was awarded for pole position.
 *
 * @author Andrew Kearney
 * @see FastestLap
 * @see PointsAllocation
 * @see PolePosition
 * @see ResultsCounted
 * @since 1.0
 */
public abstract class TopFive implements ScoringSystem {
    private final PolePosition mPolePosition = PolePosition.NOT_AWARDED;
    private final int[] mPilotPoints = PointsAllocation.getTopFive();
    private final int[] mConstructorPoints = EmptyArrays.EMPTY_INT_ARRAY;

    @Override
    public abstract FastestLap getFastestLap();

    @Override
    public PolePosition getPolePosition() {
        return mPolePosition;
    }

    @Override
    public int getPilotPointsAwarded(int position) {
        Params.notNegative(position);
        if (position > mPilotPoints.length) {
            return 0;
        } else {
            return mPilotPoints[position - 1];
        }

    }

    @Override
    public int getConstructorPointsAwarded(int position) {
        return mConstructorPoints.length;
    }
}
