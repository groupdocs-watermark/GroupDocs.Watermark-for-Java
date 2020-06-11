---
id: email-attachments
url: watermark/java/email-attachments
title: Email attachments
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Extracting all attachments from email message

GroupDocs.Watermark allows you to get the information about the [attachments](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/EmailContent#getAttachments()) in an email message. Below is the code snippet for extracting attachments from Email.

**advanced\_usage.add\_watermarks\_to\_email\_attachments.EmailExtractAllAttachments**

```csharp
EmailLoadOptions loadOptions = new EmailLoadOptions();                                                       
// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"      
Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);                              
                                                                                                             
EmailContent content = watermarker.getContent(EmailContent.class);                                           
for (EmailAttachment attachment : content.getAttachments())                                                  
{                                                                                                            
    System.out.println("Name: " + attachment.getName());                                                     
    System.out.println("File format: " + attachment.getDocumentInfo().getFileType());                        
                                                                                                             
    FileOutputStream outputStream = new FileOutputStream(Constants.OutputPath + "\\" + attachment.getName());
    outputStream.write(attachment.getContent());                                                             
    outputStream.close();                                                                                    
}                                                                                                            
                                                                                                             
watermarker.close();                                                                                         
```

## Removing particular attachment from email message

Using GroupDocs.Watermark, you can [remove](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.common/RemoveOnlyListBase#remove(T)) any particular attachment from an email message. Below is the code for removing specific attachment:

**advanced\_usage.add\_watermarks\_to\_email\_attachments.EmailRemoveAttachment**

```csharp
EmailLoadOptions loadOptions = new EmailLoadOptions();                                                         
// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"        
Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);                                
                                                                                                               
EmailContent content = watermarker.getContent(EmailContent.class);                                             
for (int i = content.getAttachments().getCount() - 1; i >= 0; i--)                                             
{                                                                                                              
    EmailAttachment attachment = content.getAttachments().get_Item(i);                                         
                                                                                                               
    // Remove all attached files with a particular name and format                                             
    if (attachment.getName().contains("sample") && attachment.getDocumentInfo().getFileType() == FileType.DOCX)
    {                                                                                                          
        content.getAttachments().removeAt(i);                                                                  
    }                                                                                                          
}                                                                                                              
                                                                                                               
// Save changes                                                                                                
watermarker.save(Constants.OutMessageMsg);                                                                     
                                                                                                               
watermarker.close();                                                                                           
```

## Adding attachment to email message

You can also add attachments to the email messages using GroupDocs.Watermark. Following is the code sample for adding an attachment:

**advanced\_usage.add\_watermarks\_to\_email\_attachments.EmailAddAttachment**

```csharp
EmailLoadOptions loadOptions = new EmailLoadOptions();                                                 
// Constants.InMessageMsg is an absolute or relative path to your document. Ex: "C:\\Docs\\message.msg"
Watermarker watermarker = new Watermarker(Constants.InMessageMsg, loadOptions);                        
                                                                                                       
EmailContent content = watermarker.getContent(EmailContent.class);                                     
                                                                                                       
File attachmentFile = new File(Constants.InSampleMsg);                                                 
byte[] attachmentBytes = new byte[(int) attachmentFile.length()];                                      
InputStream attachmentInputStream = new FileInputStream(attachmentFile);                               
attachmentInputStream.read(attachmentBytes);                                                           
attachmentInputStream.close();                                                                         
                                                                                                       
content.getAttachments().add(attachmentBytes, "sample.msg");                                           
                                                                                                       
// Save changes                                                                                        
watermarker.save(Constants.OutMessageMsg);                                                             
                                                                                                       
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
