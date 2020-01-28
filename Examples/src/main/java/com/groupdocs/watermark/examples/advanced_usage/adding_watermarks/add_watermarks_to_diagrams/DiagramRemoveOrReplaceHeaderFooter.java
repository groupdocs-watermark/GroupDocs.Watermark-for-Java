package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.watermarks.Color;

public class DiagramRemoveOrReplaceHeaderFooter {
    /**
     * This example shows how to remove and replace a particular header and footer in a Diagram document.
     */
    public static void run() {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        DiagramContent content = watermarker.getContent(DiagramContent.class);

        // Remove header
        content.getHeaderFooter().setHeaderCenter(null);

        // Replace footer
        content.getHeaderFooter().setFooterCenter("Footer center");
        content.getHeaderFooter().getFont().setSize(19);
        content.getHeaderFooter().getFont().setFamilyName("Calibri");
        content.getHeaderFooter().setTextColor(Color.getRed());

        watermarker.save(Constants.OutDiagramVsdx);

        watermarker.close();
    }
}
