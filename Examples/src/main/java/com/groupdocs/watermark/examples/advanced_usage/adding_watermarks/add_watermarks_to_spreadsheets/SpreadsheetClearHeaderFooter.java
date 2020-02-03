package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_spreadsheets;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.OfficeHeaderFooterType;
import com.groupdocs.watermark.contents.SpreadsheetContent;
import com.groupdocs.watermark.contents.SpreadsheetHeaderFooterSection;
import com.groupdocs.watermark.contents.SpreadsheetHeaderFooterSectionCollection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.SpreadsheetLoadOptions;

public class SpreadsheetClearHeaderFooter {
    /**
     * This example shows how to clear a particular header and footer.
     */
    public static void run() {
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        // Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: @"C:\Docs\spreadsheet.xlsx"
        Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);

        SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);

        SpreadsheetHeaderFooterSectionCollection sections = content
                .getWorksheets().get_Item(0)
                .getHeadersFooters().getByOfficeHeaderFooterType(OfficeHeaderFooterType.HeaderPrimary)
                .getSections();
        for (SpreadsheetHeaderFooterSection section : sections)
        {
            section.setScript(null);
            section.setImage(null);
        }

        watermarker.save(Constants.OutSpreadsheetXlsx);

        watermarker.close();
    }
}
