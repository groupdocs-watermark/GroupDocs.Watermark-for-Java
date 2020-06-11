---
id: existing-objects-in-diagram-document
url: watermark/java/existing-objects-in-diagram-document
title: Existing objects in diagram document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The watermarks in Visio documents are usually represented by shapes. But sometimes document headers&footers can also be used to display text that can be considered as the watermark. GroupDocs.Watermark API allows you to find and remove watermarks of both types in Visio document.

## Removing watermark from a particular page

Removing watermark from a particular page of a Visio document using GroupDocs.Watermark consists of following steps.

1.  Load the document
2.  Create and initialize image/text search criteria
3.  Find possible watermarks
4.  Remove found watermarks
5.  Save the document

Following code sample shows how to remove watermark from a particular page.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramRemoveWatermark**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                                                         
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"                          
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                                                   
                                                                                                                                   
DiagramContent content = watermarker.getContent(DiagramContent.class);                                                             
                                                                                                                                   
// Initialize search criteria                                                                                                      
ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Constants.LogoPng);                                       
TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Company Name");                                                    
                                                                                                                                   
// Call FindWatermarks method for the first page                                                                                   
PossibleWatermarkCollection possibleWatermarks = content.getPages().get_Item(0).search(textSearchCriteria.or(imageSearchCriteria));
                                                                                                                                   
// Remove all found watermarks                                                                                                     
possibleWatermarks.clear();                                                                                                        
                                                                                                                                   
watermarker.save(Constants.OutDiagramVsdx);                                                                                        
                                                                                                                                   
watermarker.close();                                                                                                               
```

## Working with shapes

### Extracting information about all shapes

[Search()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#search()) method searches watermarks of all mentioned types, but in some cases, it's necessary to analyze only one type of Visio objects. Following code sample shows how to get information about all the shapes in a Visio document.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramGetShapesInformation**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                               
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                         
                                                                                                         
DiagramContent content = watermarker.getContent(DiagramContent.class);                                   
for (DiagramPage page : content.getPages())                                                              
{                                                                                                        
    for (DiagramShape shape : page.getShapes())                                                          
    {                                                                                                    
        if (shape.getImage() != null)                                                                    
        {                                                                                                
            System.out.println(shape.getImage().getWidth());                                             
            System.out.println(shape.getImage().getHeight());                                            
            System.out.println(shape.getImage().getBytes().length);                                      
        }                                                                                                
                                                                                                         
        System.out.println(shape.getName());                                                             
        System.out.println(shape.getX());                                                                
        System.out.println(shape.getY());                                                                
        System.out.println(shape.getWidth());                                                            
        System.out.println(shape.getHeight());                                                           
        System.out.println(shape.getRotateAngle());                                                      
        System.out.println(shape.getText());                                                             
        System.out.println(shape.getId());                                                               
    }                                                                                                    
}                                                                                                        
                                                                                                         
watermarker.close();                                                                                     
```

### Removing a particular shape

You can also remove a particular shape from a page using GroupDocs.Watermark API (as shown in the sample code below).

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramRemoveShape()**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                                
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: @"C:\Docs\diagram.vsdx"  
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                          
                                                                                                          
DiagramContent content = watermarker.getContent(DiagramContent.class);                                    
                                                                                                          
// Remove shape by index                                                                                  
content.getPages().get_Item(0).getShapes().removeAt(0);                                                   
                                                                                                          
// Remove shape by reference                                                                              
content.getPages().get_Item(0).getShapes().remove(content.getPages().get_Item(0).getShapes().get_Item(0));
                                                                                                          
watermarker.save(Constants.OutDiagramVsdx);                                                               
                                                                                                          
watermarker.close();                                                                                      
```

### Removing shapes with particular text formatting

You can also find and remove the shapes with a particular text formatting from a Visio document as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramRemoveTextShapesWithParticularTextFormatting**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                                            
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"             
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                                      
                                                                                                                      
DiagramContent content = watermarker.getContent(DiagramContent.class);                                                
for (DiagramPage page : content.getPages())                                                                           
{                                                                                                                     
    for (int i = page.getShapes().getCount() - 1; i >= 0; i--)                                                        
    {                                                                                                                 
        for (FormattedTextFragment fragment : page.getShapes().get_Item(i).getFormattedTextFragments())               
        {                                                                                                             
            if (fragment.getForegroundColor().equals(Color.getRed()) && fragment.getFont().getFamilyName() == "Arial")
            {                                                                                                         
                page.getShapes().removeAt(i);                                                                         
                break;                                                                                                
            }                                                                                                         
        }                                                                                                             
    }                                                                                                                 
}                                                                                                                     
                                                                                                                      
watermarker.save(Constants.OutDiagramVsdx);                                                                           
                                                                                                                      
watermarker.close();                                                                                                  
```

### Removing hyperlink associated with a particular shape

Using GroupDocs.Watermark for Java, you can also remove hyperlink associated with a particular shape inside a Visio document. Use following code sample to achieve this functionality.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramRemoveHyperlinks**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                               
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                         
                                                                                                         
DiagramContent content = watermarker.getContent(DiagramContent.class);                                   
DiagramShape shape = content.getPages().get_Item(0).getShapes().get_Item(0);                             
for (int i = shape.getHyperlinks().getCount() - 1; i >= 0; i--)                                          
{                                                                                                        
    if (shape.getHyperlinks().get_Item(i).getAddress().contains("http://someurl.com"))                   
    {                                                                                                    
        shape.getHyperlinks().removeAt(i);                                                               
    }                                                                                                    
}                                                                                                        
                                                                                                         
watermarker.save(Constants.OutDiagramVsdx);                                                              
                                                                                                         
