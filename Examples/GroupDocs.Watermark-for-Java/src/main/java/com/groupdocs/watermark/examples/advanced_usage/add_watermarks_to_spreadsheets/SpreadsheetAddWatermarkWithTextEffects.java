package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.OfficeDashStyle;
import com.groupdocs.watermark.contents.OfficeLineStyle;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.options.SpreadsheetTextEffects;
import com.groupdocs.watermark.options.SpreadsheetWatermarkShapeOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkWithTextEffects {
	/**
	 * This example shows how to apply text effects when adding shape watermark in Excel worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));

	    SpreadsheetTextEffects effects = new SpreadsheetTextEffects();
	    effects.getLineFormat().setEnabled(true);
	    effects.getLineFormat().setColor(Color.getRed());
	    effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);
	    effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);
	    effects.getLineFormat().setWeight(1);

	    SpreadsheetWatermarkShapeOptions options = new SpreadsheetWatermarkShapeOptions();
	    options.setEffects(effects);

	    watermarker.add(watermark, options);
	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
