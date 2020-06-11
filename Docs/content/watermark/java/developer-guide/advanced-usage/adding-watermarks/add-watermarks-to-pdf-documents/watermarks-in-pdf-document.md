---
id: watermarks-in-pdf-document
url: watermark/java/watermarks-in-pdf-document
title: Watermarks in PDF document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
# Attachments in PDF document

## Extract all attachments from PDF document 

GroupDocs.Watermark API allows you to extract [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/PdfContent#getAttachments()) in PDF document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfExtractAllAttachments**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                           
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"    
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                             
                                                                                                             
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                            
for (PdfAttachment attachment : pdfContent.getAttachments())                                                 
{                                                                                                            
    System.out.println("Name: " + attachment.getName());                                                     
    System.out.println("Description: " + attachment.getDescription());                                       
    System.out.println("File type: " + attachment.getDocumentInfo().getFileType());                          
                                                                                                             
    // Save the attached file on disk                                                                        
    FileOutputStream outputStream = new FileOutputStream(Constants.OutputPath + "\\" + attachment.getName());
    outputStream.write(attachment.getContent());                                                             
    outputStream.close();                                                                                    
}                                                                                                            
                                                                                                             
watermarker.close();                                                                                         
```

## Add an attachment to PDF document

The API also allows you to add attachments to the PDF document. Following code snippet shows how to remove an attachment

**advanced\_usage.add\_watermarks\_to\_pdf.PdfAddAttachment**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                        
                                                                                                         
File file = new File(Constants.InSampleDocx);                                                            
byte[] attachmentBytes = new byte[(int) file.length()];                                                  
InputStream inputStream = new FileInputStream(file);                                                     
inputStream.read(attachmentBytes);                                                                       
inputStream.close();                                                                                     
                                                                                                         
// Add the attachment                                                                                    
pdfContent.getAttachments().add(attachmentBytes, "sample doc", "sample doc as attachment");              
                                                                                                         
// Save changes                                                                                          
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

## Remove attachment from PDF document

The API also allows you to remove attachments from the PDF document. Following code snippet shows how to remove an attachment.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfRemoveAttachment**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                             
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"      
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                               
                                                                                                               
PdfContent pdfContent = watermarker.getContent(PdfContent.class);                                              
for (int i = pdfContent.getAttachments().getCount() - 1; i >= 0; i--)                                          
{                                                                                                              
    PdfAttachment attachment = pdfContent.getAttachments().get_Item(i);                                        
                                                                                                               
    // Remove all attached pdf files with a particular name                                                    
    if (attachment.getName().contains("sample") && attachment.getDocumentInfo().getFileType() == FileType.DOCX)
    {                                                                                                          
        pdfContent.getAttachments().removeAt(i);                                                               
    }                                                                                                          
}                                                                                                              
                                                                                                               
watermarker.save(Constants.OutDocumentPdf);                                                                    
                                                                                                               
watermarker.close();                                                                                           
```

## Search for images attachments

In case you want to search for all the images attachments in a PDF document, you can use GroupDocs.Watermark. Following code sample shows how to search images attachments of PDF document.

**advanced\_usage.add\_watermarks\_to\_pdf.PdfSearchImageInAttachment**

```csharp
PdfLoadOptions loadOptions = new PdfLoadOptions();                                                       
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf, loadOptions);                         
                                                                                                         
// Consider only the attached images                                                                     
watermarker.getSearchableObjects().setPdfSearchableObjects(PdfSearchableObjects.AttachedImages);         
                                                                                                         
// Search for similar images                                                                             
WatermarkableImageCollection possibleWatermarks = watermarker.getImages();                               
                                                                                                         
System.out.println("Found " + possibleWatermarks.getCount() + " image(s).");                             
                                                                                                         
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
