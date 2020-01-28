package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailUpdateBody {
	/**
	 * This example shows how to modify the body and subject of an email message.
	 */
	public static void run() {
		EmailLoadOptions loadOptions = new EmailLoadOptions();
		// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
		Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

		EmailContent content = watermarker.getContent(EmailContent.class);

	    // Set the plain text body
	    content.setBody("Test plain text body");

	    // Set the html body
	    content.setHtmlBody("<html><body>Test html body</body></html>");

	    // Set the email subject
	    content.setSubject("Test subject");

	    // Save changes
	    watermarker.save(Constants.OutMessageMsg);
	    
	    watermarker.close();
	}
}
