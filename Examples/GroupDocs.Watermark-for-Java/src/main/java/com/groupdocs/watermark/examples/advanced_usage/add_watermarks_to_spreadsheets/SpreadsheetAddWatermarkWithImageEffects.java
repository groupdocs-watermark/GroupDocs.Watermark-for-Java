package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetImageEffects;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.options.SpreadsheetWatermarkShapeOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class SpreadsheetAddWatermarkWithImageEffects {
	/**
	 * This example shows how to apply image effects to the shape watermark.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);

        SpreadsheetImageEffects effects = new SpreadsheetImageEffects();
        effects.setBrightness(0.7);
        effects.setContrast(0.6);
        effects.setChromaKey(Color.getRed());
        effects.getBorderLineFormat().setEnabled(true);
        effects.getBorderLineFormat().setWeight(1);

        SpreadsheetWatermarkShapeOptions options = new SpreadsheetWatermarkShapeOptions();
        options.setEffects(effects);

        watermarker.add(watermark, options);

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
