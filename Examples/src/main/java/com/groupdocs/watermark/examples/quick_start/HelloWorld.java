package com.groupdocs.watermark.examples.quick_start;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class HelloWorld {
    public static void run() {
        String documentPath = Constants.InSamplePdf; // NOTE: Put here actual path for your document
        Watermarker watermarker = new Watermarker(documentPath);

        // Big bold font for a strong, visible watermark
        Font font = new Font("Arial", 72, FontStyle.Bold);

        // Create text watermark
        TextWatermark watermark = new TextWatermark("CONFIDENTIAL", font);

        // Appearance
        watermark.setForegroundColor(Color.getRed());
        watermark.setOpacity(0.2);         // 0 = fully transparent, 1 = solid
        watermark.setRotateAngle(55);      // diagonal

        // Positioning
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setSizingType(SizingType.ScaleToParentDimensions);
        watermark.setScaleFactor(1);       // cover most of the page

        watermarker.add(watermark);
        watermarker.save(Constants.OutSamplePdf);
        watermarker.close();
    }
}
