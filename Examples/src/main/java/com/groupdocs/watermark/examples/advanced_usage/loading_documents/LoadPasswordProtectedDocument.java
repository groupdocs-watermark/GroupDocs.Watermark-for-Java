package com.groupdocs.watermark.examples.advanced_usage.loading_documents;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.LoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class LoadPasswordProtectedDocument {
	/**
	 * This example demonstrates how to load an encrypted document using the password.
	 */
	public static void run() {
		LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("P@$$w0rd");
        // Constants.InProtectedDocumentDocx is an absolute or relative path to your document. Ex: @"C:\\Docs\\protected-document.docx"
        String filePath = Constants.InProtectedDocumentDocx;
        Watermarker watermarker = new Watermarker(filePath, loadOptions);

        // use watermarker methods to manage watermarks in the document
        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));

        watermarker.add(watermark);

        watermarker.save(Constants.OutProtectedDocumentDocx);
        
        watermarker.close();
	}
}
