package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextAlignment;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddATextWatermark {
    /**
     * This example demonstrates how to add a text watermark to a local document.
     */
    public static void run() {
        // Constants.InSampleDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\sample.docx"
        Watermarker watermarker = new Watermarker(Constants.InSampleDocx);

        TextWatermark watermark = new TextWatermark("TOP SECRET\nDo not distribute", new Font("Arial", 36));
        watermark.setForegroundColor(Color.getRed());
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setY(200);
        watermark.setTextAlignment(TextAlignment.Center);
        watermark.setOpacity(0.5);
        watermarker.add(watermark);

        watermarker.save(Constants.OutSampleDocx);

        watermarker.close();
    }
}
