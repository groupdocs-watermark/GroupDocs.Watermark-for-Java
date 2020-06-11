---
id: add-watermarks-to-spreadsheet-documents
url: watermark/java/add-watermarks-to-spreadsheet-documents
title: Add watermarks to spreadsheet documents
weight: 8
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Adding watermark to a particular worksheet 

GroupDocs.Watermark provides an easy way to add watermark to the worksheets of any Excel document. Adding watermark to a particular Excel worksheet using GroupDocs.Watermark consists of following steps.

1.  Load the document
2.  Create and initialize watermark object
3.  Set watermark properties
4.  Create [SpreadsheetWatermarkShapeOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkShapeOptions) and call [setWorksheetIndex()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkShapeOptions#setWorksheetIndex(int))
5.  Add watermark to the worksheet
6.  Save the document

Following code shows how to add watermark to a particular worksheet.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkToWorksheet**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
// Add text watermark to the first worksheet                                                                     
TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));                         
SpreadsheetWatermarkShapeOptions textWatermarkOptions = new SpreadsheetWatermarkShapeOptions();                  
textWatermarkOptions.setWorksheetIndex(0);                                                                       
watermarker.add(textWatermark, textWatermarkOptions);                                                            
                                                                                                                 
// Add image watermark to the second worksheet                                                                   
ImageWatermark imageWatermark = new ImageWatermark(Constants.LogoJpg);                                           
                                                                                                                 
SpreadsheetWatermarkShapeOptions imageWatermarkOptions = new SpreadsheetWatermarkShapeOptions();                 
imageWatermarkOptions.setWorksheetIndex(1);                                                                      
watermarker.add(imageWatermark, imageWatermarkOptions);                                                          
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
imageWatermark.close();                                                                                          
```

## Getting size of content area

If for some reasons you want to use absolute sizing and positioning, you may also need to get the [width](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet#getContentAreaWidth()) and the [height](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet#getContentAreaHeight()) of the content area (range of cells which contains data).

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetGetContentAreaDimensions**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
                                                                                                                 
// Get the size of content area                                                                                  
System.out.println(content.getWorksheets().get_Item(0).getContentAreaHeight());                                  
System.out.println(content.getWorksheets().get_Item(0).getContentAreaWidth());                                   
                                                                                                                 
// Get the size of particular cell                                                                               
System.out.println(content.getWorksheets().get_Item(0).getColumnWidth(0));                                       
System.out.println(content.getWorksheets().get_Item(0).getRowHeight(0));                                         
                                                                                                                 
watermarker.close();                                                                                             
```

## Adding watermark to the images from a particular worksheet

Using GroupDocs.Watermark, you can add watermark to the images that belong to a particular worksheet using method [findImages()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/ContentPart#findImages()) of  [SpreadsheetWorksheet](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/SpreadsheetWorksheet).

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkToWorksheetImages**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));                            
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                                    
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                        
watermark.setRotateAngle(45);                                                                                    
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                                     
watermark.setScaleFactor(1);                                                                                     
                                                                                                                 
// Get all images from the first worksheet                                                                       
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                   
WatermarkableImageCollection images = content.getWorksheets().get_Item(0).findImages();                          
                                                                                                                 
// Add watermark to all found images                                                                             
for (WatermarkableImage image : images)                                                                          
{                                                                                                                
    image.add(watermark);                                                                                        
}                                                                                                                
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

## Different types of watermark in Excel documents

### Shapes

When you're calling [add()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#add(com.groupdocs.watermark.Watermark,%20com.groupdocs.watermark.options.WatermarkOptions)) method of [Watermarker](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker) class with [SpreadsheetWatermarkShapeOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkShapeOptions) parameter, simple shape is added to an Excel document. Besides [SpreadsheetWatermarkShapeOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkShapeOptions) there is [SpreadsheetWatermarkModernWordArtOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkModernWordArtOptions) type which is used only with [TextWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark). Both options add watermark to an Excel document as a shape, however, there are some differences. When [TextWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark) is added with [SpreadsheetWatermarkShapeOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkShapeOptions) there options, it looks and behaves like WordArt object added in Excel'2003, and [SpreadsheetWatermarkModernWordArtOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkModernWordArtOptions) option adds text watermark that looks and behaves like Excel'2013 WordArt object.

The code sample below shows how to add modern WordArt watermark to Excel document worksheet.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddModernWordArdWatermark**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));                         
SpreadsheetWatermarkModernWordArtOptions options = new SpreadsheetWatermarkModernWordArtOptions();               
options.setWorksheetIndex(0);                                                                                    
                                                                                                                 
