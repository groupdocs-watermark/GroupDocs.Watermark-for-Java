package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_diagrams;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.DiagramContent;
import com.groupdocs.watermark.contents.DiagramShape;
import com.groupdocs.watermark.contents.DiagramWatermarkableImage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.DiagramLoadOptions;

public class DiagramReplaceShapeImage {
    /**
     * This example shows how to replace the image of particular shapes.
     */
    public static void run() throws Exception {
        DiagramLoadOptions loadOptions = new DiagramLoadOptions();
        // Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);

        DiagramContent content = watermarker.getContent(DiagramContent.class);
        for (DiagramShape shape : content.getPages().get_Item(0).getShapes())
        {
            if (shape.getImage() != null)
            {
                File imageFile = new File(Constants.TestPng);
                byte[] imageBytes = new byte[(int) imageFile.length()];
                InputStream imageInputStream = new FileInputStream(imageFile);
                imageInputStream.read(imageBytes);
                imageInputStream.close();

                shape.setImage(new DiagramWatermarkableImage(imageBytes));
            }
        }

        // Save changes
        watermarker.save(Constants.OutDiagramVsdx);

        watermarker.close();
    }
}
