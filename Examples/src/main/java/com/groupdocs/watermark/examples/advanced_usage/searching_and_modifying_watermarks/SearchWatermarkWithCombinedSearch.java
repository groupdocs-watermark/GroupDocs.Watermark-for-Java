package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.ImageSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.RotateAngleSearchCriteria;
import com.groupdocs.watermark.search.SearchCriteria;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class SearchWatermarkWithCombinedSearch {
    /**
     * This example shows how to search watermark with the combination of different search criteria.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Constants.LogoPng);
        imageSearchCriteria.setMaxDifference(0.9);

        TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Company Name");

        RotateAngleSearchCriteria rotateAngleSearchCriteria = new RotateAngleSearchCriteria(30, 60);

        SearchCriteria combinedSearchCriteria = imageSearchCriteria.or(textSearchCriteria)
                                                                   .and(rotateAngleSearchCriteria);
        PossibleWatermarkCollection possibleWatermarks = watermarker.search(combinedSearchCriteria);

        System.out.println("Found " + possibleWatermarks.getCount() + " possible watermark(s).");

        watermarker.close();
    }
}
