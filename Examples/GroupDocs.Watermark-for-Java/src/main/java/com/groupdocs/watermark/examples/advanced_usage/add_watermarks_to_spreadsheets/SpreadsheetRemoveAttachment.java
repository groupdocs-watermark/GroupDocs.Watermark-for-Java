package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import java.io.File;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetAttachment;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetRemoveAttachment {
	/**
	 * This example shows how to remove attachments in Excel document.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetWorksheet worksheet : content.getWorksheets())
	    {
	        for (int i = worksheet.getAttachments().getCount() - 1; i >= 0; i--)
	        {
	            SpreadsheetAttachment attachment = worksheet.getAttachments().get_Item(i);
	            if (attachment.isLink() &&
	                !new File(attachment.getSourceFullName()).exists() || // Linked file that is not available at this moment
	                attachment.getDocumentInfo().isEncrypted()) // Attached file protected with a password
	            {
	                // Remove the file if it meets at least one of the conditions above
	                worksheet.getAttachments().removeAt(i);
	            }
	        }
	    }

	    // Save changes
	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
