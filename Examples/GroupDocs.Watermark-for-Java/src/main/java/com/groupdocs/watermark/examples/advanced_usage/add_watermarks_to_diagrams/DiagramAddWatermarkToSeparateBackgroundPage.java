package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramWatermarkPlacementType;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.options.DiagramShapeWatermarkOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class DiagramAddWatermarkToSeparateBackgroundPage {
	/**
	 * This example shows how to place the watermark on separate newly created background pages.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

	    // Initialize watermark of any supported type
	    TextWatermark textWatermark = new TextWatermark("Test watermark 1", new Font("Calibri", 19));

	    DiagramShapeWatermarkOptions options = new DiagramShapeWatermarkOptions();
	    options.setPlacementType(DiagramWatermarkPlacementType.SeparateBackgrounds);

	    // Create separate background for each page where it is not set. Add watermark to it.
	    watermarker.add(textWatermark, options);

	    watermarker.save(Constants.OutDiagramVsdx);
	    
	    watermarker.close();
	}
}
