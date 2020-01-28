package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;
import com.groupdocs.watermark.search.EmailSearchableObjects;
import com.groupdocs.watermark.search.PossibleWatermarkCollection;
import com.groupdocs.watermark.search.SearchCriteria;
import com.groupdocs.watermark.search.TextSearchCriteria;

public class EmailSearchTextInBody {
    /**
     * This example shows how to search for a text in the subject as well as in the body of the email message.
     */
    public static void run() {
        EmailLoadOptions loadOptions = new EmailLoadOptions();
        // Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
        Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

        SearchCriteria criteria = new TextSearchCriteria("test", false);

        // Specify search locations
        watermarker.getSearchableObjects().setEmailSearchableObjects(EmailSearchableObjects.Subject | EmailSearchableObjects.HtmlBody | EmailSearchableObjects.PlainTextBody);

        // Note, search is performed only if you pass TextSearchCriteria instance to FindWatermarks method
        PossibleWatermarkCollection watermarks = watermarker.search(criteria);

        // Remove found text fragments
        watermarks.clear();

        // Save changes
        watermarker.save(Constants.OutMessageMsg);

        watermarker.close();
    }
}
