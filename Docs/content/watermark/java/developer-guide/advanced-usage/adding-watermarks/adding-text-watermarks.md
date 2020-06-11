---
id: adding-text-watermarks
url: watermark/java/adding-text-watermarks
title: Adding text watermarks
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
Following code snippet shows how to add text watermark to a document. If the document consists of multiple parts (pages, worksheets, slides, frames etc), the watermark will be added to all of them.

**advanced\_usage.adding\_text\_watermarks.AddTextWatermark**

```csharp
// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
Watermarker watermarker = new Watermarker(Constants.InImagePng);                                   
                                                                                                   
// Initialize the font to be used for watermark                                                    
Font font = new Font("Arial", 19, FontStyle.Bold | FontStyle.Italic);                              
                                                                                                   
// Create the watermark object                                                                     
TextWatermark watermark = new TextWatermark("Test watermark", font);                               
                                                                                                   
// Set watermark properties                                                                        
watermark.setForegroundColor(Color.getRed());                                                      
watermark.setBackgroundColor(Color.getBlue());                                                     
watermark.setTextAlignment(TextAlignment.Right);                                                   
watermark.setOpacity(0.5);                                                                         
                                                                                                   
// Add watermark                                                                                   
watermarker.add(watermark);                                                                        
                                                                                                   
watermarker.save(Constants.OutImagePng);                                                           
                                                                                                   
watermarker.close();                                                                             
```

## Sizing and positioning of watermark

### Absolute watermark positioning

