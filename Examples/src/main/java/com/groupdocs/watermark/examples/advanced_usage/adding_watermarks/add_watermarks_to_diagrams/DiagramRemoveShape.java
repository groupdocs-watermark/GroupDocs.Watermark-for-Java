package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;

public class DiagramRemoveShape {
	/**
	 * This example shows how to remove a particular shape from a page.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: @"C:\Docs\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

		DiagramContent content = watermarker.getContent(DiagramContent.class);

	    // Remove shape by index
	    content.getPages().get_Item(0).getShapes().removeAt(0);

	    // Remove shape by reference
	    content.getPages().get_Item(0).getShapes().remove(content.getPages().get_Item(0).getShapes().get_Item(0));

	    watermarker.save(Constants.OutDiagramVsdx);

	    watermarker.close();
	}
}
