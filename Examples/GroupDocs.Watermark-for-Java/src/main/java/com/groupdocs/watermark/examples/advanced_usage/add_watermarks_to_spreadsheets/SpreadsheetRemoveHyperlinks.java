package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetRemoveHyperlinks {
	/**
	 * This example shows how to remove/replace hyperlink associated with a particular shape or chart inside an Excel document.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

	    // Replace hyperlink
	    content.getWorksheets().get_Item(0).getCharts().get_Item(0).setHyperlink("https://www.aspose.com/");
	    content.getWorksheets().get_Item(0).getShapes().get_Item(0).setHyperlink("https://www.groupdocs.com/");

	    // Remove hyperlink
	    content.getWorksheets().get_Item(1).getCharts().get_Item(0).setHyperlink(null);
	    content.getWorksheets().get_Item(1).getShapes().get_Item(0).setHyperlink(null);

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
