---
id: get-document-info
url: watermark/java/get-document-info
title: Get document Info
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
GroupDocs.Watermark allows to get document information which includes:

*   [FileType](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/IDocumentInfo#getFileType())
*   [PageCount](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/IDocumentInfo#getPageCount())
*   [FileSize](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/IDocumentInfo#getSize())
*   [IsEncrypted](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/IDocumentInfo#isEncrypted())

The following code samples demonstrate how to get document information.

## Get document information from a file from local disk

This example demostrates how to get document information from the local file.

**basic\_usage.GetDocumentInfoForTheFileFromLocalDisk**

```csharp
// Constants.InSourceDocx is an absolute or relative path to your document. Ex.: "C:\\Docs\\source.docx"
Watermarker watermarker = new Watermarker(Constants.InSourceDocx);                                      
IDocumentInfo info = watermarker.getDocumentInfo();                                                 
System.out.println("File type: " + info.getFileType());                                             
System.out.println("Number of pages: " + info.getPageCount());                                      
System.out.println("Document size: " + info.getSize() + " bytes");
watermarker.dispose();
```

## Get document information from a stream

This example demonstrates how to get document information from the file stream.

**basic\_usage.GetDocumentInfoForTheFileFromStream**

```csharp
// Constants.InSourceDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\source.docx"
FileInputStream stream = new FileInputStream(Constants.InSourceDocx);                                  
Watermarker watermarker = new Watermarker(stream);                                                     
IDocumentInfo info = watermarker.getDocumentInfo();                                                    
System.out.println("File type: " + info.getFileType());                                                
System.out.println("Number of pages: " + info.getPageCount());                                         
System.out.println("Document size: " + info.getSize() + " bytes");
watermarker.dispose();
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
