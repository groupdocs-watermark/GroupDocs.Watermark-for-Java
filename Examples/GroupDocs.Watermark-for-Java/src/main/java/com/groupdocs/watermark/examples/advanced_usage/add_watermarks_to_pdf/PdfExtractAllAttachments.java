package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_pdf;

import java.io.FileOutputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfAttachment;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfExtractAllAttachments {
	/**
	 * This example shows how to extract attachments in PDF document.
	 */
	public static void run() throws Exception {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    for (PdfAttachment attachment : pdfContent.getAttachments())
	    {
	        System.out.println("Name: " + attachment.getName());
	        System.out.println("Description: " + attachment.getDescription());
	        System.out.println("File type: " + attachment.getDocumentInfo().getFileType());

	        // Save the attached file on disk
	        FileOutputStream outputStream = new FileOutputStream(Constants.OutputPath + "\\" + attachment.getName());
			outputStream.write(attachment.getContent());
			outputStream.close();
	    }

	    watermarker.close();
	}
}
