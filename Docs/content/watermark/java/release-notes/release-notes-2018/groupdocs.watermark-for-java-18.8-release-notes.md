---
id: groupdocs-watermark-for-java-18-8-release-notes
url: watermark/java/groupdocs-watermark-for-java-18-8-release-notes
title: GroupDocs.Watermark for Java 18.8 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Watermark for Java 18.8.{{< /alert >}}

## Major Features

There are the following features, enhancements and fixes in this release:

*   Metered licensing security is improved and now supports Java version 8u101 or above
*   Fixed locking watermark in PPTX, PPT
*   Added SmartArt and CustomXml drawing types
*   Implemented ability to skip unreadable characters during text watermark search
*   Implemented protection of text watermark using unreadable characters for Slides

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| WATERMARKJAVA-50 | Metered licensing security is improved and now supports Java version 8u101 or above | Breaking Change |
| WATERMARKNET-895 | Locking watermark in PPTX, PPT is not working | Bug |
| WATERMARKNET-981 | Add SmartArt and CustomXml drawing types | Enhancement |
| WATERMARKNET-998 | Implement ability to skip unreadable characters during text watermark search | New Feature |
| WATERMARKNET-999 | Implement protection of text watermark using unreadable characters for Slides | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Watermark for Java 18.8. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Watermark which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Breaking Change - Metered licensing security is improved and now supports Java version 8u101 or above

##### Description

This breaking change improves Metered licensing security. Metered licensing is now applicable only in Java runtime version 8u101 or above. Please use other types of licensing in Java 7.

##### Public API changes

None.

##### Usage

The following example will fail in Java 7 but will be completed successfully in Java 8u101 or above:

**Java**

```csharp
Metered metered = new Metered();
try {
    metered.setMeteredKey(publicKey, privateKey);
} catch(Exception e) {
    e.printStackTrace(System.out);
}
 
String inputFileName = "d:\\input.pptx";
String outputFileName = "d:\\output.pptx";
final SlidesDocument document = Document.load(SlidesDocument.class, inputFileName);
 
TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
document.addWatermark(watermark);
 
document.save(outputFileName);
document.close();
```

### Ability to skip unreadable characters during text watermark search

##### Description

This feature allows finding text watermark even if it contains unreadable characters between letters.

##### Public API changes

*getSkipUnreadableCharacters()* method has been added to *TextSearchCriteria* class.  
*set*Skip*UnreadableCharacters(boolean)* method has been added to *TextSearchCriteria* class.

##### Usage

Search for text watermarks with skipping unreadable characters:

**Java**

```csharp
String inputFileName = "d:\\input.pptx";
 
final SlidesDocument document = Document.load(SlidesDocument.class, inputFileName);
 
String watermarkText = "Company name";
TextSearchCriteria criterion = new TextSearchCriteria(watermarkText);
 
// Enabling skipping of unreadable characters
criterion.setSkipUnreadableCharacters(true);
 
PossibleWatermarkCollection result = document.findWatermarks(criterion);
 
document.close();
```

### Protection of text watermark using unreadable characters for Slides document

##### Description

This feature allows strengthening protection of text watermark in case of modifying with Find And Replace dialog.

##### Public API changes

*getProtectWithUnreadableCharacters()* method has been added to *SlidesShapeSettings* class.  
*setProtectWithUnreadableCharacters(boolean)* method has been added to *SlidesShapeSettings* class.

##### Usage

Protect text watermark with unreadable characters:

**Java**

```csharp
String inputFileName = "d:\\input.pptx";
String outputFileName = "d:\\output.pptx";
 
final SlidesDocument document = Document.load(SlidesDocument.class, inputFileName);
 
TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
 
SlidesShapeSettings settings = new SlidesShapeSettings();
settings.setLocked(true);
settings.setProtectWithUnreadableCharacters(true);
 
document.addWatermark(watermark, settings);
 
document.save(outputFileName);
 
document.close();
```

### Added SmartArt and CustomXml drawing types for Spreadsheets 

##### Description

This enhancement adds two new supported drawing types to **CellsMsoDrawingType** enum: **SmartArt** and **CustomXml**.

##### Public API changes

*SmartArt* value has been added to *CellsMsoDrawingType* enum.  
*CustomXml* value has been added to *CellsMsoDrawingType* enum.

##### Usage

Remove shapes of *SmartArt and* *CustomXml type from document worksheet:*

**Java**

```csharp
String inputFileName = "G:\\Input.xlsx";
String outputFileName = "G:\\Output.xlsx";
 
final CellsDocument document = Document.load(CellsDocument.class, inputFileName);
CellsShapeCollection shapes = document.getWorksheets().get_Item(0).getShapes();
for (int i = shapes.getCount() - 1; i >= 0; i--)
{
    CellsShape shape = shapes.get_Item(i);
    if (shape.getMsoDrawingType() == CellsMsoDrawingType.SmartArt ||
        shape.getMsoDrawingType() == CellsMsoDrawingType.CustomXml)
    {
        shapes.removeAt(i);
    }
}
document.save(outputFileName);
document.close();
```

### Bug Fixed - Locking watermark in PPTX, PPT is not working

##### Description

PowerPoint has a problem with text locking because none of the lock commands are officially supported in PowerPoint. Text watermark remained editable when it was locked by setting *SlidesShapeSettings.setLocked* property to true. Additional lock for text watermark in PPTX, PPT documents has been implemented by adding a transparent rectangle on top of the text shape. The transparent rectangle prevents selecting and editing text in PowerPoint directly. But the user can still edit watermark by using the *Find And Replace* dialog in PowerPoint.

##### Public API changes

None.

##### Usage

Lock text watermark:

**Java**

```csharp
String inputFileName = "d:\\input.pptx";
String outputFileName = "d:\\output.pptx";
 
final SlidesDocument document = Document.load(SlidesDocument.class, inputFileName);
 
TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
 
SlidesShapeSettings settings = new SlidesShapeSettings();
settings.setLocked(true);
 
document.addWatermark(watermark, settings);
 
document.save(outputFileName);
 
document.close();
```
