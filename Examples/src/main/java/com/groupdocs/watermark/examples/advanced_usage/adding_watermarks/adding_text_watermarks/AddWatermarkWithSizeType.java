package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkWithSizeType {
    /**
     * This example shows how to consider the size of the page/slide/frame on which a watermark will be placed.
     */
    public static void run() {
        // Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
        Watermarker watermarker = new Watermarker(Constants.InImagePng);

        Font font = new Font("Calibri", 12);
        TextWatermark watermark = new TextWatermark("This is a test watermark", font);

        // Set sizing type
        watermark.setSizingType(SizingType.ScaleToParentDimensions);

        // Set watermark scale
        watermark.setScaleFactor(0.5);

        watermarker.add(watermark);
        watermarker.save(Constants.OutImagePng);

        watermarker.close();
    }
}
