package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailRemoveEmbeddedImages {
    /**
     * This example shows how to remove the embedded images from the body of the email message.
     */
    public static void run() {
        EmailLoadOptions loadOptions = new EmailLoadOptions();
        // Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
        Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

        EmailContent content = watermarker.getContent(EmailContent.class);
        for (int i = content.getEmbeddedObjects().getCount() - 1; i >= 0; i--)
        {
            if (content.getEmbeddedObjects().get_Item(i).getDocumentInfo().getFileType() == FileType.JPEG)
            {
                // Remove reference to the image from html body
                String pattern = "<img[^>]*src=\"cid:" + content.getEmbeddedObjects().get_Item(i).getContentId() + "\"[^>]*>";
                content.setHtmlBody(content.getHtmlBody().replaceAll(pattern, ""));

                // Remove the image
                content.getEmbeddedObjects().removeAt(i);
            }
        }

        watermarker.save(Constants.OutMessageMsg);

        watermarker.close();
    }
}
