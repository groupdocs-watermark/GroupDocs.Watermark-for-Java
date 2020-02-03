package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.contents.PresentationSlide;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;

public class PresentationGetSlideBackgroundsInformation {
    /**
     * This example shows how to extract information about all the slide backgrounds in a PowerPoint document.
     */
    public static void run() {
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        // Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
        Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

        PresentationContent content = watermarker.getContent(PresentationContent.class);
        for (PresentationSlide slide : content.getSlides())
        {
            if (slide.getImageFillFormat().getBackgroundImage() != null)
            {
                System.out.println(slide.getImageFillFormat().getBackgroundImage().getWidth());
                System.out.println(slide.getImageFillFormat().getBackgroundImage().getHeight());
                System.out.println(slide.getImageFillFormat().getBackgroundImage().getBytes().length);
            }
        }

        watermarker.close();
    }
}
