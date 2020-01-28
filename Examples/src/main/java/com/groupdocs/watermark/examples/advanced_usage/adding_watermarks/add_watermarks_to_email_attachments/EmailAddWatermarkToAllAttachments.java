package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.common.IDocumentInfo;
import com.groupdocs.watermark.contents.EmailAttachment;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class EmailAddWatermarkToAllAttachments {
    /**
     * This example shows how to add watermark to all the attachments of supported types in an email message.
     */
    public static void run() {
        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));
        EmailLoadOptions loadOptions = new EmailLoadOptions();
        // Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
        Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

        EmailContent content = watermarker.getContent(EmailContent.class);
        for (EmailAttachment attachment : content.getAttachments())
        {
            // Check if the attached file is supported by GroupDocs.Watermark
            IDocumentInfo info = attachment.getDocumentInfo();
            if (info.getFileType() != FileType.Unknown && !info.isEncrypted())
            {
                // Load the attached document
                Watermarker attachedWatermarker = attachment.createWatermarker();

                // Add watermark
                attachedWatermarker.add(watermark);

                // Save changes in the attached file
                attachment.updateContent(attachedWatermarker);

                attachedWatermarker.close();
            }
        }

        // Save changes
        watermarker.save(Constants.OutMessageMsg);

        watermarker.close();
    }
}
