package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfXObject;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfReplaceTextForParticularXObject {
    /**
     * This example shows how to edit and replace the text of the particular XObject.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);
        for (PdfXObject xObject : pdfContent.getPages().get_Item(0).getXObjects())
        {
            // Replace text
            if (xObject.getText().contains("Test"))
            {
                xObject.setText("Passed");
            }
        }

        // Save document
        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
