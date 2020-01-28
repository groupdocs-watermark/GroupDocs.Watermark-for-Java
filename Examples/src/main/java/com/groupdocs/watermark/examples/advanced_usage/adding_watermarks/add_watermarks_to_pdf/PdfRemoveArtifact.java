package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfRemoveArtifact {
    /**
     * This example shows how to remove an artifact from a particular page of the PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);

        // Remove Artifact by index
        pdfContent.getPages().get_Item(0).getArtifacts().removeAt(0);

        // Remove Artifact by reference
        pdfContent.getPages().get_Item(0).getArtifacts().remove(pdfContent.getPages().get_Item(0).getArtifacts().get_Item(0));

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
