package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_presentations;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.contents.PresentationWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;

public class PresentationSetBackgroundImageForChart {
	/**
	 * This example shows how to set the background image for a chart inside PowerPoint document.
	 */
	public static void run() throws Exception {
		PresentationLoadOptions loadOptions = new PresentationLoadOptions();
		// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
		Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

		PresentationContent content = watermarker.getContent(PresentationContent.class);
		
	    File imageFile = new File(Constants.TestPng);
		byte[] imageBytes = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageBytes);
		imageInputStream.close();	    

		
	    content.getSlides().get_Item(0).getCharts().get_Item(0).getImageFillFormat().setBackgroundImage(new PresentationWatermarkableImage(imageBytes));
	    content.getSlides().get_Item(0).getCharts().get_Item(0).getImageFillFormat().setTransparency(0.5);
	    content.getSlides().get_Item(0).getCharts().get_Item(0).getImageFillFormat().setTileAsTexture(true);

	    watermarker.save(Constants.OutPresentationPptx);

	    watermarker.close();
	}
}
