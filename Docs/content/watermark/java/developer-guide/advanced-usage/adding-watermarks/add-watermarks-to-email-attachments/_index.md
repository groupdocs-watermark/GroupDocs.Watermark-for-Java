---
id: add-watermarks-to-email-attachments
url: watermark/java/add-watermarks-to-email-attachments
title: Add watermarks to email attachments
weight: 4
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The API allows you to add watermark to all the [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/EmailContent#getAttachments()) of supported types in an email message as shown in the following code sample.

**advanced\_usage.add\_watermarks\_to\_email\_attachments.EmailAddWatermarkToAllAttachments**

```csharp
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));                  
EmailLoadOptions loadOptions = new EmailLoadOptions();                                                 
// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);                        
                                                                                                       
EmailContent content = watermarker.getContent(EmailContent.class);                                     
for (EmailAttachment attachment : content.getAttachments())                                            
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
                                                                                                       
// Save changes                                                                                        
watermarker.save(Constants.OutMessageMsg);                                                             
                                                                                                       
watermarker.close();                                                                                   
```

## Advanced use cases

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