Using GroupDocs.Watermark, you can also add watermark to some absolute position in the document. Following example shows how to add a text watermark with absolute positioning using methods [set](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setX(double))[X](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/x)[,](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/x) [set](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setY(double))[Y](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/y)[,](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/x) [set](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setWidth(double))[Width](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/width) [and](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/x) [setHeight](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setHeight(double))[. The values of all properties for absolute sizing and positioning are measured in default document units.](https://apireference.groupdocs.com/net/watermark/groupdocs.watermark/watermark/properties/x)

**advanced\_usage.adding\_text\_watermarks.AddWatermarkToAbsolutePosition**

```csharp
// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
Watermarker watermarker = new Watermarker(Constants.InImagePng);                                   
                                                                                                   
Font font = new Font("Times New Roman", 8);                                                        
TextWatermark watermark = new TextWatermark("Test watermark", font);                               
                                                                                                   
// Set watermark coordinates                                                                       
watermark.setX(10);                                                                                
watermark.setY(20);                                                                                
                                                                                                   
// Set watermark size                                                                              
watermark.setWidth(100);                                                                           
watermark.setHeight(40);                                                                           
                                                                                                   
watermarker.add(watermark);                                                                        
watermarker.save(Constants.OutImagePng);                                                           
                                                                                                   
watermarker.close();                                                                             
```

{{< alert style="warning" >}}Note that the origin of coordinates may be different for different document types (relative positioning doesn't have these specifics and can be used as a unified positioning approach).{{< /alert >}}

Following are the origin of the coordinates for different formats of the documents.

| Document Format | Unit of Measure | Origin of Coordinates |
| --- | --- | --- |
| PDF | Point | Left bottom corner of page |
| WordProcessing | Point | Left top corner of page  |
| Spreadsheet | Point | Left top corner of worksheet  |
| Presentation | Point | Left top corner of slide  |
| Image | Pixel | Left top corner of image (frame)  |
| Diagram | Point | Left top corner of page |

### Relative watermark positioning 

Instead of exact coordinates, you can also use parent relative alignment. Furthermore, you can also set offset from parent's borders by using [Margins](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#getMargins()) property as shown in below example. Following example shows how to align the watermark vertically and horizontally.

**advanced\_usage.adding\_text\_watermarks.AddWatermarkToRelativePosition**

```csharp
// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png
Watermarker watermarker = new Watermarker(Constants.InImagePng);                                  
                                                                                                  
Font font = new Font("Calibri", 12);                                                              
TextWatermark watermark = new TextWatermark("Test watermark", font);                              
watermark.setHorizontalAlignment(HorizontalAlignment.Right);                                      
watermark.setVerticalAlignment(VerticalAlignment.Bottom);                                         
                                                                                                  
// Set absolute margins. Values are measured in document units.                                   
watermark.getMargins().setRight(10);                                                              
watermark.getMargins().setBottom(5);                                                              
                                                                                                  
watermarker.add(watermark);                                                                       
watermarker.save(Constants.OutImagePng);                                                          
                                                                                                  
watermarker.close();                                                                            
```

{{< alert style="warning" >}}Excel worksheets don't have explicit borders, therefore, the most right bottom non-empty cell is used to determine working area size.{{< /alert >}}

### Using [setMarginType](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/Margins#setMarginType(int))

In the example above, absolute margin values are used. This means that margins are measured in document units. But you can set relative margins for a watermark as well (as shown in below example).

**advanced\_usage.adding\_text\_watermarks.AddWatermarkWithMarginType**

```csharp
// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
Watermarker watermarker = new Watermarker(Constants.InImagePng);                                   
                                                                                                   
Font font = new Font("Calibri", 12);                                                               
TextWatermark watermark = new TextWatermark("Test watermark", font);                               
watermark.setHorizontalAlignment(HorizontalAlignment.Right);                                       
watermark.setVerticalAlignment(VerticalAlignment.Bottom);                                          
                                                                                                   
// Set relative margins. Margin value will be interpreted as a portion                             
// of appropriate parent dimension. If this type is chosen, margin value                           
// must be between 0.0 and 1.0.                                                                    
watermark.getMargins().setMarginType(MarginType.RelativeToParentDimensions);                       
watermark.getMargins().setRight(0.1);                                                              
watermark.getMargins().setBottom(0.2);                                                             
                                                                                                   
watermarker.add(watermark);                                                                        
watermarker.save(Constants.OutImagePng);                                                           
                                                                                                   
watermarker.close();                                                                             
```

### Size types

In most cases, to add good looking watermark, you should consider the size of the page/slide/frame on which it will be placed. [setSizingType](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setSizingType(int)) and [setScaleFactor](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setScaleFactor(double)) methods can be used to scale the watermark depending on the parent size.

**advanced\_usage.adding\_text\_watermarks.AddWatermarkWithSizeType**

```csharp
// Constants.InImagePng is an absolute or relative path to your document. Ex: "C:\\Docs\\image.png"
Watermarker watermarker = new Watermarker(Constants.InImagePng);                                   
                                                                                                   
Font font = new Font("Calibri", 12);                                                               
TextWatermark watermark = new TextWatermark("This is a test watermark", font);                     
                                                                                                   
// Set sizing type                                                                                 
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                       
                                                                                                   
// Set watermark scale                                                                             
watermark.setScaleFactor(0.5);                                                                     
                                                                                                   
watermarker.add(watermark);                                                                        
watermarker.save(Constants.OutImagePng);                                                           
                                                                                                   
watermarker.close();                                                                             
```

{{< alert style="info" >}}Using of relative size and positioning is the simplest way to add watermark to a document of any type.{{< /alert >}}

### Watermark rotation

GroupDocs.Watermark API also supports rotation of the watermark. You can use [setRotateAngle](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setRotateAngle(double)) method to define watermark rotation angle in degrees. A positive value means clockwise rotation.

**advanced\_usage.adding\_text\_watermarks.AddTextWatermarkWithRotationAngle**

```csharp
// Constants.InTestDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\test.docx"
Watermarker watermarker = new Watermarker(Constants.InTestDocx);                                   
                                                                                                   
Font font = new Font("Calibri", 8);                                                                
TextWatermark watermark = new TextWatermark("Test watermark", font);                               
watermark.setHorizontalAlignment(HorizontalAlignment.Right);                                       
watermark.setVerticalAlignment(VerticalAlignment.Top);                                             
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                       
watermark.setScaleFactor(0.5);                                                                     
                                                                                                   
// Set rotation angle                                                                              
watermark.setRotateAngle(45);                                                                      
                                                                                                   
watermarker.add(watermark);                                                                        
watermarker.save(Constants.OutTestDocx);                                                           
                                                                                                   
watermarker.close();                                                                             
```

If rotation angle is set, it is assumed that watermark size is equal to axis-aligned bounding box size. The following picture illustrates what is the watermark bounding box and how it is used for sizing and positioning. The picture shows a result of execution of the above code snippet. The actual watermark bounds are colored in blue and the bounding box is colored in red. As you can see, the bounding box size is used to calculate watermark relative size.

![](watermark/java/images/adding-text-watermarks.jpg)

### Considering parent margins

For most document formats you can set page margins when working with a document. By default, GroupDocs.Watermark ignores document margins and uses maximum available space for watermarking as shown in below image.

![](watermark/java/images/adding-text-watermarks_1.png)

As you can see, the watermark goes beyond page margins. To change this behavior, call [setConsiderParentMargins](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermark#setConsiderParentMargins(boolean)) method with true (as shown in below example).

**advanced\_usage.adding\_text\_watermarks.AddWatermarkWithParentMargin**

```csharp
// Constants.InInputVsdx is an absolute or relative path to your document. Ex: "C:\\Docs\\input.vsdx"
Watermarker watermarker = new Watermarker(Constants.InInputVsdx);                                    
                                                                                                     
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 42));                
watermark.setHorizontalAlignment(HorizontalAlignment.Right);                                         
watermark.setVerticalAlignment(VerticalAlignment.Top);                                               
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                         
watermark.setScaleFactor(1);                                                                         
watermark.setRotateAngle(45);                                                                        
watermark.setForegroundColor(Color.getRed());                                                        
watermark.setBackgroundColor(Color.getAqua());                                                       
                                                                                                     
// Add watermark considering parent margins                                                          
watermark.setConsiderParentMargins(true);                                                            
                                                                                                     
watermarker.add(watermark);                                                                          
watermarker.save(Constants.OutInputVsdx);                                                            
                                                                                                     
watermarker.close();                                                                               
```

Now, the watermark is aligned with respect to page margins.

![](watermark/java/images/adding-text-watermarks_2.png)

## Watermark in documents of different types

Watermarks in documents of different types are represented by different objects. Some of these objects do not support some watermark properties. For example, the background color can not be set for WordArt object which is used as text watermark in a Word document. The full list of supported properties for all document types is available at [Features Overview]({{< ref "watermark/java/getting-started/features-overview.md" >}}).

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
