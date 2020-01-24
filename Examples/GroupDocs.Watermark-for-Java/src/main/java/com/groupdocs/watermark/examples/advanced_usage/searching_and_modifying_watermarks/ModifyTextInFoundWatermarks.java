package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.PossibleWatermark;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class ModifyTextInFoundWatermarks {
	/**
	 * This example shows how to replace text of the found watermarks.
	 */
	public static void run() {
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

	    TextSearchCriteria searchCriteria = new TextSearchCriteria("test", false);
	    PossibleWatermarkCollection watermarks = watermarker.search(searchCriteria);
	    for (PossibleWatermark watermark : watermarks)
	    {
	        try
	        {
	            // Edit text
	            watermark.setText("passed");
	        }
	        catch (Exception e)
	        {
	            // Found entity may not support text editing
	            // Passed argument can have inappropriate value
	            // Process such cases here
	        }
	    }

	    // Save document
	    watermarker.save(Constants.OutDocumentPdf);
	    
	    watermarker.close();
	}
}
