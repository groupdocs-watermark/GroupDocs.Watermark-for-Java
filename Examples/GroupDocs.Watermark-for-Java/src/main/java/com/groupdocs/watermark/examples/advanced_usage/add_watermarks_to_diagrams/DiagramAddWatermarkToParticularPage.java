package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.options.DiagramPageWatermarkOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class DiagramAddWatermarkToParticularPage {
	/**
	 * This example shows how to add watermark to a particular page of the document.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

	    TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Calibri", 19));

	    DiagramPageWatermarkOptions textWatermarkOptions = new DiagramPageWatermarkOptions();
	    textWatermarkOptions.setPageIndex(0);

	    // Add text watermark to the first page
	    watermarker.add(textWatermark, textWatermarkOptions);

	    ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);

        DiagramPageWatermarkOptions imageWatermarkOptions = new DiagramPageWatermarkOptions();
        imageWatermarkOptions.setPageIndex(1);

        // Add image watermark to the second page
        watermarker.add(imageWatermark, imageWatermarkOptions);

	    watermarker.save(Constants.OutDiagramVsdx);
	    
	    watermarker.close();
	    imageWatermark.close();
	}
}