watermarker.close();                                                                                     
```

### Replacing text for particular shapes

Since version 18.1. GroupDocs.Watermark allows you to replace the text for particular shapes. Following code sample shows how to replace shapes' text.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramReplaceTextForParticularShapes**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                              
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: @"C:\Docs\diagram.vsdx"
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                        
                                                                                                        
DiagramContent content = watermarker.getContent(DiagramContent.class);                                  
for (DiagramShape shape : content.getPages().get_Item(0).getShapes())                                   
{                                                                                                       
    if (shape.getText() != null && shape.getText().contains("© Aspose 2016"))                           
    {                                                                                                   
        shape.setText("© GroupDocs 2017");                                                              
    }                                                                                                   
}                                                                                                       
                                                                                                        
// Save changes                                                                                         
watermarker.save(Constants.OutDiagramVsdx);                                                             
                                                                                                        
watermarker.close();                                                                                    
```

### Replacing text for particular shapes with formatted text

You can also replace the text with a formatted text as shown in the following code sample.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramReplaceTextWithFormatting**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                                                                  
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"                                   
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                                                            
                                                                                                                                            
DiagramContent content = watermarker.getContent(DiagramContent.class);                                                                      
for (DiagramShape shape : content.getPages().get_Item(0).getShapes())                                                                       
{                                                                                                                                           
    if (shape.getText() != null && shape.getText().contains("© Aspose 2016"))                                                               
    {                                                                                                                                       
        shape.getFormattedTextFragments().clear();                                                                                          
        shape.getFormattedTextFragments().add("© GroupDocs 2017", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }                                                                                                                                       
}                                                                                                                                           
                                                                                                                                            
// Save changes                                                                                                                             
watermarker.save(Constants.OutDiagramVsdx);                                                                                                 
                                                                                                                                            
watermarker.close();                                                                                                                        
```

### Replacing shape image

Since version 18.1. GroupDocs.Watermark also allows you to replace the image of particular shapes as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramReplaceShapeImage**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                                
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx" 
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                          
                                                                                                          
DiagramContent content = watermarker.getContent(DiagramContent.class);                                    
for (DiagramShape shape : content.getPages().get_Item(0).getShapes())                                     
{                                                                                                         
    if (shape.getImage() != null)                                                                         
    {                                                                                                     
        File imageFile = new File(Constants.TestPng);                                                     
        byte[] imageBytes = new byte[(int) imageFile.length()];                                           
        InputStream imageInputStream = new FileInputStream(imageFile);                                    
        imageInputStream.read(imageBytes);                                                                
        imageInputStream.close();                                                                         
                                                                                                          
        shape.setImage(new DiagramWatermarkableImage(imageBytes));                                        
    }                                                                                                     
}                                                                                                         
                                                                                                          
// Save changes                                                                                           
watermarker.save(Constants.OutDiagramVsdx);                                                               
                                                                                                          
watermarker.close();                                                                                      
```

## Working with headers and footers

### Extracting information about all headers and footers

The API allows you to extract information about all the headers and footers in a Visio document using following code.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramGetHeaderFooterInformation**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                               
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                         
                                                                                                         
DiagramContent content = watermarker.getContent(DiagramContent.class);                                   
                                                                                                         
// Get header&footer font settings                                                                       
System.out.println(content.getHeaderFooter().getFont().getFamilyName());                                 
System.out.println(content.getHeaderFooter().getFont().getSize());                                       
System.out.println(content.getHeaderFooter().getFont().getBold());                                       
System.out.println(content.getHeaderFooter().getFont().getItalic());                                     
System.out.println(content.getHeaderFooter().getFont().getUnderline());                                  
System.out.println(content.getHeaderFooter().getFont().getStrikeout());                                  
                                                                                                         
// Get text contained in headers&footers                                                                 
System.out.println(content.getHeaderFooter().getHeaderLeft());                                           
System.out.println(content.getHeaderFooter().getHeaderCenter());                                         
System.out.println(content.getHeaderFooter().getHeaderRight());                                          
System.out.println(content.getHeaderFooter().getFooterLeft());                                           
System.out.println(content.getHeaderFooter().getFooterCenter());                                         
System.out.println(content.getHeaderFooter().getFooterRight());                                          
                                                                                                         
// Get text color                                                                                        
System.out.println(content.getHeaderFooter().getTextColor().toArgb());                                   
                                                                                                         
// Get header&footer margins                                                                             
System.out.println(content.getHeaderFooter().getFooterMargin());                                         
System.out.println(content.getHeaderFooter().getHeaderMargin());                                         
                                                                                                         
watermarker.close();                                                                                     
```

### Removing or replacing a particular header and footer

Following code sample shows how to remove and replace a particular header and footer in a Visio document.

**advanced\_usage.add\_watermarks\_to\_diagrams.DiagramRemoveOrReplaceHeaderFooter**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();                                               
// Constants.InDiagramVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vsdx"
Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx, loadOptions);                         
                                                                                                         
DiagramContent content = watermarker.getContent(DiagramContent.class);                                   
                                                                                                         
// Remove header                                                                                         
content.getHeaderFooter().setHeaderCenter(null);                                                         
                                                                                                         
// Replace footer                                                                                        
content.getHeaderFooter().setFooterCenter("Footer center");                                              
content.getHeaderFooter().getFont().setSize(19);                                                         
content.getHeaderFooter().getFont().setFamilyName("Calibri");                                            
content.getHeaderFooter().setTextColor(Color.getRed());                                                  
                                                                                                         
watermarker.save(Constants.OutDiagramVsdx);                                                              
                                                                                                         
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
