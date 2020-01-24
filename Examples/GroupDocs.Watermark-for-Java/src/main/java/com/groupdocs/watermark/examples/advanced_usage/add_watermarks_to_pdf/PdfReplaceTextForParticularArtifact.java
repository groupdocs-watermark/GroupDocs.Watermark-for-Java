package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfArtifact;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfReplaceTextForParticularArtifact {
	/**
	 * This example shows how to replace the text of the particular artifacts.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    for (PdfArtifact artifact : pdfContent.getPages().get_Item(0).getArtifacts())
	    {
	        // Replace text
	        if (artifact.getText().contains("Test"))
	        {
	            artifact.setText("Passed");
	        }
	    }

	    // Save document
	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