watermarker.add(textWatermark, options);                                                                         
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

### Shape additional options

The API also provides the feature to set some additional options ([setName()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkBaseOptions#setName(java.lang.String)), [setAlternativeText()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkBaseOptions#setAlternativeText(java.lang.String)) and [setLocked()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetWatermarkBaseOptions#setLocked(boolean))) when adding shape watermark to Excel worksheet (as shown in the below sample).

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkUsingShapeSettings**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));                         
SpreadsheetWatermarkShapeOptions options = new SpreadsheetWatermarkShapeOptions();                               
                                                                                                                 
// Set the shape name                                                                                            
options.setName("Shape 1");                                                                                      
                                                                                                                 
// Set the descriptive (alternative) text that will be associated with the shape                                 
options.setAlternativeText("Test watermark");                                                                    
                                                                                                                 
// Editing of the shape in Excel is forbidden                                                                    
options.setLocked(true);                                                                                         
                                                                                                                 
watermarker.add(watermark, options);                                                                             
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

### Text effects

You can also apply [text effects](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetTextEffects) when adding shape watermark in Excel worksheet as shown in below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkWithTextEffects**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));                         
                                                                                                                 
SpreadsheetTextEffects effects = new SpreadsheetTextEffects();                                                   
effects.getLineFormat().setEnabled(true);                                                                        
effects.getLineFormat().setColor(Color.getRed());                                                                
effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);                                                
effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);                                                    
effects.getLineFormat().setWeight(1);                                                                            
                                                                                                                 
SpreadsheetWatermarkShapeOptions options = new SpreadsheetWatermarkShapeOptions();                               
options.setEffects(effects);                                                                                     
                                                                                                                 
watermarker.add(watermark, options);                                                                             
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

### Image effects

The API also allows you to apply [image effects](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetImageEffects) to the shape watermark using below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkWithImageEffects**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);                                                
                                                                                                                 
SpreadsheetImageEffects effects = new SpreadsheetImageEffects();                                                 
effects.setBrightness(0.7);                                                                                      
effects.setContrast(0.6);                                                                                        
effects.setChromaKey(Color.getRed());                                                                            
effects.getBorderLineFormat().setEnabled(true);                                                                  
effects.getBorderLineFormat().setWeight(1);                                                                      
                                                                                                                 
SpreadsheetWatermarkShapeOptions options = new SpreadsheetWatermarkShapeOptions();                               
options.setEffects(effects);                                                                                     
                                                                                                                 
watermarker.add(watermark, options);                                                                             
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

### Worksheet backgrounds

