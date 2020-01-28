package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.FileType;
import com.groupdocs.watermark.contents.PdfAttachment;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;

public class PdfRemoveAttachment {
    /**
     * This example shows how to remove attachments from the PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);
        for (int i = pdfContent.getAttachments().getCount() - 1; i >= 0; i--)
        {
            PdfAttachment attachment = pdfContent.getAttachments().get_Item(i);

            // Remove all attached pdf files with a particular name
            if (attachment.getName().contains("sample") && attachment.getDocumentInfo().getFileType() == FileType.DOCX)
            {
                pdfContent.getAttachments().removeAt(i);
            }
        }

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
