package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramWatermarkPlacementType;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;
import com.groupdocs.watermark.options.DiagramShapeWatermarkOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class DiagramAddWatermarkToAllPagesOfParticularType {
    /**
     * This example shows how to add watermark to a particular type of the pages.
     */
    public static void run() {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        // Initialize text watermark
        TextWatermark textWatermark = new TextWatermark("Test watermark 1", new Font("Calibri", 19));

        DiagramShapeWatermarkOptions textWatermarkOptions = new DiagramShapeWatermarkOptions();
        textWatermarkOptions.setPlacementType(DiagramWatermarkPlacementType.BackgroundPages);

        // Add text watermark to all background pages
        watermarker.add(textWatermark, textWatermarkOptions);

        // Initialize image watermark
        ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);

        DiagramShapeWatermarkOptions imageWatermarkOptions = new DiagramShapeWatermarkOptions();
        imageWatermarkOptions.setPlacementType(DiagramWatermarkPlacementType.ForegroundPages);

        // Add image watermark to all foreground pages
        watermarker.add(imageWatermark, imageWatermarkOptions);

        watermarker.save(Constants.OutDiagramVsdx);
        imageWatermark.close();
        watermarker.close();
    }
}
