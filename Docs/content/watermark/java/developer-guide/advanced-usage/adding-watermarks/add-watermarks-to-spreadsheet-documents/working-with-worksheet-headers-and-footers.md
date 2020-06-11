---
id: working-with-worksheet-headers-and-footers
url: watermark/java/working-with-worksheet-headers-and-footers
title: Working with worksheet headers and footers
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Extracting information about all headers and footers in an Excel document

You can extract [information](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet#getHeadersFooters()) about all the headers and footers in an Excel document as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetGetHeaderFooterInformation**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
                                                                                                                 
for (SpreadsheetWorksheet worksheet : content.getWorksheets())                                                   
{                                                                                                                
    for (SpreadsheetHeaderFooter headerFooter : worksheet.getHeadersFooters())                                   
    {                                                                                                            
        System.out.println(headerFooter.getHeaderFooterType());                                                  
        for (SpreadsheetHeaderFooterSection section : headerFooter.getSections())                                
        {                                                                                                        
            System.out.println(section.getSectionType());                                                        
            if (section.getImage() != null)                                                                      
            {                                                                                                    
                System.out.println(section.getImage().getWidth());                                               
                System.out.println(section.getImage().getHeight());                                              
                System.out.println(section.getImage().getBytes().length);                                        
            }                                                                                                    
                                                                                                                 
            System.out.println(section.getScript());                                                             
        }                                                                                                        
    }                                                                                                            
}                                                                                                                
                                                                                                                 
watermarker.close();                                                                                             
```

## Clearing a particular header and footer

You can also clear a particular [header and footer](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetHeaderFooterSection) using GroupDocs.Watermark as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetClearHeaderFooter**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                              
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: @"C:\Docs\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                            
                                                                                                                
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                  
                                                                                                                
SpreadsheetHeaderFooterSectionCollection sections = content                                                     
        .getWorksheets().get_Item(0)                                                                            
        .getHeadersFooters().getByOfficeHeaderFooterType(OfficeHeaderFooterType.HeaderPrimary)                  
        .getSections();                                                                                         
for (SpreadsheetHeaderFooterSection section : sections)                                                         
{                                                                                                               
    section.setScript(null);                                                                                    
    section.setImage(null);                                                                                     
}                                                                                                               
                                                                                                                
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                 
                                                                                                                
watermarker.close();                                                                                            
```

## Clearing a particular section of header and footer

Using GroupDocs.Watermark, you can also clear a particular section of [header and footer](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetHeaderFooterSection) as shown in the sample code below.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetClearSectionOfHeaderFooter**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
                                                                                                                 
SpreadsheetHeaderFooterSection section = content                                                                 
        .getWorksheets().get_Item(0)                                                                             
        .getHeadersFooters().getByOfficeHeaderFooterType(OfficeHeaderFooterType.HeaderEven)                      
        .getSections().getBySpreadsheetHeaderFooterSectionType(SpreadsheetHeaderFooterSectionType.Left);         
section.setImage(null);                                                                                          
section.setScript(null);                                                                                         
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Adding watermark to all images in header and footer

GroupDocs.Watermark enables you to add watermark to [images](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetHeaderFooterSection#getImage()) inside any header and footer. You can use below code sample to achieve this.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkToImagesInHeaderFooter**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
// Initialize image or text watermark                                                                            
TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));                            
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                                    
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                        
watermark.setRotateAngle(45);                                                                                    
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                                     
watermark.setScaleFactor(1);                                                                                     
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
for (SpreadsheetWorksheet worksheet : content.getWorksheets())                                                   
{                                                                                                                
    for (SpreadsheetHeaderFooter headerFooter : worksheet.getHeadersFooters())                                   
    {                                                                                                            
        for (SpreadsheetHeaderFooterSection section : headerFooter.getSections())                                
        {                                                                                                        
            if (section.getImage() != null)                                                                      
            {                                                                                                    
                // Add watermark to the image                                                                    
                section.getImage().add(watermark);                                                               
            }                                                                                                    
        }                                                                                                        
    }                                                                                                            
}                                                                                                                
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
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
