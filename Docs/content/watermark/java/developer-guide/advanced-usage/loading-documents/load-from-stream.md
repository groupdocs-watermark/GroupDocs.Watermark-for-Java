---
id: load-from-stream
url: watermark/java/load-from-stream
title: Load from stream
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The following example democtrates how to create a [watermarker](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker) for a document stream:

**advanced\_usage.loading\_documents.LoadFromStream**

```csharp
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
FileInputStream document = new FileInputStream(Constants.InDocumentDocx);                                   
Watermarker watermarker = new Watermarker(document);                                                        
                                                                                                            
// use watermarker methods to manage watermarks                                                             
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));                       
                                                                                                            
watermarker.add(watermark);                                                                                 
                                                                                                            
watermarker.save(Constants.OutDocumentDocx);                                                                
                                                                                                            
watermarker.close();                                                                                      
document.close();                                                                                           
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
