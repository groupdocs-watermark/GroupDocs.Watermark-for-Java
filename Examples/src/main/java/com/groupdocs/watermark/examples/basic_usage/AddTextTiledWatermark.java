package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;
import com.groupdocs.watermark.watermarks.MeasureValue;
import com.groupdocs.watermark.watermarks.TextAlignment;
import com.groupdocs.watermark.watermarks.TextWatermark;
import com.groupdocs.watermark.watermarks.TileMeasureType;
import com.groupdocs.watermark.watermarks.TileOptions;
import com.groupdocs.watermark.watermarks.TileType;

public class AddTextTiledWatermark {
    /**
     * This example shows how to add a tiled text watermark to a document.
     */
    public static void run() {
        // Constants.InSamplePdf is an absolute or relative path to your document. Ex: "C:\\Docs\\sample.pdf"
        Watermarker watermarker = new Watermarker(Constants.InSamplePdf);

        // Initialize the font to be used for watermark
        Font font = new Font("Arial", 10, FontStyle.Italic);

        String userEmail = "useremail@mail.com";
        String fileId = "1234-4a04-935f-3c83c3079a47";
        String disclaimer = "Confidential - Do not distribute - Subject to NDA";
        String watermarkText = userEmail + "\n" + fileId + "\n" + disclaimer;

        // Create the watermark object
        TextWatermark watermark = new TextWatermark(watermarkText, font);

        // Configure tile options
        MeasureValue lineSpacing = new MeasureValue();
        lineSpacing.setMeasureType(TileMeasureType.Percent);
        lineSpacing.setValue(12);

        MeasureValue watermarkSpacing = new MeasureValue();
        watermarkSpacing.setMeasureType(TileMeasureType.Percent);
        watermarkSpacing.setValue(10);

        TileOptions tileOptions = new TileOptions();
        tileOptions.setTileType(TileType.Straight);
        tileOptions.setRotateAroundCenter(true);
        tileOptions.setLineSpacing(lineSpacing);
        tileOptions.setWatermarkSpacing(watermarkSpacing);
        watermark.setTileOptions(tileOptions);

        // Set watermark properties
        watermark.setForegroundColor(Color.getGray());
        watermark.setOpacity(0.4);
        watermark.setRotateAngle(-45.0);
        watermark.setTextAlignment(TextAlignment.Center);

        // Add watermark
        watermarker.add(watermark);

        watermarker.save(Constants.OutSamplePdf);

        watermarker.close();
    }
}
