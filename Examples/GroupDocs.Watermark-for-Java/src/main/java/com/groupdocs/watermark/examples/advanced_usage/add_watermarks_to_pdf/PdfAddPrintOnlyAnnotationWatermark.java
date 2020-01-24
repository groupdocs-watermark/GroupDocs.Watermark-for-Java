package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfAnnotationWatermarkOptions;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddPrintOnlyAnnotationWatermark {
	/**
	 * This example shows how to add print only annotation watermark to the document.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    TextWatermark textWatermark = new TextWatermark("This is a print only test watermark. It won't appear in view mode.", new Font("Arial", 8));
	    Boolean isPrintOnly = true;

	    // Annotation will be printed, but not displayed in pdf viewing application
	    PdfAnnotationWatermarkOptions options = new PdfAnnotationWatermarkOptions();
	    options.setPageIndex(0);
	    options.setPrintOnly(isPrintOnly);
	    watermarker.add(textWatermark, options);

	    watermarker.save(Constants.OutDocumentPdf);
	    
	    watermarker.close();
	}
}
