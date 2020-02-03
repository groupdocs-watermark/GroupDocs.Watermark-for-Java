package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;

public class DiagramGetHeaderFooterInformation {
    /**
     * This example shows how to extract information about all the headers and footers in a Diagram document.
     */
    public static void run() {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        DiagramContent content = watermarker.getContent(DiagramContent.class);

        // Get header&footer font settings
        System.out.println(content.getHeaderFooter().getFont().getFamilyName());
        System.out.println(content.getHeaderFooter().getFont().getSize());
        System.out.println(content.getHeaderFooter().getFont().getBold());
        System.out.println(content.getHeaderFooter().getFont().getItalic());
        System.out.println(content.getHeaderFooter().getFont().getUnderline());
        System.out.println(content.getHeaderFooter().getFont().getStrikeout());

        // Get text contained in headers&footers
        System.out.println(content.getHeaderFooter().getHeaderLeft());
        System.out.println(content.getHeaderFooter().getHeaderCenter());
        System.out.println(content.getHeaderFooter().getHeaderRight());
        System.out.println(content.getHeaderFooter().getFooterLeft());
        System.out.println(content.getHeaderFooter().getFooterCenter());
        System.out.println(content.getHeaderFooter().getFooterRight());

        // Get text color
        System.out.println(content.getHeaderFooter().getTextColor().toArgb());

        // Get header&footer margins
        System.out.println(content.getHeaderFooter().getFooterMargin());
        System.out.println(content.getHeaderFooter().getHeaderMargin());

        watermarker.close();
    }
}
