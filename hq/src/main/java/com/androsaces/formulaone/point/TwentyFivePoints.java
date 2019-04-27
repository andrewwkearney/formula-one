/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

import com.androsaces.buckaroo.Params;
import java.util.Arrays;
import java.util.Objects;

/**
 * This points scoring system was used from 2010 until 2018, where points were
 * awarded to the top ten finishers in all races of the season, with the race
 * winner receiving 25 driver and constructor points down to the 10th place
 * finisher receiving 1 driver and constructor point. No points were awarded
 * to the pole position or fastest lap holder.
 *
 * @author Andrew Kearney
 * @see FastestLap
 * @see PolePosition
 * @see ResultsCounted
 * @since 1.0
 */
public class TwentyFivePoints implements ScoringSystem {
    private final FastestLap mFastestLap = FastestLap.NOT_AWARDED;
    private final PolePosition mPolePosition = PolePosition.NOT_AWARDED;
    private final ResultsCounted mPilotResultsCounted = ResultsCounted.ALL;
    private final ResultsCounted mConstructorResultsCounted = ResultsCounted.ALL;
    private final int[] mPilotPoints = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
    private final int[] mConstructorPoints = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    @Override
    public FastestLap getFastestLap() {
        return mFastestLap;
    }

    @Override
    public PolePosition getPolePosition() {
        return mPolePosition;
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public int getPilotPointsAwarded(int position) {
        Params.notNegative(position);
        if (position > mPilotPoints.length) {
            return 0;
        } else {
            return mPilotPoints[position - 1];
        }
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof TwentyFivePoints)) {
            return false;
        }
        TwentyFivePoints that = (TwentyFivePoints) o;
        return mFastestLap == that.mFastestLap &&
            mPilotResultsCounted == that.mPilotResultsCounted &&
            mConstructorResultsCounted == that.mConstructorResultsCounted &&
            Arrays.equals(mPilotPoints, that.mPilotPoints) &&
            Arrays.equals(mConstructorPoints, that.mConstructorPoints);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mFastestLap, mPilotResultsCounted, mConstructorResultsCounted);
        result = 31 * result + Arrays.hashCode(mPilotPoints);
        result = 31 * result + Arrays.hashCode(mConstructorPoints);
        return result;
    }

    @Override
    public String toString() {
        return "TwentyFivePoints{" +
            "fastestLap=" + mFastestLap +
            ", polePosition=" + mPolePosition +
            ", pilotResultsCounted=" + mPilotResultsCounted +
            ", constructorResultsCounted=" + mConstructorResultsCounted +
            ", pilotPointsAwardDownTo=" + mPilotPoints.length +
            ", constructorPointsAwardDownTo=" + mConstructorPoints.length +
            '}';
    }
}
