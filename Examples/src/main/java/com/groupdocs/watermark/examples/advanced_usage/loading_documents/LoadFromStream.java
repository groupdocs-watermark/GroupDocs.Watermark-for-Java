package com.groupdocs.watermark.examples.advanced_usage.loading_documents;

import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class LoadFromStream {
    /**
     * This example demonstrates how to create a watermarker for a document stream.
     */
    public static void run() throws Exception {
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: @"C:\\Docs\\document.docx"
        FileInputStream document = new FileInputStream(Constants.InDocumentDocx);
        Watermarker watermarker = new Watermarker(document);

        // use watermarker methods to manage watermarks
        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));

        watermarker.add(watermark);

        watermarker.save(Constants.OutDocumentDocx);

        watermarker.close();
        document.close();
    }
}
