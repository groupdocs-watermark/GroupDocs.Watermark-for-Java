package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.contents.PresentationSlide;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkToSlideBackgroundImages {
	/**
	 * This example shows how to add watermark to the background images that belong to a PowerPoint document.
	 */
	public static void run() {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

	    // Initialize image or text watermark
	    TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
	    watermark.setVerticalAlignment(VerticalAlignment.Center);
	    watermark.setRotateAngle(45);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);

	    PresentationContent content = watermarker.getContent(PresentationContent.class);
	    for (PresentationSlide slide : content.getSlides())
	    {
	        if (slide.getImageFillFormat().getBackgroundImage() != null)
	        {
	            // Add watermark to the image
	            slide.getImageFillFormat().getBackgroundImage().add(watermark);
	        }
	    }

	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	}
}
