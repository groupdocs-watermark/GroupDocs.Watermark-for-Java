package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.PagesSetup;
import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkToSpecificSlides {
    /**
     * This example shows how to add watermarks to particular slides of a PowerPoint presentation.
     */
    public static void run() {
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        // Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
        Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

        // Add text watermark to the even slides
        TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
        PagesSetup textPagesSetup = new PagesSetup();
        textPagesSetup.setEvenPages(true);
        textWatermark.setPagesSetup(textPagesSetup);
        watermarker.add(textWatermark);

        // Add image watermark to the last slide
        ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);
        PagesSetup imagePagesSetup = new PagesSetup();
        imagePagesSetup.setLastPage(true);
        imageWatermark.setPagesSetup(imagePagesSetup);
        watermarker.add(imageWatermark);

        watermarker.save(Constants.OutPresentationPptx);

        watermarker.close();
        imageWatermark.close();
    }
}
