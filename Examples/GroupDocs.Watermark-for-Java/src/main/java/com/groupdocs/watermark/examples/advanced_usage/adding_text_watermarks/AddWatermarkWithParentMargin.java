package com.groupdocs.watermark.examples.advanced_usage.adding_text_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkWithParentMargin {
	/**
	 * This example shows how to consider parent margins.
	 */
	public static void run() {
		// Constants.InInputVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\input.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InInputVsdx);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 42));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Right);
	    watermark.setVerticalAlignment(VerticalAlignment.Top);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);
	    watermark.setRotateAngle(45);
	    watermark.setForegroundColor(Color.getRed());
	    watermark.setBackgroundColor(Color.getAqua());

	    // Add watermark considering parent margins
	    watermark.setConsiderParentMargins(true);

	    watermarker.add(watermark);
	    watermarker.save(Constants.OutInputVsdx);

	    watermarker.close();
	}
}
