package com.androsaces.formulaone.pdf;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link PDFReader} class.
 *
 * @author Andrew Kearney
 */
class PDFReaderTest {
    private PDFReader mPDFReader = new PDFReader();

    @Test
    void throwsExceptionIfFileDoesNotExist() {
        IOException ioException = assertThrows(IOException.class, () -> mPDFReader.loadPdfFile(""));
        assertEquals(" (No such file or directory)", ioException.getMessage());
    }

    @Test
    @DisplayName("Parse a single page document")
    void singlePageDocument() throws Exception {
        String onePageDocument = "pdf/one_page_document.pdf";
        URL onePageDocUrl = ClassLoader.getSystemResource(onePageDocument);
        Map<Integer, List<String>> documentLines = mPDFReader.loadPdfFile(onePageDocUrl.getPath());
        List<String> pageOneLines = documentLines.get(1);
        assertNotNull(pageOneLines);
        assertNull(documentLines.get(2));
        assertTrue(pageOneLines.stream().anyMatch(l -> l.contains("Hello World")));
    }

    @Test
    @DisplayName("Parse a double page document")
    void doublePageDocument() throws Exception {
        String twoPageDocument = "pdf/two_page_document.pdf";
        URL twoPageDocUrl = ClassLoader.getSystemResource(twoPageDocument);
        Map<Integer, List<String>> documentLines = mPDFReader.loadPdfFile(twoPageDocUrl.getPath());
        List<String> pageOneLines = documentLines.get(1);
        List<String> pageTwoLines = documentLines.get(2);
        assertNotNull(pageOneLines);
        assertNotNull(pageTwoLines);

        assertTrue(pageOneLines.stream().anyMatch(l -> l.contains("Hello World")));
        assertTrue(pageTwoLines.stream().anyMatch(l -> l.contains("Hello World")));
        assertTrue(pageTwoLines.stream().anyMatch(l -> l.contains("Formula 1")));
    }

    @Test
    @DisplayName("Parse a single page document that only has an image")
    void documentWithImageOnly() throws Exception {
        String onePageDocumentWithImage = "pdf/one_page_document_with_image.pdf";
        URL imageDocUrl = ClassLoader.getSystemResource(onePageDocumentWithImage);
        Map<Integer, List<String>> documentLines = mPDFReader.loadPdfFile(imageDocUrl.getPath());
        List<String> pageOneLines = documentLines.get(1);
        assertNotNull(pageOneLines);
        assertNull(documentLines.get(2));

    }

    @Test
    @DisplayName("Parse a single page document with a password")
    void singlePageDocumentWithPassword() {

    }

    @Test
    @DisplayName("Parse a double page document with a password")
    void doublePageDocumentWithPassword() {

    }

    @Test
    @DisplayName("Parse a single page document with a password that only has an image")
    void documentWithImageOnlyWithPassword() {

    }
}