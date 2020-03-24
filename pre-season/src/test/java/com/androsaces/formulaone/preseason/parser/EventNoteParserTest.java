package com.androsaces.formulaone.preseason.parser;

import com.androsaces.formulaone.document.FIADocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.spec.ECField;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * @author Andrew Kearney
 */
class EventNoteParserTest {
    private static final Logger log = LoggerFactory.getLogger(EventNoteParserTest.class);

    private static final String PATH = "src/test/resources/pdf";
    private static final String FILE_NAME = "EventNotes.pdf";
    private final PDFTextStripper mTextStripper = mock(PDFTextStripper.class);

    @Test
    @SuppressWarnings("ConstantConditions")
    @DisplayName("Cannot instantiate class with null PDF text stripper")
    void nullNotPossible() {
        assertThrows(IllegalArgumentException.class, () -> new CircuitMapParser(null));
    }

    @Test
    @DisplayName("Empty file returns null document")
    void allPDFsReturnNull() {
        // So far there hasn't been any useful info in the circuit map to extract
        CircuitMapParser parser = new CircuitMapParser(mTextStripper);
        assertEquals(FIADocument.NULL, parser.parse(parser.load(PATH + '/' + FILE_NAME)));
    }

    @Test
    void renameMe() throws Exception {
        PDDocument document = createDocument(PATH + '/' + FILE_NAME);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        System.out.println("Number of page: " + document.getNumberOfPages());
        EventNoteParser parser = new EventNoteParser();
        parser.parse(text);
        PDPageTree pages = document.getPages();
        Iterator<PDPage> iterator = pages.iterator();
        while (iterator.hasNext()) {

            iterator.next();
        }
        log.info(text);
        System.out.println(text);
        assertNotNull(document);
    }

    private PDDocument createDocument(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            return PDDocument.load(inputStream);
        } catch (IOException e) {
            // Do nothing, it's just a test
        }
        return null;
    }

    @Test
    void handleHeading() throws Exception {
        String line = "1) Matters arising from the Brazilian Grand Prix";
        EventNoteParser parser = new EventNoteParser();
        FIADocument<Map<Integer, Map<Integer, String>>> document = parser.parse(line);
        Map<Integer, Map<Integer, String>> doc = document.getDocument();
        Map<Integer, String> integerStringMap = doc.get(1);
        String s = integerStringMap.get(0);
        assertEquals(line.substring(3), s);
    }
}