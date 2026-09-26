package com.groupdocs.watermark.examples.advanced_usage.loading_documents;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.LoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextAlignment;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class LoadingDocumentWithKnownType {
    /**
     * This example demonstrates how to watermark a document of a known type for best performance.
     */
    public static void run() {
        LoadOptions loadOptions = new LoadOptions();
        // Specifying the file type eliminates the need for format detection, enabling faster document opening
        loadOptions.setFileType(FileType.fromExtension(".xlsx"));
        // Or set the format family directly when using a stream, for example:
        // loadOptions.setFormatFamily(FormatFamily.Spreadsheet);

        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
        Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

        TextWatermark watermark = new TextWatermark("Test\nwatermark", new Font("Arial", 12));
        watermark.setTextAlignment(TextAlignment.Center);
        watermarker.add(watermark);

        watermarker.save(Constants.OutSpreadsheetXlsx);

        watermarker.close();
    }
}
