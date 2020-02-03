package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfArtifactWatermarkOptions;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddArtifactWatermark {
    /**
     * This example shows how to add an artifact watermark to a document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfArtifactWatermarkOptions options = new PdfArtifactWatermarkOptions();

        // Add text watermark
        TextWatermark textWatermark = new TextWatermark("This is an artifact watermark", new Font("Arial", 8));
        textWatermark.setHorizontalAlignment(HorizontalAlignment.Right);
        watermarker.add(textWatermark, options);

        // Add image watermark
        ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoBmp);

        watermarker.add(imageWatermark, options);

        imageWatermark.close();

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
