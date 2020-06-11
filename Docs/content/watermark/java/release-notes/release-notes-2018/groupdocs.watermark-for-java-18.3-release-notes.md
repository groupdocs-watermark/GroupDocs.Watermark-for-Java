---
id: groupdocs-watermark-for-java-18-3-release-notes
url: watermark/java/groupdocs-watermark-for-java-18-3-release-notes
title: GroupDocs.Watermark for Java 18.3 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Watermark for Java 18.3.{{< /alert >}}

## Major Features

There are the following new features in this monthly release:

*   Implement ability to edit PDF document objects that can be considered as watermarks
*   Implement ability to edit text and image in found possible watermarks (across all formats)

## Full List of Issues Covering all Changes in this Release

| Key  | Summary | Category |
| --- | --- | --- |
| WATERMARKNET-788 | Implement ability to edit PDF document objects that can be considered as watermarks  | New Feature  |
| WATERMARKNET-789  | Implement ability to edit text and image in found possible watermarks (across all formats)  | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Watermark for Java 18.3. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Watermark which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Edit PDF document objects that can be considered as watermarks

##### Description

This feature allows a user to edit existing XObjects, Artifacts and Annotations in a PDF document.

##### Public API changes

*PdfShapeFormattedTextFragmentCollection* class has been added to *com.groupdocs.watermark* package.  
*PdfTextFormattedTextFragmentCollection* class has been added to *com.groupdocs.watermark* package.  
*PdfXForm* class has been added to *com.groupdocs.watermark* package.  
*PdfXImage* class has been added to *com.groupdocs.watermark* package.  
*PdfShape* class has been added to *com.groupdocs.watermark* package.  
*PdfXObject* class is now inherited from *PdfShape*.  
*PdfArtifact* class is now inherited from *PdfShape*.  
*PdfAnnotation* class is now inherited from *PdfShape*.

##### Usage

Replace text for particular XObjects.

**Java**

```csharp
PdfDocument doc = Document.load(PdfDocument.class, "D:\\xobjects.pdf");

for (PdfXObject xObject : doc.getPages().get_Item(0).getXObjects())
{
    if (xObject.getText().contains("Test"))
    {
        xObject.setText("Passed");
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace text for particular Artifacts.

**Java**

```csharp
PdfDocument doc = Document.load(PdfDocument.class, "D:\\artifacts.pdf");

