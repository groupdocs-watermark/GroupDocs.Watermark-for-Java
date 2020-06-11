---
id: add-text-or-image-watermark
url: watermark/java/add-text-or-image-watermark
title: Add text or image watermark
weight: 3
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
GroupDocs.Watermark allows to add watermarks and save resultant document. Full list of supported document formats can be found [here]({{< ref "watermark/java/getting-started/supported-document-formats.md" >}}). You may add text and image watermarks to the documents from local disk and from streams.

## Add a text watermark

The following example demostrates how to add a [TextWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark) to a local document:

*   [Create](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#Watermarker(java.lang.String)) a watermarker for the local file (line 2);
*   [Create](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark#TextWatermark(java.lang.String,%20com.groupdocs.watermark.watermarks.Font)) a watermark with text and font (line 4);
*   Set the watermark [color](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark#setForegroundColor(com.groupdocs.watermark.watermarks.Color)), [horizontal](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setHorizontalAlignment(int)) and [vertical](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setVerticalAlignment(int)) alignments (lines 5-7);
*   [Add](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#add(com.groupdocs.watermark.Watermark)) the watermark to the document (line 9);
*   [Save](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#save(java.lang.String)) the document to the new file (line 10).
*   [Close](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#close()) the watermarker and free its resources (line 12).

**basic\_usage.AddATextWatermark**

```csharp
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                      
                                                                                                         
TextWatermark watermark = new TextWatermark("top secret", new Font("Arial", 36));                        
watermark.setForegroundColor(Color.getRed());                                                            
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                            
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                
                                                                                                         
watermarker.add(watermark);                                                                              
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                   
```

## Add an Image Watermark

The following example demonstrates how to add an [ImageWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/ImageWatermark) to a document from a stream:

*   [Create](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#Watermarker(java.lang.String)) a watermarker for the file stream (line 4);
*   [Create](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/ImageWatermark#ImageWatermark(java.lang.String)) an image watermark from the local image file (line 6);
*   Set the watermark [horizontal](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setHorizontalAlignment(int)) and [vertical](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setVerticalAlignment(int)) alignments (lines 7, 8);
*   [Add](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#add(com.groupdocs.watermark.Watermark)) the watermark to the document (line 9);
*   [Save](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#save(java.lang.String)) the document to the new file (line 11).
*   [Close](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/ImageWatermark#close()) the watermark and free its resources (line 13);
*   [Close](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#close()) the watermarker and free its resources (line 14).

**basic\_usage.AddAnImageWatermark**

```csharp
// Constants.InDocumentXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.xlsx" 
FileInputStream stream = new FileInputStream(Constants.InDocumentXlsx);                                     
                                                                                                            
Watermarker watermarker = new Watermarker(stream);                                                          
                                                                                                            
ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);                                           
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                               
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                   
watermarker.add(watermark);                                                                                 
                                                                                                            
watermarker.save(Constants.OutDocumentXlsx);                                                                
                                                                                                            
watermark.close();                                                                                          
watermarker.close();                                                                                      
stream.close();                                                                                             
```

## More resources

### Advanced usage topics

To learn more about document watermarking features and get familiar how to manage watermarks and more, please refer to the[advanced usage section]({{< ref "watermark/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
