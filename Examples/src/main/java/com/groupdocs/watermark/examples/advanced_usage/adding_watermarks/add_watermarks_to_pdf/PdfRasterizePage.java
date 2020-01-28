package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfImageConversionFormat;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfArtifactWatermarkOptions;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfRasterizePage {
	/**
	 * This example shows how to rasterize any particular page of the PDF document.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    // Initialize image or text watermark
	    TextWatermark watermark = new TextWatermark("Do not copy", new Font("Arial", 8));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
	    watermark.setVerticalAlignment(VerticalAlignment.Center);
	    watermark.setRotateAngle(45);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);
	    watermark.setOpacity(0.5);

	    // Add watermark of any type first
	    PdfArtifactWatermarkOptions options = new PdfArtifactWatermarkOptions();
	    options.setPageIndex(0);
	    watermarker.add(watermark, options);

	    // Rasterize the first page
	    PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    pdfContent.getPages().get_Item(0).rasterize(100, 100, PdfImageConversionFormat.Png);

	    // Content of the first page is replaced with raster image
	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
