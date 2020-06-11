---
id: working-with-spreadsheet-document-attachments
url: watermark/java/working-with-spreadsheet-document-attachments
title: Working with spreadsheet document attachments
weight: 3
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Extract all attachments from Excel document 

GroupDocs.Watermark API allows you to extract [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet#getAttachments()) in Excel document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetExtractAllAttachments**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                                                
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"                                 
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                                              
                                                                                                                                                  
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                                                    
for (SpreadsheetWorksheet worksheet : content.getWorksheets())                                                                                    
{                                                                                                                                                 
    for (SpreadsheetAttachment attachment : worksheet.getAttachments())                                                                           
    {                                                                                                                                             
        System.out.println("Alternative text: " + attachment.getAlternativeText());                                                               
        System.out.println("Attachment frame x-coordinate: " + attachment.getX());                                                                
        System.out.println("Attachment frame y-coordinate: " + attachment.getY());                                                                
        System.out.println("Attachment frame width: " + attachment.getWidth());                                                                   
        System.out.println("Attachment frame height: " + attachment.getHeight());                                                                 
        System.out.println("Preview image size: " + attachment.getPreviewImageContent() != null ? attachment.getPreviewImageContent().length : 0);
                                                                                                                                                  
        if (attachment.isLink())                                                                                                                  
        {                                                                                                                                         
            // The document contains only a link to the attached file                                                                             
            System.out.println("Full path to the attached file: " + attachment.getSourceFullName());                                              
        }                                                                                                                                         
        else                                                                                                                                      
        {                                                                                                                                         
            // The attached file is stored in the document                                                                                        
            System.out.println("File type: " + attachment.getDocumentInfo().getFileType());                                                       
            System.out.println("Name of the source file: " + attachment.getSourceFullName());                                                     
            System.out.println("File size: " + attachment.getContent().length);                                                                   
        }                                                                                                                                         
    }                                                                                                                                             
}                                                                                                                                                 
                                                                                                                                                  
watermarker.close();                                                                                                                              
```

## Add an attachment to Excel document

 GroupDocs.Watermark API allows you to add attachments in Excel document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddAttachment**

```csharp
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
File file = new File(Constants.InDocumentDocx);                                                                  
byte[] attachmentBytes = new byte[(int) file.length()];                                                          
InputStream inputStream = new FileInputStream(file);                                                             
inputStream.read(attachmentBytes);                                                                               
inputStream.close();                                                                                             
                                                                                                                 
file = new File(Constants.DocumentPreviewPng);                                                                   
byte[] previewImageBytes = new byte[(int) file.length()];                                                        
inputStream = new FileInputStream(file);                                                                         
inputStream.read(previewImageBytes);                                                                             
inputStream.close();                                                                                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
SpreadsheetWorksheet worksheet = content.getWorksheets().get_Item(0);                                            
                                                                                                                 
// Add the attachment                                                                                            
worksheet.getAttachments().addAttachment(attachmentBytes, // File content                                        
                                        "sample document.docx", // Source file full name (the extension is used  
                                        // to determine appropriate application to open                          
                                        // the file)                                                             
                                        previewImageBytes, // Preview image content                              
                                        50, // X-coordinate of the attachment frame                              
                                        100, // Y-coordinate of the attachment frame                             
                                        200, // Attachment frame width                                           
                                        400); // Attachment frame height                                         
                                                                                                                 
// Save changes                                                                                                  
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Add linked attachment to Excel document

 GroupDocs.Watermark API allows you to add linked attachments in Excel document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddLinkedAttachment**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
SpreadsheetWorksheet worksheet = content.getWorksheets().get_Item(0);                                            
                                                                                                                 
File file = new File(Constants.DocumentPreviewPng);                                                              
byte[] previewImageBytes = new byte[(int) file.length()];                                                        
FileInputStream inputStream = new FileInputStream(file);                                                         
inputStream.read(previewImageBytes);                                                                             
inputStream.close();                                                                                             
                                                                                                                 
// Add the attachment                                                                                            
worksheet.getAttachments().addLink(Constants.InDocumentDocx, // Source file path                                 
                                   previewImageBytes, // Preview image content                                   
                                   50, // X-coordinate of the attachment frame                                   
                                   100, // Y-coordinate of the attachment frame                                  
                                   200, // Attachment frame width                                                
                                   400); // Attachment frame height                                              
                                                                                                                 
// Save changes                                                                                                  
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Remove attachment from Excel document

GroupDocs.Watermark API allows you to remove [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetAttachmentCollection) in Excel document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetRemoveAttachment**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                    
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"     
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                  
                                                                                                                      
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                        
for (SpreadsheetWorksheet worksheet : content.getWorksheets())                                                        
{                                                                                                                     
    for (int i = worksheet.getAttachments().getCount() - 1; i >= 0; i--)                                              
    {                                                                                                                 
        SpreadsheetAttachment attachment = worksheet.getAttachments().get_Item(i);                                    
        if (attachment.isLink() &&                                                                                    
            !new File(attachment.getSourceFullName()).exists() || // Linked file that is not available at this moment 
            attachment.getDocumentInfo().isEncrypted()) // Attached file protected with a password                    
        {                                                                                                             
            // Remove the file if it meets at least one of the conditions above                                       
            worksheet.getAttachments().removeAt(i);                                                                   
        }                                                                                                             
    }                                                                                                                 
}                                                                                                                     
                                                                                                                      
// Save changes                                                                                                       
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                       
                                                                                                                      
watermarker.close();                                                                                                  
```

## Add watermark to all attachments  

GroupDocs.Watermark API allows you to add watermark to all [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetAttachmentCollection) in Excel document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkToAttachment**

```csharp
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));                            
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
for (SpreadsheetWorksheet worksheet : content.getWorksheets())                                                   
{                                                                                                                
    for (SpreadsheetAttachment attachment : worksheet.getAttachments())                                          
    {                                                                                                            
        // Check if the attached file is supported by GroupDocs.Watermark                                        
        IDocumentInfo info = attachment.getDocumentInfo();                                                       
        if (info.getFileType() != FileType.Unknown && !info.isEncrypted())                                       
        {                                                                                                        
            // Load the attached document                                                                        
            Watermarker attachedWatermarker = attachment.createWatermarker();                                    
                                                                                                                 
            // Add watermark                                                                                     
            attachedWatermarker.add(watermark);                                                                  
                                                                                                                 
            // Save changes in the attached file                                                                 
            attachment.updateContent(attachedWatermarker);                                                       
                                                                                                                 
            attachedWatermarker.close();                                                                         
        }                                                                                                        
    }                                                                                                            
}                                                                                                                
                                                                                                                 
// Save changes                                                                                                  
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Search for images in attached files

GroupDocs.Watermark API allows you to search for all the [images and watermarkable attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.search/SpreadsheetSearchableObjects) in Excel document. Following code performs this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetSearchImageInAttachment**

```csharp
// Consider only the attached images                                                                             
WatermarkerSettings settings = new WatermarkerSettings();                                                        
settings.getSearchableObjects().setSpreadsheetSearchableObjects(SpreadsheetSearchableObjects.AttachedImages);    
                                                                                                                 
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions, settings);                   
                                                                                                                 
// Specify sample image to compare document images with                                                          
ImageSearchCriteria criteria = new ImageDctHashSearchCriteria(Constants.AttachmentPng);                          
                                                                                                                 
// Search for similar images                                                                                     
PossibleWatermarkCollection possibleWatermarks = watermarker.search(criteria);                                   
                                                                                                                 
// Remove or modify found image watermarks                                                                       
// ...                                                                                                           
                                                                                                                 
System.out.println("Found " + possibleWatermarks.getCount() + " possible watermark(s).");                        
                                                                                                                 
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
