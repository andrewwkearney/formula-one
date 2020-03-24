package com.androsaces.formulaone.preseason.parser;

import com.androsaces.formulaone.document.EventNoteDocument;
import com.androsaces.formulaone.document.FIADocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrew Kearney
 */
public class EventNoteParser implements DocumentParser {
    private static final Logger log = LoggerFactory.getLogger(EventNoteParser.class);

    private final Map<Integer, Map<Integer, String>> mDocumentPoints = new HashMap<>();
    private final FIADocument<Map<Integer, Map<Integer, String>>> mFIADocument = new EventNoteDocument();
    private State mState = State.INITIAL;
    private int mPosition = 0;
    private int mHeading = 0;
    private int mSubHeading = 0;

    @Override
    public PDDocument load(InputStream inputStream) {
        return null;
    }

    @Override
    public PDDocument load(String fileName) {
        return null;
    }

    @Override
    public FIADocument parse(PDDocument document) {
        return null;
    }

    public FIADocument parse(String document) throws Exception {

        while (mPosition < document.length()) {
            char c = document.charAt(mPosition);
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
                    parseNumber(document);
                    break;
                case ' ':
                case '\n':
                    ++mPosition;
                    break;
                default:
                    ++mPosition;
            }
        }

        return mFIADocument;
    }

    private void parseNumber(String document) {
        if (document.charAt(mPosition + 1) == ')') {
            mState = State.HEADING;
            mHeading = document.charAt(mPosition) - 48;
            int start = mPosition + 3;
            Map<Integer, String> subHeading = new HashMap<>();
            subHeading.put(mSubHeading, document.substring(start));
            mDocumentPoints.put(mHeading, subHeading);
            mFIADocument.setDocument(mDocumentPoints);
            // Some kind of list item
        }
        mPosition = document.length();
    }

    private enum State {
        INITIAL, HEADING
    }
}
