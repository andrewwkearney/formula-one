/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.point;

public class PointsAllocation {
    private static final int[] TOP_FIVE = new int[]{8, 6, 4, 3, 2};
    private static final int[] TOP_SIX_EIGHT_POINTS = new int[]{8, 6, 4, 3, 2, 1};
    private static final int[] TOP_SIX_NINE_POINTS = new int[]{9, 6, 4, 3, 2, 1};
    private static final int[] TOP_SIX_TEN_POINTS = new int[]{10, 6, 4, 3, 2, 1};
    private static final int[] TOP_EIGHT = new int[]{10, 8, 6, 5, 4, 3, 2, 1};
    private static final int[] TOP_TEN = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    private PointsAllocation() {
    }

    /**
     * Race point allocation where first place is awarded 8 points, second is
     * awarded 6 points, third place is awarded 4 points, fourth place is
     * awarded 3 points and fifth place is awarded 2 points
     */
    public static int[] getTopFive() {
        return TOP_FIVE;
    }

    /**
     * Race point allocation where first place is awarded 8 points, second
     * place is awarded 6 points, third place is awarded 4 points, fourth place
     * is awarded 3 points, fifth place is awarded 2 points and sixth place is
     * awarded 1 point
     */
    public static int[] getTopSixEightPoints() {
        return TOP_SIX_EIGHT_POINTS;
    }

    /**
     * Race point allocation where first place is awarded 9 points, second
     * place is awarded 6 points, third place is awarded 4 points, fourth place
     * is awarded 3 points, fifth place is awarded 2 points and sixth place is
     * awarded 1 point
     */
    public static int[] getTopSixNinePoints() {
        return TOP_SIX_NINE_POINTS;
    }

    /**
     * Race point allocation where first place is awarded 10 points, second
     * place is awarded 6 points, third place is awarded 4 points, fourth place
     * is awarded 3 points, fifth place is awarded 2 points and sixth place is
     * awarded 1 point
     */
    public static int[] getTopSixTenPoints() {
        return TOP_SIX_TEN_POINTS;
    }

    /**
     * Race point allocation where first place is awarded 10 points, second
     * place is awarded 8 points, third place is awarded 6 points, fourth place
     * is awarded 5 points, fifth place is awarded 4 points, sixth place is
     * awarded 3 points, seventh place is awarded 2 points and eighth place is
     * awarded 1 point
     */
    public static int[] getTopEight() {
        return TOP_EIGHT;
    }

    /**
     * Race point allocation where first place is awarded 25 points, second
     * place is awarded 18 points, third place is awarded 15 points, fourth
     * place is awarded 12 points, fifth place is awarded 10 points, sixth
     * place is awarded 8 points, seventh place is awarded 6 points, eighth
     * place is awarded 4 points, ninth place is awarded 2 points and tenth
     * place is awarded 1 point
     */
    public static int[] getTopTen() {
        return TOP_TEN;
    }
}
