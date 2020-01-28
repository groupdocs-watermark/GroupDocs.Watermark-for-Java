package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.PdfArtifact;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfPage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddWatermarkToImageArtifacts {
    /**
     * This example shows how to add watermark to all image artifacts.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);

        // Initialize image or text watermark
        TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setRotateAngle(45);
        watermark.setSizingType(SizingType.ScaleToParentDimensions);
        watermark.setScaleFactor(1);

        for (PdfPage page : pdfContent.getPages())
        {
            for (PdfArtifact artifact : page.getArtifacts())
            {
                if (artifact.getImage() != null)
                {
                    // Add watermark to the image
                    artifact.getImage().add(watermark);
                }
            }
        }

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
