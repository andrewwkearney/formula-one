package com.androsaces.formulaone.time;

/**
 * @author Andrew Kearney
 */
public interface Time extends Comparable<Time> {
    /**
     *
     * @return
     */
    long getTime();

    String getTimeString();
}
