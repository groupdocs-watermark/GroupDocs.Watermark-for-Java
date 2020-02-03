package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfArtifactWatermarkOptions;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddWatermarks {
    /**
     * This example shows how to add watermark to a particular page of a PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        // Add text watermark to the first page
        TextWatermark textWatermark = new TextWatermark("This is a test watermark", new Font("Arial", 8));
        PdfArtifactWatermarkOptions textWatermarkOptions = new PdfArtifactWatermarkOptions();
        textWatermarkOptions.setPageIndex(0);

        watermarker.add(textWatermark, textWatermarkOptions);

        // Add image watermark to the second page
        ImageWatermark imageWatermark = new ImageWatermark(Constants.ProtectJpg);

        PdfArtifactWatermarkOptions imageWatermarkOptions = new PdfArtifactWatermarkOptions();
        imageWatermarkOptions.setPageIndex(1);
        watermarker.add(imageWatermark, imageWatermarkOptions);

        imageWatermark.close();

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
