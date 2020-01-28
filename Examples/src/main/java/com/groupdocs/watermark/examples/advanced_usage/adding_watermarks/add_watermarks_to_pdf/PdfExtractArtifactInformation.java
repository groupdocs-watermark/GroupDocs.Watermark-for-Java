package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfArtifact;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfPage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfExtractArtifactInformation {
	/**
	 * This example shows how to extract the information about the artifacts in a PDF document.
	 */
	public static void run() {
		PdfLoadOptions loadOptions = new PdfLoadOptions();
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

		PdfContent pdfContent = watermarker.getContent(PdfContent.class);
	    for (PdfPage page : pdfContent.getPages())
	    {
	        for (PdfArtifact artifact : page.getArtifacts())
	        {
	            System.out.println(artifact.getArtifactType());
	            System.out.println(artifact.getArtifactSubtype());
	            if (artifact.getImage() != null)
	            {
	                System.out.println(artifact.getImage().getWidth());
	                System.out.println(artifact.getImage().getHeight());
	                System.out.println(artifact.getImage().getBytes().length);
	            }

	            System.out.println(artifact.getText());
	            System.out.println(artifact.getOpacity());
	            System.out.println(artifact.getX());
	            System.out.println(artifact.getY());
	            System.out.println(artifact.getWidth());
	            System.out.println(artifact.getHeight());
	            System.out.println(artifact.getRotateAngle());
	        }
	    }
	    
	    watermarker.close();
	}
}
