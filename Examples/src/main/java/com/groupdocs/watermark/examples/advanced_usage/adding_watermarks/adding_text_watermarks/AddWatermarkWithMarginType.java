package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.MarginType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkWithMarginType {
	/**
	 * This example shows how to set relative margins for a watermark.
	 */
	public static void run() {
		// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
		Watermarker watermarker = new Watermarker(Constants.InImagePng);

	    Font font = new Font("Calibri", 12);
	    TextWatermark watermark = new TextWatermark("Test watermark", font);
	    watermark.setHorizontalAlignment(HorizontalAlignment.Right);
	    watermark.setVerticalAlignment(VerticalAlignment.Bottom);

	    // Set relative margins. Margin value will be interpreted as a portion
	    // of appropriate parent dimension. If this type is chosen, margin value
	    // must be between 0.0 and 1.0.
	    watermark.getMargins().setMarginType(MarginType.RelativeToParentDimensions);
	    watermark.getMargins().setRight(0.1);
	    watermark.getMargins().setBottom(0.2);

	    watermarker.add(watermark);
	    watermarker.save(Constants.OutImagePng);
	    
	    watermarker.close();
	}
}
