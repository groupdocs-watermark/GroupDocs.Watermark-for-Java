package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkToBackgroundImages {
	/**
	 * This example shows how to add watermark to the background images that belong to an Excel document.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    // Initialize image or text watermark
	    TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
	    watermark.setVerticalAlignment(VerticalAlignment.Center);
	    watermark.setRotateAngle(45);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);

	    SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetWorksheet worksheet : content.getWorksheets())
	    {
	        if (worksheet.getBackgroundImage() != null)
	        {
	            // Add watermark to the image
	            worksheet.getBackgroundImage().add(watermark);
	        }
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
