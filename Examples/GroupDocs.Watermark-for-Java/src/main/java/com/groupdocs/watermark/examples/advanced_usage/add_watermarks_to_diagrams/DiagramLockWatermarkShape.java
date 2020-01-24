package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.options.DiagramShapeWatermarkOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class DiagramLockWatermarkShape {
	/**
	 * This example shows how to protect watermark from editing.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

	    TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

	    DiagramShapeWatermarkOptions options = new DiagramShapeWatermarkOptions();
	    options.setLocked(true);

	    // Editing of the shape in Visio is forbidden
	    watermarker.add(watermark, options);

	    watermarker.save(Constants.OutDiagramVsdx);

		watermarker.close();
	}
}
