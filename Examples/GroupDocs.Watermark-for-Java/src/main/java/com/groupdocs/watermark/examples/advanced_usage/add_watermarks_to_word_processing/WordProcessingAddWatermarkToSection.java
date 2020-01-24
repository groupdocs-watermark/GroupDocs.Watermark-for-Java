package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingWatermarkSectionOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkToSection {
	/**
	 * This example shows how to add watermark to the headers of a particular section.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

	    // Add watermark to all headers of the first section
	    WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();
	    options.setSectionIndex(0);
	    watermarker.add(watermark, options);

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
