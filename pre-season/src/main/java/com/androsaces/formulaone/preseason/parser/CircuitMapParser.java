/*
 * Copyright (c) 2020. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.preseason.parser;

import com.androsaces.buckaroo.annotation.NotNull;
import com.androsaces.formulaone.document.FIADocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CircuitMapParser implements DocumentParser {
    private static final Logger log = LoggerFactory.getLogger(CircuitMapParser.class);
    private final PDFTextStripper mTextStripper;

    public CircuitMapParser(@NotNull PDFTextStripper textStripper) {
        mTextStripper = textStripper;
    }

    @Override
    public PDDocument load(@NotNull InputStream inputStream) {
        return null;
    }

    @Override
    public PDDocument load(@NotNull String fileName) {
        log.info("loading {}", fileName);
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            byte[] bytes = inputStream.readAllBytes();
            log.info(inputStream.toString());
            return PDDocument.load(bytes);
        } catch (IOException e) {
            // Do nothing.
        }
        return null;
    }

    @Override
    public FIADocument parse(@NotNull PDDocument document) {
        return FIADocument.NULL;
    }
}
