package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetHeaderFooter;
import com.groupdocs.watermark.contents.SpreadsheetHeaderFooterSection;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetGetHeaderFooterInformation {
	/**
	 * This example shows how to extract information about all the headers and footers in an Excel document.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

	    for (SpreadsheetWorksheet worksheet : content.getWorksheets())
	    {
	        for (SpreadsheetHeaderFooter headerFooter : worksheet.getHeadersFooters())
	        {
	        	System.out.println(headerFooter.getHeaderFooterType());
	            for (SpreadsheetHeaderFooterSection section : headerFooter.getSections())
	            {
	            	System.out.println(section.getSectionType());
	                if (section.getImage() != null)
	                {
	                	System.out.println(section.getImage().getWidth());
	                	System.out.println(section.getImage().getHeight());
	                	System.out.println(section.getImage().getBytes().length);
	                }

	                System.out.println(section.getScript());
	            }
	        }
	    }
	    
	    watermarker.close();
	}
}
