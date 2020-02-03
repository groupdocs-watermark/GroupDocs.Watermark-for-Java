package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;

public class RemoveWatermark {
    /**
     * This example shows how to find and remove a particular watermark from a document.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        PossibleWatermarkCollection possibleWatermarks = watermarker.search();

        // Remove possible watermark at the specified index from the document.
        possibleWatermarks.removeAt(0);

        // Remove specified possible watermark from the document.
        possibleWatermarks.remove(possibleWatermarks.get_Item(0));

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
