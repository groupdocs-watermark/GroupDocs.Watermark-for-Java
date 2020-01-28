package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetShape;
import com.groupdocs.watermark.contents.SpreadsheetWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetSetBackgroundImageForParticularShapes {
	/**
	 * This example shows how to set the background image for the particular shapes in an Excel Worksheet.
	 */
	public static void run() throws Exception {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		File imageFile = new File(Constants.TestPng);
		byte[] imageBytes = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageBytes);
		imageInputStream.close();

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
	    for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())
	    {
	        if (shape.getText() == "© Aspose 2016")
	        {
	            shape.getImageFillFormat().setBackgroundImage(new SpreadsheetWatermarkableImage(imageBytes));
	            shape.getImageFillFormat().setTransparency(0.5);
	            shape.getImageFillFormat().setTileAsTexture(true);
	        }
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
