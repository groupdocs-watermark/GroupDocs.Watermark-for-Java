---
id: add-watermarks-to-pdf-documents
url: watermark/java/add-watermarks-to-pdf-documents
title: Add watermarks to PDF documents
weight: 6
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Adding watermark to a particular page 

GroupDocs.Watermark API allows you to add watermark to a particular page of a PDF document. Adding watermark to a PDF document using GroupDocs.Watermark consists of following steps.

1.  Load the document 
2.  Create and initialize watermark object 
3.  Set watermark properties 
4.  Add watermark to the page of the document using method [setPageIndex()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/PdfArtifactWatermarkOptions#setPageIndex(int)) of [PdfArtifactWatermarkOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/PdfArtifactWatermarkOptions)
5.  Save the document

Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfAddWatermarks**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
// Add text watermark to the first page                                                                  
TextWatermark textWatermark = new TextWatermark("This is a test watermark", new Font("Arial", 8));       
PdfArtifactWatermarkOptions textWatermarkOptions = new PdfArtifactWatermarkOptions();                    
textWatermarkOptions.setPageIndex(0);                                                                    
                                                                                                         
watermarker.add(textWatermark, textWatermarkOptions);                                                    
                                                                                                         
// Add image watermark to the second page                                                                
ImageWatermark imageWatermark = new ImageWatermark(Constants.ProtectJpg);                                
                                                                                                         
PdfArtifactWatermarkOptions imageWatermarkOptions = new PdfArtifactWatermarkOptions();                   
imageWatermarkOptions.setPageIndex(1);                                                                   
watermarker.add(imageWatermark, imageWatermarkOptions);                                                  
                                                                                                         
imageWatermark.close();                                                                                  
                                                                                                         
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

## Adding watermark to all images of a particular page

The API also allows you to add watermark to the images inside a particular page of the PDF document. Following code snippet shows how to add watermark to all images in a particular page of a PDF document.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfAddWatermarkToImages**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
// Initialize image or text watermark                                                                    
TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));                    
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                            
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                
watermark.setRotateAngle(45);                                                                            
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                             
watermark.setScaleFactor(1);                                                                             
                                                                                                         
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
                                                                                                         
// Get all images from the first page                                                                    
WatermarkableImageCollection images = pdfContent.getPages().get_Item(0).findImages();                    
                                                                                                         
// Add watermark to all found images                                                                     
for (WatermarkableImage image : images)                                                                  
{                                                                                                        
    image.add(watermark);                                                                                
}                                                                                                        
                                                                                                         
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

## Getting page size 

If for some reasons you want to use absolute sizing and positioning, you may also need to determine page size. GroupDocs.Watermark also provides the feature to get the dimensions of the page in a PDF document. Below example shows how to get [width](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfPage#getWidth()) and [height](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfPage#getHeight()) of a particular page.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfGetDimensions**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
                                                                                                         
System.out.println(pdfContent.getPages().get_Item(0).getWidth());                                        
System.out.println(pdfContent.getPages().get_Item(0).getHeight());                                       
                                                                                                         
watermarker.close();                                                                                     
```

## Page margins in PDF document

{{< alert style="info" >}}PDF Reference 1.7A PDF page may be prepared either for a finished medium, such as a sheet of paper, or as part of a prepress process in which the content of the page is placed on an intermediate medium, such as film or an imposed reproduction plate. In the latter case, it is important to distinguish between the intermediate page and the finished page. The intermediate page may often include additional production-related content, such as bleeds or printer marks, that falls outside the boundaries of the finished page. To handle such cases, a PDF page can define as many as five separate boundaries to control various aspects of the imaging process:The media box defines the boundaries of the physical medium on which the page is to be printed. It may include any extended area surrounding the finished page for bleed, printing marks, or other such purposes. It may also include areas close to the edges of the medium that cannot be marked because of physical limitations of the output device. Content falling outside this boundary can safely be discarded without affecting the meaning of the PDF file.The crop box defines the region to which the contents of the page are to be clipped (cropped) when displayed or printed. Unlike the other boxes, the crop box has no defined meaning in terms of physical page geometry or intended use; it merely imposes clipping on the page contents. However, in the absence of additional information (such as imposition instructions specified in a JDF or PJTF job ticket), the crop box determines how the page’s contents are to be positioned on the output medium. The default value is the page’s media box.The bleed box (PDF 1.3) defines the region to which the contents of the page should be clipped when output in a production environment. This may include any extra bleed area needed to accommodate the physical limitations of cutting, folding, and trimming equipment. The actual printed page may include printing marks that fall outside the bleed box. The default value is the page’s crop box.The trim box (PDF 1.3) defines the intended dimensions of the finished page after trimming. It may be smaller than the media box to allow for production-related content, such as printing instructions, cut marks, or color bars. The default value is the page’s crop box.The art box (PDF 1.3) defines the extent of the page’s meaningful content (including potential white space) as intended by the page’s creator. The default value is the page’s crop box.{{< /alert >}}

If a PDF document contains a crop box definition, Adobe Acrobat uses it for screen display and printing. That's why GroupDocs.Watermark uses crop box by default to calculate relative watermark size and position. When you call [Watermark.setConsiderParentMargins()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setConsiderParentMargins(boolean)) mathods with true, trim box rectangle is used instead. But what if you want to get watermark aligned to bleed box or art box? In this case, you need to set the appropriate value with [PdfContent.setPageMarginType()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfContent#setPageMarginType(int)) method as shown in the below example.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfAddWatermarkWithPageMarginType**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 42));                    
watermark.setHorizontalAlignment(HorizontalAlignment.Right);                                             
watermark.setVerticalAlignment(VerticalAlignment.Top);                                                   
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                             
watermark.setScaleFactor(1);                                                                             
                                                                                                         
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
pdfContent.setPageMarginType(PdfPageMarginType.BleedBox);                                                
watermark.setConsiderParentMargins(true);                                                                
                                                                                                         
watermarker.add(watermark);                                                                              
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

## Add watermark to all attachments

GroupDocs.Watermark also provides the feature to add watermark to supported files in all [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfContent#getAttachments()) in a PDF document. Below example shows how to add watermark to all supported attachments.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfAddWatermarkToAllAttachments**

```csharp
TextWatermark watermark = new TextWatermark("This is WaterMark on Attachment", new Font("Arial", 19));   
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
for (PdfAttachment attachment : pdfContent.getAttachments())                                             
{                                                                                                        
    // Check if the attached file is supported by GroupDocs.Watermark                                    
    IDocumentInfo info = attachment.getDocumentInfo();                                                   
    if (info.getFileType() != FileType.Unknown && !info.isEncrypted())                                   
    {                                                                                                    
        // Load the attached document                                                                    
        Watermarker attachedWatermarker = attachment.createWatermarker();                                
                                                                                                         
        // Add watermark                                                                                 
        attachedWatermarker.add(watermark);                                                              
                                                                                                         
        // Save changes in the attached file                                                             
        attachment.updateContent(attachedWatermarker);                                                   
                                                                                                         
        attachedWatermarker.close();                                                                     
    }                                                                                                    
}                                                                                                        
                                                                                                         
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
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
