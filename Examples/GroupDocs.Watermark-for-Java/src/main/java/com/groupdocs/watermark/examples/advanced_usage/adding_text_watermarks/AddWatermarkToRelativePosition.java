package com.groupdocs.watermark.examples.advanced_usage.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkToRelativePosition {
	/**
	 * This example shows how to align the watermark vertically and horizontally.
	 */
	public static void run() {
		// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png
		Watermarker watermarker = new Watermarker(Constants.InImagePng);

	    Font font = new Font("Calibri", 12);
	    TextWatermark watermark = new TextWatermark("Test watermark", font);
	    watermark.setHorizontalAlignment(HorizontalAlignment.Right);
	    watermark.setVerticalAlignment(VerticalAlignment.Bottom);

	    // Set absolute margins. Values are measured in document units.
	    watermark.getMargins().setRight(10);
	    watermark.getMargins().setBottom(5);

	    watermarker.add(watermark);
		watermarker.save(Constants.OutImagePng);
		
		watermarker.close();
	}
}
