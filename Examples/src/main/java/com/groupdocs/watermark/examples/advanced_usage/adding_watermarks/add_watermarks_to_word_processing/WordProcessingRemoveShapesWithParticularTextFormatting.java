package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingSection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.search.FormattedTextFragment;
import com.groupdocs.watermark.watermarks.Color;

public class WordProcessingRemoveShapesWithParticularTextFormatting {
	/**
	 * This example shows how to find and remove the shapes with a particular text formatting.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

		WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
	    for (WordProcessingSection section : content.getSections())
	    {
	        for (int i = section.getShapes().getCount() - 1; i >= 0; i--)
	        {
	            for (FormattedTextFragment fragment : section.getShapes().get_Item(i).getFormattedTextFragments())
	            {
	                if (fragment.getForegroundColor().equals(Color.getRed()) && fragment.getFont().getFamilyName() == "Arial")
	                {
	                    section.getShapes().removeAt(i);
	                    break;
	                }
	            }
	        }
	    }

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
