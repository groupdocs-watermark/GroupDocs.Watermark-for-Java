package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermark;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.SearchCriteria;

public class ModifyImageInFoundWatermarks {
	/**
	 * This example shows how to replace the image of the found watermarks.
	 */
	public static void run() throws Exception {
		File imageFile = new File(Constants.ImagePng);
		byte[] imageData = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageData);
		imageInputStream.close();

		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

	    // Search watermark matching a particular image
	    SearchCriteria searchCriteria = new ImageDctHashSearchCriteria(Constants.LogoBmp);
	    PossibleWatermarkCollection watermarks = watermarker.search(searchCriteria);
	    for (PossibleWatermark watermark : watermarks)
	    {
	        try
	        {
	            // Replace image
	            watermark.setImageData(imageData);
	        }
	        catch (Exception e)
	        {
	            // Found entity may not support image replacement
	            // Passed image can have inappropriate format
	            // Process such cases here
	        }
	    }

	    // Save document
	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
