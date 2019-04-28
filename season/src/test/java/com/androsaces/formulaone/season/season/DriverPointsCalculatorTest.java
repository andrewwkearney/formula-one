package com.androsaces.formulaone.season.season;

import com.androsaces.formulaone.point.TwentyFivePoints;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for {@link DriverPointsCalculator} class.
 *
 * @author Andrew Kearney
 */
class DriverPointsCalculatorTest {
    private static final Logger logger = LoggerFactory.getLogger(DriverPointsCalculatorTest.class);
    private DriverPointsCalculator mCalculator = new DriverPointsCalculator(new TwentyFivePoints());
    private Map<String, String> mDriverDetails = createDriverMap();

    @Test
    void renameMe() {
        Map<String, Integer> racePositions = new LinkedHashMap<>();
        racePositions.put("2013_BOT", 1);
        racePositions.put("2007_HAM", 2);
        racePositions.put("2015_VER", 3);
        racePositions.put("2007_VET", 4);
        racePositions.put("2018_LEC", 5);
        racePositions.put("2014_MAG", 6);
        racePositions.put("2010_HUL", 7);
        racePositions.put("2001_RAI", 8);
        racePositions.put("2017_STR", 9);
        racePositions.put("2014_KVY", 10);

        Map<String, Integer> stringIntegerMap = mCalculator.calculateResults(racePositions);

        logger.info("-----------------------");
        logger.info("|   Driver   | Points |");
        logger.info("-----------------------");

        stringIntegerMap.forEach((d, p) -> {
            String format = String.format("| %10s | %6d |", mDriverDetails.get(d), p);
            logger.info(format);
        });
    }

    private Map<String, String> createDriverMap() {
        Map<String, String> driverMap = new HashMap<>();
        driverMap.put("2001_RAI", "Räikkonen");
        driverMap.put("2006_KUB", "Kubica");
        driverMap.put("2007_HAM", "Hamilton");
        driverMap.put("2007_VET", "Vettel");
        driverMap.put("2009_GRO", "Grosjean");
        driverMap.put("2010_HUL", "Hulkenberg");
        driverMap.put("2011_PER", "Pérez");
        driverMap.put("2011_RIC", "Ricciardo");
        driverMap.put("2013_BOT", "Bottas");
        driverMap.put("2014_KVY", "Kvyat");
        driverMap.put("2014_MAG", "Magnussen");
        driverMap.put("2015_SAI", "Sainz");
        driverMap.put("2015_VER", "Verstappen");
        driverMap.put("2017_GAS", "Gasly");
        driverMap.put("2017_GIO", "Giovinazzi");
        driverMap.put("2017_STR", "Stroll");
        driverMap.put("2018_LEC", "Leclerc");
        driverMap.put("2019_ALB", "Albon");
        driverMap.put("2019_NOR", "Norris");
        driverMap.put("2019_RUS", "Russell");
        return driverMap;
    }
}