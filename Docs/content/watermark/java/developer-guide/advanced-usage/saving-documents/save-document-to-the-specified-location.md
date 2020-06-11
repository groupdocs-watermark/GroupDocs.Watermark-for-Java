---
id: save-document-to-the-specified-location
url: watermark/java/save-document-to-the-specified-location
title: Save document to the specified location
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
Following code shows usage of [save(String)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#save(java.lang.String)) method.

**advanced\_usage.saving\_documents.SaveDocumentToTheSpecifiedLocation**

```csharp
// Constants.InTestDoc is an absolute or relative path to your document. Ex: "C:\\Docs\\test.doc"
Watermarker watermarker = new Watermarker(Constants.InTestDoc);                                  
                                                                                                 
// watermarking goes here                                                                        
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));            
watermarker.add(watermark);                                                                      
                                                                                                 
// Saves the document to the specified location                                                  
watermarker.save(Constants.OutTestDoc);                                                          
                                                                                                 
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
