package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfAddAttachment {
	/**
	 * This example shows how to add attachments to the PDF document.
	 */
	public static void run() throws Exception {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);

		File file = new File(Constants.InSampleDocx);
		byte[] attachmentBytes = new byte[(int) file.length()];
		InputStream inputStream = new FileInputStream(file);
		inputStream.read(attachmentBytes);
		inputStream.close();
		
		// Add the attachment
	    pdfContent.getAttachments().add(attachmentBytes, "sample doc", "sample doc as attachment");

	    // Save changes
	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
