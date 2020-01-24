package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationImageEffects;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.options.PresentationWatermarkSlideOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class PresentationAddWatermarkWithImageEffects {
	/**
	 * This example shows how to apply image effects to the shape watermark.
	 */
	public static void run() {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

	    ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);

	    PresentationImageEffects effects = new PresentationImageEffects();
        effects.setBrightness(0.7);
        effects.setContrast(0.6);
        effects.setChromaKey(Color.getRed());
        effects.getBorderLineFormat().setEnabled(true);
        effects.getBorderLineFormat().setWeight(1);

        PresentationWatermarkSlideOptions options = new PresentationWatermarkSlideOptions();
        options.setEffects(effects);

        watermarker.add(watermark, options);

	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	    watermark.close();
	}
}
