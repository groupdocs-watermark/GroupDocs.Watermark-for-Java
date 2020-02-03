package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.OfficeHeaderFooterType;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;

public class WordProcessingLinkHeaderFooterInSection {
    /**
     * This example shows how to link the header/footer.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);

        // Link footer for even numbered pages to corresponding footer in previous section
        content.getSections().get_Item(1).getHeadersFooters().getByOfficeHeaderFooterType(OfficeHeaderFooterType.FooterEven).setLinkedToPrevious(true);

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