for (PdfArtifact artifact : doc.getPages().get_Item(0).getArtifacts())
{
    if (artifact.getText().contains("Test"))
    {
        artifact.setText("Passed");
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace text for particular Annotations.

**Java**

```csharp
PdfDocument doc = Document.load(PdfDocument.class, "D:\\annotations.pdf");

for (PdfAnnotation annotation : doc.getPages().get_Item(0).getAnnotations())
{
    if (annotation.getText().contains("Test"))
    {
        annotation.setText("Passed");
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace text with formatting (XObjects).

**Java**

```csharp
PdfDocument doc = Document.load(PdfDocument.class, "D:\\xobjects.pdf");

for (PdfXObject xObject : doc.getPages().get_Item(0).getXObjects())
{
    if (xObject.getText().contains("Test"))
    {
        xObject.getFormattedTextFragments().clear();
        xObject.getFormattedTextFragments().add("Passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace text with formatting (Artifacts).

**Java**

```csharp
PdfDocument doc = Document.load(PdfDocument.class, "D:\\artifacts.pdf");

for (PdfArtifact artifact : doc.getPages().get_Item(0).getArtifacts())
{
    if (artifact.getText().contains("Test"))
    {
        artifact.getFormattedTextFragments().clear();
        artifact.getFormattedTextFragments().add("Passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace text with formatting (Annotations).

**Java**

```csharp
PdfDocument doc = Document.load(PdfDocument.class, "D:\\annotations.pdf");

for (PdfAnnotation annotation : doc.getPages().get_Item(0).getAnnotations())
{
    if (annotation.getText().contains("Test"))
    {
        annotation.getFormattedTextFragments().clear();
        annotation.getFormattedTextFragments().add("Passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace XObject image.

**Java**

```csharp
String imagePath = "D:\\test.png";
File imageFile = new File(imagePath);
byte[] imageBytes = new byte[(int)imageFile.length()];
InputStream imageInputStream = new FileInputStream(imageFile);
imageInputStream.read(imageBytes);
imageInputStream.close();

PdfDocument doc = Document.load(PdfDocument.class, "D:\\xobjects.pdf");

for (PdfXObject xObject : doc.getPages().get_Item(0).getXObjects())
{
    if (xObject.getImage() != null)
    {
        xObject.setImage(new PdfWatermarkableImage(imageBytes));
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace Artifact image.

**Java**

```csharp
String imagePath = "D:\\test.png";
File imageFile = new File(imagePath);
byte[] imageBytes = new byte[(int)imageFile.length()];
InputStream imageInputStream = new FileInputStream(imageFile);
imageInputStream.read(imageBytes);
imageInputStream.close();

PdfDocument doc = Document.load(PdfDocument.class, "D:\\artifacts.pdf");

for (PdfArtifact artifact : doc.getPages().get_Item(0).getArtifacts())
{
    if (artifact.getImage() != null)
    {
        artifact.setImage(new PdfWatermarkableImage(imageBytes));
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

Replace Annotation image.

**Java**

```csharp
String imagePath = "D:\\test.png";
File imageFile = new File(imagePath);
byte[] imageBytes = new byte[(int)imageFile.length()];
InputStream imageInputStream = new FileInputStream(imageFile);
imageInputStream.read(imageBytes);
imageInputStream.close();

PdfDocument doc = Document.load(PdfDocument.class, "D:\\annotations.pdf");

for (PdfAnnotation annotation : doc.getPages().get_Item(0).getAnnotations())
{
    if (annotation.getImage() != null)
    {
        annotation.setImage(new PdfWatermarkableImage(imageBytes));
    }
}

doc.save("D:\\output.pdf");
doc.close();
```

### Edit text and image in found possible watermarks (across all formats)

##### Description

This feature allows a user to edit image and text in found possible watermarks.

##### Public API changes

*FormattedTextFragmentCollection* and *FormattedTextFragmentMutableCollection* classes have been merged into one class called *FormattedTextFragmentCollection*.  
*setText* method has been added to *PossibleWatermark* class.  
*setImageData* method has been added to *PossibleWatermark* class.

##### Usage

Replace text of found possible watermarks.

**Java**

```csharp
Document doc = Document.load("D:\\input.pptx");

TextSearchCriteria searchCriteria = new TextSearchCriteria("test", false);
PossibleWatermarkCollection watermarks = doc.findWatermarks(searchCriteria);
for (PossibleWatermark watermark : watermarks)
{
    try
    {
        watermark.setText("passed");
    }
    catch (Exception e)
    {
        // Found entity may not support text editing
        // Passed argument can have inappropriate value
        // Process such cases here
    }
}

doc.save("D:\\output.pptx");
doc.close();
```

Replace text with formatting.

**Java**

```csharp
Document doc = Document.load("D:\\input.docx");

TextSearchCriteria searchCriteria = new TextSearchCriteria("test", false);
PossibleWatermarkCollection watermarks = doc.findWatermarks(searchCriteria);
for (PossibleWatermark watermark : watermarks)
{
    try
    {
        watermark.getFormattedTextFragments().clear();
        watermark.getFormattedTextFragments().add("passed", new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
    }
    catch (Exception e)
    {
        // Found entity may not support text editing
        // Passed argument can have inappropriate value
        // Process such cases here
    }
}

doc.save("D:\\output.docx");
doc.close();
```

Replace images of found possible watermarks.

**Java**

```csharp
String imagePath = "D:\\test.png";
File imageFile = new File(imagePath);
byte[] imageBytes = new byte[(int)imageFile.length()];
InputStream imageInputStream = new FileInputStream(imageFile);
imageInputStream.read(imageBytes);
imageInputStream.close();

Document doc = Document.load("D:\\input.pdf");

SearchCriteria searchCriteria = new ImageDctHashSearchCriteria("D:\\logo.bmp");
PossibleWatermarkCollection watermarks = doc.findWatermarks(searchCriteria);
for (PossibleWatermark watermark : watermarks)
{
    try
    {
        watermark.setImageData(imageBytes);
    }
    catch (Exception e)
    {
        // Found entity may not support image replacing
        // Passed image can have inappropriate format
        // Process such cases here
    }
}

doc.save("D:\\output.pdf");
doc.close();
```
