package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;
import com.groupdocs.watermark.watermarks.TextAlignment;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddTextWatermark {
    /**
     * This example shows how to add text watermark to a document.
     */
    public static void run() {
        // Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
        Watermarker watermarker = new Watermarker(Constants.InImagePng);

        // Initialize the font to be used for watermark
        Font font = new Font("Arial", 19, FontStyle.Bold | FontStyle.Italic);

        // Create the watermark object
        TextWatermark watermark = new TextWatermark("Test watermark", font);

        // Set watermark properties
        watermark.setForegroundColor(Color.getRed());
        watermark.setBackgroundColor(Color.getBlue());
        watermark.setTextAlignment(TextAlignment.Right);
        watermark.setOpacity(0.5);

        // Add watermark
        watermarker.add(watermark);

        watermarker.save(Constants.OutImagePng);

        watermarker.close();
    }
}
