package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.ImageSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;

public class SearchImageWatermark {
    /**
     * This example shows how to search for image watermarks that resemble with a particular image.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        // Initialize criteria with the image
        ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Constants.WatermarkJpg);

        //Set maximum allowed difference between images
        imageSearchCriteria.setMaxDifference(0.9);

        PossibleWatermarkCollection possibleWatermarks = watermarker.search(imageSearchCriteria);

        System.out.println("Found " + possibleWatermarks.getCount() + " possible watermark(s).");

        watermarker.close();
    }
}
