---
id: get-supported-file-formats
url: watermark/java/get-supported-file-formats
title: Get supported file formats
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
GroupDocs.Watermark allows to get the [list of all supported file formats]({{< ref "watermark/java/getting-started/supported-document-formats.md" >}}) by following the below steps:

*   Call [getSupportedFileTypes](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/FileType#getSupportedFileTypes()) of [FileType](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/FileType) class;
*   Enumerate through the collection of [FileType](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/FileType) objects*.*

The following code sample demonstrates how to get supported file formats list.

**basic\_usage.GetSupportedFileFormats**

```csharp
FileType[] fileTypes = FileType.getSupportedFileTypes();
for(FileType fileType : fileTypes) {                    
    System.out.println(fileType);                       
}                                                       
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
