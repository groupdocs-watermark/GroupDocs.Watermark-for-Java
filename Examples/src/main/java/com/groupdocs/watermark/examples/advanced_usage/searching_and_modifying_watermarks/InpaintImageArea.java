package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.InpaintingMethod;
import com.groupdocs.watermark.common.Rectangle;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.ImageInpaintingPossibleWatermark;

public class InpaintImageArea {
    /**
     * This example demonstrates how to inpaint a specified rectangular area in an image.
     */
    public static void run() {
        // Constants.SampleJpg is an absolute or relative path to your image. Ex: "C:\\Docs\\sample.jpg"
        Watermarker watermarker = new Watermarker(Constants.SampleJpg);

        // Specify the area to be restored and the inpainting method
        ImageInpaintingPossibleWatermark possibleWatermark = new ImageInpaintingPossibleWatermark();
        possibleWatermark.setRectangles(new Rectangle[] { new Rectangle(200, 180, 260, 60) });
        possibleWatermark.setMethod(InpaintingMethod.PatchBased);
        possibleWatermark.setPatchSize(9);

        watermarker.remove(possibleWatermark);

        watermarker.save(Constants.OutSampleJpg);

        watermarker.close();
    }
}
