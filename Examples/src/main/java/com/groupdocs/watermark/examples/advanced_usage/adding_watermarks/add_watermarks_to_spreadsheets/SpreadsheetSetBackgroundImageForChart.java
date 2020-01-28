package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetSetBackgroundImageForChart {
	/**
	 * This example shows how to set the background image for a chart inside an Excel document.
	 */
	public static void run() throws Exception {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

		File imageFile = new File(Constants.TestPng);
		byte[] imageBytes = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageBytes);
		imageInputStream.close();
		
		content.getWorksheets().get_Item(0).getCharts().get_Item(0).getImageFillFormat().setBackgroundImage(new SpreadsheetWatermarkableImage(imageBytes));
	    content.getWorksheets().get_Item(0).getCharts().get_Item(0).getImageFillFormat().setTransparency(0.5);
	    content.getWorksheets().get_Item(0).getCharts().get_Item(0).getImageFillFormat().setTileAsTexture(true);

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
