package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.contents.DiagramPage;
import com.groupdocs.watermark.contents.DiagramShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;

public class DiagramGetShapesInformation {
	/**
	 * This example shows how to get information about all the shapes in a Diagram document.
	 */
	public static void run() {
		DiagramLoadOptions loadOptions = new DiagramLoadOptions();
		// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
		Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

	    DiagramContent content = watermarker.getContent(DiagramContent.class);
	    for (DiagramPage page : content.getPages())
	    {
	        for (DiagramShape shape : page.getShapes())
	        {
	            if (shape.getImage() != null)
	            {
	            	System.out.println(shape.getImage().getWidth());
	            	System.out.println(shape.getImage().getHeight());
	            	System.out.println(shape.getImage().getBytes().length);
	            }

	            System.out.println(shape.getName());
	            System.out.println(shape.getX());
	            System.out.println(shape.getY());
	            System.out.println(shape.getWidth());
	            System.out.println(shape.getHeight());
	            System.out.println(shape.getRotateAngle());
	            System.out.println(shape.getText());
	            System.out.println(shape.getId());
	        }
	    }
	    
	    watermarker.close();
	}
}
