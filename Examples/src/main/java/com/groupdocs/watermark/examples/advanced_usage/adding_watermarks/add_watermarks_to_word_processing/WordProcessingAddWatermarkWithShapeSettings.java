package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingWatermarkSectionOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkWithShapeSettings {
    /**
     * This example shows how to set some additional options when adding shape watermark to a Word document.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

        //Some settings for watermark
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setRotateAngle(25.0);
        watermark.setForegroundColor(Color.getRed());
        watermark.setOpacity(1.0);

        WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();

        // Set the shape name
        options.setName("Shape 1");

        // Set the descriptive (alternative) text that will be associated with the shape
        options.setAlternativeText("Test watermark");

        watermarker.add(watermark, options);

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
