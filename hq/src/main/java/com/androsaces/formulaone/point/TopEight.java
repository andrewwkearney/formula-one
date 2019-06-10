/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import com.androsaces.buckaroo.Params;

import java.util.Arrays;
import java.util.Objects;

/**
 * This points scoring system was used from 2003 until 2009, where points were
 * awarded to the top eight finishers in all races of the season, with the race
 * winner receiving 10 driver and constructor points down to the eighth place
 * finisher receiving 1 driver and constructor point. No points were awarded to
 * the pole position or fastest lap holder.
 *
 * @author Andrew Kearney
 * @see FastestLap
 * @see PointsAllocation
 * @see PolePosition
 * @see ResultsCounted
 * @since 1.0
 */
public class TopEight implements ScoringSystem {
    private final FastestLap mFastestLap = FastestLap.NOT_AWARDED;
    private final PolePosition mPolePosition = PolePosition.NOT_AWARDED;
    private final ResultsCounted mPilotResultsCounted = ResultsCounted.ALL;
    private final ResultsCounted mConstructorResultsCounted = ResultsCounted.ALL;
    private final int[] mPilotPoints = PointsAllocation.getTopEight();
    private final int[] mConstructorPoints = PointsAllocation.getTopEight();

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
        Params.notNegative(position);
        if (position > mConstructorPoints.length) {
            return 0;
        } else {
            return mConstructorPoints[position - 1];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopEight topEight = (TopEight) o;
        return mFastestLap == topEight.mFastestLap &&
                mPolePosition == topEight.mPolePosition &&
                mPilotResultsCounted == topEight.mPilotResultsCounted &&
                mConstructorResultsCounted == topEight.mConstructorResultsCounted &&
                Arrays.equals(mPilotPoints, topEight.mPilotPoints) &&
                Arrays.equals(mConstructorPoints, topEight.mConstructorPoints);
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
        return "TopEight{" +
                "fastestLap=" + mFastestLap +
                ", polePosition=" + mPolePosition +
                ", pilotResultsCounted=" + mPilotResultsCounted +
                ", constructorResultsCounted=" + mConstructorResultsCounted +
                ", pilotPoints=" + mPilotPoints.length +
                ", constructorPoints=" + mConstructorPoints.length +
                '}';
    }
}
