package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetGetContentAreaDimensions {
	/**
	 * This example shows how to get the size of the content area (range of cells which contains data).
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

	    // Get the size of content area
	    System.out.println(content.getWorksheets().get_Item(0).getContentAreaHeight());
	    System.out.println(content.getWorksheets().get_Item(0).getContentAreaWidth());

	    // Get the size of particular cell
	    System.out.println(content.getWorksheets().get_Item(0).getColumnWidth(0));
	    System.out.println(content.getWorksheets().get_Item(0).getRowHeight(0));

	    watermarker.close();
	}
}
