package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class SearchTextWatermarkSkippingUnreadableCharacters {
    /**
     * This example shows how to skip unreadable characters when searching for the watermark.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        String watermarkText = "Company name";
        TextSearchCriteria criterion = new TextSearchCriteria(watermarkText);

        // Enable skipping of unreadable characters
        criterion.setSkipUnreadableCharacters(true);

        PossibleWatermarkCollection result = watermarker.search(criterion);

        // ...

        System.out.println("Found " + result.getCount() + " possible watermark(s).");

        watermarker.close();
    }
}
