package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_images;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.TiffImageLoadOptions;
import com.groupdocs.watermark.options.TiffImageWatermarkOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkToImage {
	/**
	 * This example shows how to add watermark to some particular frame(s).
	 */
	public static void run() {
		// Constants.InImageTiff is an absolute or relative path to your document. Ex: "C:\\Docs\\image.tiff"
		TiffImageLoadOptions loadOptions = new TiffImageLoadOptions();
		Watermarker watermarker = new Watermarker(Constants.InImageTiff, loadOptions);

	    // Initialize text or image watermark
	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

	    // Add watermark to the first frame
	    TiffImageWatermarkOptions options = new TiffImageWatermarkOptions();
	    options.setFrameIndex(0);

	    watermarker.add(watermark, options);
	    watermarker.save(Constants.OutImageTiff);

	    watermarker.close();
	}
}
