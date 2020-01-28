package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_email_attachments;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.EmailContent;
import com.groupdocs.watermark.contents.EmailEmbeddedObject;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.EmailLoadOptions;

public class EmailAddEmbeddedImage {
	/**
	 * This example shows how to embed images in the body of the email message.
	 */
	public static void run() throws Exception {
		EmailLoadOptions loadOptions = new EmailLoadOptions();
		// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
		Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);

		EmailContent content = watermarker.getContent(EmailContent.class);
		
		File imageFile = new File(Constants.SampleJpg);
		byte[] imageBytes = new byte[(int) imageFile.length()];
		InputStream imageInputStream = new FileInputStream(imageFile);
		imageInputStream.read(imageBytes);
		imageInputStream.close();

		content.getEmbeddedObjects().add(imageBytes, "sample.jpg");
	    EmailEmbeddedObject embeddedObject = content.getEmbeddedObjects().get_Item(content.getEmbeddedObjects().getCount() - 1);
	    content.setHtmlBody("<html><body>This is an embedded image: <img src=\"cid:" + embeddedObject.getContentId() + "\"></body></html>");
	    watermarker.save(Constants.OutMessageMsg);

	    watermarker.close();
	}
}
