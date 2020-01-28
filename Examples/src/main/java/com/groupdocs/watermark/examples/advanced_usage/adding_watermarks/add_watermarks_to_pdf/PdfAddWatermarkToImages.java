package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.WatermarkableImage;
import com.groupdocs.watermark.contents.WatermarkableImageCollection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddWatermarkToImages {
	/**
	 * This example shows how to add watermark to the images inside a particular page of the PDF document.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    // Initialize image or text watermark
	    TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
	    watermark.setVerticalAlignment(VerticalAlignment.Center);
	    watermark.setRotateAngle(45);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);

	    PdfContent pdfContent = watermarker.getContent(PdfContent.class);

	    // Get all images from the first page
	    WatermarkableImageCollection images = pdfContent.getPages().get_Item(0).findImages();

	    // Add watermark to all found images
	    for (WatermarkableImage image : images)
	    {
	        image.add(watermark);
	    }

	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
