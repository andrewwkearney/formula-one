/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.ui.axis;

import com.androsaces.formulaone.time.LapTime;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.chart.Axis;

import java.util.List;

/**
 * @author Andrew Kearney
 */
public class LapTimeAxis extends Axis<LapTime> {
    private final StringProperty currentFormatterProperty = new SimpleStringProperty(this, "currentFormatter", "");

    /** This is the minimum current data value and it is used while auto ranging. */
    private double dataMinValue;
    /** This is the maximum current data value and it is used while auto ranging. */
    private double dataMaxValue;
    private boolean measureInvalid = false;

    @Override
    protected Object autoRange(double length) {
        // guess something sensible
        if (isAutoRanging()) {
            double labelSize = getTickLabelFont().getSize() * 2;
            return autoRange(dataMinValue, dataMaxValue, length, labelSize);
        } else {
            return getRange();
        }
    }

    private Object autoRange(double minValue, double maxValue, double length, double labelSize) {
        return null;
    }

    @Override
    protected Object getRange() {
        return new Object[]{
                getLowerBound(),
                getUpperBound(),
                getTickUnit(),
                getScale(),
                currentFormatterProperty.get()
        };
    }

    @Override
    protected void setRange(Object range, boolean animate) {
        Object[] rangeProps = (Object[]) range;
        double lowerBound = (double) rangeProps[0];
        double upperBound = (double) rangeProps[1];
        double tickUnit = (double) rangeProps[2];
        double scame = (double) rangeProps[3];
        String formatter = (String) rangeProps[4];
        currentFormatterProperty.set(formatter);
        double oldLowerBound = getLowerBound();
        setLowerBound(lowerBound);
        setUpperBound(upperBound);
        setTickUnit(tickUnit);
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


    /**
     * The value for the lower bound of this axis (minimum value). This value is
     * automatically set if auto ranging is on.
     */
    private DoubleProperty lowerBound = new DoublePropertyBase(0) {
        @Override protected void invalidated() {
            if (!isAutoRanging()) {
                invalidateRange();
                requestAxisLayout();
            }
        }

        @Override public Object getBean() {
            return LapTimeAxis.this;
        }

        @Override public String getName() {
            return "lowerBound";
        }
    };
    public final double getLowerBound() { return lowerBound.get(); }
    public final void setLowerBound(double value) { lowerBound.set(value); }
    public final DoubleProperty lowerBoundProperty() { return lowerBound; }

    /**
     * The value for the upper bound of this axis (maximum value). This value is
     * automatically set if auto ranging is on.
     */
    private DoubleProperty upperBound = new DoublePropertyBase(0) {
        @Override protected void invalidated() {
            if (!isAutoRanging()) {
                invalidateRange();
                requestAxisLayout();
            }
        }

        @Override public Object getBean() {
            return LapTimeAxis.this;
        }

        @Override public String getName() {
            return "upperBound";
        }
    };
    public final double getUpperBound() { return upperBound.get(); }
    public final void setUpperBound(double value) { upperBound.set(value); }
    public final DoubleProperty upperBoundProperty() { return upperBound; }

    private ReadOnlyDoubleWrapper scale = new ReadOnlyDoubleWrapper(this, "scale", 0) {
        @Override
        protected void invalidated() {
            requestAxisLayout();
            measureInvalid = true;
        }
    };
    public final double getScale() { return scale.get(); }
    public final void setScale(double value) { scale.set(value); }
    public final ReadOnlyDoubleProperty scaleProperty() { return scale.getReadOnlyProperty(); }

    /**
     * The value between each major tick mark in data units. This is
     * automatically set if auto ranging is on.
     */
    private DoubleProperty tickUnit = new DoublePropertyBase() {
        @Override protected void invalidated() {
            if (!isAutoRanging()) {
                invalidateRange();
                requestAxisLayout();
            }
        }

        @Override public Object getBean() {
            return LapTimeAxis.this;
        }

        @Override public String getName() {
            return "tickUnit";
        }
    };

    public final double getTickUnit() { return tickUnit.get(); }
    public final void setTickUnit(double value) { tickUnit.set(value); }
    public DoubleProperty tickUnitProperty() { return tickUnit; }
}
