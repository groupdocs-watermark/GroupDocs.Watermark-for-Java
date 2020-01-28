package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermark;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;

public class ModifyTextWithFormattingInFoundWatermarks {
    /**
     * This example shows how to replace the watermark's text with formatting.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        TextSearchCriteria searchCriteria = new TextSearchCriteria("test", false);
        PossibleWatermarkCollection watermarks = watermarker.search(searchCriteria);
        for (PossibleWatermark watermark : watermarks)
        {
            try
            {
                // Edit text
                watermark.getFormattedTextFragments().clear();
                watermark.getFormattedTextFragments().add("passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
            }
            catch (Exception e)
            {
                // Found entity may not support text editing
                // Passed arguments can have inappropriate value
                // Process such cases here
            }
        }

        // Save document
        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
