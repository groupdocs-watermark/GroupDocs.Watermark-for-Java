package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.PagesSetup;
import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkToSpecificPages {
    /**
     * This example shows how to add a watermark to particular pages of a Word document.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        // Add text watermark to the even pages
        TextWatermark textWatermark = new TextWatermark("DRAFT", new Font("Arial", 42));
        PagesSetup pagesSetup = new PagesSetup();
        pagesSetup.setEvenPages(true);
        textWatermark.setPagesSetup(pagesSetup);
        watermarker.add(textWatermark);

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
    }
}
