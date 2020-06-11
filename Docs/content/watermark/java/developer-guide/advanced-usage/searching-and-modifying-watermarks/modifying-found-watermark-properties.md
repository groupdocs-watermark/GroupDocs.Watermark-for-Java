---
id: modifying-found-watermark-properties
url: watermark/java/modifying-found-watermark-properties
title: Modifying found watermark properties
weight: 3
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
GroupDocs.Watermark also allows you to replace text and image in the found possible watermarks. Following sections will show you how to replace text and image of a found watermark.

## Replacing text

To replace text of the found watermarks, loop through the possible watermarks in the [watermark collection](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.search/PossibleWatermarkCollection) and call [setText()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.search/PossibleWatermark#setText(java.lang.String)) method as shown in the following code sample.

**advanced\_usage.searching\_and\_modifying\_watermarks.EditTextInFoundWatermarks**

```csharp
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                      
                                                                                                         
TextSearchCriteria searchCriteria = new TextSearchCriteria("test", false);                               
PossibleWatermarkCollection watermarks = watermarker.search(searchCriteria);                             
for (PossibleWatermark watermark : watermarks)                                                           
{                                                                                                        
    try                                                                                                  
    {                                                                                                    
        // Edit text                                                                                     
        watermark.setText("passed");                                                                     
    }                                                                                                    
    catch (Exception e)                                                                                  
    {                                                                                                    
        // Found entity may not support text editing                                                     
        // Passed argument can have inappropriate value                                                  
        // Process such cases here                                                                       
    }                                                                                                    
}                                                                                                        
                                                                                                         
// Save document                                                                                         
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

## Replacing text with formatting

You can also replace the watermark's text with [formatting](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.search/PossibleWatermark#getFormattedTextFragments()) as shown in the below code sample.

**advanced\_usage.searching\_and\_modifying\_watermarks.EditTextWithFormattingInFoundWatermarks**

```csharp
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"                             
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                                                   
                                                                                                                                      
TextSearchCriteria searchCriteria = new TextSearchCriteria("test", false);                                                            
PossibleWatermarkCollection watermarks = watermarker.search(searchCriteria);                                                          
for (PossibleWatermark watermark : watermarks)                                                                                        
{                                                                                                                                     
    try                                                                                                                               
    {                                                                                                                                 
        // Edit text                                                                                                                  
        watermark.getFormattedTextFragments().clear();                                                                                
        watermark.getFormattedTextFragments().add("passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }                                                                                                                                 
    catch (Exception e)                                                                                                               
    {                                                                                                                                 
        // Found entity may not support text editing                                                                                  
        // Passed arguments can have inappropriate value                                                                              
        // Process such cases here                                                                                                    
    }                                                                                                                                 
}                                                                                                                                     
                                                                                                                                      
// Save document                                                                                                                      
watermarker.save(Constants.OutDocumentPdf);                                                                                           
                                                                                                                                      
watermarker.close();                                                                                                                  
```

## Replacing image

Following code sample shows how to replace the image of the found watermarks using GroupDocs.Watermark.

**advanced\_usage.searching\_and\_modifying\_watermarks.ReplacesImageInFoundWatermarks**

```csharp
File imageFile = new File(Constants.ImagePng);                                                           
byte[] imageData = new byte[(int) imageFile.length()];                                                   
InputStream imageInputStream = new FileInputStream(imageFile);                                           
imageInputStream.read(imageData);                                                                        
imageInputStream.close();                                                                                
                                                                                                         
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                      
                                                                                                         
// Search watermark matching a particular image                                                          
SearchCriteria searchCriteria = new ImageDctHashSearchCriteria(Constants.LogoBmp);                       
PossibleWatermarkCollection watermarks = watermarker.search(searchCriteria);                             
for (PossibleWatermark watermark : watermarks)                                                           
{                                                                                                        
    try                                                                                                  
    {                                                                                                    
        // Replace image                                                                                 
        watermark.setImageData(imageData);                                                               
    }                                                                                                    
    catch (Exception e)                                                                                  
    {                                                                                                    
        // Found entity may not support image replacement                                                
        // Passed image can have inappropriate format                                                    
        // Process such cases here                                                                       
    }                                                                                                    
}                                                                                                        
                                                                                                         
// Save document                                                                                         
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
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
