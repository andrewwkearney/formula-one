package com.androsaces.formulaone.document;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Kearney
 */
class EventNoteDocumentTest {
    @Test
    void whatHappensHere() {
        String expected = "Example text";
        EventNoteDocument document = new EventNoteDocument();
        document.addHeading(1, expected);

        Map<Integer, Map<Integer, String>> map = document.getDocument();
        assertNotNull(map.get(1));
        Map<Integer, String> subHead = map.get(1);
        String s = subHead.get(0);
        assertEquals(expected, s);
    }

}