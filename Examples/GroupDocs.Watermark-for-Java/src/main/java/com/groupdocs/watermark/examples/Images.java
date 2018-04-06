package com.groupdocs.watermark.examples;

import com.groupdocs.watermark.Document;
import com.groupdocs.watermark.Font;
import com.groupdocs.watermark.ImageWatermark;
import com.groupdocs.watermark.MultiframeImageDocument;
import com.groupdocs.watermark.TextWatermark;

public class Images {
	// ExStart:SourcePDFFilePath
	private final static String FILE_PATH = "sample.gif";
	// ExEnd:SourcePDFFilePath

	/**
	 * Adds watermark to a multi frame image
	 */
	public static void addWatermarkToMultiframeImageDocument() {
		try {
			// ExStart:AddWatermarkToMultiframeImageDocument
			MultiframeImageDocument doc = Document.load(MultiframeImageDocument.class,
					Common.mapSourceFilePath(FILE_PATH));

			// Initialize text or image watermark
			TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

			ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

			// Add watermark to the first frame
			doc.getFrames().get_Item(0).addWatermark(watermark);
			doc.getFrames().get_Item(0).addWatermark(imageWatermark);

			doc.save(Common.mapOutputFilePath(FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkToMultiframeImageDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
