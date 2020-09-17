/*
 * Copyright (c) 2020. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.time;

import com.androsaces.buckaroo.Params;
import com.androsaces.buckaroo.config.UnitOfTime;

import static com.androsaces.buckaroo.config.UnitOfTime.*;

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

    public DepartsLaneTime(String departLaneTime) {
        mDepartLaneTimeString = departLaneTime;
        mDepartLaneTime = stringToLong(departLaneTime);
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
        time = time / 1000;
        int seconds = (int) time % 60;
        time = time / 60;
        int minutes = (int) time % 60;
        time = time / 60;
        return String.format("%02d:%02d:%02d", time, minutes, seconds);
    }

    private static long stringToLong(String stringTime) {
        long time = 0L;
        if ("00:00:00".equals(stringTime)) return time;
        String[] split = stringTime.split(":");

        time = Integer.parseInt(split[0]) * HOUR.getUnitOfTime();
        time += Integer.parseInt(split[1]) * MINUTE.getUnitOfTime();
        time += Integer.parseInt(split[2]) * SECOND.getUnitOfTime();
        return time;
    }

    private static long reduce(long time, UnitOfTime unitOfTime) {
        return time / unitOfTime.getUnitOfTime();
    }
}
