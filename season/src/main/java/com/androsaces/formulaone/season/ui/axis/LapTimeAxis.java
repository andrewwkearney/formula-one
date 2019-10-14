/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.ui.axis;

import com.androsaces.formulaone.time.LapTime;
import javafx.scene.chart.Axis;

import java.util.List;

/**
 * @author Andrew Kearney
 */
public class LapTimeAxis extends Axis<LapTime> {
    @Override
    protected Object autoRange(double length) {
        return null;
    }

    @Override
    protected void setRange(Object range, boolean animate) {

    }

    @Override
    protected Object getRange() {
        return null;
    }

    @Override
    public double getZeroPosition() {
        return 0;
    }

    @Override
    public double getDisplayPosition(LapTime value) {
        return 0;
    }

    @Override
    public LapTime getValueForDisplay(double displayPosition) {
        return null;
    }

    @Override
    public boolean isValueOnAxis(LapTime value) {
        return false;
    }

    @Override
    public double toNumericValue(LapTime value) {
        return 0;
    }

    @Override
    public LapTime toRealValue(double value) {
        return null;
    }

    @Override
    protected List<LapTime> calculateTickValues(double length, Object range) {
        return null;
    }

    @Override
    protected String getTickMarkLabel(LapTime value) {
        return null;
    }
}
