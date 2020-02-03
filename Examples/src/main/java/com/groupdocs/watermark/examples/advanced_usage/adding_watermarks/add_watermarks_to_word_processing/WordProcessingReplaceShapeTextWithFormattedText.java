package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;

public class WordProcessingReplaceShapeTextWithFormattedText {
    /**
     * This example shows how to replace the text of the shapes with formatted text.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);

        // Set shape's text
        for (WordProcessingShape shape : content.getSections().get_Item(0).getShapes())
        {
            if (shape.getText().contains("Some text"))
            {
                shape.getFormattedTextFragments().clear();
                shape.getFormattedTextFragments().add("Another text", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
            }
        }

        // Save document
        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
