package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import java.io.File;
import java.io.FileInputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetShape;
import com.groupdocs.watermark.contents.SpreadsheetWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetReplaceImageOfParticularShapes {
	/**
	 * This examples shows how to replace the image of the particular shapes in an Excel Worksheet.
	 */
	public static void run() throws Exception {
		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

		SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

		File file = new File(Constants.TestPng);
		byte[] imageBytes = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(imageBytes);
		inputStream.close();	    

	    for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())
	    {
	        if (shape.getImage() != null)
	        {
	            shape.setImage(new SpreadsheetWatermarkableImage(imageBytes));
	        }
	    }

	    watermarker.save(Constants.OutSpreadsheetXlsx);

	    watermarker.close();
	}
}
