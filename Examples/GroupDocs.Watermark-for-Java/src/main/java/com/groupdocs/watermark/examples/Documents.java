package com.groupdocs.watermark.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.groupdocs.watermark.CellsAttachment;
import com.groupdocs.watermark.CellsChart;
import com.groupdocs.watermark.CellsDocument;
import com.groupdocs.watermark.CellsHeaderFooter;
import com.groupdocs.watermark.CellsHeaderFooterSection;
import com.groupdocs.watermark.CellsHeaderFooterSectionCollection;
import com.groupdocs.watermark.CellsHeaderFooterSectionType;
import com.groupdocs.watermark.CellsImageEffects;
import com.groupdocs.watermark.CellsSearchableObjects;
import com.groupdocs.watermark.CellsShape;
import com.groupdocs.watermark.CellsShapeSettings;
import com.groupdocs.watermark.CellsTextEffects;
import com.groupdocs.watermark.CellsWatermarkableImage;
import com.groupdocs.watermark.CellsWorksheet;
import com.groupdocs.watermark.Color;
import com.groupdocs.watermark.DiagramDocument;
import com.groupdocs.watermark.DiagramHyperlink;
import com.groupdocs.watermark.DiagramPage;
import com.groupdocs.watermark.DiagramShape;
import com.groupdocs.watermark.DiagramShapeSettings;
import com.groupdocs.watermark.DiagramWatermarkPlacementType;
import com.groupdocs.watermark.DiagramWatermarkableImage;
import com.groupdocs.watermark.Document;
import com.groupdocs.watermark.EmailAddress;
import com.groupdocs.watermark.EmailAttachment;
import com.groupdocs.watermark.EmailDocument;
import com.groupdocs.watermark.EmailEmbeddedObject;
import com.groupdocs.watermark.EmailSearchableObjects;
import com.groupdocs.watermark.FileFormat;
import com.groupdocs.watermark.Font;
import com.groupdocs.watermark.FontStyle;
import com.groupdocs.watermark.FormattedTextFragment;
import com.groupdocs.watermark.HorizontalAlignment;
import com.groupdocs.watermark.ISlidesHyperlinkContainer;
import com.groupdocs.watermark.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.ImageSearchCriteria;
import com.groupdocs.watermark.ImageWatermark;
import com.groupdocs.watermark.OfficeDashStyle;
import com.groupdocs.watermark.OfficeHeaderFooterType;
import com.groupdocs.watermark.OfficeLineStyle;
import com.groupdocs.watermark.PdfAnnotation;
import com.groupdocs.watermark.PdfArtifact;
import com.groupdocs.watermark.PdfAttachment;
import com.groupdocs.watermark.PdfDocument;
import com.groupdocs.watermark.PdfImageConversionFormat;
import com.groupdocs.watermark.PdfPage;
import com.groupdocs.watermark.PdfPageMarginType;
import com.groupdocs.watermark.PdfSearchableObjects;
import com.groupdocs.watermark.PdfXObject;
import com.groupdocs.watermark.PossibleWatermarkCollection;
import com.groupdocs.watermark.SearchCriteria;
import com.groupdocs.watermark.SizingType;
import com.groupdocs.watermark.SlidesChart;
import com.groupdocs.watermark.SlidesDocument;
import com.groupdocs.watermark.SlidesHyperlinkActionType;
import com.groupdocs.watermark.SlidesImageEffects;
import com.groupdocs.watermark.SlidesImageFillFormat;
import com.groupdocs.watermark.SlidesLayoutSlide;
import com.groupdocs.watermark.SlidesMasterSlide;
import com.groupdocs.watermark.SlidesSearchableObjects;
import com.groupdocs.watermark.SlidesShape;
import com.groupdocs.watermark.SlidesShapeSettings;
import com.groupdocs.watermark.SlidesSlide;
import com.groupdocs.watermark.SlidesTextEffects;
import com.groupdocs.watermark.SlidesWatermarkableImage;
import com.groupdocs.watermark.TextSearchCriteria;
import com.groupdocs.watermark.TextWatermark;
import com.groupdocs.watermark.VerticalAlignment;
import com.groupdocs.watermark.WatermarkableImage;
import com.groupdocs.watermark.WatermarkableImageCollection;
import com.groupdocs.watermark.WordsDocument;
import com.groupdocs.watermark.WordsImageEffects;
import com.groupdocs.watermark.WordsPageSetup;
import com.groupdocs.watermark.WordsSection;
import com.groupdocs.watermark.WordsShape;
import com.groupdocs.watermark.WordsShapeSettings;
import com.groupdocs.watermark.WordsTextEffects;

public class Documents {
	public static class PDF {
		// initialize file path
		// ExStart:SourcePDFFilePath
		private final static String FILE_PATH = "sample.pdf";
		// ExEnd:SourcePDFFilePath

