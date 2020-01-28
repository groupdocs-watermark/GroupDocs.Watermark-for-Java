package com.groupdocs.watermark.examples.basic_usage;

import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class AddAnImageWatermark {
    /**
     * This example demonstrates how to add an image watermark to a document from a stream.
     */
    public static void run() throws Exception {
        // Constants.InDocumentXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.xlsx"
        FileInputStream stream = new FileInputStream(Constants.InDocumentXlsx);

        Watermarker watermarker = new Watermarker(stream);

        ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);
        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermarker.add(watermark);

        watermarker.save(Constants.OutDocumentXlsx);

        watermark.close();
        watermarker.close();
        stream.close();
    }
}
