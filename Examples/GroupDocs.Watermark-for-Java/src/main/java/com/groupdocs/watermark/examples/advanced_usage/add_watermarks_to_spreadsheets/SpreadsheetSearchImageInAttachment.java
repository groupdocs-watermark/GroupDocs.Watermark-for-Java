package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.WatermarkerSettings;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.ImageSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.SpreadsheetSearchableObjects;

public class SpreadsheetSearchImageInAttachment {
	/**
	 * This example shows how to search for all the images and watermarkable attachments in Excel document.
	 */
	public static void run() {
		// Consider only the attached images
		WatermarkerSettings settings = new WatermarkerSettings();
		settings.getSearchableObjects().setSpreadsheetSearchableObjects(SpreadsheetSearchableObjects.AttachedImages);

		SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
		// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
		Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions, settings);

	    // Specify sample image to compare document images with
	    ImageSearchCriteria criteria = new ImageDctHashSearchCriteria(Constants.AttachmentPng);

	    // Search for similar images
	    PossibleWatermarkCollection possibleWatermarks = watermarker.search(criteria);

	    // Remove or modify found image watermarks
	    // ...

	    System.out.println("Found " + possibleWatermarks.getCount() + " possible watermark(s).");

	    watermarker.close();
	}
}
