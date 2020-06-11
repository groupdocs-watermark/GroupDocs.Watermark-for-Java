---
id: rasterize-document-or-page
url: watermark/java/rasterize-document-or-page
title: Rasterize document or page
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The watermark can be removed from the PDF documents using third-party tools. However, if you want to get a watermark that is almost impossible to remove, you can consider PDF document rasterization. GroupDocs.Watermark provides the feature to convert all the pages of a PDF document to raster images with only one line of code.

## Rasterize PDF document

Following code snippet is used to [rasterize](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfContent#rasterize(int,%20int,%20int)) the PDF document to protect added watermarks.  

**advanced\_usage.add\_watermarks\_to\_pdf.PdfRasterizeDocument**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
// Initialize image or text watermark                                                                    
TextWatermark watermark = new TextWatermark("Do not copy", new Font("Arial", 8));                        
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                            
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                
watermark.setRotateAngle(45);                                                                            
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                             
watermark.setScaleFactor(1);                                                                             
watermark.setOpacity(0.5);                                                                               
                                                                                                         
// Add watermark of any type first                                                                       
watermarker.add(watermark);                                                                              
                                                                                                         
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
                                                                                                         
// Rasterize all pages                                                                                   
pdfContent.rasterize(100, 100, PdfImageConversionFormat.Png);                                            
                                                                                                         
// Content of all pages is replaced with raster images                                                   
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

{{< alert style="warning" >}}You can't restore document content after saving the document. Rasterization significantly increases the size of the resultant PDF file.{{< /alert >}}

## Rasterize particular page of the PDF document

The API also allows you to [rasterize](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfPage#rasterize(int,%20int,%20int)) any particular page of the PDF document. Following code snippet is used to rasterize a page of the PDF document.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfRasterizePage**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
// Initialize image or text watermark                                                                    
TextWatermark watermark = new TextWatermark("Do not copy", new Font("Arial", 8));                        
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                            
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                
watermark.setRotateAngle(45);                                                                            
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                             
watermark.setScaleFactor(1);                                                                             
watermark.setOpacity(0.5);                                                                               
                                                                                                         
// Add watermark of any type first                                                                       
PdfArtifactWatermarkOptions options = new PdfArtifactWatermarkOptions();                                 
options.setPageIndex(0);                                                                                 
watermarker.add(watermark, options);                                                                     
                                                                                                         
// Rasterize the first page                                                                              
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
pdfContent.getPages().get_Item(0).rasterize(100, 100, PdfImageConversionFormat.Png);                     
                                                                                                         
// Content of the first page is replaced with raster image                                               
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
