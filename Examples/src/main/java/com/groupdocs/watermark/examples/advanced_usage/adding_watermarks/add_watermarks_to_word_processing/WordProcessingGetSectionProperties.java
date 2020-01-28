package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;

public class WordProcessingGetSectionProperties {
	/**
	 * This example shows how to get some page properties for a section.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

	    WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);

	    System.out.println(content.getSections().get_Item(0).getPageSetup().getWidth());
	    System.out.println(content.getSections().get_Item(0).getPageSetup().getHeight());
	    System.out.println(content.getSections().get_Item(0).getPageSetup().getTopMargin());
	    System.out.println(content.getSections().get_Item(0).getPageSetup().getRightMargin());
	    System.out.println(content.getSections().get_Item(0).getPageSetup().getBottomMargin());
	    System.out.println(content.getSections().get_Item(0).getPageSetup().getLeftMargin());

	    watermarker.close();
	}
}
