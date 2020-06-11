---
id: load-password-protected-document
url: watermark/java/load-password-protected-document
title: Load password-protected document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
Some document formats also support content encryption. To load these type of documents you will have to provide the password. GroupDocs.Watermark API allows you to load content of these documents to manage watermark.

## Load password-protected document of any supported format

The following example demonstrates how to load an encrypted document of any supported format using the password. If the password is incorrect, [InvalidPasswordException](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.exceptions/InvalidPasswordException) is thrown.

**advanced\_usage.loading\_documents.LoadPasswordProtectedDocument**

```csharp
LoadOptions loadOptions = new LoadOptions();                                                                                   
loadOptions.setPassword("P@$$w0rd");                                                                                           
// Constants.InProtectedDocumentDocx is an absolute or relative path to your document. Ex: @"C:\\Docs\\protected-document.docx"
String filePath = Constants.InProtectedDocumentDocx;                                                                           
Watermarker watermarker = new Watermarker(filePath, loadOptions);                                                              
                                                                                                                               
// use watermarker methods to manage watermarks in the document                                                                
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));                                          
                                                                                                                               
watermarker.add(watermark);                                                                                                    
                                                                                                                               
watermarker.save(Constants.OutProtectedDocumentDocx);                                                                          
                                                                                                                               
watermarker.close();                                                                                                         
```

## Load password-protected word processing document

The following example demontrates how to load an encrypted word processing document (DOC, DOCX etc) using the password.

**advanced\_usage.loading\_documents.LoadPasswordProtectedWordProcessingDocument**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                                       
loadOptions.setPassword("P@$$w0rd");                                                                                           
// Constants.InProtectedDocumentDocx is an absolute or relative path to your document. Ex: @"C:\\Docs\\protected-document.docx"
String filePath = Constants.InProtectedDocumentDocx;                                                                           
Watermarker watermarker = new Watermarker(filePath, loadOptions);                                                              
                                                                                                                               
// use watermarker methods to manage watermarks in the WordProcessing document                                                 
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));                                          
                                                                                                                               
watermarker.add(watermark);                                                                                                    
                                                                                                                               
watermarker.save(Constants.OutProtectedDocumentDocx);                                                                          
                                                                                                                               
watermarker.close();                                                                                                         

```

The following [LoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/LoadOptions) descendants use [setPassword](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/LoadOptions#setPassword(java.lang.String)) method:

*   [DiagramLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/DiagramLoadOptions)
*   [PdfLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/PdfLoadOptions)
*   [PresentationLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/PresentationLoadOptions)
*   [SpreadsheetLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetLoadOptions)
*   [WordProcessingLoadOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/WordProcessingLoadOptions)

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
