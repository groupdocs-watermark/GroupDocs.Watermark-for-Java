package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import java.util.regex.Pattern;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class SearchWatermarkWithRegularExpression {
    /**
     * This example shows how to use a regular expression to search for watermarks.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        Pattern pattern = Pattern.compile("© \\d{4}$");

        // Search by regular expression
        TextSearchCriteria textSearchCriteria = new TextSearchCriteria(pattern);

        // Find possible watermarks using regular expression
        PossibleWatermarkCollection possibleWatermarks = watermarker.search(textSearchCriteria);

        System.out.println("Found " + possibleWatermarks.getCount() + " possible watermark(s).");

        watermarker.close();
    }
}
