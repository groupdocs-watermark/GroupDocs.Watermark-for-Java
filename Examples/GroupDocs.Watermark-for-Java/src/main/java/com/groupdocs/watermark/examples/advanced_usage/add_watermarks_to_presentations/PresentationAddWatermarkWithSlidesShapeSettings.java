package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.options.PresentationWatermarkSlideOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkWithSlidesShapeSettings {
	/**
	 * This example shows how to set some additional options when adding a shape watermark.
	 */
	public static void run() {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));
	    watermark.setBackground(true);

	    PresentationWatermarkSlideOptions options = new PresentationWatermarkSlideOptions();

	    // Set the shape name
	    options.setName("Shape 1");

	    // Set the descriptive (alternative) text that will be associated with the shape
	    options.setAlternativeText("Test watermark");

	    // Editing of the shape in PowerPoint is forbidden
	    options.setLocked(true);

	    watermarker.add(watermark, options);

	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	}
}
