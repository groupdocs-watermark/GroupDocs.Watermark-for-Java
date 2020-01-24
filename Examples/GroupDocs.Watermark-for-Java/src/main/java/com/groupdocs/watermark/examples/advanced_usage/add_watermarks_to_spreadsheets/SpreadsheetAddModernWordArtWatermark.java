package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.options.SpreadsheetWatermarkModernWordArtOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddModernWordArtWatermark {
	/**
	 * This example shows how to add modern WordArt watermark to Excel document worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
	    SpreadsheetWatermarkModernWordArtOptions options = new SpreadsheetWatermarkModernWordArtOptions();
	    options.setWorksheetIndex(0);

	    watermarker.add(textWatermark, options);
	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
