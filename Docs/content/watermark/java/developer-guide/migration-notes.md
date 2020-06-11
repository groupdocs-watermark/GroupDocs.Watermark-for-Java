---
id: migration-notes
url: watermark/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
## Why To Migrate?

Here are the key reasons to use the new updated API provided by GroupDocs.Watermark for Java since version 20.1:

*   *Watermarker* class is introduced as a **single entry point** to manage watermarks in the document (instead of *Document*class from previous versions).
*   Adding watermarks was unified for all supported document formats.
*   Product architecture was redesigned from scratch in order to simplify passing options to manage watermarks.
*   Document information and preview generation procedures were simplified.

## How To Migrate?

Here is brief comparison of how to manage watermarks using the old and new API.


### Load Documents

#### Any Supported Format

The folowing examples show how to load a document of any supported format.

**Old API**

```csharp
Document doc = Document.load("test.doc");
// watermarking goes here
// ...
doc.close(); 
```

**New API**

```csharp
Watermarker watermarker = new Watermarker("test.doc");
// watermarking goes here
// ...
doc.close();
```

#### Document of Specific Format

The following examples show how to load a diagram document.

**Old API**

```csharp
DiagramDocument doc = Document.load(DiagramDocument.class, "diagram.vsdx");
// watermarking goes here
// ...
doc.close();
```

**New API**

```csharp
DiagramLoadOptions loadOptions = new DiagramLoadOptions();
Watermarker watermarker = new Watermarker("diagram.vsdx", loadOptions);
// watermarking goes here
// ...
doc.close();
```

### Add watermarks

The following examples show how to add text watermark to a document of any supported type.

**Old API**

```csharp
for (File file : new File("Documents").listFiles())
{
    Document document = Document.load(file.getPath());

    TextWatermark watermark = new TextWatermark("top secret", new Font("Arial", 36))
    watermark.setForegroundColor(Color.getRed());
    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
    watermark.setVerticalAlignment(VerticalAlignment.Center);

    document.addWatermark(watermark);
    document.save(file.getPath() + ".watermarked");
    document.close();
}
```

**New API**

```csharp
for (File file : new File("Documents").listFiles())
{                                                                                       
    Watermarker watermarker = new Watermarker(file.getPath());

    TextWatermark watermark = new TextWatermark("top secret", new Font("Arial", 36));
    watermark.setForegroundColor(Color.getRed());
    watermark.setHorizontalAlignment(HorizontalAlignment.Center);
    watermark.setVerticalAlignment(VerticalAlignment.Center);

    watermarker.add(watermark);
    watermarker.save();                                                             
    watermarker.close();
}
```

#### Add Watermark with Options

The following examples show how to add watermark to the first page of a diagram document.

**Old API**

```csharp
DiagramDocument doc = Document.load(DiagramDocument.class, "diagram.vsdx");

TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Calibri", 19));

doc.getPages().get_Item(0).addWatermark(textWatermark);

doc.save();
doc.close(); 
```

**New API**

```csharp
Watermarker watermarker = new Watermarker("diagram.vsdx", new DiagramLoadOptions());

TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Calibri", 19));

DiagramPageWatermarkOptions options = new DiagramPageWatermarkOptions();
options.setPageIndex(0);

watermarker.add(textWatermark, options);

watermarker.save();
watermarker.close(); 
```

### Search Watermarks

The following examles show how to find watermarks using search criteria.

**Old API**

```csharp
Document doc = Document.load("test.some_ext");

SizeSearchCriteria widthRange = new SizeSearchCriteria(Dimension.Width, 50, 100);
RotateAngleSearchCriteria rotateAngle = new RotateAngleSearchCriteria(0, 45);
TextSearchCriteria textCriteria = new TextSearchCriteria(Pattern.compile("^Test watermark$"));

PossibleWatermarkCollection watermarks = doc.findWatermarks(textCriteria.and(widthRange.or(rotateAngle)));

System.out.println("Found " + watermarks.Count + " possible watermarks.");

doc.close(); 
```

**New API**

```csharp
Watermarker watermarker = new Watermarker("test.some_ext");

SizeSearchCriteria widthRange = new SizeSearchCriteria(Dimension.Width, 50, 100);
RotateAngleSearchCriteria rotateAngle = new RotateAngleSearchCriteria(0, 45);
TextSearchCriteria textCriteria = new TextSearchCriteria(Pattern.compile("^Test watermark$"));

PossibleWatermarkCollection watermarks = watermarker.search(textCriteria.and(widthRange.or(rotateAngle)));

System.out.println("Found " + watermarks.Count + " possible watermarks.");

watermarker.close();
```

### Remove Watermarks

The following examples show how to remove all possible watermarks.

**Old API**

```csharp
Document doc = Document.load("document.pdf");

PossibleWatermarkCollection watermarks = doc.findWatermarks();
watermarks.clear();
doc.save("document_without_watermarks.pdf");

doc.close(); 
```

**New API**

```csharp
Watermarker watermarker = new Watermarker("document.pdf");

PossibleWatermarkCollection watermarks = watermarker.search();
watermarker.remove(watermarks);
watermarker.save("document_without_watermarks.pdf");

watermarker.close();
```

### Get Document Info

The following examples show how to get document information from the local file.

**Old API**

```csharp
DocumentInfo documentInfo = Document.getInfo("test.ppt");
System.out.println(documentInfo.getFileFormat());
System.out.println(documentInfo.isEncrypted());
```

**New API**

```csharp
Watermarker watermarker = new Watermarker("test.ppt");

IDocumentInfo info = watermarker.getDocumentInfo();
System.out.println("File type: " + info.getFileType());
System.out.println("Number of pages: " + info.getPageCount());
System.out.println("Document size: " + info.getSize() + " bytes");

watermarker.close(); 
```
