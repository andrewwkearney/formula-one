/*
 * Copyright (c) 2020. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.parser;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @author Andrew Kearney
 */
public class LapTimesParser {
    private static final String DOCUMENT_URL = "/Users/akearney/Downloads/" +
        "2019_01_aus_f1_p1_timing_firstpracticesessionlaptimes_v01.pdf";
    private static final String REGEX_PATTERN = "^\\d* P? (\\d{1,2}:\\d{2}.\\d{3})$";
    private static final String DRIVER_PATTERN = "(\\d{1,2}) (\\w*\\. \\w*)";
    private static PDDocument document;

    private final Pattern lapPattern = Pattern.compile(REGEX_PATTERN);
    private final Pattern driverPattern = Pattern.compile(DRIVER_PATTERN);
    private Matcher lapMatcher;
    private Matcher driverMatcher;
    private Map<Integer, List<String>> mLapTimes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        LapTimesParser parser = new LapTimesParser();
        parser.example();
    }

    void example() {
        try (PDDocument doc = PDDocument.load(new File(DOCUMENT_URL))) {
            Splitter splitter = new Splitter();
            List<PDDocument> pages = splitter.split(doc);
            PDFTextStripper stripper = new PDFTextStripper();
            Iterator<PDDocument> iterator = pages.iterator();
            while (iterator.hasNext()) {
                PDDocument next = iterator.next();
                String text = stripper.getText(next);
                String[] split = text.split("\\n");
                for (String line : split) {
                    driverMatcher = driverPattern.matcher(line);
                    if (driverMatcher.matches()) {
                        addDriverToMap(driverMatcher.group(1));
                    }
                    lapMatcher = lapPattern.matcher(line);
                    if (lapMatcher.matches()) {
                        line = line.concat(" lap time");
                        System.out.println(line);
                    } else {
                        line = line.concat(" unknown");
//                System.out.println(line);
                    }
                }
                System.out.println(mLapTimes.entrySet());
            }
        } catch (Exception e) {

        }
    }

    void test() throws Exception {
//        URI uri = DOCUMENT_URL.toURI();
        File file = new File(DOCUMENT_URL);
        PDDocument doc = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String s = stripper.getText(doc);
//        System.out.println(s);
        String[] lines = s.split("\\n");

//        for (String line : lines) {
//            driverMatcher = driverPattern.matcher(line);
//            if (driverMatcher.matches()) {
//                addDriverToMap(driverMatcher.group(1));
//            }
//            lapMatcher = lapPattern.matcher(line);
//            if (lapMatcher.matches()) {
//                line = line.concat(" lap time");
//                System.out.println(line);
//            } else {
//                line = line.concat(" unknown");
//                System.out.println(line);
//            }
//        }
//        System.out.println(mLapTimes.entrySet());
    }

    private void addDriverToMap(String line) {
        System.out.println(line);
        mLapTimes.put(Integer.getInteger(line), Collections.emptyList());
    }
}
