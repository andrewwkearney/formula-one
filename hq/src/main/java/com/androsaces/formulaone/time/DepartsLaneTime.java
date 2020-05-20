/*
 * Copyright (c) 2020. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.time;

import com.androsaces.buckaroo.Params;

/**
 * Represents the first time that a pilot leaves the pit lane at the beginning of
 * a Formula 1 session.
 *
 * @author Andrew Kearney
 */
public class DepartsLaneTime implements Time {
    private final long mDepartLaneTime;
    private final String mDepartLaneTimeString;

    DepartsLaneTime(long departLaneTime) {
        mDepartLaneTime = Params.notNegative(departLaneTime);
        mDepartLaneTimeString = longToString(departLaneTime);
    }

    @Override
    public long getTime() {
        return mDepartLaneTime;
    }

    @Override
    public String getTimeString() {
        return mDepartLaneTimeString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartsLaneTime that = (DepartsLaneTime) o;
        return mDepartLaneTime == that.mDepartLaneTime;
    }

    @Override
    public int hashCode() {
        return (int) (mDepartLaneTime ^ (mDepartLaneTime >>> 32));
    }

    @Override
    public int compareTo(Time o) {
        return (int) (mDepartLaneTime - o.getTime());
    }

    @Override
    public String toString() {
        return mDepartLaneTimeString;
    }

    private static String longToString(long time) {
        if (time == 0L) return "00:00:00";
        int hours = (int) time / 3600;
        time = time % 3600;
        int minutes = (int) time / 60;
        time = time % 60;
        int seconds = (int) time;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
