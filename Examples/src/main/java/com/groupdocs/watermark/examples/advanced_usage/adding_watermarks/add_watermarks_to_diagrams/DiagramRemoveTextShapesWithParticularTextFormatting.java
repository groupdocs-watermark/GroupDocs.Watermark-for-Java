package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.contents.DiagramPage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.search.FormattedTextFragment;
import com.groupdocs.watermark.watermarks.Color;

public class DiagramRemoveTextShapesWithParticularTextFormatting {
	/**
	 * This example shows how to find and remove the shapes with a particular text formatting.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

		DiagramContent content = watermarker.getContent(DiagramContent.class);
	    for (DiagramPage page : content.getPages())
	    {
	        for (int i = page.getShapes().getCount() - 1; i >= 0; i--)
	        {
	            for (FormattedTextFragment fragment : page.getShapes().get_Item(i).getFormattedTextFragments())
	            {
	                if (fragment.getForegroundColor().equals(Color.getRed()) && fragment.getFont().getFamilyName() == "Arial")
	                {
	                    page.getShapes().removeAt(i);
	                    break;
	                }
	            }
	        }
	    }

	    watermarker.save(Constants.OutDiagramVsdx);

	    watermarker.close();
	}
}
