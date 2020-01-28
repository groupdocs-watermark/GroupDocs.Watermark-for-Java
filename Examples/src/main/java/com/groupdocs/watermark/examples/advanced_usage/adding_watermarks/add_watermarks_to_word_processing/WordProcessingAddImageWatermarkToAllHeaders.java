package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingWatermarkSectionOptions;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class WordProcessingAddImageWatermarkToAllHeaders {
    /**
     * This example shows how to add watermark with linking headers and footers.
     */
    public static void run() {
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        ImageWatermark watermark = new ImageWatermark(Constants.LargePng);

        // Add watermark to all headers of the first section
        WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();
        options.setSectionIndex(0);
        watermarker.add(watermark, options);

        // Link all other headers&footers to corresponding headers&footers of the first section
        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
        for (int i = 1; i < content.getSections().getCount(); i++)
        {
            content.getSections().get_Item(i).getHeadersFooters().linkToPrevious(true);
        }

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
