package com.androsaces.formulaone.parser;

import com.androsaces.formulaone.time.LapTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

public class SessionLapTimeDocumentParser {
    private static final Logger log = LoggerFactory.getLogger(SessionLapTimeDocumentParser.class);

    public Map<String, LapTime> memoiseLapTime(String inputString) {
        int position = 0;
        while (position < inputString.length()) {
            char c = inputString.charAt(position);
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    parseNumber();
                case 'P':
                    parsePitIndicator();
                case '\n':
                case '\r':
                case '\t':
                case ' ':
                    ++position;
                    break;
                default:
                    log.warn("unexpected char {} at position {}", c, position);
            }
            position++;
        }
        return null;
    }

    private void parseNumber() {

    }
}
