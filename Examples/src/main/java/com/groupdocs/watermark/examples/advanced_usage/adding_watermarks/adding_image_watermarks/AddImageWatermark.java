package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.adding_image_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class AddImageWatermark {
    /**
     * This example shows how to add image watermark from a local file.
     */
    public static void run() {
        // Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
        Watermarker watermarker = new Watermarker(Constants.InPresentationPptx);

        // Use path to the image as constructor parameter
        ImageWatermark watermark = new ImageWatermark(Constants.WatermarkJpg);

        // Add watermark to the document
        watermarker.add(watermark);

        watermarker.save(Constants.OutPresentationPptx);

        watermark.close();
        watermarker.close();
    }
}
