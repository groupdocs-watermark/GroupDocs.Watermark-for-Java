package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingSection;
import com.groupdocs.watermark.contents.WordProcessingShape;
import com.groupdocs.watermark.contents.WordProcessingShapeType;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;

public class WordProcessingShapeTypeUsage {
	/**
	 * This example demonstrates the usage of WordProcessingShapeType enum.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

		WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
	    for (WordProcessingSection section : content.getSections())
	    {
	        for (WordProcessingShape shape : section.getShapes())
	        {
	            //Check for Diagonal Corners Rounded shapes
	            if (shape.getShapeType() == WordProcessingShapeType.DiagonalCornersRounded)
	            {
	            	System.out.println("Diagonal Corners Rounded shape found");

	                //Write text on all Diagonal Corners Rounded shapes
	                shape.getFormattedTextFragments().add("I am Diagonal Corner Rounded", new Font("Calibri", 8, FontStyle.Bold), Color.getRed(), Color.getAqua());
	            }
	        }
	    }

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
