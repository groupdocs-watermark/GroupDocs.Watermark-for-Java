package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkToAbsolutePosition {
	/**
	 * This example shows how to add a text watermark with absolute positioning.
	 */
	public static void run() {
		// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
		Watermarker watermarker = new Watermarker(Constants.InImagePng);

		Font font = new Font("Times New Roman", 8);
		TextWatermark watermark = new TextWatermark("Test watermark", font);

		// Set watermark coordinates
		watermark.setX(10);
		watermark.setY(20);

		// Set watermark size
		watermark.setWidth(100);
		watermark.setHeight(40);

		watermarker.add(watermark);
		watermarker.save(Constants.OutImagePng);

		watermarker.close();
	}
}
