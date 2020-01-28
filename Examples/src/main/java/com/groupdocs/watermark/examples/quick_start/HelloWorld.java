package com.groupdocs.watermark.examples.quick_start;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.options.PdfXObjectWatermarkOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class HelloWorld {
	public static void run() {
        String documentPath = Constants.InDocumentPdf; // NOTE: Put here actual path for your document
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        Watermarker watermarker = new Watermarker(documentPath, loadOptions);
        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 36, FontStyle.Bold | FontStyle.Italic));
        PdfXObjectWatermarkOptions options = new PdfXObjectWatermarkOptions();
        options.setPageIndex(0);

        watermarker.add(watermark, options);
        watermarker.save(Constants.OutDocumentPdf);
        watermarker.close();
 	}
}
