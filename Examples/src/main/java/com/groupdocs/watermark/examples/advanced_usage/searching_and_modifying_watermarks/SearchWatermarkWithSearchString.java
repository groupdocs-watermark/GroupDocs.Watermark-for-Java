package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class SearchWatermarkWithSearchString {
    /**
     * This example shows how to search for the watermarks that meet a particular text criterion.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        // Search by exact string
        TextSearchCriteria textSearchCriteria = new TextSearchCriteria("© 2017");

        // Find all possible watermarks containing some specific text
        PossibleWatermarkCollection possibleWatermarks = watermarker.search(textSearchCriteria);

        System.out.println("Found " + possibleWatermarks.getCount() + " possible watermark(s)");

        watermarker.close();
    }
}
