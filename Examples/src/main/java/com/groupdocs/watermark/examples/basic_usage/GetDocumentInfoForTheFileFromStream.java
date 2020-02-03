package com.groupdocs.watermark.examples.basic_usage;

import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.IDocumentInfo;
import com.groupdocs.watermark.examples.Constants;

public class GetDocumentInfoForTheFileFromStream {
    /**
     * This example demonstrates how to get document information from the file stream.
     */
    public static void run() throws Exception {
        // Constants.InSourceDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\source.docx"
        FileInputStream stream = new FileInputStream(Constants.InSourceDocx);
        Watermarker watermarker = new Watermarker(stream);
        IDocumentInfo info = watermarker.getDocumentInfo();
        System.out.println("File type: " + info.getFileType());
        System.out.println("Number of pages: " + info.getPageCount());
        System.out.println("Document size: " + info.getSize() + " bytes");
        watermarker.close();
        stream.close();
    }
}
