# Watermark Images & Documents via Java

[GroupDocs.Watermark is a Java library](https://products.groupdocs.com/watermark/java) to add text or image watermarks to Office, OpenOffice, PDF & Visio documents as well as all popular image formats. It also allows the developers to search and remove previously added watermarks (including watermarks added by third-party tools). 

<p align="center">
  <a title="Download GroupDocs.Watermark for Java Example's Source Code" href="https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java/archive/master.zip"> 
    <img src="https://camo.githubusercontent.com/11839cd752a2d367f3149c7bee1742b68e4a4d37/68747470733a2f2f7261772e6769746875622e636f6d2f4173706f73654578616d706c65732f6a6176612d6578616d706c65732d64617368626f6172642f6d61737465722f696d616765732f646f776e6c6f61645a69702d427574746f6e2d4c617267652e706e67" data-canonical-src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" style="max-width:100%;">
  </a>
</p>

Directory | Description
--------- | -----------
[Examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Add, Remove or Search for Watermarks

- [Add text or image watermark](https://docs.groupdocs.com/watermark/java/add-text-or-image-watermark/) to [40+ document formats](https://docs.groupdocs.com/watermark/java/supported-document-formats/).
- Add watermark to embedded images inside a document.
- Remove or [modify existing watermark objects](https://docs.groupdocs.com/watermark/java/modifying-found-watermark-properties/).
- Extract information of watermark objects.
- Search and remove watermarks from supported document formats.
- Search watermarks in particular objects such as Excel charts.
- Search watermarks by text formatting (font, color etc.).
- Extract document's basic information such as file type, size, pages count, page height & width.
- Generate image representations of document pages.

## Get Started with GroupDocs.Watermark for Java

GroupDocs.Watermark for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-watermark), so simply [configure](https://docs.groupdocs.com/watermark/java/installation/) your Maven project to fetch the dependencies automatically.

## Add Text Watermark to PDF Pages

```java
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                      
                                                                                                         
TextWatermark watermark = new TextWatermark("top secret", new Font("Arial", 36));                        
watermark.setForegroundColor(Color.getRed());                                                            
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                            
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                
                                                                                                         
watermarker.add(watermark);                                                                              
watermarker.save(Constants.OutDocumentPdf);                                                              
                                                                                                         
watermarker.close();        
```

## Search Watermarks in PDF Document

```java
// Constants.InDocumentPdf is an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker(Constants.InDocumentPdf);                                      
                                                                                                         
PossibleWatermarkCollection possibleWatermarks = watermarker.search();                                   
for (PossibleWatermark possibleWatermark : possibleWatermarks)                                           
{                                                                                                        
    if (possibleWatermark.getImageData() != null)                                                        
    {                                                                                                    
        System.out.println(possibleWatermark.getImageData().length);                                     
    }                                                                                                    
                                                                                                         
    System.out.println(possibleWatermark.getText());                                                     
    System.out.println(possibleWatermark.getX());                                                        
    System.out.println(possibleWatermark.getY());                                                        
    System.out.println(possibleWatermark.getRotateAngle());                                              
    System.out.println(possibleWatermark.getWidth());                                                    
    System.out.println(possibleWatermark.getHeight());                                                   
}                                                                                                        
                                                                                                         
watermarker.close();        
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/watermark/java) | [Documentation](https://docs.groupdocs.com/watermark/java/) | [Demos](https://products.groupdocs.app/watermark/family) | [API Reference](https://apireference.groupdocs.com/java/watermark) | [Examples](https://github.com/groupdocs-watermark/GroupDocs.watermark-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/watermark/) | [Free Support](https://forum.groupdocs.com/c/watermark) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
