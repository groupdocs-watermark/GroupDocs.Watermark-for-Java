package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingLockType;
import com.groupdocs.watermark.options.WordProcessingWatermarkPagesOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddLockedWatermarkToAllPages {
	/**
	 * This example shows how to lock watermark in all pages.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
	    watermark.setForegroundColor(Color.getRed());

	    WordProcessingWatermarkPagesOptions options = new WordProcessingWatermarkPagesOptions();
	    options.setLocked(true);
	    options.setLockType(WordProcessingLockType.AllowOnlyFormFields);

	    // To protect with password
	    //options.setPassword("7654321");

	    watermarker.add(watermark, options);

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
