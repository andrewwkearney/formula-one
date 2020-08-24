/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.time;

import com.androsaces.buckaroo.Params;
import com.androsaces.buckaroo.annotation.NotNull;

/**
 * Represents a lap time that can be set by a pilot within an active Formula 1 session.
 *
 * @author Andrew Kearney
 */
public class LapTime implements Time {
    private final long mLapTime;
    private final String mLapTimeString;

    /**
     * Creates a new instance of a lap time where the provided long is the number
     * of milliseconds the lap took to complete.
     *
     * @param lapTime the lap time in milliseconds
     */
    public LapTime(long lapTime) {
        mLapTime = Params.notNegative(lapTime);
        mLapTimeString = longToString(lapTime);
    }

    /**
     * Creates a new instance of a lap time where the provided string is in the
     * format of m:ss.sss.
     *
     * @param lapTime the lap time as a string
     */
    public LapTime(@NotNull String lapTime) {
        mLapTimeString = Params.notNull(lapTime, "lapTime");
        mLapTime = stringToLong(lapTime);
    }

    @Override
    public long getTime() {
        return mLapTime;
    }

    @Override
    public String getTimeString() {
        return mLapTimeString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LapTime that = (LapTime) o;
        return this.mLapTime == that.mLapTime;
    }

    @Override
    public int hashCode() {
        return (int) (mLapTime ^ (mLapTime >>> 32));
    }

    @Override
    public int compareTo(Time o) {
        return (int) (mLapTime - o.getTime());
    }

    @Override
    public String toString() {
        return mLapTimeString;
    }

    private static String longToString(long time) {
        if (time == 0L) return "0:00.000";
        int minute = (int) (time / 60000);
        time = time % 60000;
        int second = (int) time / 1000;
        time = time % 1000;
        int milli = (int) time;
        return String.format("%1d:%02d.%03d", minute, second, milli);
    }

    private static long stringToLong(String lapTime) {
        if ("0:00.000".equals(lapTime)) return 0L;
        long time = 0L;
        int colon = lapTime.indexOf(":");
        int period = lapTime.indexOf(".");
        int minute = Integer.parseInt(lapTime.substring(0, colon));
        time = minute * 60000;
        int second = Integer.parseInt(lapTime.substring(++colon, period));
        time = time + (second * 1000);
        int milli = Integer.parseInt(lapTime.substring(++period));
        time = time + milli;
        return time;
    }
}
