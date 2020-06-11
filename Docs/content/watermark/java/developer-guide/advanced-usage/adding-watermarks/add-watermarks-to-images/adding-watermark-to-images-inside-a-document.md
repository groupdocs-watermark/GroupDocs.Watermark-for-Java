---
id: adding-watermark-to-images-inside-a-document
url: watermark/java/adding-watermark-to-images-inside-a-document
title: Adding watermark to images inside a document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
The most of the document formats allow you to place images inside a document. If you want to add watermark to images inside a document then it can be possible using GroupDocs.Watermark. Following are the steps to add watermark to the images of any document.

1.  Load the document 
2.  Create and initialize watermark object 
3.  Set watermark properties 
4.  [Find](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark/Watermarker#getImages()) images in the document
5.  [Add](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/WatermarkableImage#add(com.groupdocs.watermark.Watermark)) watermark to all found images
6.  Save the document

**advanced\_usage.add\_watermarks\_to\_images.AddWatermarkToImagesInsideDocument**

```csharp
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                      
                                                                                                         
// Initialize text watermark                                                                             
TextWatermark textWatermark = new TextWatermark("Protected image", new Font("Arial", 8));                
textWatermark.setHorizontalAlignment(HorizontalAlignment.Center);                                        
textWatermark.setVerticalAlignment(VerticalAlignment.Center);                                            
textWatermark.setRotateAngle(45);                                                                        
textWatermark.setSizingType(SizingType.ScaleToParentDimensions);                                         
textWatermark.setScaleFactor(1);                                                                         
                                                                                                         
// Initialize image watermark                                                                            
ImageWatermark imageWatermark = new ImageWatermark(Constants.ProtectJpg);                                
                                                                                                         
imageWatermark.setHorizontalAlignment(HorizontalAlignment.Center);                                       
imageWatermark.setVerticalAlignment(VerticalAlignment.Center);                                           
imageWatermark.setRotateAngle(-45);                                                                      
imageWatermark.setSizingType(SizingType.ScaleToParentDimensions);                                        
imageWatermark.setScaleFactor(1);                                                                        
                                                                                                         
// Find all images in a document                                                                         
WatermarkableImageCollection images = watermarker.getImages();                                           
                                                                                                         
for (int i = 0; i < images.getCount(); i++)                                                              
{                                                                                                        
    if (images.get_Item(i).getWidth() > 100 && images.get_Item(i).getHeight() > 100)                     
    {                                                                                                    
        if (i % 2 == 0)                                                                                  
        {                                                                                                
            images.get_Item(i).add(textWatermark);                                                       
        }                                                                                                
        else                                                                                             
        {                                                                                                
            images.get_Item(i).add(imageWatermark);                                                      
        }                                                                                                
    }                                                                                                    
}                                                                                                        
                                                                                                         
imageWatermark.close();                                                                                  
                                                                                                         
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
