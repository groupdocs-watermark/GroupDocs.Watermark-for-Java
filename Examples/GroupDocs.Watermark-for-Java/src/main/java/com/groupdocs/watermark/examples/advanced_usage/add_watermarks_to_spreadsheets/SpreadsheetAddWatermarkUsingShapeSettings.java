package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.options.SpreadsheetWatermarkShapeOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkUsingShapeSettings {
	/**
	 * This example shows how to set some additional options when adding shape watermark to Excel worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));
	    SpreadsheetWatermarkShapeOptions options = new SpreadsheetWatermarkShapeOptions();

	    // Set the shape name
	    options.setName("Shape 1");

	    // Set the descriptive (alternative) text that will be associated with the shape
	    options.setAlternativeText("Test watermark");

	    // Editing of the shape in Excel is forbidden
	    options.setLocked(true);

	    watermarker.add(watermark, options);
	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
