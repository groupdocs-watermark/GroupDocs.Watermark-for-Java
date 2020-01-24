package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.options.PresentationWatermarkSlideOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationProtectWatermarkUsingUnreadableCharacters {
	/**
	 * This example shows how to include unreadable characters in watermark text.
	 */
	public static void run() {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));

	    PresentationWatermarkSlideOptions options = new PresentationWatermarkSlideOptions();
	    options.setLocked(true);
	    options.setProtectWithUnreadableCharacters(true);

	    // Add watermark
	    watermarker.add(watermark, options);

	    // Save document
	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	}
}
