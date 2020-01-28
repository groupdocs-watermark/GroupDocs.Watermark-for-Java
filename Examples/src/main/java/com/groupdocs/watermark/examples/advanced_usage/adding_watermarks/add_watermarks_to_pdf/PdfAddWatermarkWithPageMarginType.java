package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfPageMarginType;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddWatermarkWithPageMarginType {
	/**
	 * This example shows how to get watermark aligned to bleed box.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 42));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Right);
	    watermark.setVerticalAlignment(VerticalAlignment.Top);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);

	    PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    pdfContent.setPageMarginType(PdfPageMarginType.BleedBox);
	    watermark.setConsiderParentMargins(true);

	    watermarker.add(watermark);
	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
