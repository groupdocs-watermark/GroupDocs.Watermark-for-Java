package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.OfficeDashStyle;
import com.groupdocs.watermark.contents.OfficeLineStyle;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingTextEffects;
import com.groupdocs.watermark.options.WordProcessingWatermarkSectionOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class WordProcessingAddWatermarkWithTextEffects {
	/**
	 * This example shows how to apply some text effects to the shape watermarks.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

	    WordProcessingTextEffects effects = new WordProcessingTextEffects();
	    effects.getLineFormat().setEnabled(true);
	    effects.getLineFormat().setColor(Color.getRed());
	    effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);
	    effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);
	    effects.getLineFormat().setWeight(1);

	    WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();
	    options.setEffects(effects);

	    watermarker.add(watermark, options);
	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
