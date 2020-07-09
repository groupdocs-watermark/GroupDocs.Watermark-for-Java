---
id: groupdocs-watermark-for-java-20-1-release-notes
url: watermark/java/groupdocs-watermark-for-java-20-1-release-notes
title: GroupDocs.Watermark for Java 20.1 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Watermark for Java 20.1{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check Public Docs section. The legacy API have been moved into legacy package so after update to this version it is required to make project-wide replacement of package usages from com.groupdocs.watermark. to com.groupwocs.watermark.legacy. to resolve build issues.{{< /alert >}}

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| WATERMARKNET-1093 | New Public API | Feature |

# Public API and Backward Incompatible Changes

All public types from com.groupdocs.watermark package are moved and marked as deprecated

#### All public types from com.groupdocs.watermark package

1.  Have been moved into **com.groupdocs.watermark.legacy** namespace
2.  Marked as **Deprecated***.*

#### Full list of types that have been moved and marked as deprecated:

###### div.rbtoc1591871307087 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1591871307087 ul { list-style-type: disc; list-style-image: none; margin-left: 0px; }div.rbtoc1591871307087 li { margin-left: 0px; padding-left: 0px; }

###### com.groupdocs.watermark

New package: **com.groupdocs.watermark.legacy**

Types:

*   AndSearchCriteria
*   AttachedImagePossibleWatermark
*   Attachment
*   AttachmentWatermarkableImage
*   CellsAttachedImagePossibleWatermark
*   CellsAttachment
*   CellsAttachmentCollection
*   CellsAutoShapeType
*   CellsBackgroundPossibleWatermark
*   CellsCellFormattedTextFragment
*   CellsCellFormattedTextFragmentCollection
*   CellsCellPossibleWatermark
*   CellsChart
*   CellsChartBackgroundPossibleWatermark
*   CellsChartCollection
*   CellsDocument
*   CellsHeaderFooter
*   CellsHeaderFooterCollection
*   CellsHeaderFooterPossibleWatermark
*   CellsHeaderFooterSection
*   CellsHeaderFooterSectionCollection
*   CellsHeaderFooterSectionType
*   CellsHyperlinkPossibleWatermark
*   CellsImageEffects
*   CellsImageFillFormat
*   CellsMsoDrawingType
*   CellsPageSetup
*   CellsSearchableObjects
*   CellsShape
*   CellsShapeCollection
*   CellsShapeFormattedTextFragment
*   CellsShapeFormattedTextFragmentCollection
*   CellsShapePossibleWatermark
*   CellsShapeSettings
*   CellsTextEffectFormattedTextFragment
*   CellsTextEffectFormattedTextFragmentCollection
*   CellsTextEffects
*   CellsWatermarkableImage
*   CellsWorksheet
*   CellsWorksheetCollection
*   Color
*   ColorRange
*   DetachedImageException
*   DiagramCommentPossibleWatermark
*   DiagramDocument
*   DiagramFormattedTextFragment
*   DiagramFormattedTextFragmentCollection
*   DiagramHeaderFooter
*   DiagramHeaderFooterFont
*   DiagramHeaderFooterPossibleWatermark
*   DiagramHyperlink
*   DiagramHyperlinkCollection
*   DiagramHyperlinkPossibleWatermark
*   DiagramPage
*   DiagramPageCollection
*   DiagramSearchableObjects
*   DiagramShape
*   DiagramShapeCollection
*   DiagramShapePossibleWatermark
*   DiagramShapeSettings
*   DiagramWatermarkPlacementType
*   DiagramWatermarkableImage
*   Dimension
*   Document
*   DocumentFactory
*   DocumentInfo
*   DocumentPart
*   EmailAddress
*   EmailAddressCollection
*   EmailAttachedImagePossibleWatermark
*   EmailAttachment
*   EmailAttachmentBase
*   EmailAttachmentCollection
*   EmailBodyTextPossibleWatermark
*   EmailBodyType
*   EmailDocument
*   EmailEmbeddedImagePossibleWatermark
*   EmailEmbeddedObject
*   EmailEmbeddedObjectCollection
*   EmailHtmlBodyTextPossibleWatermark
*   EmailSearchableObjects
*   EmailSubjectTextPossibleWatermark
*   EmailTextPossibleWatermark
*   EncryptionIsNotSupportedException
*   FileFormat
*   FloatingAttachedImagePossibleWatermark
*   Font
*   FontStyle
*   FormattedTextFragment
*   FormattedTextFragmentCollection
*   FormattedTextFragmentCollectionType
*   GifImageDocument
*   HorizontalAlignment
*   HyperlinkPossibleWatermark
*   IDocumentFactory
*   IRotatableTwoDObject
*   ISlidesHyperlinkContainer
*   ITwoDObject
*   ImageColorHistogramSearchCriteria
*   ImageDctHashSearchCriteria
*   ImageDocument
*   ImageFrame
*   ImageFrameCollection
*   ImageSearchCriteria
*   ImageThumbnailSearchCriteria
*   ImageWatermark
*   InvalidPasswordException
*   IsImageSearchCriteria
*   IsTextSearchCriteria
*   LoadOptions
*   MarginType
*   Margins
*   MultiframeImageDocument
*   NamespaceDoc
*   NamespaceDoc
*   NamespaceDoc
*   NotSearchCriteria
*   OfficeDashStyle
*   OfficeHeaderFooterType
*   OfficeImageEffects
*   OfficeImageFillFormatTWatermarkableImage
*   OfficeLineFormat
*   OfficeLineStyle
*   OfficeShapeSettings
*   OfficeTextEffects
*   OrSearchCriteria
*   PdfAnnotation
*   PdfAnnotationCollection
*   PdfAnnotationPossibleWatermark
*   PdfAnnotationType
*   PdfArtifact
*   PdfArtifactCollection
*   PdfArtifactPossibleWatermark
*   PdfArtifactSubtype
*   PdfArtifactType
*   PdfAttachedImagePossibleWatermark
*   PdfAttachment
*   PdfAttachmentCollection
*   PdfCryptoAlgorithm
*   PdfDocument
*   PdfFormattedTextFragment
*   PdfFormattedTextFragmentCollection
*   PdfHyperlinkPossibleWatermark
*   PdfImageConversionFormat
*   PdfPage
*   PdfPageCollection
*   PdfPageMarginType
*   PdfPermissions
*   PdfSearchableObjects
*   PdfShape
*   PdfShapeFormattedTextFragmentCollection
*   PdfTextFormattedTextFragmentCollection
*   PdfTextPossibleWatermark
*   PdfWatermarkableImage
*   PdfXForm
*   PdfXImage
*   PdfXObject
*   PdfXObjectCollection
*   PdfXObjectPossibleWatermark
*   PossibleWatermark
*   PossibleWatermarkCollection
*   PreviewFactory
*   PreviewHandler
*   PreviewImageData
*   PreviewNotSupportedException
*   PreviewPage
*   PreviewUnitOfMeasurement
*   ReadOnlyListBase
*   RemoveOnlyListBase
*   RotateAngleSearchCriteria
*   SearchCriteria
*   SearchableObjects
*   ShapePossibleWatermark
*   ShapeSearchAdapter
*   SizeSearchCriteria
*   SizingType
*   SlidesBackgroundPossibleWatermark
*   SlidesBaseShape
*   SlidesBaseSlide
*   SlidesChart
*   SlidesChartBackgroundPossibleWatermark
*   SlidesChartCollection
*   SlidesDocument
*   SlidesFormattedTextFragment
*   SlidesFormattedTextFragmentCollection
*   SlidesHyperlinkActionType
*   SlidesHyperlinkPossibleWatermark
*   SlidesImageEffects
*   SlidesImageFillFormat
*   SlidesLayoutSlide
*   SlidesLayoutSlideCollection
*   SlidesMasterHandoutSlide
*   SlidesMasterNotesSlide
*   SlidesMasterSlide
*   SlidesMasterSlideCollection
*   SlidesNotesSlide
*   SlidesSearchableObjects
*   SlidesShape
*   SlidesShapeCollection
*   SlidesShapePossibleWatermark
*   SlidesShapeSettings
*   SlidesShapeType
*   SlidesSlide
*   SlidesSlideCollection
*   SlidesSlideImageFillFormat
*   SlidesTextEffects
*   SlidesWatermarkableImage
*   TextAlignment
*   TextFormattingSearchCriteria
*   TextSearchCriteria
*   TextWatermark
*   TiffImageDocument
*   TwoDObjectPossibleWatermark
*   UnexpectedDocumentStructureException
*   UnitOfMeasurement
*   UnsupportedFileTypeException
*   VerticalAlignment
*   Watermark
*   WatermarkableImage
*   WatermarkableImageCollection
*   WordsDocument
*   WordsFlipOrientation
*   WordsFormattedTextFragmentCollection
*   WordsHeaderFooter
*   WordsHeaderFooterCollection
*   WordsHorizontalAlignment
*   WordsImageEffects
*   WordsLockType
*   WordsPageSetup
*   WordsProtectionType
*   WordsRelativeHorizontalPosition
*   WordsRelativeVerticalPosition
*   WordsSearchableObjects
*   WordsSection
*   WordsSectionCollection
*   WordsShape
*   WordsShapeCollection
*   WordsShapeFormattedTextFragmentCollection
*   WordsShapePossibleWatermark
*   WordsShapeSettings
*   WordsShapeType
*   WordsTextEffects
*   WordsTextFormattedTextFragment
*   WordsTextFormattedTextFragmentCollection
*   WordsTextHyperlinkPossibleWatermark
*   WordsTextPossibleWatermark
*   WordsVerticalAlignment
*   WordsWatermarkableImage
*   WordsWordArtShapeFormattedTextFragment
*   WordsWordArtShapeFormattedTextFragmentCollection
