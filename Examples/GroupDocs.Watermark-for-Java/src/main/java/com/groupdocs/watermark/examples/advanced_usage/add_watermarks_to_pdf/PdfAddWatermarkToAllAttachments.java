package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.common.IDocumentInfo;
import com.groupdocs.watermark.contents.PdfAttachment;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddWatermarkToAllAttachments {
	/**
	 * This example shows how to add watermark to supported files in all attachments in a PDF document.
	 */
	public static void run() {
		TextWatermark watermark = new TextWatermark("This is WaterMark on Attachment", new Font("Arial", 19));
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    for (PdfAttachment attachment : pdfContent.getAttachments())
	    {
	        // Check if the attached file is supported by GroupDocs.Watermark
	        IDocumentInfo info = attachment.getDocumentInfo();
	        if (info.getFileType() != FileType.Unknown && !info.isEncrypted())
	        {
	            // Load the attached document
	            Watermarker attachedWatermarker = attachment.createWatermarker();

                // Add watermark
                attachedWatermarker.add(watermark);

                // Save changes in the attached file
                attachment.updateContent(attachedWatermarker);
                
                attachedWatermarker.close();
	        }
	    }

	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
