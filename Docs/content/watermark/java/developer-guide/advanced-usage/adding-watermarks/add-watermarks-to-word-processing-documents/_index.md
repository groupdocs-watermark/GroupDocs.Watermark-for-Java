---
id: add-watermarks-to-word-processing-documents
url: watermark/java/add-watermarks-to-word-processing-documents
title: Add watermarks to word processing documents
weight: 9
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
Microsoft Word allows the user to divide and format the [document](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingContent) into multiple [sections](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingContent#getSections()). Defining sections in the document enables the user to set specific page layout and formatting for different parts of the document. An example of the sections is headers and footers. Headers and footers are used to display text or any graphical object on all the pages.

## Adding watermark to a particular section

GroupDocs.Watermark API allows you to add watermark objects in the headers and footers of the page. Adding watermark to a section of a Word document using GroupDocs.Watermark consists of following steps.

1.  Load the document 
2.  Create and initialize watermark object 
3.  Set watermark properties
4.  Create [WordProcessingWatermarkSectionOptions](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/WordProcessingWatermarkSectionOptions) and call [setSectionIndex()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/WordProcessingWatermarkSectionOptions#setSectionIndex(int))
5.  Add watermark to the section of the document
6.  Save the document

Following code adds watermark to the headers of a particular section.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingAddWatermarkToSection**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));                      
                                                                                                           
// Add watermark to all headers of the first section                                                       
WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();               
options.setSectionIndex(0);                                                                                
watermarker.add(watermark, options);                                                                       
                                                                                                           
watermarker.save(Constants.OutDocumentDocx);                                                               
                                                                                                           
watermarker.close();                                                                                       
```

The code snippet above adds watermark to the first section (to all headers of this section). So, it will be displayed on all pages belonging to the section.

## Getting page size 

If for some reasons you want to use absolute sizing and positioning, you may also need to get some [page properties](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingSection#getPageSetup()) for a section. GroupDocs.Watermark allows you to extract information about a particular section.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingGetSectionProperties**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                       
                                                                                                           
System.out.println(content.getSections().get_Item(0).getPageSetup().getWidth());                           
System.out.println(content.getSections().get_Item(0).getPageSetup().getHeight());                          
System.out.println(content.getSections().get_Item(0).getPageSetup().getTopMargin());                       
System.out.println(content.getSections().get_Item(0).getPageSetup().getRightMargin());                     
System.out.println(content.getSections().get_Item(0).getPageSetup().getBottomMargin());                    
System.out.println(content.getSections().get_Item(0).getPageSetup().getLeftMargin());                      
                                                                                                           
watermarker.close();                                                                                       
```

## Adding watermark to the images inside a particular section

