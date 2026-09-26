package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.PagesSetup;
import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfArtifactWatermarkOptions;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PdfAddWatermarksToSpecificPages {
    /**
     * This example shows how to add watermarks to particular pages of a PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        // Add text watermark to the odd pages
        TextWatermark textWatermark = new TextWatermark("This is a test watermark", new Font("Arial", 8));
        PagesSetup textPagesSetup = new PagesSetup();
        textPagesSetup.setOddPages(true);
        textWatermark.setPagesSetup(textPagesSetup);
        textWatermark.setForegroundColor(Color.getRed());
        textWatermark.setHorizontalAlignment(HorizontalAlignment.Center);
        textWatermark.setVerticalAlignment(VerticalAlignment.Center);

        PdfArtifactWatermarkOptions textWatermarkOptions = new PdfArtifactWatermarkOptions();
        watermarker.add(textWatermark, textWatermarkOptions);

        // Add image watermark to the first page
        ImageWatermark imageWatermark = new ImageWatermark(Constants.ProtectJpg);
        PagesSetup imagePagesSetup = new PagesSetup();
        imagePagesSetup.setFirstPage(true);
        imageWatermark.setPagesSetup(imagePagesSetup);

        PdfArtifactWatermarkOptions imageWatermarkOptions = new PdfArtifactWatermarkOptions();
        watermarker.add(imageWatermark, imageWatermarkOptions);

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
        imageWatermark.close();
    }
}
