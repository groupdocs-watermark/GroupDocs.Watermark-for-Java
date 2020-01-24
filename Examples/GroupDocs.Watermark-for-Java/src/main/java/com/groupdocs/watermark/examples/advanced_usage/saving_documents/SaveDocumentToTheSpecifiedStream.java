package com.groupdocs.watermark.examples.advanced_usage.saving_documents;

import java.io.ByteArrayOutputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SaveDocumentToTheSpecifiedStream {
	/**
	 * This example shows how to save the document to the specified stream.
	 */
	public static void run() throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	    // Constants.InTestDoc is an absolute or relative path to your document. Ex: "C:\\Docs\\test.doc"
	    Watermarker watermarker = new Watermarker(Constants.InTestDoc);

        // watermarking goes here
        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));
        watermarker.add(watermark);

        // Saves the document to the specified stream
        watermarker.save(outputStream);

        watermarker.close();
        outputStream.close();
	}
}
