package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.MeasureValue;
import com.groupdocs.watermark.watermarks.TileMeasureType;
import com.groupdocs.watermark.watermarks.TileOptions;
import com.groupdocs.watermark.watermarks.TileType;

public class AddImageTiledWatermark {
    /**
     * This example shows how to add a tiled image watermark to a document.
     */
    public static void run() {
        // Constants.InSamplePdf is an absolute or relative path to your document. Ex: "C:\\Docs\\sample.pdf"
        Watermarker watermarker = new Watermarker(Constants.InSamplePdf);

        // Create image watermark
        ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);
        watermark.setOpacity(0.25);
        watermark.setRotateAngle(-30);
        watermark.setBackground(true);

        // Configure tile options
        MeasureValue lineSpacing = new MeasureValue();
        lineSpacing.setMeasureType(TileMeasureType.Percent);
        lineSpacing.setValue(12);

        MeasureValue watermarkSpacing = new MeasureValue();
        watermarkSpacing.setMeasureType(TileMeasureType.Percent);
        watermarkSpacing.setValue(10);

        TileOptions tileOptions = new TileOptions();
        tileOptions.setTileType(TileType.Offset);
        tileOptions.setLineSpacing(lineSpacing);
        tileOptions.setWatermarkSpacing(watermarkSpacing);
        watermark.setTileOptions(tileOptions);

        // Add watermark
        watermarker.add(watermark);

        watermarker.save(Constants.OutSamplePdf);

        watermarker.close();
        watermark.close();
    }
}
