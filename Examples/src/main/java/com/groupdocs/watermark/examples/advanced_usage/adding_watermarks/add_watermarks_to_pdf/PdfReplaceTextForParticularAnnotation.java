package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfAnnotation;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfReplaceTextForParticularAnnotation {
    /**
     * This example shows how to edit and replace the text of the particular annotations.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);
        for (PdfAnnotation annotation : pdfContent.getPages().get_Item(0).getAnnotations())
        {
            // Replace text
            if (annotation.getText().contains("Test"))
            {
                annotation.setText("Passed");
            }
        }

        // Save document
        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
