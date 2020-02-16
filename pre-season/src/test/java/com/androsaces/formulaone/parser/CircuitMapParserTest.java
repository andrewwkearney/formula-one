package com.androsaces.formulaone.parser;

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
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CircuitMapParserTest {
    private static final Logger log = LoggerFactory.getLogger(CircuitMapParserTest.class);

    private static final String PATH = "src/test/resources/pdf";
    private static final String FILE_NAME = "CircuitMap.pdf";
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

    void renameMe() throws Exception {
        PDDocument document = createDocument(PATH + '/' + FILE_NAME);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        System.out.println("Number of page: " + document.getNumberOfPages());
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
}