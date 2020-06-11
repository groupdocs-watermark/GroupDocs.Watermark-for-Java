---
id: load-document-of-specific-format
url: watermark/java/load-document-of-specific-format
title: Load document of specific format
weight: 3
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The constructors [Watermarker(String)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#Watermarker(java.lang.String)) and [Watermarker(InputStream)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#Watermarker(java.io.InputStream)) can load a document of any supported format. When you're loading a document, GroupDocs.Watermark automatically detects its type and creates an instance of the appropriate class. If document format is not supported, constructor throws [UnsupportedFileTypeException](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.exceptions/UnsupportedFileTypeException). If you need specify the format of a document to load, you can use constructors with [LoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/LoadOptions) parameter.

The following examle demonstrates how to create a watermarker for the Spreadsheet document:

**advanced\_usage.loading\_documents.LoadingDocumentOfSpecificFormat**

```csharp
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
String filePath = Constants.InSpreadsheetXlsx;                                                                    
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                
Watermarker watermarker = new Watermarker(filePath, loadOptions);                                                 
                                                                                                                  
// use watermarker methods to manage watermarks in the Spreadsheet document                                       
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));                             
                                                                                                                  
watermarker.add(watermark);                                                                                       
                                                                                                                  
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                   
                                                                                                                  
watermarker.close();                                                                                            

```

Any supported format family has the specific [LoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/LoadOptions) descendant:

| Format | LoadOptions descendant |
| --- | --- |
| Diagram | [DiagramLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/DiagramLoadOptions) |
| Email | [EmailLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/EmailLoadOptions) |
| Image | [ImageLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/ImageLoadOptions) |
| GifImage | [GifImageLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/GifImageLoadOptions) |
| TiffImage | [TiffImageLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/TiffImageLoadOptions) |
| PDF | [PdfLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/PdfLoadOptions) |
| Presentation | [PresentationLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/PresentationLoadOptions) |
| Spreadsheet | [SpreadsheetLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetLoadOptions) |
| WordProcessing | [WordProcessingLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/WordProcessingLoadOptions) |

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
