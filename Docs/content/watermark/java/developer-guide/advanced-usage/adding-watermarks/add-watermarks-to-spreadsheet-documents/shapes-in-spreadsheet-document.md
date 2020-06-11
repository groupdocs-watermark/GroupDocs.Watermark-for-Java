---
id: shapes-in-spreadsheet-document
url: watermark/java/shapes-in-spreadsheet-document
title: Shapes in spreadsheet document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Extracting information about all shapes in an Excel document

[Search()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#search()) method searches watermarks of all mentioned types, but in some cases, it's necessary to analyze only one class of Excel objects. Following code sample shows how to get information about all the [shapes](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet#getShapes()) in an Excel document.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetGetShapesInformation**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                              
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: @"C:\Docs\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                            
                                                                                                                
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                  
for (SpreadsheetWorksheet worksheet : content.getWorksheets())                                                  
{                                                                                                               
    for (SpreadsheetShape shape : worksheet.getShapes())                                                        
    {                                                                                                           
        System.out.println(shape.getAutoShapeType());                                                           
        System.out.println(shape.getMsoDrawingType());                                                          
        System.out.println(shape.getText());                                                                    
        if (shape.getImage() != null)                                                                           
        {                                                                                                       
            System.out.println(shape.getImage().getWidth());                                                    
            System.out.println(shape.getImage().getHeight());                                                   
            System.out.println(shape.getImage().getBytes().length);                                             
        }                                                                                                       
                                                                                                                
        System.out.println(shape.getId());                                                                      
        System.out.println(shape.getAlternativeText());                                                         
        System.out.println(shape.getX());                                                                       
        System.out.println(shape.getY());                                                                       
        System.out.println(shape.getWidth());                                                                   
        System.out.println(shape.getHeight());                                                                  
        System.out.println(shape.getRotateAngle());                                                             
        System.out.println(shape.isWordArt());                                                                  
        System.out.println(shape.getName());                                                                    
    }                                                                                                           
}                                                                                                               
                                                                                                                
watermarker.close();                                                                                            
```

## Removing a particular shape

You can also remove a particular [shape](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet#getShapes()) from the worksheet as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetRemoveShape**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                  
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"   
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                
                                                                                                                    
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                      
                                                                                                                    
// Remove shape by index                                                                                            
content.getWorksheets().get_Item(0).getShapes().removeAt(0);                                                        
                                                                                                                    
// Remove shape by reference                                                                                        
content.getWorksheets().get_Item(0).getShapes().remove(content.getWorksheets().get_Item(0).getShapes().get_Item(0));
                                                                                                                    
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                     
                                                                                                                    
watermarker.close();                                                                                                
```

## Removing shapes with particular text formatting

You can also find and remove the shapes with a [particular text formatting](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#getFormattedTextFragments()) from an Excel document as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetRemoveTextShapesWithParticularTextFormatting**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                    
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"     
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                  
                                                                                                                      
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                        
for (SpreadsheetWorksheet section : content.getWorksheets())                                                          
{                                                                                                                     
    for (int i = section.getShapes().getCount() - 1; i >= 0; i--)                                                     
    {                                                                                                                 
        for (FormattedTextFragment fragment : section.getShapes().get_Item(i).getFormattedTextFragments())            
        {                                                                                                             
            if (fragment.getForegroundColor().equals(Color.getRed()) && fragment.getFont().getFamilyName() == "Arial")
            {                                                                                                         
                section.getShapes().removeAt(i);                                                                      
                break;                                                                                                
            }                                                                                                         
        }                                                                                                             
    }                                                                                                                 
}                                                                                                                     
                                                                                                                      
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                       
                                                                                                                      
watermarker.close();                                                                                                  
```

## Removing/replacing hyperlink associated with a particular shape

Using GroupDocs.Watermark for Java, you can also remove/replace hyperlink associated with a particular [shape](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setHyperlink(java.lang.String)) or [chart](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetChart#setHyperlink(java.lang.String)) inside an Excel document. Use following code sample to achieve this functionality.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetRemoveHyperlinks**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
                                                                                                                 
// Replace hyperlink                                                                                             
content.getWorksheets().get_Item(0).getCharts().get_Item(0).setHyperlink("https://www.aspose.com/");             
content.getWorksheets().get_Item(0).getShapes().get_Item(0).setHyperlink("https://www.groupdocs.com/");          
                                                                                                                 
// Remove hyperlink                                                                                              
content.getWorksheets().get_Item(1).getCharts().get_Item(0).setHyperlink(null);                                  
content.getWorksheets().get_Item(1).getShapes().get_Item(0).setHyperlink(null);                                  
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

{{< alert style="warning" >}}This feature is also supported for charts.{{< /alert >}}

## Replacing text for particular shapes

Since version 17.12, GroupDocs.Watermark supports replacing [text](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setText(java.lang.String)) for particular shapes in an Excel Worksheet. Following code sample shows the usage of this feature.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetReplaceTextForParticularShapes**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())                                   
{                                                                                                                
    if (shape.getText() == "© Aspose 2016")                                                                      
    {                                                                                                            
        shape.setText("© GroupDocs 2017");                                                                       
    }                                                                                                            
}                                                                                                                
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Replacing text for particular shapes with formatted text

You can also replace the [text](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setText(java.lang.String)) of the shapes with [formatted text](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#getFormattedTextFragments()) as shown in the following code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetReplaceTextWithFormattingForParticularShapes**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                                          
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"                           
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                                        
                                                                                                                                            
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                                              
for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())                                                              
{                                                                                                                                           
    if (shape.getText() == "© Aspose 2016")                                                                                                 
    {                                                                                                                                       
        shape.getFormattedTextFragments().clear();                                                                                          
        shape.getFormattedTextFragments().add("© GroupDocs 2017", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }                                                                                                                                       
}                                                                                                                                           
                                                                                                                                            
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                                             
                                                                                                                                            
watermarker.close();                                                                                                                        
```

## Replacing shape image

GroupDocs.Watermark also allows you to replace the [image](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setImage(com.groupdocs.watermark.contents.SpreadsheetWatermarkableImage)) of the particular shapes in an Excel Worksheet as shown in the following code sample. This feature is supported since version 17.12.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetReplaceImageOfParticularShapes**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
                                                                                                                 
File file = new File(Constants.TestPng);                                                                         
byte[] imageBytes = new byte[(int) file.length()];                                                               
FileInputStream inputStream = new FileInputStream(file);                                                         
inputStream.read(imageBytes);                                                                                    
inputStream.close();                                                                                             
                                                                                                                 
for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())                                   
{                                                                                                                
    if (shape.getImage() != null)                                                                                
    {                                                                                                            
        shape.setImage(new SpreadsheetWatermarkableImage(imageBytes));                                           
    }                                                                                                            
}                                                                                                                
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Setting background image for particular shapes

Since version 17.12, GroupDocs.Watermark enables you to set the [background image](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#getImageFillFormat()) for the particular shapes in an Excel Worksheet. Following code sample shows the usage of this feature.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetSetBackgroundImageForParticularShapes**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
File imageFile = new File(Constants.TestPng);                                                                    
byte[] imageBytes = new byte[(int) imageFile.length()];                                                          
InputStream imageInputStream = new FileInputStream(imageFile);                                                   
imageInputStream.read(imageBytes);                                                                               
imageInputStream.close();                                                                                        
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())                                   
{                                                                                                                
    if (shape.getText() == "© Aspose 2016")                                                                      
    {                                                                                                            
        shape.getImageFillFormat().setBackgroundImage(new SpreadsheetWatermarkableImage(imageBytes));            
        shape.getImageFillFormat().setTransparency(0.5);                                                         
        shape.getImageFillFormat().setTileAsTexture(true);                                                       
    }                                                                                                            
}                                                                                                                
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Updating shape properties

Since version 17.12, GroupDocs.Watermark also provides the feature of modifying properties ([setX()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setX(double)), [setY()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setY(double)), [setWidth()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setWidth(double)), [setHeight()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setHeight(double)), [setRotateAngle()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setRotateAngle(double)) or [setAlternativeText()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetShape#setAlternativeText(java.lang.String))) of particular shapes in an Excel Worksheet. Following code sample shows how to use this feature.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetUpdateShapeProperties**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
for (SpreadsheetShape shape : content.getWorksheets().get_Item(0).getShapes())                                   
{                                                                                                                
    if (shape.getText() == "© Aspose 2019")                                                                      
    {                                                                                                            
        shape.setAlternativeText("watermark");                                                                   
        shape.setRotateAngle(30);                                                                                
        shape.setX(200);                                                                                         
        shape.setY(200);                                                                                         
        shape.setWidth(400);                                                                                     
        shape.setHeight(100);                                                                                    
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
