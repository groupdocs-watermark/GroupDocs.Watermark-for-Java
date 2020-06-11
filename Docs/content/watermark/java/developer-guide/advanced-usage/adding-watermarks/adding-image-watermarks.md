---
id: adding-image-watermarks
url: watermark/java/adding-image-watermarks
title: Adding image watermarks
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
GroupDocs.Watermar API supports adding the following image file types as image watermark:

*   Bmp;
*   Png;
*   Gif;
*   Jpeg.

## Add image watermark from local file

Following code snippet shows how to add [ImageWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/ImageWatermark) to a document. If the document consists of multiple parts (pages, worksheets, slides, frames etc), the watermark will be added to all of them.

**advanced\_usage.adding\_image\_watermarks.AddImageWatermark**

```csharp
// Constants.InPresentationPptx is an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
Watermarker watermarker = new Watermarker(Constants.InPresentationPptx);                                           
                                                                                                                   
// Use path to the image as constructor parameter                                                                  
ImageWatermark watermark = new ImageWatermark(Constants.WatermarkJpg);                                             
                                                                                                                   
// Add watermark to the document                                                                                   
watermarker.add(watermark);                                                                                        
                                                                                                                   
watermarker.save(Constants.OutPresentationPptx);                                                                   
                                                                                                                   
watermark.close();                                                                                                 
watermarker.close();                                                                                             
```

## Add image watermark from stream  

You can also use a stream of the image to initialize [ ImageWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/ImageWatermark) instance as shown in below example.

**advanced\_usage.adding\_image\_watermarks.AddImageWatermarkUsingStream**

```csharp
// Constants.WatermarkJpg is an absolute or relative path to your document. Ex: "C:\\Docs\\watermark.jpg"
FileInputStream watermarkStream = new FileInputStream(Constants.WatermarkJpg);                           
                                                                                                         
Watermarker watermarker = new Watermarker(Constants.InImagePng);                                         
                                                                                                         
// Use stream containing an image as constructor parameter                                               
ImageWatermark watermark = new ImageWatermark(watermarkStream);                                          
                                                                                                         
// Add watermark to the document                                                                         
watermarker.add(watermark);                                                                              
                                                                                                         
watermarker.save(Constants.OutImagePng);                                                                 
                                                                                                         
watermark.close();                                                                                       
watermarker.dispose();                                                                                   
watermarkStream.close();                                                                                 
```

{{< alert style="warning" >}}ImageWatermark class implements Closable  interface. Therefore, it is necessary to call close() method when you are done working with the watermark. {{< /alert >}}

For the advanced use of image watermark properties please check the following article about text watermarks, however same techniques will work for image watermark as well:

*   [Adding Text Watermarks]({{< ref "watermark/java/developer-guide/advanced-usage/adding-watermarks/adding-image-watermarks.md" >}})

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