		/**
		 * Adds watermark to a PDF document
		 */
		public static void addWatermark() {
			try {
				// ExStart:AddWatermarkToPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
				doc.getPages().get_Item(0).addWatermark(textWatermark);

				// Add image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.getPages().get_Item(1).addWatermark(imageWatermark);
				imageWatermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets dimensions of a PDF document
		 */
		public static void getDimensions() {
			try {
				// ExStart:GetDimensionsPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));
				System.out.println(doc.getPages().get_Item(0).getWidth());
				System.out.println(doc.getPages().get_Item(0).getHeight());

				doc.close();
				// ExEnd:GetDimensionsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images inside a PDF document
		 */
		public static void addWatermarkToImages() {
			try {
				// ExStart:AddWatermarkToImagesPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				// Get all images from the first page
				WatermarkableImageCollection images = doc.getPages().get_Item(0).findImages();

				// Add watermark to all found images
				for (WatermarkableImage image : images) {
					image.addWatermark(watermark);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImagesPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds artifact watermark to a PDF document
		 */
		public static void addArtifactWatermark() {
			try {
				// ExStart:AddArtifactWatermarkPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.addArtifactWatermark(imageWatermark);
				imageWatermark.close();

				// Add text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
				doc.addArtifactWatermark(textWatermark);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddArtifactWatermarkPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds annotation watermark to a PDF document
		 */
		public static void addAnnotationWatermark() {
			try {
				// ExStart:AddAnnotationWatermarkPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.addAnnotationWatermark(imageWatermark);
				imageWatermark.close();

				// Add text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
				doc.addAnnotationWatermark(textWatermark);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddAnnotationWatermarkPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds print only annotation watermark to a PDF document
		 */
		public static void addPrintOnlyAnnotationWatermark() {
			try {
				// ExStart:AddPrintOnlyAnnotationWatermarkPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark textWatermark = new TextWatermark("This is a test watermark", new Font("Arial", 8));
				boolean isPrintOnly = true;

				// Annotation will be printed, but not displayed in pdf viewing
				// application
				doc.getPages().get_Item(0).addAnnotationWatermark(textWatermark, isPrintOnly);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddPrintOnlyAnnotationWatermarkPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes watermark from a PDF document
		 */
		public static void removeWatermark() {
			try {
				// ExStart:RemoveWatermarkFromPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize search criteria
				ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
				TextSearchCriteria textSearchCriteria = new TextSearchCriteria("This is a test watermark");

				PossibleWatermarkCollection possibleWatermarks = doc.getPages().get_Item(0)
						.findWatermarks(imageSearchCriteria.or(textSearchCriteria));

				// Remove all found watermarks
				for (int i = possibleWatermarks.getCount() - 1; i >= 0; i--) {
					possibleWatermarks.removeAt(i);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveWatermarkFromPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about all XObjects in a PDF document
		 */
		public static void extractXObjectInformation() {
			try {
				// ExStart:ExtractXObjectInformationPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfPage page : doc.getPages()) {
					for (PdfXObject xObject : page.getXObjects()) {
						if (xObject.getImage() != null) {
							System.out.println(xObject.getImage().getWidth());
							System.out.println(xObject.getImage().getHeight());
							System.out.println(xObject.getImage().getBytes().length);
						}
						for (FormattedTextFragment fragment : xObject.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}
						System.out.println(xObject.getText());
						System.out.println(xObject.getX());
						System.out.println(xObject.getY());
						System.out.println(xObject.getWidth());
						System.out.println(xObject.getHeight());
						System.out.println(xObject.getRotateAngle());
					}
				}
				doc.close();
				// ExEnd:ExtractXObjectInformationPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes XObject from a PDF document
		 */
		public static void removeXObject() {
			try {
				// ExStart:RemoveXObjectPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove XObject by index
				doc.getPages().get_Item(0).getXObjects().removeAt(0);

				// Remove XObject by reference
				doc.getPages().get_Item(0).getXObjects().remove(doc.getPages().get_Item(0).getXObjects().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveXObjectPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes XObject with particular text formatting
		 */
		public static void removeXObjectWithParticularTextFormatting() {
			try {
				// ExStart:RemoveXObjectWithParticularTextFormatting_1
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfPage page : doc.getPages()) {
					for (int i = page.getXObjects().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : page.getXObjects().get_Item(i)
								.getFormattedTextFragments()) {
							if (Color.getRed().equals(fragment.getForegroundColor())) {
								page.getXObjects().removeAt(i);
								break;
							}
						}
					}

				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveXObjectWithParticularTextFormatting_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images XObjects inside a PDF document
		 */
		public static void addWatermarkToXObjects() {
			try {
				// ExStart:AddWatermarkToXObjectsPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (PdfPage page : doc.getPages()) {
					for (PdfXObject xObject : page.getXObjects()) {
						if (xObject.getImage() != null) {
							// Add watermark to the image
							xObject.getImage().addWatermark(watermark);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToXObjectsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about all artifacts in a PDF document
		 */
		public static void extractArtifactInformation() {
			try {
				// ExStart:ExtractArtifactInformationPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfPage page : doc.getPages()) {
					for (PdfArtifact artifact : page.getArtifacts()) {
						System.out.println(artifact.getArtifactType());
						System.out.println(artifact.getArtifactSubtype());
						if (artifact.getImage() != null) {
							System.out.println(artifact.getImage().getWidth());
							System.out.println(artifact.getImage().getHeight());
							System.out.println(artifact.getImage().getBytes().length);
						}
						for (FormattedTextFragment fragment : artifact.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}
						System.out.println(artifact.getText());
						System.out.println(artifact.getOpacity());
						System.out.println(artifact.getX());
						System.out.println(artifact.getY());
						System.out.println(artifact.getWidth());
						System.out.println(artifact.getHeight());
						System.out.println(artifact.getRotateAngle());
					}
				}
				doc.close();
				// ExEnd:ExtractArtifactInformationPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes artifact from a PDF document
		 */
		public static void removeArtifact() {
			try {
				// ExStart:RemoveArtifactPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove Artifact by index
				doc.getPages().get_Item(0).getArtifacts().removeAt(0);

				// Remove Artifact by reference
				doc.getPages().get_Item(0).getArtifacts().remove(doc.getPages().get_Item(0).getArtifacts().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveArtifactPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes artifact containing particular text formatting
		 */
		public static void removeArtifactWithParticularTextFormatting() {
			try {
				// ExStart:RemoveArtifactsWithParticularTextFormatting_1
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfPage page : doc.getPages()) {
					for (int i = page.getArtifacts().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : page.getArtifacts().get_Item(i)
								.getFormattedTextFragments()) {
							if (fragment.getFont().getSize() > 42) {
								page.getArtifacts().removeAt(i);
								break;
							}
						}
					}

				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveArtifactsWithParticularTextFormatting_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images Artifacts inside a PDF document
		 */
		public static void addWatermarkToArtifacts() {
			try {
				// ExStart:AddWatermarkToArtifactsPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (PdfPage page : doc.getPages()) {
					for (PdfArtifact artifact : page.getArtifacts()) {
						if (artifact.getImage() != null) {
							// Add watermark to the image
							artifact.getImage().addWatermark(watermark);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToArtifactsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about all annotations in a PDF document
		 */
		public static void extractAnnotationInformation() {
			try {
				// ExStart:ExtractAnnotationInformationPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfPage page : doc.getPages()) {
					for (PdfAnnotation annotation : page.getAnnotations()) {
						System.out.println(annotation.getAnnotationType());
						if (annotation.getImage() != null) {
							System.out.println(annotation.getImage().getWidth());
							System.out.println(annotation.getImage().getHeight());
							System.out.println(annotation.getImage().getBytes().length);
						}
						for (FormattedTextFragment fragment : annotation.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}
						System.out.println(annotation.getText());
						System.out.println(annotation.getX());
						System.out.println(annotation.getY());
						System.out.println(annotation.getWidth());
						System.out.println(annotation.getHeight());
						System.out.println(annotation.getRotateAngle());
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ExtractAnnotationInformationPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes annotation from a PDF document
		 */
		public static void removeAnnotation() {
			try {
				// ExStart:RemoveAnnotationPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove Annotation by index
				doc.getPages().get_Item(0).getAnnotations().removeAt(0);

				// Remove Annotation by reference
				doc.getPages().get_Item(0).getAnnotations()
						.remove(doc.getPages().get_Item(0).getAnnotations().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveAnnotationPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes annotation with particular text formatting
		 */
		public static void removeAnnotationWithParticularTextFormatting() {
			try {
				// ExStart:RemoveAnnotationsWithParticularTextFormatting_1
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfPage page : doc.getPages()) {
					for (int i = page.getAnnotations().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : page.getAnnotations().get_Item(i)
								.getFormattedTextFragments()) {
							if ("Verdana".equals(fragment.getFont().getFamilyName())) {
								page.getAnnotations().removeAt(i);
								break;
							}
						}
					}

				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveAnnotationsWithParticularTextFormatting_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images Annotations inside a PDF document
		 */
		public static void addWatermarkToAnnotations() {
			try {
				// ExStart:AddWatermarkToAnnotationsPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (PdfPage page : doc.getPages()) {
					for (PdfAnnotation annotation : page.getAnnotations()) {
						if (annotation.getImage() != null) {
							// Add watermark to the image
							annotation.getImage().addWatermark(watermark);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToAnnotationsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Rasterizes a PDF document
		 */
		public static void rasterizePDFDocument() {
			try {
				// ExStart:RasterizePDFDocumentPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Do not copy", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);
				watermark.setOpacity(0.5);

				// Add watermark of any type first
				doc.addWatermark(watermark);

				// Rasterize all pages
				doc.rasterize(100, 100, PdfImageConversionFormat.Png);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RasterizePDFDocumentPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Rasterizes a particular page of a PDF document
		 */
		public static void rasterizeParticularPageOfPDFDocument() {
			try {
				// ExStart:RasterizeParticularPageOfPDFDocumentPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Do not copy", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);
				watermark.setOpacity(0.5);

				// Add watermark of any type first
				doc.getPages().get_Item(0).addWatermark(watermark);

				// Rasterize the first page
				doc.getPages().get_Item(0).rasterize(100, 100, PdfImageConversionFormat.Png);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RasterizeParticularPageOfPDFDocumentPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to a PDF document specifying page margin type
		 */
		public static void addWatermarkWithPageMrginType() {
			try {
				// ExStart:AddWatermarkWithPageMrginTypePDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 42));
				watermark.setHorizontalAlignment(HorizontalAlignment.Right);
				watermark.setVerticalAlignment(VerticalAlignment.Top);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				doc.setPageMarginType(PdfPageMarginType.BleedBox);
				watermark.setConsiderParentMargins(true);
				doc.addWatermark(watermark);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithPageMrginTypePDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extracts attachments from PDF document
		 */
		public static void extractAttachments() {
			try {
				// ExStart:extractAttachmentsPDF
				String targetFolder = Common.ATTACHMENTS_PATH;
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfAttachment attachment : doc.getAttachments()) {
					System.out.println("Name: " + attachment.getName());
					System.out.println("Description: " + attachment.getDescription());
					System.out.println("File format: " + attachment.getDocumentInfo().getFileFormat());

					// Save the attached file on disk
					FileOutputStream fileStream = new FileOutputStream(targetFolder + "\\" + attachment.getName());
					fileStream.write(attachment.getContent());
					fileStream.close();
				}
				doc.close();
				// ExEnd:extractAttachmentsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes particular attachment from PDF document
		 */
		public static void removeAttachment() {
			try {
				// ExStart:removeAttachmentPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (int i = doc.getAttachments().getCount() - 1; i >= 0; i--) {
					PdfAttachment attachment = doc.getAttachments().get_Item(i);

					// Remove all attached pdf files with a particular name
					if (attachment.getName().contains("EULA")
							&& attachment.getDocumentInfo().getFileFormat() == FileFormat.Pdf) {
						doc.getAttachments().removeAt(i);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:removeAttachmentPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all attached files of supported types
		 */
		public static void addWatermarkToAttachments() {
			try {
				// ExStart:addWatermarkToAttachmentsPDF
				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (PdfAttachment attachment : doc.getAttachments()) {
					// Check if the attached file is supported by
					// GroupDocs.Watermark
					if (attachment.getDocumentInfo().getFileFormat() != FileFormat.Undefined
							&& !attachment.getDocumentInfo().isEncrypted()) {
						// Load the attached document
						Document attachedDocument = attachment.loadDocument();

						// Add wateramrk
						attachedDocument.addWatermark(watermark);

						// Save changes in the attached file
						attachment.updateDocument(attachedDocument);

						// Close the attached document
						attachedDocument.close();
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:addWatermarkToAttachmentsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Searches for images in attached files
		 */
		public static void searchImagesInAttachments() {
			try {
				// ExStart:searchImagesInAttachmentsPDF
				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Consider only the attached images
				doc.getSearchableObjects().setPdfSearchableObjects(PdfSearchableObjects.AttachedImages);

				// Specify sample image to compare document images with
				ImageSearchCriteria criteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);

				// Search for similar images
				PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks(criteria);

				// Remove found image watermarks
				possibleWatermarks.clear();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:searchImagesInAttachmentsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds attachment to PDF file
		 */
		public static void addAttachments() {
			try {
				// ExStart:addAttachmentsPDF
				String attachmentPath = Common.mapSourceFilePath("sample.docx");
				File attachmentFile = new File(attachmentPath);
				byte[] attachmentBytes = new byte[(int) attachmentFile.length()];
				InputStream attachmentInputStream = new FileInputStream(attachmentFile);
				attachmentInputStream.read(attachmentBytes);
				attachmentInputStream.close();

				PdfDocument doc = Document.load(PdfDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add the attachment
				doc.getAttachments().add(attachmentBytes, "License Agreement.doc", "end-user license agreement");

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:addAttachmentsPDF
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}
	}

	public static class Word {
		// initialize file path
		// ExStart:SourceWordFilePath
		private final static String FILE_PATH = "sample_with_watermark.docx";

		// ExEnd:SourceWordFilePath
		/**
		 * Adds watermark to a section of Word document
		 */
		public static void addWatermarkToSection() {
			try {
				// ExStart:AddWatermarkToSection
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

				// Add watermark to all visible headers of the first section
				doc.getSections().get_Item(0).addWatermark(watermark);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToSection
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to a particular page of Word document
		 */
		public static void addWatermarkToParticuarPage() {
			try {
				// ExStart:AddWatermarkToParticuarPageWord
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark textWatermark = new TextWatermark("DRAFT", new Font("Arial", 42));

				// Add watermark to the last page
				doc.addWatermark(textWatermark, doc.getPageCount());

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToParticuarPageWord
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets properties of a section of Word document
		 */
		public static void getSectionProperties() {
			try {
				// ExStart:GetSectionProperties
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				WordsPageSetup pageSetup = doc.getSections().get_Item(0).getPageSetup();

				System.out.println(pageSetup.getWidth());
				System.out.println(pageSetup.getHeight());
				System.out.println(pageSetup.getTopMargin());
				System.out.println(pageSetup.getRightMargin());
				System.out.println(pageSetup.getBottomMargin());
				System.out.println(pageSetup.getLeftMargin());

				doc.close();
				// ExEnd:GetSectionProperties
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Links header/footer to the previous section of Word document
		 */
		public static void linkHeaderFooterInSection() {
			try {
				// ExStart:LinkHeaderFooterInSection
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Link footer for even numbered pages to corresponding footer
				// in previous section
				doc.getSections().get_Item(0).getHeadersFooters()
						.getByOfficeHeaderFooterType(OfficeHeaderFooterType.FooterEven).setLinkedToPrevious(true);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:LinkHeaderFooterInSection
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Links all header/footer to the previous section of Word document
		 */
		public static void linkAllHeaderFooterInSection() {
			try {
				// ExStart:LinkAllHeaderFooterInSection
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Link all headers and footers to the corresponding headers and
				// footers in the previous section.
				doc.getSections().get_Item(0).getHeadersFooters().linkToPrevious(true);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:LinkAllHeaderFooterInSection
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Links all header/footer to the previous section and adds watermark
		 */
		public static void linkAllHeaderFooterInSectionAndAddsWatermark() {
			try {
				// ExStart:LinkAllHeaderFooterInSection
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				// Add watermark to all visible headers of the first section
				doc.getSections().get_Item(0).addWatermark(watermark);

				watermark.close();

				// Link all other headers&footers to corresponding
				// headers&footers of the first section
				for (int i = 1; i < doc.getSections().getCount(); i++) {
					doc.getSections().get_Item(i).getHeadersFooters().linkToPrevious(true);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:LinkAllHeaderFooterInSection
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets different headers/footers for even/odd numbered pages and for
		 * the first page of the document
		 */
		public static void setDifferentFirstPageHeaderFooter() {
			try {
				// ExStart:SetDifferentFirstPageHeaderFooter
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				doc.getSections().get_Item(0).getPageSetup().setDifferentFirstPageHeaderFooter(true);
				doc.getSections().get_Item(0).getPageSetup().setOddAndEvenPagesHeaderFooter(true);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SetDifferentFirstPageHeaderFooter
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds image watermark to a word document
		 */
		public static void addImageWatermark() {
			try {
				// ExStart:AddImageWatermarkToWord
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				// Add watermark to all visible headers of the first section
				doc.getSections().get_Item(0).addWatermark(watermark);

				watermark.close();

				// Link all other headers&footers to corresponding
				// headers&footers of the first section
				for (int i = 1; i < doc.getSections().getCount(); i++) {
					doc.getSections().get_Item(i).getHeadersFooters().linkToPrevious(true);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddImageWatermarkToWord
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images inside a section of Word document
		 */
		public static void addWatermarkToImages() {
			try {
				// ExStart:AddWatermarkToImagesWordSection
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				// Get all images belonging to the first section
				WatermarkableImageCollection images = doc.getSections().get_Item(0).findImages();

				// Add watermark to all found images
				for (WatermarkableImage image : images) {
					image.addWatermark(watermark);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImagesWordSection
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to Word document with Words Shape Settings
		 */
		public static void addWatermarkWithWordsShapeSettings() {
			try {
				// ExStart:AddWatermarkWithWordsShapeSettings
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("This is test watermark", new Font("Arial", 19));
				WordsShapeSettings shapeSettings = new WordsShapeSettings();

				// Set the shape name
				shapeSettings.setName("Shape 1");

				// Set the descriptive (alternative) text that will be
				// associated with the shape
				shapeSettings.setAlternativeText("Test watermark");

				doc.addWatermark(watermark, shapeSettings);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithWordsShapeSettings
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to Word document with text effects
		 */
		public static void addWatermarkWithTextEffects() {
			try {
				// ExStart:AddWatermarkWithTextEffectsWord
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

				WordsTextEffects effects = new WordsTextEffects();
				effects.getLineFormat().setEnabled(true);
				effects.getLineFormat().setColor(Color.getRed());
				effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);
				effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);
				effects.getLineFormat().setWeight(1);
				doc.addTextWatermark(watermark, effects);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithTextEffectsWord
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to Word document with image effects
		 */
		public static void addWatermarkWithImageEffects() {
			try {
				// ExStart:AddWatermarkWithImageEffectsWord
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				WordsImageEffects effects = new WordsImageEffects();
				effects.setBrightness(0.7);
				effects.setContrast(0.6);
				effects.setChromaKey(Color.getWhite());
				effects.getBorderLineFormat().setEnabled(true);
				effects.getBorderLineFormat().setWeight(1);
				doc.addImageWatermark(watermark, effects);
				watermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithImageEffectsWord
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes watermark from a particular section of Word document
		 */
		public static void removeWatermarkFromSection() {
			try {
				// ExStart:RemoveWatermarkFromSection
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize search criteria
				ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
				TextSearchCriteria textSearchCriteria = new TextSearchCriteria("This is test watermark");

				// Call findWatermarks method for a section
				PossibleWatermarkCollection possibleWatermarks = doc.getSections().get_Item(0)
						.findWatermarks(textSearchCriteria.or(imageSearchCriteria));

				// Remove all found watermarks
				for (int i = possibleWatermarks.getCount() - 1; i >= 0; i--) {
					possibleWatermarks.removeAt(i);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveWatermarkFromSection
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Finds watermarks in a header/footer of Word document
		 */
		public static void findWatermarkInHeaderFooter() {
			try {
				// ExStart:FindWatermarkInHeaderFooter
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
				TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Company Name");

				PossibleWatermarkCollection possibleWatermarks = doc.getSections().get_Item(0).getHeadersFooters()
						.getByOfficeHeaderFooterType(OfficeHeaderFooterType.HeaderPrimary)
						.findWatermarks(textSearchCriteria.or(imageSearchCriteria));

				System.out.println(possibleWatermarks.getCount());
				doc.close();
				// ExEnd:FindWatermarkInHeaderFooter
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extracts information about all the shapes is a Word document
		 */
		public static void getShapesInformation() {
			try {
				// ExStart:GetShapesInformationWord
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (WordsSection section : doc.getSections()) {
					for (WordsShape shape : section.getShapes()) {
						if (shape.getHeaderFooter() != null) {
							System.out.println("In header/footer");
						}

						System.out.println(shape.getShapeType());
						System.out.println(shape.getWidth());
						System.out.println(shape.getHeight());
						System.out.println(shape.isWordArt());
						System.out.println(shape.getRotateAngle());
						System.out.println(shape.getAlternativeText());
						System.out.println(shape.getName());
						System.out.println(shape.getX());
						System.out.println(shape.getY());
						System.out.println(shape.getText());
						if (shape.getImage() != null) {
							System.out.println(shape.getImage().getWidth());
							System.out.println(shape.getImage().getHeight());
							System.out.println(shape.getImage().getBytes().length);
						}

						for (FormattedTextFragment fragment : shape.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}

						System.out.println(shape.getHorizontalAlignment());
						System.out.println(shape.getVerticalAlignment());
						System.out.println(shape.getRelativeHorizontalPosition());
						System.out.println(shape.getRelativeVerticalPosition());
						System.out.println(shape.getHyperlink());
					}
				}

				doc.close();
				// ExEnd:GetShapesInformationWord
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shape in a Word document
		 */
		public static void removeShape() {
			try {
				// ExStart:RemoveShapeWordDocument
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove shape by index
				doc.getSections().get_Item(0).getShapes().removeAt(0);

				// Remove shape by reference
				doc.getSections().get_Item(0).getShapes().remove(doc.getSections().get_Item(0).getShapes().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveShapeWordDocument
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shape with particular text formatting
		 */
		public static void removeShapeWithParticularTextFormatting() {
			try {
				// ExStart:RemoveTextShapesWithParticularTextFormattingWord_1
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (WordsSection section : doc.getSections()) {
					for (int i = section.getShapes().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : section.getShapes().get_Item(i)
								.getFormattedTextFragments()) {
							if ("Arial".equals(fragment.getFont().getFamilyName())
									&& Color.getRed().equals(fragment.getForegroundColor())) {
								section.getShapes().removeAt(i);
								break;
							}
						}
					}

				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveTextShapesWithParticularTextFormattingWord_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all image shapes in a Word document
		 */
		public static void addWatermarkToImageShapes() {
			try {
				// ExStart:AddWatermarkToImageShapesWordDocument
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (WordsSection section : doc.getSections()) {
					for (WordsShape shape : section.getShapes()) {
						// Headers&Footers usually contains only service
						// information.
						// So, we skip images in headers/footers, expecting that
						// they are probably watermarks or backgrounds
						if (shape.getHeaderFooter() == null && shape.getImage() != null) {
							shape.getImage().addWatermark(watermark);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImageShapesWordDocument
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes/replaces hyperlink associated with a particular shape
		 */
		public static void removeHyperlinkAssociatedWithParticularShape() {
			try {
				// ExStart:RemoveHyperlinksWord_1
				WordsDocument doc = Document.load(WordsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Replace hyperlink
				doc.getSections().get_Item(0).getShapes().get_Item(0).setHyperlink("https://www.groupdocs.com/");

				// Remove hyperlink
				doc.getSections().get_Item(0).getShapes().get_Item(1).setHyperlink(null);

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveHyperlinksWord_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}
	}

	public static class Excel {
		// initialize file path
		// ExStart:SourceExcelFilePath
		private final static String FILE_PATH = "sample.xlsx";
		// ExEnd:SourceExcelFilePath

		/**
		 * Adds watermark to Excel spreadsheet
		 */
		public static void addWatermark() {
			try {
				// ExStart:AddWatermarkToExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
				doc.getWorksheets().get_Item(0).addWatermark(textWatermark);

				// Add image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.getWorksheets().get_Item(0).addWatermark(imageWatermark);
				imageWatermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets content area dimensions of Excel worksheet
		 */
		public static void getContentAreaDimensions() {
			try {
				// ExStart:GetContentAreaDimensionsExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Get the size of content area
				System.out.println(doc.getWorksheets().get_Item(0).getContentAreaHeight());
				System.out.println(doc.getWorksheets().get_Item(0).getContentAreaWidth());

				// Get the size of particular cell
				System.out.println(doc.getWorksheets().get_Item(0).getColumnWidth(0));
				System.out.println(doc.getWorksheets().get_Item(0).getRowHeight(0));

				doc.close();
				// ExEnd:GetContentAreaDimensionsExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images inside an Excel worksheet
		 */
		public static void addWatermarkToImages() {
			try {
				// ExStart:AddWatermarkToImagesExcelWorksheet
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				// Get all images from the first worksheet
				WatermarkableImageCollection images = doc.getWorksheets().get_Item(0).findImages();

				// Add watermark to all found images
				for (WatermarkableImage image : images) {
					image.addWatermark(watermark);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();

				// ExEnd:AddWatermarkToImagesExcelWorksheet
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds modern word art watermark to Excel worksheet
		 */
		public static void addModernWordArdWatermark() {
			try {
				// ExStart:AddModernWordArdWatermarkToExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 36));
				doc.getWorksheets().get_Item(0).addModernWordArtWatermark(textWatermark);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddModernWordArdWatermarkToExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to Excel worksheet with additional shape settings
		 */
		public static void addWatermarkUsingCellsShapeSettings() {
			try {
				// ExStart:AddWatermarkUsingCellsShapeSettings
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 36));
				CellsShapeSettings shapeSettings = new CellsShapeSettings();

				// Set the shape name
				shapeSettings.setName("Shape 1");

				// Set the descriptive (alternative) text that will be
				// associated with the shape
				shapeSettings.setAlternativeText("Test watermark");

				// Editing of the shape in Excel is forbidden
				shapeSettings.setLocked(true);
				doc.addModernWordArtWatermark(textWatermark, shapeSettings);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkUsingCellsShapeSettings
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark with text effects to Excel worksheet
		 */
		public static void addWatermarkWithTextEffects() {
			try {
				// ExStart:AddWatermarkWithTextEffectsToExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));

				CellsTextEffects effects = new CellsTextEffects();
				effects.getLineFormat().setEnabled(true);
				effects.getLineFormat().setColor(Color.getRed());
				effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);
				effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);
				effects.getLineFormat().setWeight(1);

				doc.addTextWatermark(watermark, effects);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithTextEffectsToExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark with image effects to Excel worksheet
		 */
		public static void addWatermarkWithImageEffects() {
			try {
				// ExStart:AddWatermarkWithImageEffectsToExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				CellsImageEffects effects = new CellsImageEffects();
				effects.setBrightness(0.7);
				effects.setContrast(0.6);
				effects.setChromaKey(Color.getWhite());
				effects.getBorderLineFormat().setEnabled(true);
				effects.getBorderLineFormat().setWeight(1);

				doc.addImageWatermark(watermark, effects);
				watermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithImageEffectsToExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark as background to Excel worksheet
		 */
		public static void addWatermarkAsBackground() {
			try {
				// ExStart:AddWatermarkAsBackgroundToExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.addWatermarkAsBackground(watermark);
				watermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkAsBackgroundToExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark as background with relative size and position to Excel
		 * worksheet
		 */
		public static void addWatermarkAsBackgroundWithRelativeSizeAndPosition() {
			try {
				// ExStart:AddWatermarkAsBackgroundWithRelativeSizeAndPosition
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(90);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(0.5);
				doc.getWorksheets().get_Item(0).addWatermarkAsBackground(watermark, doc.getWorksheets().get_Item(0)
						.getContentAreaWidthPx() /* set background width */,
						doc.getWorksheets().get_Item(0)
								.getContentAreaHeightPx() /*
															 * set background
															 * height
															 */);
				watermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkAsBackgroundWithRelativeSizeAndPosition
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark text as background to Excel worksheet
		 * <param name="WatermarkText"></param>
		 */
		public static void addWatermarkAsBackground(String WatermarkText) {
			try {
				// ExStart:AddWatermarkTextAsBackgroundToExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(0.5);
				watermark.setOpacity(0.5);
				doc.getWorksheets().get_Item(0).addWatermarkAsBackground(watermark, doc.getWorksheets().get_Item(0)
						.getContentAreaWidthPx() /* set background width */,
						doc.getWorksheets().get_Item(0)
								.getContentAreaHeightPx() /*
															 * set background
															 * height
															 */);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkTextAsBackgroundToExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds image watermark into header/footer of Excel worksheet
		 */
		public static void addWatermarkIntoHeaderFooter() {
			try {
				// ExStart:AddImageWatermarkIntoHeaderFooter
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				watermark.setVerticalAlignment(VerticalAlignment.Top);
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);
				doc.getWorksheets().get_Item(0).addWatermarkIntoHeaderFooter(watermark);
				watermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddImageWatermarkIntoHeaderFooter
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds text watermark into header/footer of Excel worksheet
		 * <param name="WatermarkText"></param>
		 */
		public static void addWatermarkIntoHeaderFooter(String WatermarkText) {
			try {
				// ExStart:AddTextWatermarkIntoHeaderFooter
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19, FontStyle.Bold));
				watermark.setForegroundColor(Color.getRed());
				watermark.setVerticalAlignment(VerticalAlignment.Top);
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				doc.getWorksheets().get_Item(0).addWatermarkIntoHeaderFooter(watermark);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddTextWatermarkIntoHeaderFooter
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes watermark from Excel worksheet
		 */
		public static void removeWatermark() {
			try {
				// ExStart:RemoveWatermarkExcelWorksheet
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize search criteria
				ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
				TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Test watermark");

				// Call findWatermarks method for a worksheet
				PossibleWatermarkCollection possibleWatermarks = doc.getWorksheets().get_Item(0)
						.findWatermarks(textSearchCriteria.or(imageSearchCriteria));

				// Remove all found watermarks
				for (int i = possibleWatermarks.getCount() - 1; i >= 0; i--) {
					possibleWatermarks.removeAt(i);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveWatermarkExcelWorksheet
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extracts information about all the shapes is a Excel document
		 */
		public static void getShapesInformation() {
			try {
				// ExStart:GetShapesInformationExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (CellsShape shape : worksheet.getShapes()) {
						System.out.println(shape.getAutoShapeType());
						System.out.println(shape.getMsoDrawingType());
						System.out.println(shape.getText());
						if (shape.getImage() != null) {
							System.out.println(shape.getImage().getWidth());
							System.out.println(shape.getImage().getHeight());
							System.out.println(shape.getImage().getBytes().length);
						}
						for (FormattedTextFragment fragment : shape.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}
						System.out.println(shape.getHyperlink());
						System.out.println(shape.getId());
						System.out.println(shape.getAlternativeText());
						System.out.println(shape.getX());
						System.out.println(shape.getY());
						System.out.println(shape.getWidth());
						System.out.println(shape.getHeight());
						System.out.println(shape.getRotateAngle());
						System.out.println(shape.isWordArt());
						System.out.println(shape.getName());
					}
				}

				doc.close();
				// ExEnd:GetShapesInformationExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shape in an Excel worksheet
		 */
		public static void removeShape() {
			try {
				// ExStart:RemoveShapeExcelWorksheet
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove shape by index
				doc.getWorksheets().get_Item(0).getShapes().removeAt(0);

				// Remove shape by reference
				doc.getWorksheets().get_Item(0).getShapes()
						.remove(doc.getWorksheets().get_Item(0).getShapes().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveShapeExcelWorksheet
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shape with particular text formatting
		 */
		public static void removeShapeWithParticularTextFormatting() {
			try {
				// ExStart:RemoveTextShapesWithParticularTextFormattingExcel_1
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (int i = worksheet.getShapes().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : worksheet.getShapes().get_Item(i)
								.getFormattedTextFragments()) {
							if ("Arial".equals(fragment.getFont().getFamilyName())
									&& Color.getRed().equals(fragment.getForegroundColor())) {
								worksheet.getShapes().removeAt(i);
								break;
							}
						}
					}
				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveTextShapesWithParticularTextFormattingExcel_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all image shapes in a Excel document
		 */
		public static void addWatermarkToImageShapes() {
			try {
				// ExStart:AddWatermarkToImageShapesExcelDocument
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (CellsShape shape : worksheet.getShapes()) {
						if (shape.getImage() != null) {
							// Add watermark to the image
							shape.getImage().addWatermark(watermark);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImageShapesExcelDocument
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces text for particular shapes
		 */
		public static void replaceTextForParticularShapes() {
			try {
				// ExStart:ReplaceTextForParticularShapes_17.12
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsShape shape : doc.getWorksheets().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.setText("© GroupDocs 2017");
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceTextForParticularShapes_17.12
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}

		}

		/**
		 * Replaces text with formatting for particular shapes
		 */
		public static void replaceTextWithParticularFormatting() {

			try {
				// ExStart:ReplaceTextWithFormattingForParticularShapes_17.12
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsShape shape : doc.getWorksheets().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.getFormattedTextFragments().clear();
						shape.getFormattedTextFragments().add("© GroupDocs 2017",
								new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceTextWithFormattingForParticularShapes_17.12
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}

		}

		/**
		 * Replaces image of particular shapes
		 */
		public static void replaceImageOfParticularShapes() {
			try {
				// ExStart:ReplaceImageOfParticularShapes_17.12
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				for (CellsShape shape : doc.getWorksheets().get_Item(0).getShapes()) {
					if (shape.getImage() != null) {
						shape.setImage(new CellsWatermarkableImage(imageBytes));
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceImageOfParticularShapes_17.12
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets background image for particular shapes
		 */
		public static void setBackgroundImageForParticularShapes() {
			try {
				// ExStart:SetBackgroundImageForParticularShapes_17.12
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				for (CellsShape shape : doc.getWorksheets().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.getImageFillFormat().setBackgroundImage(new CellsWatermarkableImage(imageBytes));
						shape.getImageFillFormat().setTransparency(0.5);
						shape.getImageFillFormat().setTileAsTexture(true);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SetBackgroundImageForParticularShapes_17.12
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Updates shape properties
		 */
		public static void updateShapeProperties() {
			try {
				// ExStart:UpdateShapeProperties_17.12
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsShape shape : doc.getWorksheets().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.setAlternativeText("watermark");
						shape.setRotateAngle(30);
						shape.setX(200);
						shape.setY(200);
						shape.setWidth(400);
						shape.setHeight(100);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:UpdateShapeProperties_17.12
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about all worksheet backgrounds in a Excel document
		 */
		public static void getInformationOfWorksheetBackgrounds() {
			try {
				// ExStart:GetInformationOfWorksheetBackgrounds
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					if (worksheet.getBackgroundImage() != null) {
						System.out.println(worksheet.getBackgroundImage().getWidth());
						System.out.println(worksheet.getBackgroundImage().getHeight());
						System.out.println(worksheet.getBackgroundImage().getBytes().length);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:GetInformationOfWorksheetBackgrounds
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes background in a Excel worksheet
		 */
		public static void removeWorksheetBackground() {
			try {
				// ExStart:RemoveWorksheetBackground
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				doc.getWorksheets().get_Item(0).setBackgroundImage(null);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveWorksheetBackground
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all background images in a Excel worksheet
		 */
		public static void addWatermarkToBackgroundImages() {
			try {
				// ExStart:AddWatermarkToBackgroundImagesExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					if (worksheet.getBackgroundImage() != null) {
						// Add watermark to the image
						worksheet.getBackgroundImage().addWatermark(watermark);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToBackgroundImagesExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about all headers/footers in a Excel document
		 */
		public static void getHeaderFooterInformation() {
			try {
				// ExStart:GetHeaderFooterInformationExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (CellsHeaderFooter headerFooter : worksheet.getHeadersFooters()) {
						System.out.println(headerFooter.getHeaderFooterType());
						for (CellsHeaderFooterSection section : headerFooter.getSections()) {
							System.out.println(section.getSectionType());
							if (section.getImage() != null) {
								System.out.println(section.getImage().getWidth());
								System.out.println(section.getImage().getHeight());
								System.out.println(section.getImage().getBytes().length);
							}
							System.out.println(section.getScript());
						}
					}
				}

				doc.close();
				// ExEnd:GetHeaderFooterInformationExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Clears particular headers/footers in a Excel worksheet
		 */
		public static void clearHeaderFooter() {
			try {
				// ExStart:ClearHeaderFooterExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				CellsHeaderFooterSectionCollection sections = doc.getWorksheets().get_Item(0).getHeadersFooters()
						.getByOfficeHeaderFooterType(OfficeHeaderFooterType.HeaderPrimary).getSections();
				for (CellsHeaderFooterSection section : sections) {
					section.setScript(null);
					section.setImage(null);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ClearHeaderFooterExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Clears particular section of headers/footers in a Excel worksheet
		 */
		public static void clearSectionOfHeaderFooter() {
			try {
				// ExStart:ClearSectionOfHeaderFooterExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				CellsHeaderFooterSection section = doc.getWorksheets().get_Item(0).getHeadersFooters()
						.getByOfficeHeaderFooterType(OfficeHeaderFooterType.HeaderPrimary).getSections()
						.getByCellsHeaderFooterSectionType(CellsHeaderFooterSectionType.Left);

				section.setScript(null);
				section.setImage(null);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ClearSectionOfHeaderFooterExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images of headers/footers in a Excel worksheet
		 */
		public static void addWatermarkToImagesInHeaderFooter() {
			try {
				// ExStart:AddWatermarkToImagesInHeaderFooterExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (CellsHeaderFooter headerFooter : worksheet.getHeadersFooters()) {
						for (CellsHeaderFooterSection section : headerFooter.getSections()) {
							if (section.getImage() != null) {
								// Add watermark to the image
								section.getImage().addWatermark(watermark);
							}
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImagesInHeaderFooterExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets background image for a chart in a Excel worksheet
		 */
		public static void setBackgroundImageForChart() {
			try {
				// ExStart:SetBackgroundImageForChart
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				CellsChart chart = doc.getWorksheets().get_Item(0).getCharts().get_Item(0);
				chart.getImageFillFormat().setBackgroundImage(new CellsWatermarkableImage(imageBytes));
				chart.getImageFillFormat().setTransparency(0.5);
				chart.getImageFillFormat().setTileAsTexture(true);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SetBackgroundImageForChart
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about all charts on a worksheet
		 */
		public static void getInformationAboutAllChart() {
			try {
				// ExStart:getInformationAboutAllChart
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsChart chart : doc.getWorksheets().get_Item(0).getCharts()) {
					System.out.println(chart.getWidth());
					System.out.println(chart.getHeight());
					System.out.println(chart.getX());
					System.out.println(chart.getY());
					System.out.println(chart.getAlternativeText());
					System.out.println(chart.getId());
					System.out.println(chart.getName());
					System.out.println(chart.getHyperlink());
				}

				doc.close();
				// ExEnd:getInformationAboutAllChart
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extract information about all attachments in an Excel document
		 */
		public static void extractAttachmentsInfo() {
			try {
				// ExStart:extractAttachmentsInfo
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (CellsAttachment attachment : worksheet.getAttachments()) {
						System.out.println("Alternative text: " + attachment.getAlternativeText());
						System.out.println("Attachment frame x-coordinate: " + attachment.getX());
						System.out.println("Attachment frame y-coordinate: " + attachment.getY());
						System.out.println("Attachment frame width: " + attachment.getWidth());
						System.out.println("Attachment frame height: " + attachment.getHeight());
						System.out.println("Preview image size: " + attachment.getPreviewImageContent() != null
								? attachment.getPreviewImageContent().length : 0);

						if (attachment.isLink()) {
							// The document contains only a link to the attached
							// file
							System.out.println("Full path to the attached file: " + attachment.getSourceFullName());
						} else {
							// The attached file is stored in the document
							System.out.println("File format: " + attachment.getDocumentInfo().getFileFormat());
							System.out.println("Name of the source file: " + attachment.getSourceFullName());
							System.out.println("File size: " + attachment.getContent().length);
						}
					}
				}

				doc.close();
				// ExEnd:extractAttachmentsInfo
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Add an attachment to an Excel document
		 */
		public static void addAttachment() {
			try {
				// ExStart:AddAttachmentExcel
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String attachmentPath = Common.mapSourceFilePath("sample.docx");
				File file = new File(attachmentPath);
				byte[] attachmentBytes = new byte[(int) file.length()];
				InputStream inputStream = new FileInputStream(file);
				inputStream.read(attachmentBytes);
				inputStream.close();

				String previewImagePath = Common.mapSourceFilePath("sample.png");
				file = new File(previewImagePath);
				byte[] previewImageBytes = new byte[(int) file.length()];
				inputStream = new FileInputStream(file);
				inputStream.read(previewImageBytes);
				inputStream.close();

				CellsWorksheet worksheet = doc.getWorksheets().get_Item(0);

				// Add the attachment
				worksheet.getAttachments().addAttachment(attachmentBytes, // File
																			// content
						attachmentPath, // Source file full name (the extension
										// is used to determine appropriate
										// application to open the file)
						previewImageBytes, // Preview image content
						50, // X-coordinate of the attachment frame
						100, // Y-coordinate of the attachment frame
						200, // Attachment frame width
						400); // Attachment frame height

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddAttachmentExcel
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Add a linked file to an Excel document
		 */
		public static void addLinkedAttachment() {
			try {
				// ExStart:AddLinkedAttachment
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String attachmentPath = Common.mapSourceFilePath("sample.docx");
				String previewImagePath = Common.mapSourceFilePath("sample.png");
				File file = new File(previewImagePath);
				byte[] previewImageBytes = new byte[(int) file.length()];
				FileInputStream inputStream = new FileInputStream(file);
				inputStream.read(previewImageBytes);
				inputStream.close();

				CellsWorksheet worksheet = doc.getWorksheets().get_Item(0);

				// Add the attachment
				worksheet.getAttachments().addLink(attachmentPath, // Source
																	// file path
						previewImageBytes, // Preview image content
						50, // X-coordinate of the attachment frame
						100, // Y-coordinate of the attachment frame
						200, // Attachment frame width
						400); // Attachment frame height

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddLinkedAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Remove particular attachments from an Excel document
		 */
		public static void removeAttachment() {
			try {
				// ExStart:RemoveAttachment
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (int i = worksheet.getAttachments().getCount() - 1; i >= 0; i--) {
						CellsAttachment attachment = worksheet.getAttachments().get_Item(i);
						if (attachment.isLink() && !new File(attachment.getSourceFullName()).exists() || // Linked
																											// file
																											// that
																											// is
																											// not
																											// available
																											// at
																											// this
																											// moment
								attachment.getDocumentInfo().isEncrypted()) // Attached
																			// file
																			// protected
																			// with
																			// a
																			// password
						{
							// Remove the file if it meets at least one of the
							// conditions above
							worksheet.getAttachments().removeAt(i);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Add watermark to all attached files of supported types
		 */
		public static void addWatermarkToAttachments() {
			try {
				// ExStart:AddWatermarkToAttachment
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

				for (CellsWorksheet worksheet : doc.getWorksheets()) {
					for (CellsAttachment attachment : worksheet.getAttachments()) {
						// Check if the attached file is supported by
						// GroupDocs.Watermark
						if (attachment.getDocumentInfo().getFileFormat() != FileFormat.Undefined
								&& !attachment.getDocumentInfo().isEncrypted()) {
							// Load the attached document
							Document attachedDocument = attachment.loadDocument();

							// Add wateramrk
							attachedDocument.addWatermark(watermark);

							// Save changes in the attached file
							attachment.updateDocument(attachedDocument);

							attachedDocument.close();
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Search for images in the attached files using FindImages or
		 * FindWatermarks method
		 */
		public static void searchImagesInAttachments() {
			try {
				// ExStart:SearchImageInAttachment
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Consider only the attached images
				doc.getSearchableObjects().setCellsSearchableObjects(CellsSearchableObjects.AttachedImages);

				// Specify sample image to compare document images with
				ImageSearchCriteria criteria = new ImageDctHashSearchCriteria("D:\\watermark.jpg");

				// Search for similar images
				PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks(criteria);

				// Remove found image watermarks
				possibleWatermarks.clear();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SearchImageInAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes/replaces hyperlink associated with particular shape
		 */
		public static void removeHyperlinkAssociatedWithParticularShape() {
			try {
				// ExStart:RemoveHyperlinksExcel_1
				CellsDocument doc = Document.load(CellsDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Replace hyperlink
				doc.getWorksheets().get_Item(0).getCharts().get_Item(0).setHyperlink("https://www.aspose.com/");
				doc.getWorksheets().get_Item(0).getShapes().get_Item(0).setHyperlink("https://www.groupdocs.com/");

				// Remove hyperlink
				doc.getWorksheets().get_Item(1).getCharts().get_Item(0).setHyperlink(null);
				doc.getWorksheets().get_Item(1).getShapes().get_Item(0).setHyperlink(null);

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveHyperlinksExcel_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

	}

	public static class PowerPoint {
		// initialize file path
		// ExStart:SourcePowerPointFilePath
		private final static String FILE_PATH = "sample.pptx";
		// ExEnd:SourcePowerPointFilePath

		/**
		 * Adds watermark to a PowerPoint slide
		 */
		public static void addWatermark() {
			try {
				// ExStart:AddWatermarkToPowerPointSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Arial", 8));
				doc.getSlides().get_Item(0).addWatermark(textWatermark);

				// Add image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.getSlides().get_Item(1).addWatermark(imageWatermark);
				imageWatermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToPowerPointSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets dimensions of a PowerPoint slide
		 */
		public static void getDimensionsOfSlide() {
			try {
				// ExStart:GetDimensionsOfSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				System.out.println(doc.getSlideWidth());
				System.out.println(doc.getSlideHeight());

				doc.close();
				// ExEnd:GetDimensionsOfSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images of a PowerPoint slide
		 */
		public static void addWatermarkToImages() {
			try {
				// ExStart:AddWatermarkToImagesPowerPointSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				// Get all images from the first slide
				WatermarkableImageCollection images = doc.getSlides().get_Item(0).findImages();

				// Add watermark to all found images
				for (WatermarkableImage image : images) {
					image.addWatermark(watermark);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImagesPowerPointSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all slide types of PowerPoint document
		 */
		public static void addWatermarkToAllSlideTypes() {
			try {
				// ExStart:AddWatermarkToAllSlideTypes
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 8));

				// Add watermark to all master slides
				for (SlidesMasterSlide slide : doc.getMasterSlides()) {
					slide.addWatermark(watermark);
				}

				// Add watermark to all layout slides
				if (doc.getLayoutSlides() != null) {
					for (SlidesLayoutSlide slide : doc.getLayoutSlides()) {
						slide.addWatermark(watermark);
					}
				}

				// Add watermark to all notes slides
				for (SlidesSlide slide : doc.getSlides()) {
					if (slide.getNotesSlide() != null) {
						slide.getNotesSlide().addWatermark(watermark);
					}
				}

				// Add watermark to handout master
				if (doc.getMasterHandoutSlide() != null) {
					doc.getMasterHandoutSlide().addWatermark(watermark);
				}

				// Add watermark to notes master
				if (doc.getMasterNotesSlide() != null) {
					doc.getMasterNotesSlide().addWatermark(watermark);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToAllSlideTypes
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to a PowerPoint slide with Slides Shape Settings
		 */
		public static void addWatermarkWithSlidesShapeSettings() {
			try {
				// ExStart:AddWatermarkWithSlidesShapeSettings
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));
				watermark.setBackground(true);
				SlidesShapeSettings shapeSettings = new SlidesShapeSettings();

				// Set the shape name
				shapeSettings.setName("Shape 1");

				// Set the descriptive (alternative) text that will be
				// associated with the shape
				shapeSettings.setAlternativeText("Test watermark");

				// Editing of the shape in PowerPoint is forbidden
				shapeSettings.setLocked(true);

				doc.addWatermark(watermark, shapeSettings);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithSlidesShapeSettings
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark with text effects to a PowerPoint slide
		 */
		public static void addWatermarkWithTextEffects() {
			try {
				// ExStart:AddWatermarkWithTextEffectsPowerPointSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Segoe UI", 19));

				SlidesTextEffects effects = new SlidesTextEffects();
				effects.getLineFormat().setEnabled(true);
				effects.getLineFormat().setColor(Color.getRed());
				effects.getLineFormat().setDashStyle(OfficeDashStyle.DashDotDot);
				effects.getLineFormat().setLineStyle(OfficeLineStyle.Triple);
				effects.getLineFormat().setWeight(1);
				doc.addTextWatermark(watermark, effects);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithTextEffectsPowerPointSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark with image effects to a PowerPoint slide
		 */
		public static void addWatermarkWithImageEffects() {
			try {
				// ExStart:AddWatermarkWithImageEffectsPowerPointSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				SlidesImageEffects effects = new SlidesImageEffects();
				effects.setBrightness(0.7);
				effects.setContrast(0.6);
				effects.setChromaKey(Color.getWhite()); // setChromaKey method
														// doesn't work for ppt
														// files at this moment.
				effects.getBorderLineFormat().setEnabled(true);
				effects.getBorderLineFormat().setWeight(1);
				doc.addImageWatermark(watermark, effects);
				watermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkWithImageEffectsPowerPointSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes watermark from PowerPoint slide
		 */
		public static void removeWatermark() {
			try {
				// ExStart:RemoveWatermarkPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize search criteria
				ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
				TextSearchCriteria textSearchCriteria = new TextSearchCriteria("This is test watermark");

				// Call findWatermarks method for a slide
				PossibleWatermarkCollection possibleWatermarks = doc.getSlides().get_Item(0)
						.findWatermarks(textSearchCriteria.or(imageSearchCriteria));

				// Remove all found watermarks
				for (int i = possibleWatermarks.getCount() - 1; i >= 0; i--) {
					possibleWatermarks.removeAt(i);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveWatermarkPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extracts information about all the shapes in PowerPoint slide
		 */
		public static void getShapesInformation() {
			try {
				// ExStart:GetShapesInformationPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (SlidesSlide slide : doc.getSlides()) {
					for (SlidesShape shape : slide.getShapes()) {
						if (shape.getImage() != null) {
							System.out.println(shape.getImage().getWidth());
							System.out.println(shape.getImage().getHeight());
							System.out.println(shape.getImage().getBytes().length);
						}

						for (FormattedTextFragment fragment : shape.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}

						System.out.println(shape.getName());
						System.out.println(shape.getAlternativeText());
						System.out.println(shape.getX());
						System.out.println(shape.getY());
						System.out.println(shape.getWidth());
						System.out.println(shape.getHeight());
						System.out.println(shape.getRotateAngle());
						System.out.println(shape.getText());
						System.out.println(shape.getId());
						System.out.println(shape.getShapeType());
						System.out.println(shape.getZOrderPosition());
						System.out.println(shape.getHyperlink(SlidesHyperlinkActionType.MouseClick));
						System.out.println(shape.getHyperlink(SlidesHyperlinkActionType.MouseOver));
					}
				}

				doc.close();
				// ExEnd:GetShapesInformationPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shape from PowerPoint slide
		 */
		public static void removeShape() {
			try {
				// ExStart:RemoveShapePowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove shape by index
				doc.getSlides().get_Item(0).getShapes().removeAt(0);

				// Remove shape by reference
				doc.getSlides().get_Item(0).getShapes().remove(doc.getSlides().get_Item(0).getShapes().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveShapePowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shape with particular text formatting
		 */
		public static void removeShapeWithParticularTextFormatting() {
			try {
				// ExStart:RemoveTextShapesWithParticularTextFormattingPowerPoint_1
				// Load document
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Get and remove shapes from slides
				for (SlidesSlide section : doc.getSlides()) {
					for (int i = section.getShapes().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : section.getShapes().get_Item(i)
								.getFormattedTextFragments()) {
							if ("Arial".equals(fragment.getFont().getFamilyName())
									&& Color.getRed().equals(fragment.getForegroundColor())) {
								section.getShapes().removeAt(i);
								break;
							}
						}
					}
				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveTextShapesWithParticularTextFormattingPowerPoint_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all image shapes in a PowerPoint document
		 */
		public static void addWatermarkToImageShapes() {
			try {
				// ExStart:AddWatermarkToImageShapesPowerPointDocument
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (SlidesSlide slide : doc.getSlides()) {
					for (SlidesShape shape : slide.getShapes()) {
						if (shape.getImage() != null) {
							// Add watermark to the image
							shape.getImage().addWatermark(watermark);
						}
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImageShapesPowerPointDocument
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information of all slide backgrounds of a PowerPoint document
		 */
		public static void getInformationOfSlideBackgrounds() {
			try {
				// ExStart:GetInformationOfSlideBackgroundsPowerPointDocument
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (SlidesSlide slide : doc.getSlides()) {
					if (slide.getImageFillFormat().getBackgroundImage() != null) {
						System.out.println(slide.getImageFillFormat().getTileAsTexture());
						System.out.println(slide.getImageFillFormat().getTransparency());
						System.out.println(slide.getImageFillFormat().getBackgroundImage().getWidth());
						System.out.println(slide.getImageFillFormat().getBackgroundImage().getHeight());
						System.out.println(slide.getImageFillFormat().getBackgroundImage().getBytes().length);
					}
				}

				doc.close();
				// ExEnd:GetInformationOfSlideBackgroundsPowerPointDocument
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes background of a PowerPoint slide
		 */
		public static void removeBackground() {
			try {
				// ExStart:RemoveBackgroundPowerPointSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				doc.getSlides().get_Item(0).getImageFillFormat().setBackgroundImage(null);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveBackgroundPowerPointSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all background images of a PowerPoint slide
		 */
		public static void addWatermarkToAllBackgroundImages() {
			try {
				// ExStart:AddWatermarkToAllBackgroundImagesPowerPointSlide
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				for (SlidesSlide slide : doc.getSlides()) {
					if (slide.getImageFillFormat().getBackgroundImage() != null) {
						// Add watermark to the image
						slide.getImageFillFormat().getBackgroundImage().addWatermark(watermark);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToAllBackgroundImagesPowerPointSlide
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets additional settings for slide backgrounds
		 */
		public static void setAdditionalSettingsForSlideBackgrounds() {
			try {
				// ExStart:SetTiledSemitransparentBackgroundPowerPoint_1
				// Get image
				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				// Load document
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Get slide and update background
				SlidesSlide slide = doc.getSlides().get_Item(0);
				slide.getImageFillFormat().setBackgroundImage(new SlidesWatermarkableImage(imageBytes));
				slide.getImageFillFormat().setTileAsTexture(true);
				slide.getImageFillFormat().setTransparency(0.5);

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SetTiledSemitransparentBackgroundPowerPoint_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets tiled semitransparent image background for a particular slide.
		 */
		public static void getChartInformation() {
			try {
				// ExStart:getChartInformation
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (SlidesChart chart : doc.getSlides().get_Item(0).getCharts()) {
					System.out.println(chart.getWidth());
					System.out.println(chart.getHeight());
					System.out.println(chart.getX());
					System.out.println(chart.getY());
					System.out.println(chart.getAlternativeText());
					System.out.println(chart.getId());
					System.out.println(chart.getName());
					System.out.println(chart.getHyperlink(SlidesHyperlinkActionType.MouseClick));
					System.out.println(chart.getHyperlink(SlidesHyperlinkActionType.MouseOver));
				}

				doc.close();
				// ExEnd:getChartInformation
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets background image for a chart in a PowerPoint presentation
		 */
		public static void setBackgroundImageForChart() {
			try {
				// ExStart:SetBackgroundImageForChartPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				SlidesImageFillFormat imageFillFormat = doc.getSlides().get_Item(0).getCharts().get_Item(0)
						.getImageFillFormat();
				imageFillFormat.setBackgroundImage(new SlidesWatermarkableImage(imageBytes));
				imageFillFormat.setTransparency(0.5);
				imageFillFormat.setTileAsTexture(true);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SetBackgroundImageForChartPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces text with formatted text
		 */
		public static void replaceTextWithFormattedText() {
			try {
				// ExStart:replaceTextWithFormattedTextPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));
				for (SlidesShape shape : doc.getSlides().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.getFormattedTextFragments().clear();
						shape.getFormattedTextFragments().add("© GroupDocs 2017",
								new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
					}
				}
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:replaceTextWithFormattedTextPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes hyperlink associated with a particular shape or chart inside
		 * a PowerPoint document
		 */
		public static void replaceHyperlinks() {
			try {
				// ExStart:RemoveHyperlinksPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String oldUrl = "http://aspose.com/";

				// Assign null to remove hyperlink
				String newUrl = "http://groupdocs.com/";

				for (SlidesSlide slide : doc.getSlides()) {
					// Replace hyperlinks in shapes
					for (SlidesShape shape : slide.getShapes()) {
						replaceHyperlink(shape, SlidesHyperlinkActionType.MouseOver, oldUrl, newUrl);
						replaceHyperlink(shape, SlidesHyperlinkActionType.MouseClick, oldUrl, newUrl);

						// Replace hyperlinks in text fragments
						for (FormattedTextFragment fragment : shape.getFormattedTextFragments()) {
							replaceHyperlink((ISlidesHyperlinkContainer) fragment, SlidesHyperlinkActionType.MouseClick,
									oldUrl, newUrl);
							replaceHyperlink((ISlidesHyperlinkContainer) fragment, SlidesHyperlinkActionType.MouseOver,
									oldUrl, newUrl);
						}
					}

					// Replace hyperlinks in charts
					for (SlidesChart chart : slide.getCharts()) {
						replaceHyperlink(chart, SlidesHyperlinkActionType.MouseOver, oldUrl, newUrl);
						replaceHyperlink(chart, SlidesHyperlinkActionType.MouseClick, oldUrl, newUrl);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveHyperlinksPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		private static void replaceHyperlink(ISlidesHyperlinkContainer hyperlinkContainer, int hyperlinkActionType,
				String oldUrl, String newUrl) {
			if (oldUrl.equals(hyperlinkContainer.getHyperlink(hyperlinkActionType))) {
				hyperlinkContainer.setHyperlink(hyperlinkActionType, newUrl);
			}
		}

		/**
		 * Replaces text for a particular shape
		 */
		public static void replaceTextForParticularShape() {
			try {
				// ExStart:ReplaceTextForParticularShapePowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (SlidesShape shape : doc.getSlides().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.setText("© GroupDocs 2017");
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceTextForParticularShapePowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces text with a particular formatting
		 */
		public static void replaceTextWithFormattingForParticularShape() {
			try {
				// ExStart:replaceTextWithFormattingForParticularShapePowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (SlidesShape shape : doc.getSlides().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.getFormattedTextFragments().clear();
						shape.getFormattedTextFragments().add("© GroupDocs 2017",
								new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:replaceTextWithFormattingForParticularShapePowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces shape image
		 */
		public static void replaceShapeImage() {
			try {
				// ExStart:replaceShapeImagePowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				for (SlidesShape shape : doc.getSlides().get_Item(0).getShapes()) {
					if (shape.getImage() != null) {
						shape.setImage(new SlidesWatermarkableImage(imageBytes));
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:replaceShapeImagePowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Sets background image for particular shapes
		 */
		public static void setBackgroundImageForParticularShapes() {
			try {
				// ExStart:SetBackgroundImageForParticularShapesPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				for (SlidesShape shape : doc.getSlides().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.getImageFillFormat().setBackgroundImage(new SlidesWatermarkableImage(imageBytes));
						shape.getImageFillFormat().setTransparency(0.5);
						shape.getImageFillFormat().setTileAsTexture(true);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:SetBackgroundImageForParticularShapesPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Modifies shape properties
		 */
		public static void modifyShapeProperties() {
			try {
				// ExStart:ModifyShapePropertiesPowerPoint
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (SlidesShape shape : doc.getSlides().get_Item(0).getShapes()) {
					if ("© Aspose 2016".equals(shape.getText())) {
						shape.setAlternativeText("watermark");
						shape.setRotateAngle(30);
						shape.setX(200);
						shape.setY(200);
						shape.setWidth(400);
						shape.setHeight(100);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ModifyShapePropertiesPowerPoint
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes hyperlinks of all types
		 */
		public static void removeHyperlinksOfAllTypes() {
			try {
				// ExStart:RemoveHyperlinksUsingFindWatermarkPowerPoint_1
				SlidesDocument doc = Document.load(SlidesDocument.class, Common.mapSourceFilePath(FILE_PATH));
				doc.getSearchableObjects().setSlidesSearchableObjects(SlidesSearchableObjects.Hyperlinks);

				// Find all hyperlinks
				PossibleWatermarkCollection watermarks = doc.findWatermarks();

				// Remove found watermarks
				watermarks.clear();

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveHyperlinksUsingFindWatermarkPowerPoint_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

	}

	public static class Visio {
		// initialize file path
		// ExStart:SourceVisioFilePath
		private final static String FILE_PATH = "sample.vsdx";
		// ExEnd:SourceVisioFilePath

		/**
		 * Adds watermark to all pages of a particular type
		 */
		public static void addWatermarkToAllPagesOfParticularType() {
			try {
				// ExStart:AddWatermarkToAllPagesOfParticularType
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark 1", new Font("Calibri", 19));

				// Add text watermark to all background pages
				doc.addWatermark(textWatermark, DiagramWatermarkPlacementType.BackgroundPages);

				// Initialize image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

				// Add image watermark to all background pages
				doc.addWatermark(imageWatermark, DiagramWatermarkPlacementType.ForegroundPages);
				imageWatermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToAllPagesOfParticularType
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to separate newly created backround pages
		 */
		public static void addWatermarkToSeparateBackgroundPage() {
			try {
				// ExStart:AddWatermarkToSeparateBackgroundPage
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize watermark of any supported type
				TextWatermark textWatermark = new TextWatermark("Test watermark 1", new Font("Calibri", 19));

				// Create separate background for each page where it is not set.
				// Add watermark to it.
				doc.addWatermark(textWatermark, DiagramWatermarkPlacementType.SeparateBackgrounds);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToSeparateBackgroundPage
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to a particular page
		 */
		public static void addWatermarkToParticularPage() {
			try {
				// ExStart:AddWatermarkToParticularPage
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Add text watermark
				TextWatermark textWatermark = new TextWatermark("Test watermark", new Font("Calibri", 19));
				doc.getPages().get_Item(0).addWatermark(textWatermark);

				// Add image watermark
				ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
				doc.getPages().get_Item(0).addWatermark(imageWatermark);
				imageWatermark.close();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToParticularPage
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Gets information about the pages
		 */
		public static void getPagesInformation() {
			try {
				// ExStart:GetPagesInformationVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (DiagramPage page : doc.getPages()) {
					System.out.println(page.getWidth());
					System.out.println(page.getHeight());
					System.out.println(page.getLeftMargin());
					System.out.println(page.getRightMargin());
					System.out.println(page.getTopMargin());
					System.out.println(page.getBottomMargin());
					System.out.println(page.getName());
					System.out.println(page.isBackground());
					System.out.println(page.isVisible());
					if (page.getBackgroundPage() != null) {
						System.out.println(page.getBackgroundPage().getName());
					}
				}

				doc.close();
				// ExEnd:GetPagesInformationVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all images of a particular page
		 */
		public static void addWatermarkToImages() {
			try {
				// ExStart:AddWatermarkToImagesVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize image or text watermark
				TextWatermark watermark = new TextWatermark("Protected image", new Font("Arial", 8));
				watermark.setHorizontalAlignment(HorizontalAlignment.Center);
				watermark.setVerticalAlignment(VerticalAlignment.Center);
				watermark.setRotateAngle(45);
				watermark.setSizingType(SizingType.ScaleToParentDimensions);
				watermark.setScaleFactor(1);

				// Get all images from the first slide
				WatermarkableImageCollection images = doc.getPages().get_Item(0).findImages();

				// Add watermark to all found images
				for (WatermarkableImage image : images) {
					image.addWatermark(watermark);
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToImagesVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Locks the watermark shape to prevent editing in MS Visio
		 */
		public static void lockWatermarkShape() {
			try {
				// ExStart:LockWatermarkShape
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

				DiagramShapeSettings shapeSettings = new DiagramShapeSettings();
				shapeSettings.setLocked(true);

				// Editing of the shape in Visio is forbidden
				doc.addWatermark(watermark, shapeSettings);

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:LockWatermarkShape
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes watermark from a particular page
		 */
		public static void removeWatermark() {
			try {
				// ExStart:RemoveWatermarkVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Initialize search criteria
				ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
				TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Test watermark");

				// Call findWatermarks method for the first page
				PossibleWatermarkCollection possibleWatermarks = doc.getPages().get_Item(0)
						.findWatermarks(textSearchCriteria.or(imageSearchCriteria));

				// Remove all found watermarks
				possibleWatermarks.clear();

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveWatermarkVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extracts information about the shapes
		 */
		public static void getShapesInformation() {
			try {
				// ExStart:GetShapesInformationVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (DiagramPage page : doc.getPages()) {
					for (DiagramShape shape : page.getShapes()) {
						if (shape.getImage() != null) {
							System.out.println(shape.getImage().getWidth());
							System.out.println(shape.getImage().getHeight());
							System.out.println(shape.getImage().getBytes().length);
						}

						for (FormattedTextFragment fragment : shape.getFormattedTextFragments()) {
							System.out.println(fragment.getText());
							System.out.println(fragment.getFont().getFamilyName());
							System.out.println(fragment.getFont().getSize());
							System.out.println(fragment.getForegroundColor().toArgb());
							System.out.println(fragment.getBackgroundColor().toArgb());
						}

						System.out.println(shape.getName());
						System.out.println(shape.getX());
						System.out.println(shape.getY());
						System.out.println(shape.getWidth());
						System.out.println(shape.getHeight());
						System.out.println(shape.getRotateAngle());
						System.out.println(shape.getText());
						System.out.println(shape.getId());

						for (DiagramHyperlink hyperlink : shape.getHyperlinks()) {
							System.out.println(hyperlink.getAddress());
							System.out.println(hyperlink.getSubAddress());
							System.out.println(hyperlink.getDescription());
						}
					}
				}

				doc.close();
				// ExEnd:GetShapesInformationVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes a particular shape
		 */
		public static void removeShape() {
			try {
				// ExStart:RemoveShapeVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove shape by index
				doc.getPages().get_Item(0).getShapes().removeAt(0);

				// Remove shape by reference
				doc.getPages().get_Item(0).getShapes().remove(doc.getPages().get_Item(0).getShapes().get_Item(0));

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveShapeVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes shapes with particular text formatting
		 */
		public static void removeShapeWithParticularTextFormatting() {
			try {
				// ExStart:RemoveTextShapesWithParticularTextFormattingVisio_1
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Get pages and remove shapes with particular text formatting
				for (DiagramPage section : doc.getPages()) {
					for (int i = section.getShapes().getCount() - 1; i >= 0; i--) {
						for (FormattedTextFragment fragment : section.getShapes().get_Item(i)
								.getFormattedTextFragments()) {
							if ("Arial".equals(fragment.getFont().getFamilyName())
									&& Color.getRed().equals(fragment.getForegroundColor())) {
								section.getShapes().removeAt(i);
								break;
							}
						}
					}
				}

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveTextShapesWithParticularTextFormattingVisio_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extracts information about all the headers&footers
		 */
		public static void getHeaderFooterInformation() {
			try {
				// ExStart:GetHeaderFooterInformationVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Get header&footer font settings
				System.out.println(doc.getHeaderFooter().getFont().getFamilyName());
				System.out.println(doc.getHeaderFooter().getFont().getSize());
				System.out.println(doc.getHeaderFooter().getFont().getBold());
				System.out.println(doc.getHeaderFooter().getFont().getItalic());
				System.out.println(doc.getHeaderFooter().getFont().getUnderline());
				System.out.println(doc.getHeaderFooter().getFont().getStrikeout());

				// Get text contained in headers&footers
				System.out.println(doc.getHeaderFooter().getHeaderLeft());
				System.out.println(doc.getHeaderFooter().getHeaderCenter());
				System.out.println(doc.getHeaderFooter().getHeaderRight());
				System.out.println(doc.getHeaderFooter().getFooterLeft());
				System.out.println(doc.getHeaderFooter().getFooterCenter());
				System.out.println(doc.getHeaderFooter().getFooterRight());

				// Get text color
				System.out.println(doc.getHeaderFooter().getTextColor().toArgb());

				// Get header&footer margins
				System.out.println(doc.getHeaderFooter().getFooterMargin());
				System.out.println(doc.getHeaderFooter().getHeaderMargin());

				doc.close();
				// ExEnd:GetHeaderFooterInformationVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes or replaces particular header&footer
		 */
		public static void removeOrReplaceHeaderFooter() {
			try {
				// ExStart:RemoveOrReplaceHeaderFooter
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Remove header
				doc.getHeaderFooter().setHeaderCenter(null);

				// Replace footer
				doc.getHeaderFooter().setFooterCenter("Footer center");
				doc.getHeaderFooter().getFont().setSize(19);
				doc.getHeaderFooter().getFont().setFamilyName("Times New Roman");
				doc.getHeaderFooter().setTextColor(Color.getBlack());

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveOrReplaceHeaderFooter
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces text for particular shapes
		 */
		public static void replaceTextForParticularShapes() {
			try {
				// ExStart:ReplaceTextForParticularShapesVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (DiagramShape shape : doc.getPages().get_Item(0).getShapes()) {
					if (shape.getText() != null && shape.getText().contains("© Aspose 2016")) {
						shape.setText("© GroupDocs 2017");
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceTextForParticularShapesVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces text with formatting
		 */
		public static void replaceTextWithFormatting() {
			try {
				// ExStart:ReplaceTextWithFormattingVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (DiagramShape shape : doc.getPages().get_Item(0).getShapes()) {
					if (shape.getText() != null && shape.getText().contains("© Aspose 2016")) {
						shape.getFormattedTextFragments().clear();
						shape.getFormattedTextFragments().add("© GroupDocs 2017",
								new Font("Calibri", 19, FontStyle.Bold), Color.getRed(), Color.getAqua());
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceTextWithFormattingVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Replaces shape image
		 */
		public static void replaceShapeImage() {
			try {
				// ExStart:ReplaceShapeImageVisio
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				for (DiagramShape shape : doc.getPages().get_Item(0).getShapes()) {
					if (shape.getImage() != null) {
						shape.setImage(new DiagramWatermarkableImage(imageBytes));
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:ReplaceShapeImageVisio
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes/replaces hyperlink associated with particular shape
		 */
		public static void removeHyperlinkAssociatedWithParticularShape() {
			try {
				// ExStart:RemoveHyperlinksVisio_1
				DiagramDocument doc = Document.load(DiagramDocument.class, Common.mapSourceFilePath(FILE_PATH));

				DiagramShape shape = doc.getPages().get_Item(0).getShapes().get_Item(0);
				for (int i = shape.getHyperlinks().getCount() - 1; i >= 0; i--) {

					if (shape.getHyperlinks().get_Item(i).getAddress().contains("http://someurl.com")) {
						shape.getHyperlinks().removeAt(i);
					}
				}
				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveHyperlinksVisio_1
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

	}

	public static class Email {
		// initialize file path
		// ExStart:SourceVisioFilePath
		private final static String FILE_PATH = "sample.msg";
		// ExEnd:SourceVisioFilePath

		/**
		 * Loads an email message
		 */
		public static void loadEmailMessage() {
			try {
				// ExStart:LoadEmailMessage
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));
				// Do something...
				doc.close();
				// ExEnd:LoadEmailMessage
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Extract all attachments from an email message
		 */
		public static void extractAllAttachments() {
			try {
				// ExStart:ExtractAllAttachments
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String targetFolder = Common.ATTACHMENTS_PATH;

				for (EmailAttachment attachment : doc.getAttachments()) {
					System.out.println("Name: " + attachment.getName());
					System.out.println("File format: " + attachment.getDocumentInfo().getFileFormat());

					FileOutputStream outputStream = new FileOutputStream(targetFolder + "\\" + attachment.getName());
					outputStream.write(attachment.getContent());
					outputStream.close();
				}

				doc.close();
				// ExEnd:ExtractAllAttachments
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes particular attachments from an email message
		 */
		public static void removeAttachment() {
			try {
				// ExStart:RemoveAttachment
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (int i = doc.getAttachments().getCount() - 1; i >= 0; i--) {
					EmailAttachment attachment = doc.getAttachments().get_Item(i);

					// Remove all attached pdf files with a particular name
					if (attachment.getName().contains("sample")
							&& attachment.getDocumentInfo().getFileFormat() == FileFormat.Msg) {
						doc.getAttachments().removeAt(i);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds watermark to all attached files of supported types
		 */
		public static void addWatermarkToAllAttachment() {
			try {
				// ExStart:AddWatermarkToAllAttachment
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 19));

				for (EmailAttachment attachment : doc.getAttachments()) {
					// Check if the attached file is supported by
					// GroupDocs.Watermark
					if (attachment.getDocumentInfo().getFileFormat() != FileFormat.Undefined
							&& !attachment.getDocumentInfo().isEncrypted()) {
						// Load the attached document
						Document attachedDocument = attachment.loadDocument();

						// Add watermark
						attachedDocument.addWatermark(watermark);

						// Save changes in the attached file
						attachment.updateDocument(attachedDocument);

						attachedDocument.close();
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddWatermarkToAllAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Adds an attachment to an email message
		 */
		public static void addAttachment() {
			try {
				// ExStart:AddAttachment
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String attachmentPath = Common.mapSourceFilePath("sample.docx");
				File attachmentFile = new File(attachmentPath);
				byte[] attachmentBytes = new byte[(int) attachmentFile.length()];
				InputStream attachmentInputStream = new FileInputStream(attachmentFile);
				attachmentInputStream.read(attachmentBytes);
				attachmentInputStream.close();

				doc.getAttachments().add(attachmentBytes, "sample.docx");

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddAttachment
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Removes all embedded jpeg images from an email message
		 */
		public static void removeEmbeddedImages() {
			try {
				// ExStart:RemoveEmbeddedImages
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				for (int i = doc.getEmbeddedObjects().getCount() - 1; i >= 0; i--) {
					if (doc.getEmbeddedObjects().get_Item(i).getDocumentInfo().getFileFormat() == FileFormat.Jpeg) {
						// Remove reference to the image from html body
						String pattern = "<img[^>]*src=\"cid:" + doc.getEmbeddedObjects().get_Item(i).getContentId()
								+ "\"[^>]*>";
						doc.setHtmlBody(doc.getHtmlBody().replaceAll(pattern, ""));

						// Remove the image
						doc.getEmbeddedObjects().removeAt(i);
					}
				}

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:RemoveEmbeddedImages
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Embeds image into email message body
		 */
		public static void addEmbeddedImage() {
			try {
				// ExStart:AddEmbeddedImage
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				String imagePath = Common.WATERMARK_IMAGE_PATH;
				File imageFile = new File(imagePath);
				byte[] imageBytes = new byte[(int) imageFile.length()];
				InputStream imageInputStream = new FileInputStream(imageFile);
				imageInputStream.read(imageBytes);
				imageInputStream.close();

				doc.getEmbeddedObjects().add(imageBytes, imagePath);
				EmailEmbeddedObject embeddedObject = doc.getEmbeddedObjects()
						.get_Item(doc.getEmbeddedObjects().getCount() - 1);
				doc.setHtmlBody("<html><body>This is an embedded image: <img src=\"cid:" + embeddedObject.getContentId()
						+ "\"></body></html>");

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:AddEmbeddedImage
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Modifies email bosy and subject
		 */
		public static void modifyEmailBodyAndSubject() {
			try {
				// ExStart:modifyEmailBodyAndSubject
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// Set the plain text body
				doc.setBody("Test plain text body");

				// Set the html body
				doc.setHtmlBody("<html><body>Test html body</body></html>");

				// Set the email subject
				doc.setSubject("Test subject");

				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:modifyEmailBodyAndSubject
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Lists all email recipients
		 */
		public static void listAllRecipients() {
			try {
				// ExStart:listAllRecipients
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				// List all direct recipients
				for (EmailAddress address : doc.getTo()) {
					System.out.println(address.getAddress());
				}

				// List all CC recipients
				for (EmailAddress address : doc.getCc()) {
					System.out.println(address.getAddress());
				}

				// List all BCC recipients
				for (EmailAddress address : doc.getBcc()) {
					System.out.println(address.getAddress());
				}
				doc.close();
				// ExEnd:listAllRecipients
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}

		/**
		 * Finds text fragment in email message
		 */
		public static void findTextFragmentInEmailMessage() {
			try {
				// ExStart:findTextFragmentInEmailMessage
				EmailDocument doc = Document.load(EmailDocument.class, Common.mapSourceFilePath(FILE_PATH));

				SearchCriteria criteria = new TextSearchCriteria("test", false);

				// Specify search locations
				doc.getSearchableObjects().setEmailSearchableObjects(EmailSearchableObjects.Subject
						| EmailSearchableObjects.HtmlBody | EmailSearchableObjects.PlainTextBody);

				// Note, search is performed only if you pass TextSearchCriteria
				// instance to findWatermarks method
				PossibleWatermarkCollection watermarks = doc.findWatermarks(criteria);

				// Remove found text fragments
				watermarks.clear();

				// Save document
				doc.save(Common.mapOutputFilePath(FILE_PATH));
				doc.close();
				// ExEnd:findTextFragmentInEmailMessage
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}
	}
}
