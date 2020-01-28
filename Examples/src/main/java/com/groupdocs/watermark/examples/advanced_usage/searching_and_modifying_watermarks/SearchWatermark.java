package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermark;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;

public class SearchWatermark {
    /**
     * This example shows how to find and get all possible watermarks in a document.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        PossibleWatermarkCollection possibleWatermarks = watermarker.search();
        for (PossibleWatermark possibleWatermark : possibleWatermarks)
        {
            if (possibleWatermark.getImageData() != null)
            {
                System.out.println(possibleWatermark.getImageData().length);
            }

            System.out.println(possibleWatermark.getText());
            System.out.println(possibleWatermark.getX());
            System.out.println(possibleWatermark.getY());
            System.out.println(possibleWatermark.getRotateAngle());
            System.out.println(possibleWatermark.getWidth());
            System.out.println(possibleWatermark.getHeight());
        }

        watermarker.close();
    }
}
