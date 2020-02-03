package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfAnnotation;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfPage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfExtractAnnotationInformation {
    /**
     * This example shows how to extract information about all the annotations in a PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);
        for (PdfPage page : pdfContent.getPages())
        {
            for (PdfAnnotation annotation : page.getAnnotations())
            {
                System.out.println(annotation.getAnnotationType());
                if (annotation.getImage() != null)
                {
                    System.out.println(annotation.getImage().getWidth());
                    System.out.println(annotation.getImage().getHeight());
                    System.out.println(annotation.getImage().getBytes().length);
                }

                System.out.println(annotation.getText());
                System.out.println(annotation.getX());
                System.out.println(annotation.getY());
                System.out.println(annotation.getWidth());
                System.out.println(annotation.getHeight());
                System.out.println(annotation.getRotateAngle());
            }
        }

        watermarker.close();
    }
}
