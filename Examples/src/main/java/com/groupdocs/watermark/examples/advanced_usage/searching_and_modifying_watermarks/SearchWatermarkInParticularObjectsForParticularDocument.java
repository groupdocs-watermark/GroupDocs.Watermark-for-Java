package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PdfSearchableObjects;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;

public class SearchWatermarkInParticularObjectsForParticularDocument {
	/**
	 * This example shows how to set searchable objects for a particular Watermarker instance.
	 */
	public static void run() {
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

	    // Search for hyperlinks only.
	    watermarker.getSearchableObjects().setPdfSearchableObjects(PdfSearchableObjects.Hyperlinks);
	    PossibleWatermarkCollection watermarks = watermarker.search();

	    // The code for working with found watermarks goes here.

	    System.out.println("Found " + watermarks.getCount() + " possible watermark(s).");

	    watermarker.close();
	}
}
