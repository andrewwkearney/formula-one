/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import com.androsaces.buckaroo.EmptyArrays;
import com.androsaces.buckaroo.Params;

/**
 * @author Andrew Kearney
 */
public class EightPoints implements ScoringSystem {
    private final FastestLap mFastestLap = FastestLap.AWARDED;
    private final PolePosition mPolePosition = PolePosition.NOT_AWARDED;
    private final ResultsCounted mPilotResultsCounted = ResultsCounted.BEST_FOUR;
    private final ResultsCounted mConstructorResultsCounted = ResultsCounted.NONE;
    private final int[] mPilotPoints = new int[]{8, 6, 4, 3, 2};
    private final int[] mConstructorPoints = EmptyArrays.EMPTY_INT_ARRAY;

    @Override
    public FastestLap getFastestLap() {
        return mFastestLap;
    }

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
        return 0;
    }
}
