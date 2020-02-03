package com.groupdocs.watermark.examples.advanced_usage.adding_watermarks.add_watermarks_to_images;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.common.HorizontalAlignment;
import com.groupdocs.watermark.common.VerticalAlignment;
import com.groupdocs.watermark.contents.WatermarkableImageCollection;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.ImageWatermark;
import com.groupdocs.watermark.watermarks.SizingType;
import com.groupdocs.watermark.watermarks.TextWatermark;

public class AddWatermarkToImagesInsideDocument {
    /**
     * This example shows how to add watermark to images inside a document.
     */
    public static void run() {
        // Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
        Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);

        // Initialize text watermark
        TextWatermark textWatermark = new TextWatermark("Protected image", new Font("Arial", 8));
        textWatermark.setHorizontalAlignment(HorizontalAlignment.Center);
        textWatermark.setVerticalAlignment(VerticalAlignment.Center);
        textWatermark.setRotateAngle(45);
        textWatermark.setSizingType(SizingType.ScaleToParentDimensions);
        textWatermark.setScaleFactor(1);

        // Initialize image watermark
        ImageWatermark imageWatermark = new ImageWatermark(Constants.ProtectJpg);

        imageWatermark.setHorizontalAlignment(HorizontalAlignment.Center);
        imageWatermark.setVerticalAlignment(VerticalAlignment.Center);
        imageWatermark.setRotateAngle(-45);
        imageWatermark.setSizingType(SizingType.ScaleToParentDimensions);
        imageWatermark.setScaleFactor(1);

        // Find all images in a document
        WatermarkableImageCollection images = watermarker.getImages();

        for (int i = 0; i < images.getCount(); i++)
        {
            if (images.get_Item(i).getWidth() > 100 && images.get_Item(i).getHeight() > 100)
            {
                if (i % 2 == 0)
                {
                    images.get_Item(i).add(textWatermark);
                }
                else
                {
                    images.get_Item(i).add(imageWatermark);
                }
            }
        }

        imageWatermark.close();

        watermarker.save(Constants.OutDocumentPdf);

        watermarker.close();
    }
}
