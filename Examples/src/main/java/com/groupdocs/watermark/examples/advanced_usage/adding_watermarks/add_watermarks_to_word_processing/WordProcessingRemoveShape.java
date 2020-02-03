package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;

public class WordProcessingRemoveShape {
    /**
     * This example shows how to remove a particular shape from a Word document.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);

        // Remove shape by index
        content.getSections().get_Item(0).getShapes().removeAt(0);

        // Remove shape by reference
        content.getSections().get_Item(0).getShapes().remove(content.getSections().get_Item(0).getShapes().get_Item(0));

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
