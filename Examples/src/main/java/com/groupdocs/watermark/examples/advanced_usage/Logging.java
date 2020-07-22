// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.watermark.examples.advanced_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.WatermarkerSettings;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.exceptions.InvalidPasswordException;
import com.groupdocs.watermark.options.LoadOptions;
import com.groupdocs.watermark.options.ILogger;
import com.groupdocs.watermark.watermarks.Font;
import com.groupdocs.watermark.watermarks.TextWatermark;

/**
 *
 * @author Costya
 */
public class Logging {
    /**
     * This example shows how to receive the information via ILogger interface.
     */
    public static void run() {
        try{
            Logger logger = new Logger();
            WatermarkerSettings watermarkerSettings = new WatermarkerSettings();
            watermarkerSettings.setLogger(logger);
        
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.setPassword("InvalidPassword");
            // Constants.InProtectedDocumentDocx is an absolute or relative path to your document. Ex: @"C:\\Docs\\protected-document.docx"
            String filePath = Constants.InProtectedDocumentDocx;
            Watermarker watermarker = new Watermarker(filePath, loadOptions, watermarkerSettings);

            // use watermarker methods to manage watermarks in the document
            TextWatermark watermark = new TextWatermark("Test watermark", new Font("Arial", 12));

            watermarker.add(watermark);

            watermarker.save(Constants.OutProtectedDocumentDocx);

            watermarker.close();
        } catch (InvalidPasswordException ex) {
            ; // Ignore the exception
        }
    }
}

class Logger implements ILogger {
    public void error(String message, Exception exception) {
        // Print error message
        System.out.println("Error: " + message);
    }

    public void trace(String message) {
        // Print event message
        System.out.println("Event: " + message);
    }

    public void warning(String message) {
        // Print warning message
        System.out.println("Warning: " + message);
    }
}
