package com.groupdocs.watermark.examples.advanced_usage.add_watermarks_to_email_attachments;

import java.io.FileOutputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.EmailAttachment;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailExtractAllAttachments {
	/**
	 * This example shows how to get the information about the attachments in an email message.
	 */
	public static void run() throws Exception {
		EmailLoadOptions loadOptions = new EmailLoadOptions();
		// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
		Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

		EmailContent content = watermarker.getContent(EmailContent.class);
	    for (EmailAttachment attachment : content.getAttachments())
	    {
	    	System.out.println("Name: " + attachment.getName());
	    	System.out.println("File format: " + attachment.getDocumentInfo().getFileType());

	    	FileOutputStream outputStream = new FileOutputStream(Constants.OutputPath + "\\" + attachment.getName());
			outputStream.write(attachment.getContent());
			outputStream.close();
	    }
	    
	    watermarker.close();
	}
}
