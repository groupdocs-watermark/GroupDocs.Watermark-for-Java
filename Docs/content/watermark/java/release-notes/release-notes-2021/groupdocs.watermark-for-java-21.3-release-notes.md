---
id: groupdocs-watermark-for-java-21-3-release-notes
url: watermark/java/groupdocs-watermark-for-java-21-3-release-notes
title: GroupDocs.Watermark for Java 21.3 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Watermark for Java 21.3{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In version 21.3 the legacy API has been removed (all types from the com.groupdocs.watermark.legacy package were removed).{{< /alert >}}

There are the following features, enhancements and fixes in this release:

* Remove obsolete API (Legacy namespace)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| WATERMARKNET-1274 | Remove obsolete API (Legacy namespace) | Improvement |
| WATERMARKNET-1282 | Implement logging functionality | Improvement |
| WATERMARKNET-1329 | Add custom PreviewOptions for Office document formats | Improvement |
| WATERMARKNET-1328 | Add page info list to IDocumenInfo | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Watermark for Java 21.3. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Watermark which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Remove obsolete API (Legacy namespace)

All types from the com.groupdocs.watermark.legacy package were removed.

##### Public API changes

All types from the com.groupdocs.watermark.legacy package were removed

##### Use cases

See the [migration notes]({{< ref "watermark/java/developer-guide/migration-notes.md" >}}) for brief comparison of the old and new APIs.

### Implement logging functionality

This improvement allows you to record events that occur in GroupDocs.Watermark library.

### Public API changes

*ILogger* interface has been added to *com.groupdocs.watermark.options* package.

*getLogger()* method has been added to *com.groupdocs.watermark.WatermarkerSettings* class.

*setLogger()* method has been added to *com.groupdocs.watermark.WatermarkerSettings* class.

### Add custom PreviewOptions for Office document formats

This improvement enables custom PreviewOptions to be used for each of supported Office document format.

##### Public API changes

*DiagramPreviewOptions* class had been added to *com.groupdocs.watermark.options* package.

*EmailPreviewOptions* class had been added to *com.groupdocs.watermark.options* package.

*PdfPreviewOptions* class had been added to *com.groupdocs.watermark.options* package.

*PresentationPreviewOptions* class had been added to *com.groupdocs.watermark.options* package.

*SpreadsheetPreviewOptions* class had been added to *com.groupdocs.watermark.options* package.

*WordProcessingPreviewOptions* class had been added to *com.groupdocs.watermark.options* package.
