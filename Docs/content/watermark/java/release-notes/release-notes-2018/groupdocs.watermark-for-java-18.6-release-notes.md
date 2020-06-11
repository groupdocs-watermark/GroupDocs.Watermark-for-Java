---
id: groupdocs-watermark-for-java-18-6-release-notes
url: watermark/java/groupdocs-watermark-for-java-18-6-release-notes
title: GroupDocs.Watermark for Java 18.6 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Watermark for Java 18.6.{{< /alert >}}

## Major Features

There are the following features in this release:

*   Implement ability to lock watermark in Word documents
*   Implement ability to make Word document read-only after applying the watermark

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| WATERMARKNET-945 | Implement ability to lock watermark in Word documents | New Feature |
| WATERMARKNET-946 | Implement ability to make Word document read-only after applying watermark | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Watermark for Java 18.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Watermark which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Ability to lock watermark in Word documents

##### Description

This feature allows user to lock added watermarks for editing.  
There are 5 variants of locking Word document when adding watermark:

*   **AllowOnlyRevisions**: user can only add revision marks to the document.
*   **AllowOnlyComments**: user can only modify comments in the document.
*   **AllowOnlyFormFields**: the document is split into one-page sections and locked section with watermark is added between each two adjacent document sections.
*   **ReadOnly**: the entire document is read-only.
*   **ReadOnlyWithEditableContent**: the document is read-only, but all the content except the watermark is marked as editable.

##### Public API changes

*IsLocked* property has been added to *WordsShapeSettings* class.  
*LockType* property has been added to *WordsShapeSettings* class.  
*PageNumbers* property has been added to *WordsShapeSettings* class.  
*Password* property has been added to *WordsShapeSettings* class.  
*WordsLockType* enum has been added to *GroupDocs.Watermark.Office.Words* namespace.  
*WordsLockType* contains the following values:

*   *AllowOnlyRevisions*
*   *AllowOnlyComments*
*   *AllowOnlyFormFields*
*   *ReadOnly*
*   *ReadOnlyWithEditableContent*

##### Usage

Lock watermark for editing when adding to all pages of a Word document:

**Java**

```csharp
String inputFileName = "d:\\input.docx";
String outputFileName = "d:\\output.docx";

WordsDocument doc = Document.load(WordsDocument.class, inputFileName);

TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
watermark.setForegroundColor(Color.getRed());

WordsShapeSettings settings = new WordsShapeSettings();
settings.setLocked(true);
settings.setLockType(WordsLockType.AllowOnlyFormFields);
settings.setPassword("7654321");

doc.addWatermark(watermark, settings);

doc.save(outputFileName);
doc.close();
```

  
Lock watermark for editing when adding to one section:

**Java**

```csharp
String inputFileName = "d:\\input.docx";
String outputFileName = "d:\\output.docx";

WordsDocument doc = Document.load(WordsDocument.class, inputFileName);

TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
watermark.setForegroundColor(Color.getRed());

WordsShapeSettings settings = new WordsShapeSettings();
settings.setLocked(true);
settings.setLockType(WordsLockType.ReadOnlyWithEditableContent);
settings.setPassword("7654321");

doc.getSections().get_Item(0).addWatermark(watermark, settings);

doc.save(outputFileName);
doc.close();
```

  
Lock watermark for editing when adding to only several pages:

**Java**

```csharp
String inputFileName = "d:\\input.docx";
String outputFileName = "d:\\output.docx";

WordsDocument doc = Document.load(WordsDocument.class, inputFileName);

TextWatermark watermark = new TextWatermark("Watermark text", new Font("Arial", 19));
watermark.setForegroundColor(Color.getRed());

WordsShapeSettings settings = new WordsShapeSettings();
settings.setPageNumbers(new int[] { 7, 17 });
settings.setLocked(true);
settings.setLockType(WordsLockType.AllowOnlyComments);
settings.setPassword("7654321");

doc.addWatermark(watermark, settings);

doc.save(outputFileName);
doc.close();
```

### Ability to make Word document read-only after applying the watermark

##### Description

This feature allows the user to lock Word document for editing.

##### Public API changes

*protect(WordsProtectionType, String)* method has been added to *WordsDocument* class.  
*unprotect()* method has been added to *WordsDocument* class.

##### Usage

Protect Word document with a password by making it read-only:

**Java**

```csharp
WordsDocument doc = Document.load(WordsDocument.class, "D:\\test.doc");

doc.protect(WordsProtectionType.ReadOnly, "7654321");

doc.save("D:\\test.doc");
doc.close();
```

  
Remove protection from Word document regardless of password:

**Java**

```csharp
WordsDocument doc = Document.load(WordsDocument.class, "D:\\test.doc");

doc.unprotect();

doc.save("D:\\test.doc");
doc.close();
```
