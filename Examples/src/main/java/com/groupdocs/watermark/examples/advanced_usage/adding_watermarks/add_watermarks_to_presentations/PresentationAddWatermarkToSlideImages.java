package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.contents.WatermarkableImage;
import com.groupdocs.watermark.contents.WatermarkableImageCollection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkToSlideImages {
    /**
     * This example shows how to add watermark to the images inside a particular PowerPoint slide.
     */
    public static void run() {
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        // Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
        Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

        TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setRotateAngle(45);
        watermark.setSizingType(SizingType.ScaleToParentDimensions);
        watermark.setScaleFactor(1);

        // Get all images from the first slide
        PresentationContent content = watermarker.getContent(PresentationContent.class);
        WatermarkableImageCollection images = content.getSlides().get_Item(0).findImages();

        // Add watermark to all found images
        for (WatermarkableImage image : images)
        {
            image.add(watermark);
        }

        watermarker.save(Constants.OutPresentationPptx);

        watermarker.close();
    }
}
