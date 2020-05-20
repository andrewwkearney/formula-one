package com.androsaces.formulaone.time;

/**
 * This interface should be implemented by any class that represents a lap time,
 * or some form of time within a Formula 1 session.
 *
 * @author Andrew Kearney
 */
public interface Time extends Comparable<Time> {
    /**
     * Returns the time as a long.
     */
    long getTime();

    /**
     * Returns the time as a formatted string.
     */
    String getTimeString();
}
