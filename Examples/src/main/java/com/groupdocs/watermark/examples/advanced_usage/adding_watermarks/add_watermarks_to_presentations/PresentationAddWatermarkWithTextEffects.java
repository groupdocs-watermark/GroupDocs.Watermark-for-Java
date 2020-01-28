package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.OfficeDashStyle;
import com.groupdocs.watermark.contents.OfficeLineStyle;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.options.PresentationTextEffects;
import com.groupdocs.watermark.options.PresentationWatermarkSlideOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkWithTextEffects {
    /**
     * This example shows how to apply text effects when adding shape watermark to a PowerPoint slide.
     */
    public static void run() {
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        // Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
        Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));

        PresentationTextEffects effects = new PresentationTextEffects();
        effects.getLineFormat().setEnabled(true);
        effects.getLineFormat().setColor(Color.getRed());
        effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);
        effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);
        effects.getLineFormat().setWeight(1);

        PresentationWatermarkSlideOptions options = new PresentationWatermarkSlideOptions();
        options.setEffects(effects);

        watermarker.add(watermark, options);
        watermarker.save(Constants.OutPresentationPptx);

        watermarker.close();
    }
}
