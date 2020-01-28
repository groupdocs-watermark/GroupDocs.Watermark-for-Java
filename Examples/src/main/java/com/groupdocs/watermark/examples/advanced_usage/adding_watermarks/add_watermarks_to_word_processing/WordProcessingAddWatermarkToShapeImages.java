package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingSection;
import com.groupdocs.watermark.contents.WordProcessingShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkToShapeImages {
    /**
     * This example shows how to add watermark to images in a document.
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

        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
        for (WordProcessingSection section : content.getSections())
        {
            for (WordProcessingShape shape : section.getShapes())
            {
                // Headers&Footers usually contains only service information.
                // So, we skip images in headers/footers, expecting that they are probably watermarks or backgrounds
                if (shape.getHeaderFooter() == null && shape.getImage() != null)
                {
                    shape.getImage().add(watermark);
                }
            }
        }

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
