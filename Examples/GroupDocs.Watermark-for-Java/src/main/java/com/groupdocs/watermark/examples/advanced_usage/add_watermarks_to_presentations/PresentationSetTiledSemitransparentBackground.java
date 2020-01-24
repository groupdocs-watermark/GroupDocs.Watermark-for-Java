package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_presentations;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.contents.PresentationSlide;
import com.groupdocs.watermark.contents.PresentationWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;

public class PresentationSetTiledSemitransparentBackground {
	/**
	 * This example shows how to tile the picture across slide's background and make the image semi-transparent.
	 */
	public static void run() throws Exception {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

		PresentationContent content = watermarker.getContent(PresentationContent.class);
	    PresentationSlide slide = content.getSlides().get_Item(0);
	    
	    File imageFile = new File(Constants.BackgroundPng);
		byte[] imageBytes = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageBytes);
		imageInputStream.close();	    
	    
	    slide.getImageFillFormat().setBackgroundImage(new PresentationWatermarkableImage(imageBytes));
	    slide.getImageFillFormat().setTileAsTexture(true);
	    slide.getImageFillFormat().setTransparency(0.5);

	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	}
}
