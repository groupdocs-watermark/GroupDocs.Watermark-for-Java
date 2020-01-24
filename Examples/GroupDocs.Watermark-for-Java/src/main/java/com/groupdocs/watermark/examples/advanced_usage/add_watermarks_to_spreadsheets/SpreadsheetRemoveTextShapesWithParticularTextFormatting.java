package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.search.FormattedTextFragment;
import com.groupdocs.watermark.watermarks.Color;

public class SpreadsheetRemoveTextShapesWithParticularTextFormatting {
	/**
	 * This example shows how to find and remove the shapes with a particular text formatting from an Excel document.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetWorksheet section : content.getWorksheets())
	    {
	        for (int i = section.getShapes().getCount() - 1; i >= 0; i--)
	        {
	            for (FormattedTextFragment fragment : section.getShapes().get_Item(i).getFormattedTextFragments())
	            {
	                if (fragment.getForegroundColor().equals(Color.getRed()) && fragment.getFont().getFamilyName() == "Arial")
	                {
	                    section.getShapes().removeAt(i);
	                    break;
	                }
	            }
	        }
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
