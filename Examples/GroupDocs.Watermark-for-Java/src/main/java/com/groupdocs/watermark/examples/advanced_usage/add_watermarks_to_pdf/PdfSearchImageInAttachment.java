package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WatermarkableImageCollection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.search.PdfSearchableObjects;

public class PdfSearchImageInAttachment {
	/**
	 * This example shows how to search for all the images attachments in a PDF document.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    // Consider only the attached images
	    watermarker.getSearchableObjects().setPdfSearchableObjects(PdfSearchableObjects.AttachedImages);

	    // Search for similar images
	    WatermarkableImageCollection possibleWatermarks = watermarker.getImages();

	    System.out.println("Found " + possibleWatermarks.getCount() + " image(s).");

	    watermarker.close();
	}
}