Using GroupDocs.Watermark, you can add watermark to the [images](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/ContentPart#findImages()) that belong to a particular section.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingAddWatermarkToSectionImages**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));                      
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                              
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                  
watermark.setRotateAngle(45);                                                                              
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                               
watermark.setScaleFactor(1);                                                                               
                                                                                                           
// Get all images belonging to the first section                                                           
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                       
WatermarkableImageCollection images = content.getSections().get_Item(0).findImages();                      
                                                                                                           
// Add watermark to all found images                                                                       
for (WatermarkableImage image : images)                                                                    
{                                                                                                          
    image.add(watermark);                                                                                  
}                                                                                                          
                                                                                                           
watermarker.save(Constants.OutDocumentDocx);                                                               
                                                                                                           
watermarker.close();                                                                                       
```

## Adding watermark to the image shapes in a Word document

Word document may also contain different [shapes](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingSection#getShapes()). The API allows you to use shape collection to add watermark to [images](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingShape#getImage()) in a document. Below example shows how to add watermark to image shapes.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingAddWatermarkToShapeImages**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                    
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx" 
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                           
                                                                                                            
TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));                       
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                               
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                   
watermark.setRotateAngle(45);                                                                               
watermark.setSizingType(SizingType.ScaleToParentDimensions);                                                
watermark.setScaleFactor(1);                                                                                
                                                                                                            
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                        
for (WordProcessingSection section : content.getSections())                                                 
{                                                                                                           
    for (WordProcessingShape shape : section.getShapes())                                                   
    {                                                                                                       
        // Headers&Footers usually contains only service information.                                       
        // So, we skip images in headers/footers, expecting that they are probably watermarks or backgrounds
        if (shape.getHeaderFooter() == null && shape.getImage() != null)                                    
        {                                                                                                   
            shape.getImage().add(watermark);                                                                
        }                                                                                                   
    }                                                                                                       
}                                                                                                           
                                                                                                            
watermarker.save(Constants.OutDocumentDocx);                                                                
                                                                                                            
watermarker.close();                                                                                        
```

## Adding watermark to a particular page of Word document

GroupDocs.Watermark enables you to add watermark to a [particular page](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.options/WordProcessingWatermarkPagesOptions) of a Word document. You can use following example to achieve this.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingAddWatermarkToParticularPage**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
TextWatermark textWatermark = new TextWatermark("DRAFT", new Font("Arial", 42));                           
                                                                                                           
// Add watermark to the last page                                                                          
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                       
WordProcessingWatermarkPagesOptions options = new WordProcessingWatermarkPagesOptions();                   
options.setPageNumbers(new int[] {content.getPageCount()});                                                
                                                                                                           
watermarker.add(textWatermark, options);                                                                   
watermarker.save(Constants.OutDocumentDocx);                                                               
                                                                                                           
watermarker.close();                                                                                       
```

## Working with headers and footers

### Linking headers and footers

Header/footer in a Word document can be linked to the corresponding header/footer in the previous section. In this way, the same content is displayed in the linked header/footer. GroupDocs.Watermark API provides the option to link the header/footer using [setLinkedToPrevious()](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingHeaderFooter#setLinkedToPrevious(boolean)) method of [WordProcessingHeaderFooter](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingHeaderFooter) class. Following code snippet serves this purpose.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingLinkHeaderFooterInSection**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                                                       
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"                                    
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                                                              
                                                                                                                                               
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                                                           
                                                                                                                                               
// Link footer for even numbered pages to corresponding footer in previous section                                                             
content.getSections().get_Item(1).getHeadersFooters().getByOfficeHeaderFooterType(OfficeHeaderFooterType.FooterEven).setLinkedToPrevious(true);
                                                                                                                                               
watermarker.save(Constants.OutDocumentDocx);                                                                                                   
                                                                                                                                               
watermarker.close();                                                                                                                           
```

### Linking all headers and footers  

Following code snippet links all the [headers and footers](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingSection#getHeadersFooters()) in a particular section.

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingLinkAllHeaderFooterInSection**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                       
                                                                                                           
// Link footer for even numbered pages to corresponding footer in previous section                         
content.getSections().get_Item(1).getHeadersFooters().get_Item(1).setLinkedToPrevious(true);               
                                                                                                           
watermarker.save(Constants.OutDocumentDocx);                                                               
                                                                                                           
watermarker.close();                                                                                       
```

### Add watermark to headers and footers with linking  

This feature can be useful to reduce resultant file size when you're adding image watermark to all [sections](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingContent#getSections()).

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingAddImageWatermark**

```csharp
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
ImageWatermark watermark = new ImageWatermark(Constants.LargePng);                                         
                                                                                                           
// Add watermark to all headers of the first section                                                       
WordProcessingWatermarkSectionOptions options = new WordProcessingWatermarkSectionOptions();               
options.setSectionIndex(0);                                                                                
watermarker.add(watermark, options);                                                                       
                                                                                                           
// Link all other headers&footers to corresponding headers&footers of the first section                    
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                       
for (int i = 1; i < content.getSections().getCount(); i++)                                                 
{                                                                                                          
    content.getSections().get_Item(i).getHeadersFooters().linkToPrevious(true);                            
}                                                                                                          
                                                                                                           
watermarker.save(Constants.OutDocumentDocx);                                                               
                                                                                                           
watermarker.close();                                                                                       
```

### Setting different headers and footers 

Using GroupDocs.Watermark API, you can also set [different](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingPageSetup#setDifferentFirstPageHeaderFooter(boolean)) headers or footers for [even and odd](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WordProcessingPageSetup#setOddAndEvenPagesHeaderFooter(boolean)) numbered pages and for the first page of the document (as shown in below example).

**advanced\_usage.add\_watermarks\_to\_word\_processing.WordProcessingSetDifferentFirstPageHeaderFooter**

```csharp
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();                                   
// Constants.InDocumentDocx is an absolute or relative path to your document. Ex: "C:\\Docs\\document.docx"
Watermarker watermarker = new Watermarker(Constants.InDocumentDocx, loadOptions);                          
                                                                                                           
WordProcessingContent content = watermarker.getContent(WordProcessingContent.class);                       
                                                                                                           
content.getSections().get_Item(0).getPageSetup().setDifferentFirstPageHeaderFooter(true);                  
content.getSections().get_Item(0).getPageSetup().setOddAndEvenPagesHeaderFooter(true);                     
                                                                                                           
watermarker.save(Constants.OutDocumentDocx);                                                               
                                                                                                           
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
