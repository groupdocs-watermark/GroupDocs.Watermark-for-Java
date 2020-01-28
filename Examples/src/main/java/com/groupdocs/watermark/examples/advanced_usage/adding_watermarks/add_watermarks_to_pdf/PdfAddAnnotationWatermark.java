package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfAnnotationWatermarkOptions;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddAnnotationWatermark {
	/**
	 * This example shows how to add watermark annotation to a PDF document.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

	    PdfAnnotationWatermarkOptions options = new PdfAnnotationWatermarkOptions();

	    // Add text watermark
	    TextWatermark textWatermark = new TextWatermark("This is a annotation watermark", new Font("Arial", 8));
	    textWatermark.setHorizontalAlignment(HorizontalAlignment.Left);
	    textWatermark.setVerticalAlignment(VerticalAlignment.Top);
	    watermarker.add(textWatermark, options);

	    // Add image watermark
	    ImageWatermark imageWatermark = new ImageWatermark(Constants.ProtectJpg);

        imageWatermark.setHorizontalAlignment(HorizontalAlignment.Right);
        imageWatermark.setVerticalAlignment(VerticalAlignment.Top);
        watermarker.add(imageWatermark, options);

	    watermarker.save(Constants.OutDocumentPdf);
	    
	    imageWatermark.close();
	    watermarker.close();
	}
}
