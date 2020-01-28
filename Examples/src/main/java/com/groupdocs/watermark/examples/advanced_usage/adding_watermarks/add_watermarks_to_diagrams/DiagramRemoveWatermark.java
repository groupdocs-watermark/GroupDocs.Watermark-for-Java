package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.search.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.search.ImageSearchCriteria;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class DiagramRemoveWatermark {
    /**
     * This example shows how to remove watermark from a particular page.
     */
    public static void run() {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        DiagramContent content = watermarker.getContent(DiagramContent.class);

        // Initialize search criteria
        ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Constants.LogoPng);
        TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Company Name");

        // Call FindWatermarks method for the first page
        PossibleWatermarkCollection possibleWatermarks = content.getPages().get_Item(0).search(textSearchCriteria.or(imageSearchCriteria));

        // Remove all found watermarks
        possibleWatermarks.clear();

        watermarker.save(Constants.OutDiagramVsdx);

        watermarker.close();
    }
}
