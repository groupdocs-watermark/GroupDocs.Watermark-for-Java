package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.contents.DiagramShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;

public class DiagramRemoveHyperlinks {
    /**
     * This example shows how to remove hyperlink associated with a particular shape.
     */
    public static void run() {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        DiagramContent content = watermarker.getContent(DiagramContent.class);
        DiagramShape shape = content.getPages().get_Item(0).getShapes().get_Item(0);
        for (int i = shape.getHyperlinks().getCount() - 1; i >= 0; i--)
        {
            if (shape.getHyperlinks().get_Item(i).getAddress().contains("http://someurl.com"))
            {
                shape.getHyperlinks().removeAt(i);
            }
        }

        watermarker.save(Constants.OutDiagramVsdx);

        watermarker.close();
    }
}
