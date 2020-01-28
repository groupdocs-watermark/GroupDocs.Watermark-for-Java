package com.groupdocs.watermark.examples.advanced_usage.searching_and_modifying_watermarks;

import java.util.regex.Pattern;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.search.HyperlinkPossibleWatermark;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class RemoveHyperlinksWithParticularUrl {
	/**
	 * This example shows how to search and remove hyperlinks in a document of any supported format.
	 */
	public static void run() {
		// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
		Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

	    PossibleWatermarkCollection watermarks = watermarker.search(new TextSearchCriteria(Pattern.compile("someurl\\.com")));
	    for (int i = watermarks.getCount() - 1; i >= 0; i--)
	    {
	        // Ensure that only hyperlinks will be removed.
	        if (HyperlinkPossibleWatermark.class.isInstance(watermarks.get_Item(i)))
	        {
	            // Output the full url of the hyperlink
	            System.out.println(watermarks.get_Item(i).getText());

	            // Remove hyperlink from the document
	            watermarks.removeAt(i);
	        }
	    }

	    watermarker.save(Constants.OutDocumentPdf);

	    watermarker.close();
	}
}
