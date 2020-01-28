package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import java.io.File;
import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetAddLinkedAttachment {
	/**
	 * This example shows how to to add linked attachments in Excel document.
	 */
	public static void run() throws Exception {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    SpreadsheetWorksheet worksheet = content.getWorksheets().get_Item(0);

	    File file = new File(Constants.DocumentPreviewPng);
		byte[] previewImageBytes = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(previewImageBytes);
		inputStream.close();	    
	    
	    // Add the attachment
	    worksheet.getAttachments().addLink(Constants.InDocumentDocx, // Source file path
	    								   previewImageBytes, // Preview image content
	                                       50, // X-coordinate of the attachment frame
	                                       100, // Y-coordinate of the attachment frame
	                                       200, // Attachment frame width
	                                       400); // Attachment frame height

	    // Save changes
	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
