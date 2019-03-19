/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.pdf;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class takes the location of a PDF file and then loads the PDF into the {@link PDDocument},
 * parsing each page of the document and retrieving any text within the page.
 *
 * @author Andrew Kearney
 * @see PDDocument
 * @see PDFTextStripper
 * @since 1.0.0
 */
public class PDFReader {
    private static final Logger logger = LoggerFactory.getLogger(PDFReader.class);

    public PDFReader() {
    }

    /**
     * Loads a file into a {@link PDDocument}, parses the file and returns a {@code Map} that
     * contains a list of strings that correspond to each line of the file.
     *
     * @param file a string with the location of the file
     * @return a map that contains an integer key that corresponds to each page and then a list of
     * strings, that are the lines from that page. This may return an empty list of the page does
     * not contain any text.
     */
    public Map<Integer, List<String>> loadPdfFile(String file) throws IOException {
        try (PDDocument document = PDDocument.load(new File(file))) {
            logger.info("loaded a PDF with {} pages", document.getNumberOfPages());
            return loadFile(document);
        } catch (InvalidPasswordException e) {
            logger.info("unable to load PDF as it has a password on the file");
        }
        return Collections.emptyMap();
    }

    /**
     * Loads a file into a {@link PDDocument}, parses the file and returns a {@code Map} that
     * contains a list of strings that correspond to each line of the file.
     *
     * @param file     a string with the location of the file
     * @param password the password for the file.
     * @return a map that contains an integer key that corresponds to each page and then a list of
     * strings, that are the lines from that page. This may return an empty list of the page does
     * not contain any text.
     */
    public Map<Integer, List<String>> loadPdfFile(String file, String password) throws IOException {
        try (PDDocument document = PDDocument.load(new File(file), password)) {
            logger.info("loaded a password protected PDF with {} pages", document.getNumberOfPages());
            return loadFile(document);
        } catch (InvalidPasswordException e) {
            logger.info("unable to load PDF as it has a password on the file");
        }
        return Collections.emptyMap();
    }

    private Map<Integer, List<String>> loadFile(PDDocument document) throws IOException {
        Splitter splitter = new Splitter();
        List<PDDocument> documentPages = splitter.split(document);
        Iterator<PDDocument> iter = documentPages.iterator();

        PDFTextStripper textStripper = new PDFTextStripper();
        Map<Integer, List<String>> linesByPage = new HashMap<>();
        int pageNumber = 1;
        while (iter.hasNext()) {
            PDDocument page = iter.next();
            String pageText = textStripper.getText(page);
            List<String> pageLines = Arrays.asList(pageText.split(System.lineSeparator()));
            linesByPage.put(pageNumber, pageLines);
            pageNumber++;
        }

        return linesByPage;
    }
}
