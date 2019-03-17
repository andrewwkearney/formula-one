/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.pilot;

import com.androsaces.buckaroo.config.Country;
import java.util.Objects;

/**
 * Represents a race or practice driver.
 *
 * @author Andrew Kearney
 */
public class Pilot {
    private final String mId;
    private final String mFirstName;
    private final String mLastName;
    private final String mTla;
    private final int mNumber;
    private final Country mNationality;

    Pilot(PilotBuilder pilotBuilder) {
        mId = pilotBuilder.mId;
        mFirstName = pilotBuilder.mFirstName;
        mLastName = pilotBuilder.mLastName;
        mTla = pilotBuilder.mTla;
        mNumber = pilotBuilder.mNumber;
        mNationality = Country.valueOf(pilotBuilder.mNationality);
    }

    /**
     * The database ID for the pilot
     */
    public String getId() {
        return mId;
    }

    /**
     * The first name of the pilot
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * The last name of the pilot
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * The timing loop abbreviation of the pilot
     */
    public String getTla() {
        return mTla;
    }

    /**
     * The pilots car number
     */
    public int getNumber() {
        return mNumber;
    }

    /**
     * The official nationality that the pilot races under
     */
    public Country getNationality() {
        return mNationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pilot)) {
            return false;
        }
        Pilot pilot = (Pilot) o;
        return mNumber == pilot.mNumber &&
            mId.equals(pilot.mId) &&
            mFirstName.equals(pilot.mFirstName) &&
            mLastName.equals(pilot.mLastName) &&
            mTla.equals(pilot.mTla) &&
            mNationality == pilot.mNationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mFirstName, mLastName, mTla, mNumber, mNationality);
    }

    @Override
    public String toString() {
        return "Pilot{" +
            "mId='" + mId + '\'' +
            ", mFirstName='" + mFirstName + '\'' +
            ", mLastName='" + mLastName + '\'' +
            ", mTla='" + mTla + '\'' +
            ", mNumber=" + mNumber +
            ", mNationality=" + mNationality.getName() +
            '}';
    }
}
