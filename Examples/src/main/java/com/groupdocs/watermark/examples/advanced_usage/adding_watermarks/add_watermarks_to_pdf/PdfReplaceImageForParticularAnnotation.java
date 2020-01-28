package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfAnnotation;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfReplaceImageForParticularAnnotation {
    /**
     * This example shows how to replace the image of a particular annotation.
     */
    public static void run() throws Exception {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);

        File imageFile = new File(Constants.TestPng);
        byte[] imageBytes = new byte[(int) imageFile.length()];
        InputStream imageStream = new FileInputStream(imageFile);
        imageStream.read(imageBytes);
        imageStream.close();

        // Replace image
        for (PdfAnnotation annotation : pdfContent.getPages().get_Item(0).getAnnotations())
        {
            if (annotation.getImage() != null)
            {
                annotation.setImage(new PdfWatermarkableImage(imageBytes));
            }
        }

        // Save document
        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
