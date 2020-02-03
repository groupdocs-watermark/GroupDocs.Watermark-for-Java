package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetShape;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetGetShapesInformation {
    /**
     * This example shows how to get information about all the shapes in an Excel document.
     */
    public static void run() {
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: @"C:\Docs\spreadsheet.xlsx"
        Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

        SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
        for (SpreadsheetWorksheet worksheet : content.getWorksheets())
        {
            for (SpreadsheetShape shape : worksheet.getShapes())
            {
                System.out.println(shape.getAutoShapeType());
                System.out.println(shape.getMsoDrawingType());
                System.out.println(shape.getText());
                if (shape.getImage() != null)
                {
                    System.out.println(shape.getImage().getWidth());
                    System.out.println(shape.getImage().getHeight());
                    System.out.println(shape.getImage().getBytes().length);
                }

                System.out.println(shape.getId());
                System.out.println(shape.getAlternativeText());
                System.out.println(shape.getX());
                System.out.println(shape.getY());
                System.out.println(shape.getWidth());
                System.out.println(shape.getHeight());
                System.out.println(shape.getRotateAngle());
                System.out.println(shape.isWordArt());
                System.out.println(shape.getName());
            }
        }

        watermarker.close();
    }
}
