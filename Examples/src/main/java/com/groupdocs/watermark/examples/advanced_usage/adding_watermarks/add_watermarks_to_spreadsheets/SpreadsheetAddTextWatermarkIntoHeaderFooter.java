package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.options.SpreadsheetWatermarkHeaderFooterOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddTextWatermarkIntoHeaderFooter {
	/**
	 * This example shows how to add text watermark in header or footer.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19, FontStyle.Bold));
	    watermark.setForegroundColor(Color.getRed());
	    watermark.setBackgroundColor(Color.getAqua());
	    watermark.setVerticalAlignment(VerticalAlignment.Top);
	    watermark.setHorizontalAlignment(HorizontalAlignment.Center);

	    SpreadsheetWatermarkHeaderFooterOptions options = new SpreadsheetWatermarkHeaderFooterOptions();
	    options.setWorksheetIndex(0);

	    watermarker.add(watermark, options);
	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
