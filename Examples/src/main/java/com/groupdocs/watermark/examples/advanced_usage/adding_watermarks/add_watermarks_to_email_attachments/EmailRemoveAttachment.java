package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.contents.EmailAttachment;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailRemoveAttachment {
	/**
	 * This example shows how to remove any particular attachment from an email message.
	 */
	public static void run() {
		EmailLoadOptions loadOptions = new EmailLoadOptions();
		// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
		Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

		EmailContent content = watermarker.getContent(EmailContent.class);
	    for (int i = content.getAttachments().getCount() - 1; i >= 0; i--)
	    {
	        EmailAttachment attachment = content.getAttachments().get_Item(i);

	        // Remove all attached files with a particular name and format
	        if (attachment.getName().contains("sample") && attachment.getDocumentInfo().getFileType() == FileType.DOCX)
	        {
	            content.getAttachments().removeAt(i);
	        }
	    }

	    // Save changes
	    watermarker.save(Constants.OutMessageMsg);

	    watermarker.close();
	}
}
