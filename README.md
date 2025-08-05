# GroupDocs.Watermark Java Examples - Protect Documents with Watermarks

![GroupDocs.Watermark for Java](https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png)

**Document security** through comprehensive watermarking solutions for Java applications. This repository provides complete examples demonstrating **how to watermark files**, **add watermark**, **create watermark**, **remove watermark**, and implement **invisible watermarking for documents** using GroupDocs.Watermark for Java.

## 🔐 Enterprise Document Security & Content Protection

**Protect documents with watermarks** across 40+ file formats with powerful **content protection with watermarking** capabilities:

- **Custom watermark** creation with personalized text and images
- **Customize watermark** appearance, positioning, and transparency
- **Custom fonts** support for branded watermarking solutions
- **Watermark automation for enterprise** Java workflows
- Advanced search and removal capabilities
- **Invisible watermarking for documents** with steganographic techniques
- **Tiling watermarks** across entire document pages for comprehensive coverage

## 📁 Repository Structure

| Directory | Description |
|-----------|-------------|
| [Examples](./Examples) | Complete Java examples showing **how to watermark a** document and implement **document security** |

## 🚀 Quick Start - How to Watermark Documents in Java

### Add Watermark to Documents

Learn **how to watermark** your documents with this simple Java example:

```java
// Specify an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker("document.pdf");                                      
                                                                                                         
TextWatermark watermark = new TextWatermark("top secret", new Font("Arial", 36));                        
watermark.setForegroundColor(Color.getRed());                                                            
watermark.setHorizontalAlignment(HorizontalAlignment.Center);                                            
watermark.setVerticalAlignment(VerticalAlignment.Center);                                                
                                                                                                         
watermarker.add(watermark);                                                                              
watermarker.save("document.pdf");                                                              
                                                                                                         
watermarker.close();
```

## 📋 Java Watermarking Examples by Use Case

### Basic Watermarking Operations
- **How to watermark in** PDF documents with Java
- **Create watermark** with custom fonts and styling
- **Add watermark** to multiple pages simultaneously
- **Customize watermark** transparency and rotation angles

### Advanced Document Security
- **Removing watermark from** third-party applications
- **Delete watermark from** specific document regions
- **Can you remove watermark from** password-protected files
- **How to remove watermarks in** batch processing workflows

### Enterprise Java Solutions
- **Watermark automation for enterprise** document management systems
- **Content protection with watermarking** for sensitive business documents
- **Document security** compliance implementations
- **Customized product** branding with corporate watermarks

## 🎯 Supported File Formats

**How to watermark files** across multiple formats using Java:

**Documents:** PDF, DOC, DOCX, XLS, XLSX, PPT, PPTX, RTF  
**Images:** PNG, JPG, BMP, TIFF, GIF, WEBP  
**Email:** EML, MSG, EMLX  
**Other:** Visio files (VSD, VSDX), OpenOffice (ODT)

## 💡 Key Java Watermarking Scenarios

### How to Search Watermarks in PDF documents
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

### Image Watermarking
```java
// Specify an absolute or relative path to your document. Ex: "C:\\Docs\\presentation.pptx"
Watermarker watermarker = new Watermarker("presentation.pptx");                                           
                                                                                                                   
// Use path to the image as constructor parameter                                                                  
ImageWatermark watermark = new ImageWatermark("watermark.jpg");                                             
                                                                                                                   
// Add watermark to the document                                                                                   
watermarker.add(watermark);                                                                                        
                                                                                                                   
watermarker.save("presentation.pptx");                                                                   
                                                                                                                   
watermark.close();                                                                                                 
watermarker.close();
```

### **How to Remove Watermark** Operations
```java
// Specify an absolute or relative path to your document. Ex: "C:\\Docs\\document.pdf"
Watermarker watermarker = new Watermarker("document.pdf");                                      
                                                                                                         
PossibleWatermarkCollection possibleWatermarks = watermarker.search();                                   
                                                                                                         
// Remove possible watermark at the specified index from the document.                                   
possibleWatermarks.removeAt(0);                                                                          
                                                                                                         
// Remove specified possible watermark from the document.                                                
possibleWatermarks.remove(possibleWatermarks.get_Item(0));                                               
                                                                                                         
watermarker.save("document.pdf");                                                              
                                                                                                         
watermarker.close();
```

## 🔧 Installation & Setup

### Maven Configuration
Add to your `pom.xml`:
```xml
<repositories>
  <repository>
    <id>GroupDocsJavaAPI</id>
    <name>GroupDocs Java API</name>
    <url>https://releases.groupdocs.com/java/repo/</url>
  </repository>
</repositories>
```

### System Requirements
- Java J2SE 7.0 (1.7) or higher
- J2SE 8.0 (1.8) recommended for optimal performance
- Compatible with all major Java IDEs

## 🌟 Advanced Java Features

- **Invisible watermarking for documents** with steganographic embedding  
- Search watermarks by formatting properties (font, color, size)
- **Document security** with password protection integration
- **Tiling watermarks** with customizable spacing and patterns
- Batch processing for **watermark automation for enterprise**
- **Custom watermark** templates for consistent branding
- Multi-threaded watermark processing for high-volume scenarios

## 📖 Documentation & Resources

- [Complete Java API Documentation](https://docs.groupdocs.com/watermark/java/)
- [Live Demo - **How to Watermark** Online](https://products.groupdocs.app/watermark/family)
- [Java API Reference Guide](https://apireference.groupdocs.com/java/watermark)
- [Developer Blog](https://blog.groupdocs.com/category/watermark/)

## 🤝 Support & Community

- [Free Support Forum](https://forum.groupdocs.com/c/watermark) - Get help with **how to remove watermark from free** community
- [Temporary License](https://purchase.groupdocs.com/temporary-license) - Test full features

## 🏷️ Tags

`java-watermarking` `document-security` `content-protection` `pdf-watermark` `document-watermark` `remove-watermark` `add-watermark` `custom-watermark` `enterprise-security` `java-library`

---

**Start securing your Java applications today!** Clone this repository to explore comprehensive examples of **how to watermark a** document, implement **document security**, and leverage **watermark automation for enterprise** Java solutions.

- [⬇️ Download Examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java/archive/master.zip) 
- [🏠 GroupDocs Home](https://products.groupdocs.com/)
- [📧 Contact Sales](https://purchase.groupdocs.com/temporary-license)