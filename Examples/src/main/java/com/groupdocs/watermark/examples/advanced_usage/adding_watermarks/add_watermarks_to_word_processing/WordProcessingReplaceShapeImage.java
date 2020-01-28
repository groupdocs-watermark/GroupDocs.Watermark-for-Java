package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingShape;
import com.groupdocs.watermark.contents.WordProcessingWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;

public class WordProcessingReplaceShapeImage {
	/**
	 * This example shows how to replace the image of the particular shapes in a Word document.
	 */
	public static void run() throws Exception {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

		WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);

		File imageFile = new File(Constants.TestPng);
		byte[] imageBytes = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageBytes);
		imageInputStream.close();
		
	    // Set shape image
	    for (WordProcessingShape shape : content.getSections().get_Item(0).getShapes())
	    {
	        if (shape.getImage() != null)
	        {
	            shape.setImage(new WordProcessingWatermarkableImage(imageBytes));
	        }
	    }

	    // Save document
	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
