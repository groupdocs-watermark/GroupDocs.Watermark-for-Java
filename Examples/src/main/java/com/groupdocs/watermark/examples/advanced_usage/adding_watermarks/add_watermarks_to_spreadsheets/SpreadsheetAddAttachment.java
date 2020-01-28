package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetAddAttachment {
	/**
	 * This example show how to add attachments in Excel document.
	 */
	public static void run() throws Exception {
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		File file = new File(Constants.InDocumentDocx);
		byte[] attachmentBytes = new byte[(int) file.length()];
		InputStream inputStream = new FileInputStream(file);
		inputStream.read(attachmentBytes);
		inputStream.close();

		file = new File(Constants.DocumentPreviewPng);
		byte[] previewImageBytes = new byte[(int) file.length()];
		inputStream = new FileInputStream(file);
		inputStream.read(previewImageBytes);
		inputStream.close();
		
		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    SpreadsheetWorksheet worksheet = content.getWorksheets().get_Item(0);

	    // Add the attachment
	    worksheet.getAttachments().addAttachment(attachmentBytes, // File content
	                                        	"sample document.docx", // Source file full name (the extension is used
	                                        	// to determine appropriate application to open
	                                        	// the file) 
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
