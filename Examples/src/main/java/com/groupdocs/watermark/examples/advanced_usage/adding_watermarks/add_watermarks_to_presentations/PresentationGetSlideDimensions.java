package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;

public class PresentationGetSlideDimensions {
	/**
	 * This example shows how to get the dimensions of a particular slide.
	 */
	public static void run() {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

	    PresentationContent content = watermarker.getContent(PresentationContent.class);

	    System.out.println(content.getSlideWidth());
	    System.out.println(content.getSlideHeight());

	    watermarker.close();
	}
}
