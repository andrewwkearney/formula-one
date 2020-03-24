package com.androsaces.formulaone.document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrew Kearney
 */
public class EventNoteDocument implements FIADocument<Map<Integer, Map<Integer, String>>> {
    private static final Logger log = LoggerFactory.getLogger(EventNoteDocument.class);
    private Map<Integer, Map<Integer, String>> mEventNoteMap = new HashMap<>();

    @Override
    public Map<Integer, Map<Integer, String>> getDocument() {
        return mEventNoteMap;
    }

    @Override
    public void setDocument(Map<Integer, Map<Integer, String>> eventNoteMap) {
        mEventNoteMap = eventNoteMap;
    }

    public void addHeading(int heading, String text) {
        mEventNoteMap.computeIfAbsent(heading, integer -> {
            Map<Integer, String> map = new HashMap<>();
            map.put(0, text);
            return map;
        });
        Map<Integer, String> blah = mEventNoteMap.get(heading);
        if (blah == null) {
            mEventNoteMap = new HashMap<>();
            Map<Integer, String> sub = new HashMap<>();
            sub.put(0, text);
        } else {
            log.warn("event note already contains heading number {}", heading);
        }

    }

    public void addSubHeading(int heading, int subHeading, String text) {

    }
}
