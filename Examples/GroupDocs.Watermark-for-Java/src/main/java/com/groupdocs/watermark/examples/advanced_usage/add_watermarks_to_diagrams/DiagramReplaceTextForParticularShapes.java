package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.contents.DiagramShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;

public class DiagramReplaceTextForParticularShapes {
	/**
	 * This example shows how to replace shapes' text.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: @"C:\Docs\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

		DiagramContent content = watermarker.getContent(DiagramContent.class);
	    for (DiagramShape shape : content.getPages().get_Item(0).getShapes())
	    {
	        if (shape.getText() != null && shape.getText().contains("© Aspose 2016"))
	        {
	            shape.setText("© GroupDocs 2017");
	        }
	    }

	    // Save changes
	    watermarker.save(Constants.OutDiagramVsdx);

	    watermarker.close();
	}
}
