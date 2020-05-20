package com.androsaces.formulaone.parser;

import com.androsaces.formulaone.time.LapTime;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author Andrew Kearney
 */
class SessionLapTimeDocumentParserTest {
    @Test
    void renameMe() {
        String inputString = returnDriverString() +
                returnFirstLapTime() +
                returnSecondLapTime() +
                returnThirdLapTime() +
                returnFourthLapTime();
        SessionLapTimeDocumentParser parser = new SessionLapTimeDocumentParser();
        Map<String, LapTime> actual = parser.memoiseLapTime(inputString);

    }

    private String returnDriverString() {
        return "3 Daniel Ricciardo\n";
    }

    private String returnFirstLapTime() {
        return "1 P 12:04:10\n";
    }

    private String returnSecondLapTime() {
        return "2 P 2:17.104\n";
    }

    private String returnThirdLapTime() {
        return "3 P 26:30.564\n";
    }

    private String returnFourthLapTime() {
        return "4 1:45.631";
    }
}