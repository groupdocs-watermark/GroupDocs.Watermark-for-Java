package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.WatermarkableImage;
import com.groupdocs.watermark.contents.WatermarkableImageCollection;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkToSectionImages {
    /**
     * This example shows how to add watermark to the images that belong to a particular section.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setRotateAngle(45);
        watermark.setSizingType(SizingType.ScaleToParentDimensions);
        watermark.setScaleFactor(1);

        // Get all images belonging to the first section
        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
        WatermarkableImageCollection images = content.getSections().get_Item(0).findImages();

        // Add watermark to all found images
        for (WatermarkableImage image : images)
        {
            image.add(watermark);
        }

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
