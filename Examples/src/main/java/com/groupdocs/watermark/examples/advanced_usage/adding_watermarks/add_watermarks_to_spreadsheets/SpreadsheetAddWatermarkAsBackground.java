package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetBackgroundWatermarkOptions;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.ImageWatermark;

public class SpreadsheetAddWatermarkAsBackground {
    /**
     * This example show how to add background watermark to all worksheets of Excel document.
     */
    public static void run() {
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
        Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

        ImageWatermark watermark = new ImageWatermark(Constants.LogoGif);

        SpreadsheetBackgroundWatermarkOptions options = new SpreadsheetBackgroundWatermarkOptions();
        watermarker.add(watermark, options);

        watermarker.save(Constants.OutSpreadsheetXlsx);

        watermarker.close();
    }
}
