package com.groupdocs.watermark.examples;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;
import java.util.regex.Pattern;

import com.groupdocs.watermark.*;

public class Common {

	public static final Path STORAGE_PATH = getProjectBaseDir().resolve("Data/Source");
	public static final Path OUTPUT_PATH = getProjectBaseDir().resolve("Data/Output");
	public static final String WATERMARK_IMAGE_PATH = getProjectBaseDir().resolve("Data/watermark.jpg").toString();
	public static final String ATTACHMENTS_PATH = getProjectBaseDir().resolve("Data/Attachments/").toString();
	public static String LICENSE_PATH = "D:\\GroupDocs.Total.Java.lic";
	public static String publicKey = "Public key for your account";
	public static String privateKey = "Private key for your account";

	// applies product license
	public static void applyLicenseFromFile() {
		try {
			//ExStart:ApplyLicenseFromFile
			// Setup license
			License lic = new License();
			lic.setLicense(LICENSE_PATH);
			//ExEnd:ApplyLicenseFromFile
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// applies product license
		public static void applyLicenseFromStream() {
			try {
				//ExStart:ApplyLicenseFromStream
				// Setup license
				License lic = new License();
				lic.setLicense(new java.io.FileInputStream(LICENSE_PATH));
				//ExEnd:ApplyLicenseFromStream
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}
		
	// returns project base directory
	public static Path getProjectBaseDir() {
		Properties props = new Properties();
		try {
			InputStream i = Common.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
	}

	// returns source file path
	public static String mapSourceFilePath(String inputFileName) {
		try {
			return STORAGE_PATH + "/" + inputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	// returns output file path
	public static String mapOutputFilePath(String outputFileName) {
		try {
			return OUTPUT_PATH + "/" + outputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	// shows how to use library in licensed mode using Dynabic.Metered account
	public static void useDynabicMeteredAccount() {
		//ExStart:ApplyMeteredLicense 
		// initialize Metered API
		Metered metered = new Metered();
		// set-up credentials
		try {
			metered.setMeteredKey(publicKey, privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ExEnd:ApplyMeteredLicense 
		// do some work:
	}

	public static void loadDocument(String fileName) {
		try {
			// ExStart:LoadDocument
			Document doc = Document.load(Common.mapSourceFilePath(fileName));

			// Here we can use document instance to add or remove watermarks

			doc.close();
			// ExEnd:LoadDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void loadDocumentFromStream(String fileName) {
		try {
			// ExStart:loadDocumentFromStream
			InputStream inputStream = new FileInputStream(Common.mapSourceFilePath(fileName));
			Document doc = Document.load(inputStream);

			// Here we can use document instance to add or remove watermarks

			doc.close();
			inputStream.close();
			// ExEnd:loadDocumentFromStream
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void saveDocument(String fileName) {
		try {
			// ExStart:loadDocumentFromStream
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Document doc = Document.load(Common.mapSourceFilePath(fileName));
			// Watermarking goes here
			// ...

			// Save the document to the specified location
			doc.save("D:\\result.doc");

			// Save the document to the specified stream
			doc.save(outputStream);

			doc.close();

			// Use the stream containing the document
			// ...
			outputStream.close();
			// Document class implements Closeable interface. Therefore, it is
			// necessary to call close method when you are done working with the
			// document. Alternatively, you can use try-with-resources
			// statement.
			// ExEnd:loadDocumentFromStream
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void loadPasswordProtectedDocument(String fileName) {
		try {
			// ExStart:loadPasswordProtectedDocument
			// Use LoadOptions instance to pass the password
			LoadOptions loadOptions = new LoadOptions();
			loadOptions.setPassword("123");
			Document doc = Document.load(Common.mapSourceFilePath(fileName), loadOptions);

			doc.close();
			// ExEnd:loadPasswordProtectedDocument
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static void getDocumentInformation(String fileName) {
		try {
			// ExStart:getDocumentInformation
			DocumentInfo documentInfo = Document.getInfo(Common.mapSourceFilePath(fileName));
			System.out.println(documentInfo.getFileFormat());
			System.out.println(documentInfo.isEncrypted());
			// ExEnd:getDocumentInformation
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static void AddWatermarkToAllDocumentsInFolder()
	{
		// ExStart:AddWatermarkToAllDocumentsInFolderBusinessCase
		String inputFolder = "D:\\docs\\input\\";
		String outputFolder = "D:\\docs\\output\\";

		File[] files = new File(inputFolder).listFiles();

		Font font = new Font("Arial", 8, FontStyle.Bold);
		TextWatermark watermark = new TextWatermark("CONFIDENTIAL", font);
		watermark.setHorizontalAlignment(HorizontalAlignment.Center);
		watermark.setVerticalAlignment(VerticalAlignment.Center);
		watermark.setRotateAngle(-45);
		watermark.setSizingType(SizingType.ScaleToParentDimensions);
		watermark.setScaleFactor(0.8);
		watermark.setOpacity(0.5);
		watermark.setForegroundColor(Color.getRed());

		for (File file : files)
		{
			if (file.isFile())
			{
				Document doc = null;
				try
				{
				   doc = Document.load(file.getAbsolutePath());                   
				   doc.addWatermark(watermark);
				   doc.save(outputFolder + file.getName());                   
				}
				catch (UnsupportedFileTypeException exception)
				{
				   System.out.println("File format is not supported. File = " + file.getName());
				}
				finally
				{    
					if (doc != null)
					{
						doc.close();
					}
				}
			}
		}
		// ExEnd:AddWatermarkToAllDocumentsInFolderBusinessCase
	}
	
	public static void RemoveCompanyLogoWatermarkFromDocuments()
	{
		//ExStart:RemoveCompanyLogoWatermarkFromDocumentsBusinessCase
		String inputFolder = "D:\\docs\\input\\";
		String outputFolder = "D:\\docs\\output\\";
		String logo = "D:\\docs\\logo.png";

		File[] files = new File(inputFolder).listFiles();

		ImageSearchCriteria imageSearchCriteria = new ImageDctHashSearchCriteria(logo);
		Pattern pattern = Pattern.compile("^Company\\s+Name$", Pattern.CASE_INSENSITIVE);
		TextSearchCriteria textSearchCriteria = new TextSearchCriteria(pattern);

		for (File file : files)
		{
			if (file.isFile())
			{
				Document doc = null;
				try
				{
				   doc = Document.load(file.getAbsolutePath());                   
				   PossibleWatermarkCollection watermarks = doc.findWatermarks(textSearchCriteria.or(imageSearchCriteria));
				   watermarks.clear();
				   doc.save(outputFolder + file.getName());                   
				}
				catch (UnsupportedFileTypeException exception)
				{
				   System.out.println("File format is not supported. File = " + file.getName());
				}
				finally
				{    
					if (doc != null)
					{
						doc.close();
					}
				}
			}
		}
		//ExEnd:RemoveCompanyLogoWatermarkFromDocumentsBusinessCase
	}

}
