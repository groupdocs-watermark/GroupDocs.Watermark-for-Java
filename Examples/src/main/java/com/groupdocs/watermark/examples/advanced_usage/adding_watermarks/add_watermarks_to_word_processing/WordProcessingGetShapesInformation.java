package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_word_processing;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.WordProcessingContent;
import com.groupdocs.watermark.contents.WordProcessingSection;
import com.groupdocs.watermark.contents.WordProcessingShape;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.WordProcessingLoadOptions;

public class WordProcessingGetShapesInformation {
    /**
     * This example shows how to extract the information about all the shapes.
     */
    public static void run() {
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        // Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
        Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);

        WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);
        for (WordProcessingSection section : content.getSections())
        {
            for (WordProcessingShape shape : section.getShapes())
            {
                if (shape.getHeaderFooter() != null)
                {
                    System.out.println("In header/footer");
                }

                System.out.println(shape.getShapeType());
                System.out.println(shape.getWidth());
                System.out.println(shape.getHeight());
                System.out.println(shape.isWordArt());
                System.out.println(shape.getRotateAngle());
                System.out.println(shape.getAlternativeText());
                System.out.println(shape.getName());
                System.out.println(shape.getX());
                System.out.println(shape.getY());
                System.out.println(shape.getText());
                if (shape.getImage() != null)
                {
                    System.out.println(shape.getImage().getWidth());
                    System.out.println(shape.getImage().getHeight());
                    System.out.println(shape.getImage().getBytes().length);
                }

                System.out.println(shape.getHorizontalAlignment());
                System.out.println(shape.getVerticalAlignment());
                System.out.println(shape.getRelativeHorizontalPosition());
                System.out.println(shape.getRelativeVerticalPosition());
            }
        }

        watermarker.close();
    }
}
