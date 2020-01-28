package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.EmailAddress;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailListRecipients {
	/**
	 * This example shows how to list all the message recipients.
	 */
	public static void run() {
		EmailLoadOptions loadOptions = new EmailLoadOptions();
		// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
		Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

		EmailContent content = watermarker.getContent(EmailContent.class);

	    // List all direct recipients
	    for (EmailAddress address : content.getTo())
	    {
	    	System.out.println(address.getAddress());
	    }

	    // List all CC recipients
	    for (EmailAddress address : content.getCc())
	    {
	    	System.out.println(address.getAddress());
	    }

	    // List all BCC recipients
	    for (EmailAddress address : content.getBcc())
	    {
	    	System.out.println(address.getAddress());
	    }

	    watermarker.close();
	}
}
