package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.IDocumentInfo;
import com.groupdocs.watermark.examples.Constants;

public class GetDocumentInfoForTheFileFromLocalDisk {
	/**
	 * This example demonstrates how to get document information from the local file.
	 */
	public static void run() {
		// Constants.InSourceDocx is an absolute or relative path to your document. Ex.: "C:\\Docs\\source.docx"
        Watermarker watermarker = new Watermarker(Constants.InSourceDocx);
        IDocumentInfo info = watermarker.getDocumentInfo();
        System.out.println("File type: " + info.getFileType());
        System.out.println("Number of pages: " + info.getPageCount());
        System.out.println("Document size: " + info.getSize() + " bytes");
        watermarker.close();
	}
}
