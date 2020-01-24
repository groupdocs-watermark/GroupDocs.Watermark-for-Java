package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetGetInformationOfWorksheetBackgrounds {
	/**
	 * This example shows how to extract information about all the worksheet backgrounds in an Excel document.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetWorksheet worksheet : content.getWorksheets())
	    {
	        if (worksheet.getBackgroundImage() != null)
	        {
	        	System.out.println(worksheet.getBackgroundImage().getWidth());
	        	System.out.println(worksheet.getBackgroundImage().getHeight());
	        	System.out.println(worksheet.getBackgroundImage().getBytes().length);
	        }
	    }

	    watermarker.close();
	}
}
