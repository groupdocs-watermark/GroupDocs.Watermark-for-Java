package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingWatermarkPagesOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkToParticularPage {
	/**
	 * This example shows how to add watermark to a particular page of a Word document.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

	    TextWatermark textWatermark = new TextWatermark("DRAFT", new Font("Arial", 42));

	    // Add watermark to the last page
	    WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
	    WordProcessingWatermarkPagesOptions options = new WordProcessingWatermarkPagesOptions();
	    options.setPageNumbers(new int[] {content.getPageCount()});

	    watermarker.add(textWatermark, options);
	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
