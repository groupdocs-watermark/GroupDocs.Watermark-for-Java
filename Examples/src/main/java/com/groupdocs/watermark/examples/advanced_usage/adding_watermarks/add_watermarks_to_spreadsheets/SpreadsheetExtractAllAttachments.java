package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.SpreadsheetAttachment;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetWorksheet;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetExtractAllAttachments {
    /**
     * This example shows how to extract attachments in Excel document.
     */
    public static void run() {
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
        Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

        SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);
        for (SpreadsheetWorksheet worksheet : content.getWorksheets())
        {
            for (SpreadsheetAttachment attachment : worksheet.getAttachments())
            {
                System.out.println("Alternative text: " + attachment.getAlternativeText());
                System.out.println("Attachment frame x-coordinate: " + attachment.getX());
                System.out.println("Attachment frame y-coordinate: " + attachment.getY());
                System.out.println("Attachment frame width: " + attachment.getWidth());
                System.out.println("Attachment frame height: " + attachment.getHeight());
                System.out.println("Preview image size: " + attachment.getPreviewImageContent() != null ? attachment.getPreviewImageContent().length : 0);

                if (attachment.isLink())
                {
                    // The document contains only a link to the attached file
                    System.out.println("Full path to the attached file: " + attachment.getSourceFullName());
                }
                else
                {
                    // The attached file is stored in the document
                    System.out.println("File type: " + attachment.getDocumentInfo().getFileType());
                    System.out.println("Name of the source file: " + attachment.getSourceFullName());
                    System.out.println("File size: " + attachment.getContent().length);
                }
            }
        }

        watermarker.close();
    }
}
