package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetReplaceTextForParticularShapes {
	/**
	 * This example shows how to replace text for particular shapes in an Excel Worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())
	    {
	        if (shape.getText() == "© Aspose 2016")
	        {
	            shape.setText("© GroupDocs 2017");
	        }
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
