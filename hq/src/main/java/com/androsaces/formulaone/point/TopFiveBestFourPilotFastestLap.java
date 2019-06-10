/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

public class TopFiveBestFourPilotFastestLap extends TopFive {
    private final FastestLap mFastestLap = FastestLap.AWARDED;
    private final ResultsCounted mPilotResultsCounted = ResultsCounted.BEST_FOUR;
    private final ResultsCounted mConstructorResultsCounted = ResultsCounted.NONE;

    @Override
    public FastestLap getFastestLap() {
        return mFastestLap;
    }
}
