package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_presentations;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.contents.PresentationContent;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.PresentationLoadOptions;
import com.groupdocs.watermark.options.PresentationWatermarkLayoutSlideOptions;
import com.groupdocs.watermark.options.PresentationWatermarkMasterHandoutSlideOptions;
import com.groupdocs.watermark.options.PresentationWatermarkMasterNotesSlideOptions;
import com.groupdocs.watermark.options.PresentationWatermarkMasterSlideOptions;
import com.groupdocs.watermark.options.PresentationWatermarkNoteSlideOptions;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class PresentationAddWatermarkToAllSlideTypes {
    /**
     * This example shows how to access each type of the slides in a PowerPoint presentation.
     */
    public static void run() {
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        // Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
        Watermarker watermarker = new Watermarker(Constants.InPresentationPptx, loadOptions);

        TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 8));

        PresentationContent content = watermarker.getContent(PresentationContent.class);

        // Add watermark to all master slides
        PresentationWatermarkMasterSlideOptions masterSlideOptions = new PresentationWatermarkMasterSlideOptions();
        masterSlideOptions.setMasterSlideIndex(-1);
        watermarker.add(watermark, masterSlideOptions);

        // Add watermark to all layout slides
        if (content.getLayoutSlides() != null)
        {
            PresentationWatermarkLayoutSlideOptions layoutSlideOptions = new PresentationWatermarkLayoutSlideOptions();
            layoutSlideOptions.setLayoutSlideIndex(-1);
            watermarker.add(watermark, masterSlideOptions);
        }

        // Add watermark to all notes slides
        for (int i = 0; i < content.getSlides().getCount(); i++)
        {
            if (content.getSlides().get_Item(i).getNotesSlide() != null)
            {
                PresentationWatermarkNoteSlideOptions noteSlideOptions = new PresentationWatermarkNoteSlideOptions();
                noteSlideOptions.setSlideIndex(i);
                watermarker.add(watermark, noteSlideOptions);
            }
        }

        // Add watermark to handout master
        if (content.getMasterHandoutSlide() != null)
        {
            PresentationWatermarkMasterHandoutSlideOptions handoutSlideOptions = new PresentationWatermarkMasterHandoutSlideOptions();
            watermarker.add(watermark, handoutSlideOptions);
        }

        // Add watermark to notes master
        if (content.getMasterNotesSlide() != null)
        {
            PresentationWatermarkMasterNotesSlideOptions masterNotesSlideOptions = new PresentationWatermarkMasterNotesSlideOptions();
            watermarker.add(watermark, masterNotesSlideOptions);
        }

        watermarker.save(Constants.OutPresentationPptx);

        watermarker.close();
    }
}
