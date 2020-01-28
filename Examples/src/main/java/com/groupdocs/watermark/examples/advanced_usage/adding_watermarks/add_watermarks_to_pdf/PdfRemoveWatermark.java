package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.ImageSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class PdfRemoveWatermark {
	/**
	 * This example shows how to remove watermarks from a particular page.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    // Initialize search criteria
	    ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Constants.LogoPng);
	    TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Company Name");

	    PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    PossibleWatermarkCollection possibleWatermarks = pdfContent.getPages().get_Item(0).search(imageSearchCriteria.or(textSearchCriteria));

	    // Remove all found watermarks
	    for (int i = possibleWatermarks.getCount() - 1; i >= 0; i--)
	    {
	        possibleWatermarks.removeAt(i);
	    }

	    watermarker.save(Constants.OutDocumentPdf);
	    
	    watermarker.close();
	}
}
