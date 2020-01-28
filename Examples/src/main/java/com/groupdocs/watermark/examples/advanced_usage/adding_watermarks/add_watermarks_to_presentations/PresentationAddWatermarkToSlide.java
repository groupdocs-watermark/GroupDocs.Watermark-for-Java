package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.options.PresentationWatermarkSlideOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkToSlide {
	/**
	 * This example shows how to add watermark to a particular slide of a PowerPoint presentation.
	 */
	public static void run() {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

	    // Add text watermark to the first slide
	    TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
	    PresentationWatermarkSlideOptions textWatermarkOptions = new PresentationWatermarkSlideOptions();
	    textWatermarkOptions.setSlideIndex(0);
	    watermarker.add(textWatermark, textWatermarkOptions);

	    // Add image watermark to the second slide
	    ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);

	    PresentationWatermarkSlideOptions imageWatermarkOptions = new PresentationWatermarkSlideOptions();
        imageWatermarkOptions.setSlideIndex(1);
        watermarker.add(imageWatermark, imageWatermarkOptions);

	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	    imageWatermark.close();
	}
}
