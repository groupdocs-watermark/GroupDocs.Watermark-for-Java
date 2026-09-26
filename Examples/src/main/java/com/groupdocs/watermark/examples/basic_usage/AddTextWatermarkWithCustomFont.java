package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

import java.io.File;

public class AddTextWatermarkWithCustomFont {
    /**
     * This example shows how to add a text watermark with a custom font to a document.
     */
    public static void run() {
        // Constants.FontsPath is an absolute or relative path to the folder with your font files. Ex: "C:\\Fonts"
        String fontsFolder = new File(Constants.FontsPath).getAbsolutePath();

        // Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
        Watermarker watermarker = new Watermarker(Constants.InImagePng);

        // Initialize the font to be used for watermark
        Font font = new Font("OT Chekharda Bold Italic", fontsFolder, 36);

        // Create the watermark object
        TextWatermark watermark = new TextWatermark("Test watermark", font);

        // Set watermark properties
        watermark.setForegroundColor(Color.getBlue());
        watermark.setOpacity(0.4);
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);

        // Add watermark
        watermarker.add(watermark);

        watermarker.save(Constants.OutImagePng);

        watermarker.close();
    }
}
