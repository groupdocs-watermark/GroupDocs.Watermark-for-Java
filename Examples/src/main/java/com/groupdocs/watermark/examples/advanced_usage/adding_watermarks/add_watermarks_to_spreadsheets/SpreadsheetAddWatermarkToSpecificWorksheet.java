package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.PagesSetup;
import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class SpreadsheetAddWatermarkToSpecificWorksheet {
    /**
     * This example shows how to add watermarks to particular worksheets.
     */
    public static void run() {
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
        Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

        // Add text watermark to the last worksheet
        TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
        PagesSetup textPagesSetup = new PagesSetup();
        textPagesSetup.setLastPage(true);
        textWatermark.setPagesSetup(textPagesSetup);
        watermarker.add(textWatermark);

        // Add image watermark to the first worksheet
        ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);
        PagesSetup imagePagesSetup = new PagesSetup();
        imagePagesSetup.setFirstPage(true);
        imageWatermark.setPagesSetup(imagePagesSetup);
        watermarker.add(imageWatermark);

        watermarker.save(Constants.OutSpreadsheetXlsx);

        watermarker.close();
        imageWatermark.close();
    }
}
