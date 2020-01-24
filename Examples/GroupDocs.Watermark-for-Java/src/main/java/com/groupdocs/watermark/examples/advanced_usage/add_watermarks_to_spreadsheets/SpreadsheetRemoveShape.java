package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetRemoveShape {
	/**
	 * This example shows how to remove a particular shape from the worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

	    // Remove shape by index
	    content.getWorksheets().get_Item(0).getShapes().removeAt(0);

	    // Remove shape by reference
	    content.getWorksheets().get_Item(0).getShapes().remove(content.getWorksheets().get_Item(0).getShapes().get_Item(0));

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
