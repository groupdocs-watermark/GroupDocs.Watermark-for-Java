---
id: add-watermarks-to-images
url: watermark/java/add-watermarks-to-images
title: Add watermarks to images
weight: 5
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Adding watermark to multi-framed image 

When you are working with an animated gif or multi-frame tiff images, you may want to add watermark to some particular frame(s) using the method [setFrameIndex()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/MultiframeImageWatermarkOptions#setFrameIndex(int)) of [TiffImageWatermarkOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/TiffImageWatermarkOptions) or [GifImageWatermarkOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/GifImageWatermarkOptions).

**advanced\_usage.add\_watermarks\_to\_images.AddWatermarkToImage**

```csharp
// Constants.InImageTiff is an absolute or relative path to your document. Ex: "C:\\Docs\\image.tiff"
TiffImageLoadOptions loadOptions = new TiffImageLoadOptions();                                       
Watermarker watermarker = new Watermarker(Constants.InImageTiff, loadOptions);                       
                                                                                                     
// Initialize text or image watermark                                                                
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));                
                                                                                                     
// Add watermark to the first frame                                                                  
TiffImageWatermarkOptions options = new TiffImageWatermarkOptions();                                 
options.setFrameIndex(0);                                                                            
                                                                                                     
watermarker.add(watermark, options);                                                                 
watermarker.save(Constants.OutImageTiff);                                                            
                                                                                                     
watermarker.close();                                                                                 
```

## Advanced use cases

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
