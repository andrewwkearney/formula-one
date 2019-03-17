/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.pilot;

import com.androsaces.buckaroo.Params;
import com.androsaces.buckaroo.pattern.Build;

/**
 * A thread-safe builder for a {@link Pilot}.
 *
 * @author Andrew Kearney
 */
public class PilotBuilder implements Build<Pilot> {
    String mId;
    String mFirstName;
    String mLastName;
    String mTla;
    int mNumber;
    String mNationality;

    public PilotBuilder() {

    }

    public PilotBuilder withId(String id) {
        mId = id;
        return this;
    }

    public PilotBuilder withFirstName(String firstName) {
        mFirstName = firstName;
        return this;
    }

    public PilotBuilder withLastName(String lastName) {
        mLastName = lastName;
        return this;
    }

    public PilotBuilder withTla(String tla) {
        mTla = tla;
        return this;
    }

    public PilotBuilder withNumber(int number) {
        mNumber = number;
        return this;
    }

    public PilotBuilder withNationality(String nationality) {
        mNationality = Params.notNull(nationality, "nationality");
        return this;
    }

    @Override
    public Pilot build() {
        Pilot pilot = new Pilot(this);
        Params.notNull(pilot.getId(), "id");
        Params.notNull(pilot.getFirstName(), "first_name");
        Params.notNull(pilot.getLastName(), "last_name");
        Params.notNull(pilot.getTla(), "tla");
        Params.inRange(pilot.getNumber(), 0, 100);
        Params.notNull(pilot.getNationality(), "nationality");
        return pilot;
    }
}
