package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfRemoveXObject {
	/**
	 * This example shows how to remove an XObject from a particular page.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);

	    // Remove XObject by index
	    pdfContent.getPages().get_Item(0).getXObjects().removeAt(0);

	    // Remove XObject by reference
	    pdfContent.getPages().get_Item(0).getXObjects().remove(pdfContent.getPages().get_Item(0).getXObjects().get_Item(0));

	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
