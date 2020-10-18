package com.androsaces.formulaone.parser;

import com.androsaces.buckaroo.Params;
import com.androsaces.buckaroo.annotation.NotNull;
import com.androsaces.formulaone.time.Time;

import java.util.Objects;

public class AggregateLapTime {
    private final int mLapNumber;
    private final boolean mIsPitted;
    private final Time mLapTime;

    public AggregateLapTime(@NotNull int lapNumber, @NotNull boolean isPitted, @NotNull Time lapTime) {
        mLapNumber = Params.inRange(lapNumber, 1, 99);
        mIsPitted = Params.notNull(isPitted);
        mLapTime = Params.notNull(lapTime, "lapTime");
    }

    public int getLapNumber() {
        return mLapNumber;
    }

    public boolean isPitted() {
        return mIsPitted;
    }

    public Time getLapTime() {
        return mLapTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregateLapTime that = (AggregateLapTime) o;
        return mLapNumber == that.mLapNumber &&
            mIsPitted == that.mIsPitted &&
            Objects.equals(mLapTime, that.mLapTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mLapNumber, mIsPitted, mLapTime);
    }

    @Override
    public String toString() {
        return "AggregateLapTime{" +
            ", mLapNumber=" + mLapNumber +
            ", mIsPitted=" + mIsPitted +
            ", mLapTime=" + mLapTime +
            '}';
    }
}
