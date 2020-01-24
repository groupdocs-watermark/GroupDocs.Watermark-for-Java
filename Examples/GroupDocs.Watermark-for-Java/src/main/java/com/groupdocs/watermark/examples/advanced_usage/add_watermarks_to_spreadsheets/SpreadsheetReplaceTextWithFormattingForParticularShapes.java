package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;

public class SpreadsheetReplaceTextWithFormattingForParticularShapes {
	/**
	 * This example shows how to replace the text of the shapes with formatted text.
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
	            shape.getFormattedTextFragments().clear();
	            shape.getFormattedTextFragments().add("© GroupDocs 2017", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
	        }
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
