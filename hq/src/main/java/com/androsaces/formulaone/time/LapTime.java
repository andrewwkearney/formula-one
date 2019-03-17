/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.time;

import com.androsaces.buckaroo.Params;

/**
 * Represents a lap time that can be set by a pilot within an active Formula 1 session.
 *
 * @author Andrew Kearney
 */
public class LapTime {
    private final long mLapTime;
    private final String mLapTimeString;

    LapTime(long lapTime) {
        mLapTime = Params.notNegative(lapTime);
        mLapTimeString = LapTimeConstructor.getLapTimeAsString(lapTime);
    }

    public long getLapTime() {
        return mLapTime;
    }

    public String getLapTimeAsString() {
        return mLapTimeString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LapTime that = (LapTime) o;
        return this.mLapTime == that.mLapTime;
    }

    @Override
    public int hashCode() {
        return (int) (mLapTime ^ (mLapTime >>> 32));
    }

    @Override
    public String toString() {
        return "LapTime{" + mLapTimeString + '}';
    }

    private static class LapTimeConstructor {
        private static String getLapTimeAsString(long time) {
            if (time == 0L) return "0:00.000";
            int minute = (int) (time / 60000);
            time = time % 60000;
            int second = (int) time / 1000;
            time = time % 1000;
            int milli = (int) time;
            return String.format("%1d:%02d.%03d", minute, second, milli);
        }
    }
}
