package com.androsaces.formulaone.season.parser;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for {@link LapTimesParser} class.
 *
 * @author Andrew Kearney
 */
class LapTimesParserTest {
    private static final Logger logger = LoggerFactory.getLogger(LapTimesParserTest.class);

    @Test
    void renameMe() {
        try (PDDocument doc = PDDocument.load(new File("/Users/akearney/Downloads/doc_6_-_2019_australian_grand_prix_-_p1_classifcation.pdf"))) {
            doc.getClass();
            Splitter splitter = new Splitter();
            PDFTextStripper stripper = new PDFTextStripper();

            List<PDDocument> split = splitter.split(doc);
            for (PDDocument next : split) {
                String text = stripper.getText(next);
                logger.info(text);
            }


//            stripper.setStartPage(0);
//            stripper.setEndPage(doc.getNumberOfPages());
//            String text = stripper.getText(doc);
//            logger.info(text);
//            stripper.get
//            stripper.setSortByPosition(true);

//            PDPageTree pages = doc.getPages();
//            Iterator<PDPage> iter = pages.iterator();
//            while (iter.hasNext()) {
//                PDPage page = iter.next();
//                String text = stripper.getText(page);
//            }
//            String text = stripper.getText(doc);
//            String[] split = text.split("\\r?\\n");
//            for (String s : split) {
//                logger.info(s);
//            }

        } catch (Exception e) {

        }
    }
}