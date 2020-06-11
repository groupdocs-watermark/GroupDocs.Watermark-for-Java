---
id: load-from-local-disk
url: watermark/java/load-from-local-disk
title: Load from local disk
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The folowing example demontrates how to create a [watermarker](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker) for a local filesystem document:

**advanced\_usage.loading\_documents.LoadFromLocalDisk**

```csharp
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
String filePath = Constants.InDocumentDocx;                                                                 
Watermarker watermarker = new Watermarker(filePath);                                                        
// use watermarker methods to manage watermarks                                                             
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));                       
                                                                                                            
watermarker.add(watermark);                                                                                 
watermarker.save(Constants.OutDocumentDocx);                                                                
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
