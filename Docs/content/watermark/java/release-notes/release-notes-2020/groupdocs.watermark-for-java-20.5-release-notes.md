---
id: groupdocs-watermark-for-java-20-5-release-notes
url: watermark/java/groupdocs-watermark-for-java-20-5-release-notes
title: GroupDocs.Watermark for Java 20.5 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Watermark for Java 20.5{{< /alert >}}

## Major Features

There are the following improvements in this release:

*   Allow to edit minor shape properties in Visio documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| WATERMARKNET-1264 | Footer and header watermark adds line break using .NET | Bug |
| WATERMARKNET-772 | Allow to edit minor shape properties in Visio documents | Improvement |
| WATERMARKNET-1268 | Watermarking of Word document uses existing paragraph if available | Improvement |
| WATERMARKNET-1269 | After removing found watermark in Word document, the empty parent paragraph is removed too | Improvement |

# Public API and Backward Incompatible Changes

### Allow to edit minor shape properties in Visio documents

#### Description

This improvement allows to edit the following shape properties in Visio documents:

*   Width
*   Height
*   X
*   Y
*   RotateAngle

#### Public API changes

[DiagramShape](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/DiagramShape) class was updated with changes as follows:

*   Added the method [setWidth(double)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/DiagramShape#setWidth(double))
*   Added the method [setHeight(double)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/DiagramShape#setHeight(double))
*   Added the method [setX(double)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/DiagramShape#setX(double))
*   Added the method [setY(double)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/DiagramShape#setY(double))
*   Added the method [setRotateAngle(double)](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.contents/DiagramShape#setRotateAngle(double))