[Microsoft Office documentation](https://support.office.com/en-us/article/Add-a-watermark-in-Excel-a372182a-d733-484e-825c-18ddf3edf009?ui=en-US&rs=en-US&ad=US&fromAR=1) says that Excel does not support adding of watermarks, however, it offers some workarounds. [One of them](https://support.office.com/en-us/article/Add-a-watermark-in-Excel-a372182a-d733-484e-825c-18ddf3edf009?ui=en-US&rs=en-US&ad=US&fromAR=1#odh_background) is using worksheet background images as watermarks.

Use the following code sample to add [background watermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetBackgroundWatermarkOptions) to all worksheets of Excel document.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkAsBackground**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
ImageWatermark watermark = new ImageWatermark(Constants.LogoGif);                                                
                                                                                                                 
SpreadsheetBackgroundWatermarkOptions options = new SpreadsheetBackgroundWatermarkOptions();                     
watermarker.add(watermark, options);                                                                             
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

{{< alert style="info" >}}Backgrounds are viewable in Normal View in the worksheet and are invisible in Page Layout mode. The image is automatically tiled on the background of the worksheet. Excel formats don't support background image customization. Using properties of image watermark (size, rotation etc) will cause image redrawing. This may lead to the decrease in performance.{{< /alert >}}

### Worksheet background image size

You can also define the size ([width](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetBackgroundWatermarkOptions#setBackgroundWidth(int)) and [height](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetBackgroundWatermarkOptions#setBackgroundHeight(int))) of the background image on which your watermark will be drawn. This feature allows you to mimic watermark relative size and position.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddWatermarkAsBackgroundWithRelativeSizeAndPosition**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                    
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"     
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                  
                                                                                                                      
ImageWatermark watermark = new ImageWatermark(Constants.LogoGif);                                                     
                                                                                                                      
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                                         
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                             
watermark.setRotateAngle(90);                                                                                         
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                                          
watermark.setScaleFactor(0.5);                                                                                        
                                                                                                                      
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                        
SpreadsheetBackgroundWatermarkOptions options = new SpreadsheetBackgroundWatermarkOptions();                          
options.setBackgroundWidth(content.getWorksheets().get_Item(0).getContentAreaWidthPx()); /* set background width */   
options.setBackgroundHeight(content.getWorksheets().get_Item(0).getContentAreaHeightPx()); /* set background height */
watermarker.add(watermark, options);                                                                                  
                                                                                                                      
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                       
                                                                                                                      
watermarker.close();                                                                                                  
```

{{< alert style="warning" >}}This method assumes that watermark absolute coordinates and size are measured in pixels (if they are assigned).{{< /alert >}}

### [TextWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark) as background

Excel does not support text backgrounds but you still can pass [TextWatermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark) instance with the [SpreadsheetBackgroundWatermarkOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/SpreadsheetBackgroundWatermarkOptions) option. The text will be converted to image preserving formatting. The following code sample demonstrates this feature.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddTextWatermarkAsBackground**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                                     
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"      
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                                   
                                                                                                                       
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));                               
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                                          
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                              
watermark.setRotateAngle(45);                                                                                          
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                                           
watermark.setScaleFactor(0.5);                                                                                         
watermark.setOpacity(0.5);                                                                                             
                                                                                                                       
SpreadsheetContent content = watermarker.getContent(SpreadsheetContent.class);                                         
SpreadsheetBackgroundWatermarkOptions options = new SpreadsheetBackgroundWatermarkOptions();                           
options.setBackgroundWidth(content.getWorksheets().get_Item(0).getContentAreaWidthPx()); /* set background width */    
options.setBackgroundHeight(content.getWorksheets().get_Item(0).getContentAreaHeightPx()); /* set background height */ 
watermarker.add(watermark, options);                                                                                   
                                                                                                                       
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                        
                                                                                                                       
watermarker.close();                                                                                                   
```

### Header and footer image watermark

Another way to mimic watermark in Excel is to [use Headers and Footers](https://support.office.com/en-us/article/Add-a-watermark-in-Excel-a372182a-d733-484e-825c-18ddf3edf009?ui=en-US&rs=en-US&ad=US&fromAR=1). You can add watermark to worksheet's header or footer using below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddImageWatermarkIntoHeaderFooter**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
ImageWatermark watermark = new ImageWatermark(Constants.LogoPng);                                                
                                                                                                                 
watermark.setVerticalAlignment(VerticalAlignment.Top);                                                           
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                                    
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                                     
watermark.setScaleFactor(1);                                                                                     
                                                                                                                 
SpreadsheetWatermarkHeaderFooterOptions options = new SpreadsheetWatermarkHeaderFooterOptions();                 
options.setWorksheetIndex(0);                                                                                    
                                                                                                                 
watermarker.add(watermark, options);                                                                             
                                                                                                                 
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

### Header and footer text watermark

You can also add [text watermark](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.watermarks/TextWatermark) in header or footer as shown in the below code sample.

**advanced\_usage.add\_watermarks\_to\_spreadsheets.SpreadsheetAddTextWatermarkIntoHeaderFooter**

```csharp
SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();                                               
// Constants.InSpreadsheetXlsx is an absolute or relative path to your document. Ex: "C:\\Docs\\spreadsheet.xlsx"
Watermarker watermarker = new Watermarker(Constants.InSpreadsheetXlsx, loadOptions);                             
                                                                                                                 
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19, FontStyle.Bold));         
watermark.setForegroundColor(Color.getRed());                                                                    
watermark.setBackgroundColor(Color.getAqua());                                                                   
watermark.setVerticalAlignment(VerticalAlignment.Top);                                                           
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                                    
                                                                                                                 
SpreadsheetWatermarkHeaderFooterOptions options = new SpreadsheetWatermarkHeaderFooterOptions();                 
options.setWorksheetIndex(0);                                                                                    
                                                                                                                 
watermarker.add(watermark, options);                                                                             
watermarker.save(Constants.OutSpreadsheetXlsx);                                                                  
                                                                                                                 
watermarker.close();                                                                                             
```

{{< alert style="warning" >}}You’ll see the watermark in Excel only when you’re in Page Layout view or Print Preview.{{< /alert >}}{{< alert style="warning" >}}Excel Headers and Footers are not designed for watermarking, so, some features don't work for header and footer watermarks.{{< /alert >}}

## Advanced use cases

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    

### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
