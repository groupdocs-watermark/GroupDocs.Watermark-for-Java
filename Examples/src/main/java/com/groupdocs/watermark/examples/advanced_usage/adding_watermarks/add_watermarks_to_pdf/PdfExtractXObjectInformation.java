package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfPage;
import com.groupdocs.watermark.contents.PdfXObject;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfExtractXObjectInformation {
    /**
     * This example shows how to extract information about all the XObjects in a PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);
        for (PdfPage page : pdfContent.getPages())
        {
            for (PdfXObject xObject : page.getXObjects())
            {
                if (xObject.getImage() != null)
                {
                    System.out.println(xObject.getImage().getWidth());
                    System.out.println(xObject.getImage().getHeight());
                    System.out.println(xObject.getImage().getBytes().length);
                }

                System.out.println(xObject.getText());
                System.out.println(xObject.getX());
                System.out.println(xObject.getY());
                System.out.println(xObject.getWidth());
                System.out.println(xObject.getHeight());
                System.out.println(xObject.getRotateAngle());
            }
        }

        watermarker.close();
    }
}
