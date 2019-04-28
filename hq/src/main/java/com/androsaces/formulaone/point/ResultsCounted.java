/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

/**
 * This enumeration determines whether points were awarded to drivers or
 * constructors for all or a selection of races in a season.
 *
 * @author Andrew Kearney
 * @since 1.0
 */
public enum ResultsCounted {
    /**
     * Points counted in all races of the season.
     */
    ALL,

    /**
     * Best 4 results counted.
     */
    BEST_FOUR,

    /**
     * Best 5 results counted.
     */
    BEST_FIVE,

    /**
     * Best 6 results counted.
     */
    BEST_SIX,

    /**
     * No results counted.
     */
    NONE
}
