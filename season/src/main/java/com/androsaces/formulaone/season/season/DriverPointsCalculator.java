/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.season;

import com.androsaces.formulaone.point.ScoringSystem;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrew Kearney
 */
public class DriverPointsCalculator {
    private static final Logger logger = LoggerFactory.getLogger(DriverPointsCalculator.class);

    private final ScoringSystem mScoringSystem;

    public DriverPointsCalculator(ScoringSystem scoringSystem) {
        mScoringSystem = scoringSystem;
    }

    public Map<String, Integer> calculateResults(Map<String, Integer> racePositions) {
        Map<String, Integer> pointsMap = new LinkedHashMap<>();
        racePositions.forEach((d, p) -> {
            int driverPointsAwarded = mScoringSystem.getPilotPointsAwarded(p);
            pointsMap.put(d, driverPointsAwarded);
        });

        return pointsMap;
    }
}
