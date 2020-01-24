package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfXObject;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;

public class PdfReplaceTextForParticularXObjectWithFormatting {
	/**
	 * This example shows how to replace text with formatting.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    for (PdfXObject xObject : pdfContent.getPages().get_Item(0).getXObjects())
	    {
	        // Replace text
	        if (xObject.getText().contains("Test"))
	        {
	            xObject.getFormattedTextFragments().clear();
	            xObject.getFormattedTextFragments().add("Passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
	        }
	    }

	    // Save document
	    watermarker.save(Constants.OutDocumentPdf);
	    
	    watermarker.close();
	}
}
