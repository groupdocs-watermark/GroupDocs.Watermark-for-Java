package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.ImageSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class WordProcessingRemoveWatermarkFromSection {
	/**
	 * This example shows how to remove watermark from a particular section.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

	    // Initialize search criteria
	    ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Constants.LogoPng);
	    TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Company Name");

	    // Call Search method for the section
	    WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
	    PossibleWatermarkCollection possibleWatermarks = content.getSections().get_Item(0).search(textSearchCriteria.or(imageSearchCriteria));

	    // Remove all found watermarks
	    for (int i = possibleWatermarks.getCount() - 1; i >= 0; i--)
	    {
	        possibleWatermarks.removeAt(i);
	    }

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
