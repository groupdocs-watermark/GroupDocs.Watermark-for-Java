package com.groupdocs.watermark.examples.advanced_usage.adding_image_watermarks;

import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class AddImageWatermarkUsingStream {
	/**
	 * This example shows how to an image watermark from stream.
	 */
	public static void run() throws Exception {
		// Constants.WatermarkJpg is an absolute or relative path to your document. Ex: "C:\\Docs\\watermark.jpg"
		FileInputStream watermarkStream = new FileInputStream(Constants.WatermarkJpg);

	    Watermarker watermarker = new Watermarker(Constants.InImagePng);

        // Use stream containing an image as constructor parameter
        ImageWatermark watermark = new ImageWatermark(watermarkStream);

        // Add watermark to the document
        watermarker.add(watermark);

        watermarker.save(Constants.OutImagePng);
        
        watermark.close();
        watermarker.close();
        watermarkStream.close();
	}
}
