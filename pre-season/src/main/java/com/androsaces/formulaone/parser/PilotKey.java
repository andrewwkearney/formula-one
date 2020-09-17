package com.androsaces.formulaone.parser;

import com.androsaces.buckaroo.Params;
import com.androsaces.buckaroo.annotation.NotNull;

import java.util.Objects;

/**
 * A record class that holds a driver number and name.
 *
 * @author Andrew Kearney
 */
public class PilotKey {
    private final int mNumber;
    private final String mName;

    public PilotKey(int number, @NotNull String name) {
        mNumber = Params.inRange(number, 1, 99);
        mName = Params.notNull(name, "name");
    }

    public int getNumber() {
        return mNumber;
    }

    public String getName() {
        return mName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotKey pilotKey = (PilotKey) o;
        return mNumber == pilotKey.mNumber &&
            Objects.equals(mName, pilotKey.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mNumber, mName);
    }
}
