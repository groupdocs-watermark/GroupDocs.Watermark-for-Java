package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.contents.DiagramShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.watermarks.Color;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.FontStyle;

public class DiagramReplaceTextWithFormatting {
    /**
     * This example shows how to replace the text with a formatted text.
     */
    public static void run() {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        DiagramContent content = watermarker.getContent(DiagramContent.class);
        for (DiagramShape shape : content.getPages().get_Item(0).getShapes())
        {
            if (shape.getText() != null && shape.getText().contains("© Aspose 2016"))
            {
                shape.getFormattedTextFragments().clear();
                shape.getFormattedTextFragments().add("© GroupDocs 2017", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
            }
        }

        // Save changes
        watermarker.save(Constants.OutDiagramVsdx);

        watermarker.close();
    }
}
