package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_pdf;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PdfContent;
import com.groupdocs.watermark.contents.PdfPage;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PdfLoadOptions;
import com.groupdocs.watermark.search.FormattedTextFragment;

public class PdfRemoveArtifactsWithParticularTextFormatting {
    /**
     * This example shows how to find and remove all artifacts containing text with a particular formatting from a PDF document.
     */
    public static void run() {
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);

        PdfContent pdfContent = watermarker.getContent(PdfContent.class);
        for (PdfPage page : pdfContent.getPages())
        {
            for (int i = page.getArtifacts().getCount() - 1; i >= 0; i--)
            {
                for (FormattedTextFragment fragment : page.getArtifacts().get_Item(i).getFormattedTextFragments())
                {
                    if (fragment.getFont().getSize() > 42)
                    {
                        page.getArtifacts().removeAt(i);
                        break;
                    }
                }
            }
        }

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
