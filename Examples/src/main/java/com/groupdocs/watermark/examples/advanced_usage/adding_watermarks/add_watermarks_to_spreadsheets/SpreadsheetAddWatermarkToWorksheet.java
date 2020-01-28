package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.options.SpreadsheetWatermarkShapeOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkToWorksheet {
	/**
	 * This example shows how to add watermark to a particular worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    // Add text watermark to the first worksheet
	    TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
	    SpreadsheetWatermarkShapeOptions textWatermarkOptions = new SpreadsheetWatermarkShapeOptions();
	    textWatermarkOptions.setWorksheetIndex(0);
	    watermarker.add(textWatermark, textWatermarkOptions);

	    // Add image watermark to the second worksheet
	    ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);

        SpreadsheetWatermarkShapeOptions imageWatermarkOptions = new SpreadsheetWatermarkShapeOptions();
        imageWatermarkOptions.setWorksheetIndex(1);
        watermarker.add(imageWatermark, imageWatermarkOptions);

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	    imageWatermark.close();
	}
}
