/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import java.util.Arrays;
import java.util.Objects;

/**
 * This points scoring system was used from 1991 until 2002, where points were
 * awarded to the top six finishers in all races of the season, with the race
 * winner receiving 10 driver and constructor points down to the 6th place
 * finisher receiving 1 driver and constructor point. No points were awarded
 * to the pole position or fastest lap holder.
 *
 * @author Andrew Kearney
 * @see FastestLap
 * @see PointsAllocation
 * @see PolePosition
 * @see ResultsCounted
 * @since 1.0
 */
public class TopSix implements ScoringSystem {
    private final FastestLap mFastestLap = FastestLap.NOT_AWARDED;
    private final PolePosition mPolePosition = PolePosition.NOT_AWARDED;
    private final ResultsCounted mPilotResultsCounted = ResultsCounted.ALL;
    private final ResultsCounted mConstructorResultsCounted = ResultsCounted.ALL;
    private final int[] mPilotPoints = PointsAllocation.getTopSixTenPoints();
    private final int[] mConstructorPoints = PointsAllocation.getTopSixTenPoints();

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
        return 0;
    }

    @Override
    public int getConstructorPointsAwarded(int position) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopSix topSix = (TopSix) o;
        return mFastestLap == topSix.mFastestLap &&
                mPolePosition == topSix.mPolePosition &&
                mPilotResultsCounted == topSix.mPilotResultsCounted &&
                mConstructorResultsCounted == topSix.mConstructorResultsCounted &&
                Arrays.equals(mPilotPoints, topSix.mPilotPoints) &&
                Arrays.equals(mConstructorPoints, topSix.mConstructorPoints);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mFastestLap, mPolePosition, mPilotResultsCounted, mConstructorResultsCounted);
        result = 31 * result + Arrays.hashCode(mPilotPoints);
        result = 31 * result + Arrays.hashCode(mConstructorPoints);
        return result;
    }

    @Override
    public String toString() {
        return "TopSix{" +
                "fastestLap=" + mFastestLap +
                ", polePosition=" + mPolePosition +
                ", pilotResultsCounted=" + mPilotResultsCounted +
                ", constructorResultsCounted=" + mConstructorResultsCounted +
                ", pilotPointsAwardDownTo=" + mPilotPoints.length +
                ", constructorPointsAwardDownTo=" + mConstructorPoints.length +
                '}';
    }
}

