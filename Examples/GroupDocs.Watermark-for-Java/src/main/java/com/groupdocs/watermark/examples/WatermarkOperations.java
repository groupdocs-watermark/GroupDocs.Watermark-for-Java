package com.groupdocs.watermark.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Pattern;

import com.groupdocs.watermark.CellsSearchableObjects;
import com.groupdocs.watermark.Color;
import com.groupdocs.watermark.ColorRange;
import com.groupdocs.watermark.DiagramSearchableObjects;
import com.groupdocs.watermark.Document;
import com.groupdocs.watermark.Font;
import com.groupdocs.watermark.FontStyle;
import com.groupdocs.watermark.HorizontalAlignment;
import com.groupdocs.watermark.HyperlinkPossibleWatermark;
import com.groupdocs.watermark.ImageDctHashSearchCriteria;
import com.groupdocs.watermark.ImageSearchCriteria;
import com.groupdocs.watermark.ImageWatermark;
import com.groupdocs.watermark.MarginType;
import com.groupdocs.watermark.PdfSearchableObjects;
import com.groupdocs.watermark.PossibleWatermark;
import com.groupdocs.watermark.PossibleWatermarkCollection;
import com.groupdocs.watermark.RotateAngleSearchCriteria;
import com.groupdocs.watermark.SearchCriteria;
import com.groupdocs.watermark.SearchableObjects;
import com.groupdocs.watermark.SizingType;
import com.groupdocs.watermark.SlidesSearchableObjects;
import com.groupdocs.watermark.TextAlignment;
import com.groupdocs.watermark.TextFormattingSearchCriteria;
import com.groupdocs.watermark.TextSearchCriteria;
import com.groupdocs.watermark.TextWatermark;
import com.groupdocs.watermark.VerticalAlignment;
import com.groupdocs.watermark.WatermarkableImageCollection;
import com.groupdocs.watermark.WordsSearchableObjects;

public class WatermarkOperations {
	// initialize file paths
	// ExStart:SourceDocumentFilesPath
	private final static String PNG_FILE_PATH = "sample.png";
	private final static String DOC_FILE_PATH = "sample.docx";
	private final static String PPT_FILE_PATH = "sample.pptx";
	private final static String XLS_FILE_PATH = "sample.xlsx";
	private final static String PDF_FILE_PATH = "sample.pdf";
	// ExEnd:SourceDocumentFilesPath

