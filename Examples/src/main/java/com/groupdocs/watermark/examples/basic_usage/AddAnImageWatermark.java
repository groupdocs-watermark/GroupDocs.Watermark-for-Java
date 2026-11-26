package com.groupdocs.watermark.examples.basic_usage;

import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.SizingType;

public class AddAnImageWatermark {
    /**
     * This example demonstrates how to add an image watermark to a document from a stream.
     */
    public static void run() throws Exception {
        // Constants.InSampleXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\sample.xlsx"
        FileInputStream stream = new FileInputStream(Constants.InSampleXlsx);

        Watermarker watermarker = new Watermarker(stream);

        ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);
        watermark.setOpacity(0.25);
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setSizingType(SizingType.ScaleToParentDimensions);
        watermark.setScaleFactor(1);
        watermarker.add(watermark);

        watermarker.save(Constants.OutSampleXlsx);

        watermark.close();
        watermarker.close();
        stream.close();
    }
}
