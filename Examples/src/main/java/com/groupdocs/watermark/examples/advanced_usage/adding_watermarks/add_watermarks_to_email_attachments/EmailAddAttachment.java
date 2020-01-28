package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailAddAttachment {
    /**
     * This example shows how to add attachments to the email messages.
     */
    public static void run() throws Exception {
        EmailLoadOptions loadOptions = new EmailLoadOptions();
        // Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
        Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

        EmailContent content = watermarker.getContent(EmailContent.class);

        File attachmentFile = new File(Constants.InSampleMsg);
        byte[] attachmentBytes = new byte[(int) attachmentFile.length()];
        InputStream attachmentInputStream = new FileInputStream(attachmentFile);
        attachmentInputStream.read(attachmentBytes);
        attachmentInputStream.close();

        content.getAttachments().add(attachmentBytes, "sample.msg");

        // Save changes
        watermarker.save(Constants.OutMessageMsg);

        watermarker.close();
    }
}
