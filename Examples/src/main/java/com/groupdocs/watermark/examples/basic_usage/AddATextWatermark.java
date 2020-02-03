package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddATextWatermark {
    /**
     * This example demonstrates how to add a text watermark to a local document.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        TextWatermark watermark = new TextWatermark("top secret", new Font("Arial", 36));
        watermark.setForegroundColor(Color.getRed());
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);

        watermarker.add(watermark);
        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
