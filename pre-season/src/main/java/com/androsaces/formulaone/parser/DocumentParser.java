/*
 * Copyright (c) 2020. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.parser;

import com.androsaces.buckaroo.annotation.NotNull;
import com.androsaces.formulaone.document.FIADocument;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.InputStream;

public interface DocumentParser {

    PDDocument load(@NotNull InputStream inputStream);

    PDDocument load(@NotNull String fileName);

    FIADocument parse(@NotNull PDDocument document);

    DocumentParser NULL = new DocumentParser() {
        @Override public PDDocument load(@NotNull InputStream inputStream) { return null; }
        @Override public PDDocument load(@NotNull String fileName) { return null; }
        @Override public FIADocument parse(@NotNull PDDocument document) { return FIADocument.NULL; }
    };
}
