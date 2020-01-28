package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingProtectionType;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;

public class WordProcessingProtectDocument {
	/**
	 * This example shows how to protect a Word document with the password.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

		WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);

	    content.protect(WordProcessingProtectionType.ReadOnly, "7654321");

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
