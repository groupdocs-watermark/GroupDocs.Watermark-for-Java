package com.groupdocs.watermark.examples.advanced_usage.loading_documents;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class LoadingDocumentOfSpecificFormat {
    /**
     * This example demonstrates how to create a watermarker for the Spreadsheet document.
     */
    public static void run() {
        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: @"C:\\Docs\\spreadsheet.xlsx"
        String filePath = Constants.InSpreadsheetXlsx;
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        Watermarker watermarker = new Watermarker(filePath, loadOptions);

        // use watermarker methods to manage watermarks in the Spreadsheet document
        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));

        watermarker.add(watermark);

        watermarker.save(Constants.OutSpreadsheetXlsx);

        watermarker.close();
    }
}