	public static void addTextWatermark() {
		try {
			// ExStart:AddTextWatermark
			Document doc = Document.load(Common.mapSourceFilePath(PNG_FILE_PATH));

			Font font = new Font("Arial", 19, FontStyle.Bold | FontStyle.Italic);
			TextWatermark watermark = new TextWatermark("Test watermark", font);

			// Set watermark properties
			watermark.setForegroundColor(Color.getRed());
			watermark.setBackgroundColor(Color.getBlue());
			watermark.setTextAlignment(TextAlignment.Right);
			watermark.setOpacity(0.5);

			doc.addWatermark(watermark);

			doc.save(Common.mapOutputFilePath(PNG_FILE_PATH));

			doc.close();
			// ExEnd:AddTextWatermark
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addImageWatermark() {
		try {
			// ExStart:AddImageWatermark
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			// Use path to an image as constructor parameter
			ImageWatermark watermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);

			// Add watermark to the document
			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));

			watermark.close();
			doc.close();
			// ExEnd:AddImageWatermark
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addImageWatermarkUsingStream() {
		try {
			// ExStart:AddImageWatermarkUsingStream
			Document doc = Document.load(Common.mapSourceFilePath(PPT_FILE_PATH));
			FileInputStream watermarkInputStream = new FileInputStream(Common.WATERMARK_IMAGE_PATH);

			// Use stream containing an image as constructor parameter
			ImageWatermark watermark = new ImageWatermark(watermarkInputStream);

			// Add watermark to the document
			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(PPT_FILE_PATH));

			watermark.close();
			watermarkInputStream.close();
			doc.close();
			// ExEnd:AddImageWatermarkUsingStream
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkToAbsolutePosition() {
		try {
			// ExStart:AddWatermarkToAbsolutePosition
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			Font font = new Font("Times New Roman", 8);
			TextWatermark watermark = new TextWatermark("Test watermark", font);

			// Set watermark coordinates
			watermark.setX(30);
			watermark.setY(40);

			// Set watermark size
			watermark.setWidth(100);
			watermark.setHeight(40);

			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkToAbsolutePosition
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkToRelativePosition() {
		try {
			// ExStart:AddWatermarkToRelativePosition
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			Font font = new Font("Calibri", 42);
			TextWatermark watermark = new TextWatermark("Test watermark", font);
			watermark.setHorizontalAlignment(HorizontalAlignment.Right);
			watermark.setVerticalAlignment(VerticalAlignment.Bottom);

			watermark.getMargins().setRight(0.1);
			watermark.getMargins().setBottom(0.2);

			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkToRelativePosition
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkWithAbsoluteMargin() {
		try {
			// ExStart:AddWatermarkWithMarginType
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			Font font = new Font("Calibri", 12);
			TextWatermark watermark = new TextWatermark("Test watermark", font);
			watermark.setHorizontalAlignment(HorizontalAlignment.Right);
			watermark.setVerticalAlignment(VerticalAlignment.Bottom);

			// Set absolute margins. Values are measured in document units.
			watermark.getMargins().setRight(10);
			watermark.getMargins().setBottom(5);

			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkWithMarginType
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkWithRelativeMargin() {
		try {
			// ExStart:AddWatermarkWithMarginType
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			Font font = new Font("Calibri", 12);
			TextWatermark watermark = new TextWatermark("Test watermark", font);
			watermark.setHorizontalAlignment(HorizontalAlignment.Right);
			watermark.setVerticalAlignment(VerticalAlignment.Bottom);

			// Set relative margins. Margin value will be interpreted as a
			// portion of appropriate parent dimension.
			// If this type is chosen, margin value must be between 0.0 and 1.0.
			watermark.getMargins().setMarginType(MarginType.RelativeToParentDimensions);
			watermark.getMargins().setRight(0.1);
			watermark.getMargins().setBottom(0.2);

			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkWithMarginType
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkWithSizeType() {
		try {
			// ExStart:AddWatermarkWithSizeType
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			Font font = new Font("Times New Roman", 12);
			TextWatermark watermark = new TextWatermark("Test watermark", font);

			// Set sizing type
			watermark.setSizingType(SizingType.ScaleToParentDimensions);

			// Set watermark scale
			watermark.setScaleFactor(0.5);

			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkWithSizeType
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkWithParentMargin() {
		try {
			// ExStart:AddWatermarkWithParentMargin
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));

			TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 42));
			watermark.setHorizontalAlignment(HorizontalAlignment.Right);
			watermark.setVerticalAlignment(VerticalAlignment.Top);
			watermark.setSizingType(SizingType.ScaleToParentDimensions);
			watermark.setScaleFactor(1);
			watermark.setRotateAngle(45);
			watermark.setForegroundColor(Color.getRed());
			watermark.setBackgroundColor(Color.getAqua());

			// Add watermark considering parent margins
			watermark.setConsiderParentMargins(true);

			doc.addWatermark(watermark);
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:AddWatermarkWithParentMargin
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addTextWatermark(int RotationAngle) {
		try {
			// ExStart:AddTextWatermarkWithRotationAngle
			Document doc = Document.load(Common.mapSourceFilePath(XLS_FILE_PATH));

			Font font = new Font("Calibri", 8);
			TextWatermark watermark = new TextWatermark("Test watermark", font);
			watermark.setHorizontalAlignment(HorizontalAlignment.Right);
			watermark.setVerticalAlignment(VerticalAlignment.Top);
			watermark.setSizingType(SizingType.ScaleToParentDimensions);
			watermark.setScaleFactor(0.5);

			// Set rotation angle
			watermark.setRotateAngle(RotationAngle);

			doc.addWatermark(watermark);

			doc.save(Common.mapOutputFilePath(XLS_FILE_PATH));
			doc.close();
			// ExEnd:AddTextWatermarkWithRotationAngle
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void addWatermarkToImagesInsideDocument() {
		try {
			// ExStart:AddWatermarkToImagesInsideDocument
			Document doc = Document.load(Common.mapSourceFilePath(PPT_FILE_PATH));
			// Initialize text watermark
			TextWatermark textWatermark = new TextWatermark("Protected image", new Font("Arial", 8));
			textWatermark.setHorizontalAlignment(HorizontalAlignment.Center);
			textWatermark.setVerticalAlignment(VerticalAlignment.Center);
			textWatermark.setRotateAngle(45);
			textWatermark.setSizingType(SizingType.ScaleToParentDimensions);
			textWatermark.setScaleFactor(1);

			// Initialize image watermark
			ImageWatermark imageWatermark = new ImageWatermark(Common.WATERMARK_IMAGE_PATH);
			imageWatermark.setHorizontalAlignment(HorizontalAlignment.Center);
			imageWatermark.setVerticalAlignment(VerticalAlignment.Center);
			imageWatermark.setRotateAngle(-45);
			imageWatermark.setSizingType(SizingType.ScaleToParentDimensions);
			imageWatermark.setScaleFactor(1);

			// Find all images in a document
			WatermarkableImageCollection images = doc.findImages();

			for (int i = 0; i < images.getCount(); i++) {
				if (images.get_Item(i).getWidth() > 100 && images.get_Item(i).getHeight() > 100) {
					if (i % 2 == 0) {
						images.get_Item(i).addWatermark(textWatermark);
					} else {
						images.get_Item(i).addWatermark(imageWatermark);
					}
				}
			}
			doc.save(Common.mapOutputFilePath(PPT_FILE_PATH));

			imageWatermark.close();
			doc.close();
			// ExEnd:AddWatermarkToImagesInsideDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void searchWatermark() {
		try {
			// ExStart:SearchWatermark
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));

			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks();
			for (PossibleWatermark possibleWatermark : possibleWatermarks) {
				if (possibleWatermark.getImageData() != null) {
					System.out.println(possibleWatermark.getImageData().length);
				}
				System.out.println(possibleWatermark.getText());
				System.out.println(possibleWatermark.getX());
				System.out.println(possibleWatermark.getY());
				System.out.println(possibleWatermark.getRotateAngle());
				System.out.println(possibleWatermark.getWidth());
				System.out.println(possibleWatermark.getHeight());
			}

			doc.close();
			// ExEnd:SearchWatermark
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches for watermark with a particular text 
	 */
	public static void searchWatermark(String searchString) {
		try {
			// ExStart:SearchWatermarkWithSearchString
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			// Search by exact string
			TextSearchCriteria textSearchCriteria = new TextSearchCriteria(searchString);

			// Find all possible watermarks containing some specific text
			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks(textSearchCriteria);

			// ...

			doc.close();
			// ExEnd:SearchWatermarkWithSearchString
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches for watermark with a regular expression 
	 */
	public static void searchWatermarkWithRegularExpression() {
		try {
			// ExStart:SearchWatermarkWithRegularExpression
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			Pattern pattern = Pattern.compile("© \\d{4}");

			// Search by regular expression
			TextSearchCriteria textSearchCriteria = new TextSearchCriteria(pattern);

			// Find possible watermarks using regular expression
			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks(textSearchCriteria);

			// ...

			doc.close();
			// ExEnd:SearchWatermarkWithRegularExpression
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches for image watermark
	 */
	public static void searchImageWatermark() {
		try {
			// ExStart:SearchImageWatermark
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			// Initialize criteria with the image
			ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);

			// Set maximum allowed difference between images
			imageSearchCriteria.setMaxDifference(0.1);

			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks(imageSearchCriteria);

			System.out.println(possibleWatermarks.get_Item(0).getHeight());
			// ...

			doc.close();
			// ExEnd:SearchImageWatermark
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches for watermark with combination of different search criteria
	 */
	public static void searchWatermarkWithCombinedSearch() {
		try {
			// ExStart:SearchWatermarkWithCombinedSearch
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(Common.WATERMARK_IMAGE_PATH);
			imageSearchCriteria.setMaxDifference(0.9);

			TextSearchCriteria textSearchCriteria = new TextSearchCriteria("Test watermark");

			RotateAngleSearchCriteria rotateAngleSearchCriteria = new RotateAngleSearchCriteria(30, 60);

			SearchCriteria combinedSearchCriteria = imageSearchCriteria.or(textSearchCriteria)
					.and(rotateAngleSearchCriteria);

			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks(combinedSearchCriteria);

			System.out.println(possibleWatermarks.getCount());
			// ...

			doc.close();
			// ExEnd:SearchWatermarkWithCombinedSearch
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches watermark with a prticular text formatting
	 */
	public static void searchWatermarkWithParticularTextFormatting() {
		try {
			// ExStart:SearchWatermarkWithParticularTextFormatting
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			TextFormattingSearchCriteria criteria = new TextFormattingSearchCriteria();
			criteria.setForegroundColorRange(new ColorRange());
			criteria.getForegroundColorRange().setMinHue(-5);
			criteria.getForegroundColorRange().setMaxHue(10);
			criteria.getForegroundColorRange().setMinBrightness(0.01f);
			criteria.getForegroundColorRange().setMaxBrightness(0.99f);
			criteria.setBackgroundColorRange(new ColorRange());
			criteria.getBackgroundColorRange().setEmpty(true);
			criteria.setFontName("Arial");
			criteria.setMinFontSize(19);
			criteria.setMaxFontSize(42);
			criteria.setFontBold(false);

			PossibleWatermarkCollection watermarks = doc.findWatermarks(criteria);

			// ...

			doc.close();
			// ExEnd:SearchWatermarkWithParticularTextFormatting
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Removes watermark
	 */
	public static void removeWatermark() {
		try {
			// ExStart:RemoveWatermark
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks();

			// Remove possible watermark at the specified index from the
			// document.
			possibleWatermarks.removeAt(0);

			// Remove specified possible watermark from the document.
			// possibleWatermarks.remove(possibleWatermarks.get_Item(0));

			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));

			doc.close();
			// ExEnd:RemoveWatermark
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches for watermark specifying which objects should be included in the
	 * search for all document instances
	 */
	public static void searchWatermarkInParticularObjects() {
		try {
			// ExStart:SearchWatermarkInParticularObjectsAllInstances
			SearchableObjects searchableObjects = new SearchableObjects();
			searchableObjects.setWordsSearchableObjects(
					WordsSearchableObjects.Hyperlinks | WordsSearchableObjects.Shapes | WordsSearchableObjects.Text);
			searchableObjects.setCellsSearchableObjects(CellsSearchableObjects.HeadersFooters);
			searchableObjects.setSlidesSearchableObjects(
					SlidesSearchableObjects.SlidesBackgrounds | SlidesSearchableObjects.Shapes);
			searchableObjects.setDiagramSearchableObjects(DiagramSearchableObjects.None);
			searchableObjects.setPdfSearchableObjects(PdfSearchableObjects.All);

			Document.setDefaultSearchableObjects(searchableObjects);

			File folder = new File(Common.STORAGE_PATH.toString());
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile()) {
					Document doc = Document.load(file.getAbsolutePath());
					PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks();

					System.out.println(possibleWatermarks.getCount());
					// The code for working with found watermarks goes here.

					doc.close();
				}
			}
			// ExEnd:SearchWatermarkInParticularObjectsAllInstances
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches for watermark specifying which objects should be included in the
	 * search for particular document instance
	 */
	public static void searchWatermarkInParticularObjectsForParticularDocument() {
		try {
			// ExStart:SearchWatermarkInParticularObjectsForParticularDocument
			Document doc = Document.load(Common.mapSourceFilePath(PDF_FILE_PATH));

			// Search for hyperlinks only.
			doc.getSearchableObjects().setPdfSearchableObjects(PdfSearchableObjects.Hyperlinks);
			PossibleWatermarkCollection possibleWatermarks = doc.findWatermarks();

			System.out.println(possibleWatermarks.getCount());
			// The code for working with found watermarks goes here.

			doc.close();
			// ExEnd:SearchWatermarkInParticularObjectsForParticularDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Searches and removes hyperlinks
	 */
	public static void removeHyperlinksWithParticularURL() {
		try {
			// ExStart:RemoveHyperlinksWithParticularURL_1
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));

			// Find watermark with particular text search criteria
			PossibleWatermarkCollection watermarks = doc
					.findWatermarks(new TextSearchCriteria(Pattern.compile("someurl\\.com")));
			for (int i = watermarks.getCount() - 1; i >= 0; i--) {
				// Ensure that only hyperlinks will be removed
				if (HyperlinkPossibleWatermark.class.isInstance(watermarks.get_Item(i))) {
					// Output the full url of the hyperlink
					System.out.println(watermarks.get_Item(i).getText());

					// Remove hyperlink from the document
					watermarks.removeAt(i);
				}
			}

			// Save document
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));

			doc.close();
			// ExEnd:RemoveHyperlinksWithParticularURL_1
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Updates text in the found watermarks
	 */
	public static void editTextInFoundWatermarks() {
		try {
			// ExStart:EditTextInFoundWatermarks_18.3
			Document doc = Document.load(Common.mapSourceFilePath(PPT_FILE_PATH));
			 
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
			 
			doc.save(Common.mapOutputFilePath(PPT_FILE_PATH));
			doc.close();
			// ExEnd:EditTextInFoundWatermarks_18.3
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Updates text with formatting in the found watermarks
	 */
	public static void editTextWithFormattingInFoundWatermarks() {
		try {
			// ExStart:EditTextWithFormattingInFoundWatermarks_18.3
			Document doc = Document.load(Common.mapSourceFilePath(DOC_FILE_PATH));
			 
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
			 
			doc.save(Common.mapOutputFilePath(DOC_FILE_PATH));
			doc.close();
			// ExEnd:EditTextWithFormattingInFoundWatermarks_18.3
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * Replaces image in the found watermarks
	 */
	public static void replacesImageInFoundWatermarks() {
		try {
			// ExStart:ReplacesImageInFoundWatermarks_18.3
			String imagePath = Common.mapSourceFilePath(Common.WATERMARK_IMAGE_PATH);
			File imageFile = new File(imagePath);
			byte[] imageBytes = new byte[(int)imageFile.length()];
			InputStream imageInputStream = new FileInputStream(imageFile);
			imageInputStream.read(imageBytes);
			imageInputStream.close();
			 
			Document doc = Document.load(Common.mapSourceFilePath(PDF_FILE_PATH));
			 
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
			 
			doc.save(Common.mapOutputFilePath(PDF_FILE_PATH));
			doc.close();
			// ExEnd:ReplacesImageInFoundWatermarks_18.3
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

}
