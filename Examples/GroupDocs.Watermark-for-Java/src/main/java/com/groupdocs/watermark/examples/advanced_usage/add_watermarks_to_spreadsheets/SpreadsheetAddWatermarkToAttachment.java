package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.common.IDocumentInfo;
import com.groupdocs.watermark.contents.SpreadsheetAttachment;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkToAttachment {
	/**
	 * This example shows how to add watermark to all attachments in Excel document.
	 */
	public static void run() {
		TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetWorksheet worksheet : content.getWorksheets())
	    {
	        for (SpreadsheetAttachment attachment : worksheet.getAttachments())
	        {
	            // Check if the attached file is supported by GroupDocs.Watermark
	            IDocumentInfo info = attachment.getDocumentInfo();
	            if (info.getFileType() != FileType.Unknown && !info.isEncrypted())
	            {
	                // Load the attached document
	                Watermarker attachedWatermarker = attachment.createWatermarker();

                    // Add watermark
                    attachedWatermarker.add(watermark);

                    // Save changes in the attached file
                    attachment.updateContent(attachedWatermarker);

                    attachedWatermarker.close();
	            }
	        }
	    }

	    // Save changes
		watermarker.save(Constants.OutSpreadsheetXlsx);

		watermarker.close();
	}
}
