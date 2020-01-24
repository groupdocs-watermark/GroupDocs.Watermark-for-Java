package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetBackgroundWatermarkOptions;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.SizingType;

public class SpreadsheetAddWatermarkAsBackgroundWithRelativeSizeAndPosition {
	/**
	 * This example shows how to define the size of the background image on which your watermark will be drawn.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    ImageWatermark watermark = new ImageWatermark(Constants.LogoGif);

        watermark.setHorizontalAlignment(HorizontalAlignment.Center);
        watermark.setVerticalAlignment(VerticalAlignment.Center);
        watermark.setRotateAngle(90);
        watermark.setSizingType(SizingType.ScaleToParentDimensions);
        watermark.setScaleFactor(0.5);

        SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
        SpreadsheetBackgroundWatermarkOptions options = new SpreadsheetBackgroundWatermarkOptions();
        options.setBackgroundWidth(content.getWorksheets().get_Item(0).getContentAreaWidthPx()); /* set background width */
        options.setBackgroundHeight(content.getWorksheets().get_Item(0).getContentAreaHeightPx()); /* set background height */
        watermarker.add(watermark, options);

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
