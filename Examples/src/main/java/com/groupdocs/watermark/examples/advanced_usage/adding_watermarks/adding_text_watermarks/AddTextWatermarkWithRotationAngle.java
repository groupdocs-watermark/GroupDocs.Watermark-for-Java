package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddTextWatermarkWithRotationAngle {
	/**
	 * This example show how to rotate a watermark.
	 */
	public static void run() {
		// Constants.InTestDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\test.docx"
		Watermarker watermarker = new Watermarker(Constants.InTestDocx);

	    Font font = new Font("Calibri", 8);
	    TextWatermark watermark = new TextWatermark("Test watermark", font);
	    watermark.setHorizontalAlignment(HorizontalAlignment.Right);
	    watermark.setVerticalAlignment(VerticalAlignment.Top);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(0.5);

	    // Set rotation angle
	    watermark.setRotateAngle(45);

	    watermarker.add(watermark);
	    watermarker.save(Constants.OutTestDocx);
	    
	    watermarker.close();
	}
}
