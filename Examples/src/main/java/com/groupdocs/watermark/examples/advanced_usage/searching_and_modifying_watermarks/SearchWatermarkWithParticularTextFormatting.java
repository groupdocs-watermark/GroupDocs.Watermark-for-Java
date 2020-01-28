package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.ColorRange;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextFormattingSearchCriteria;

public class SearchWatermarkWithParticularTextFormatting {
	/**
	 * This example shows how to search watermark with a particular text formatting.
	 */
	public static void run() {
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

	    TextFormattingSearchCriteria criteria = new TextFormattingSearchCriteria();
	    criteria.setForegroundColorRange(new ColorRange());
	    criteria.getForegroundColorRange().setMinHue(-5);
	    criteria.getForegroundColorRange().setMaxHue(10);
	    criteria.getForegroundColorRange().setMinBrightness(0.01f);
	    criteria.getForegroundColorRange().setMaxBrightness(0.99f);
	    criteria.setBackgroundColorRange(new ColorRange());
	    criteria.getBackgroundColorRange().setEmpty(true);
	    criteria.setFontName("Arial");
	    criteria.setMinFontSize(19);
	    criteria.setMaxFontSize(42);
	    criteria.setFontBold(true);

	    PossibleWatermarkCollection watermarks = watermarker.search(criteria);
	    // The code for working with found watermarks goes here.

	    System.out.println("Found " + watermarks.getCount() + " possible watermark(s).");

	    watermarker.close();
	}
}
