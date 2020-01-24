package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingImageEffects;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;
import com.groupdocs.watermark.options.WordProcessingWatermarkSectionOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class WordProcessingAddWatermarkWithImageEffects {
	/**
	 * This example shows how to apply image effects to the shape watermarks.
	 */
	public static void run() {
		WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
		// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
		Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

		ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);

        WordProcessingImageEffects effects = new WordProcessingImageEffects();
        effects.setBrightness(0.7);
        effects.setContrast(0.6);
        effects.setChromaKey(Color.getRed());
        effects.getBorderLineFormat().setEnabled(true);
        effects.getBorderLineFormat().setWeight(1);

        WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();
        options.setEffects(effects);

        watermarker.add(watermark, options);

	    watermarker.save(Constants.OutDocumentDocx);

	    watermarker.close();
	}
}
