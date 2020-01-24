package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import java.io.File;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.WatermarkerSettings;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.DiagramSearchableObjects;
import com.groupdocs.watermark.search.PdfSearchableObjects;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.PresentationSearchableObjects;
import com.groupdocs.watermark.search.SearchableObjects;
import com.groupdocs.watermark.search.SpreadsheetSearchableObjects;
import com.groupdocs.watermark.search.WordProcessingSearchableObjects;

public class SearchWatermarkInParticularObjectsAllInstances {
	/**
	 * This example shows how to set searchable objects globally (for all documents that will be created after that).
	 */
	public static void run() {
		WatermarkerSettings settings = new WatermarkerSettings();
		settings.setSearchableObjects(new SearchableObjects());
		settings.getSearchableObjects().setWordProcessingSearchableObjects(WordProcessingSearchableObjects.Hyperlinks | WordProcessingSearchableObjects.Text);
		settings.getSearchableObjects().setSpreadsheetSearchableObjects(SpreadsheetSearchableObjects.HeadersFooters);
		settings.getSearchableObjects().setPresentationSearchableObjects(PresentationSearchableObjects.SlidesBackgrounds | PresentationSearchableObjects.Shapes);
		settings.getSearchableObjects().setDiagramSearchableObjects(DiagramSearchableObjects.None);
		settings.getSearchableObjects().setPdfSearchableObjects(PdfSearchableObjects.All);

		String[] files = { Constants.InDocumentDocx, 
						   Constants.InSpreadsheetXlsx, 
						   Constants.InPresentationPptx,
		                   Constants.InDiagramVsdx, 
		                   Constants.InDocumentPdf };

		for (String file : files)
		{
		    Watermarker watermarker = new Watermarker(file, settings);

	        PossibleWatermarkCollection watermarks = watermarker.search();

	        // The code for working with found watermarks goes here.

	        System.out.println("In " + new File(file).getName() + " found " + watermarks.getCount() + " possible watermark(s).");

	        watermarker.close();
		}

	}
}
