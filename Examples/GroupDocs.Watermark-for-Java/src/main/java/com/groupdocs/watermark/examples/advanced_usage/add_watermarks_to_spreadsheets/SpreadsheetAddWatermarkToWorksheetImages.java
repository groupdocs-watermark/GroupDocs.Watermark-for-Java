package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.WatermarkableImage;
import com.groupdocs.watermark.contents.WatermarkableImageCollection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkToWorksheetImages {
	/**
	 * This example shows how to add watermark to the images that belong to a particular worksheet.
	 */
	public static void run() {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
	    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
	    watermark.setVerticalAlignment(VerticalAlignment.Center);
	    watermark.setRotateAngle(45);
	    watermark.setSizingType(SizingType.ScaleToParentDimensions);
	    watermark.setScaleFactor(1);

	    // Get all images from the first worksheet
	    SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    WatermarkableImageCollection images = content.getWorksheets().get_Item(0).findImages();

	    // Add watermark to all found images
	    for (WatermarkableImage image : images)
	    {
	        image.add(watermark);
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
