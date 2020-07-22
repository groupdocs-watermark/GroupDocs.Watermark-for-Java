---
id: logging
url: watermark/java/logging
title: Logging
weight: 4
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
[`ILogger`](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger "interface in com.groupdocs.watermark.options") interface is used to receive the information about errors, warnings and events which occur while watermarking. [`ILogger`](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger "interface in com.groupdocs.watermark.options") interface has the following members:

| Member | Description |
| --- | --- |
| **[error](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger#error(java.lang.String,%20java.lang.Exception))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") message, [Exception](http://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html?is-external=true "class or interface in java.lang") exception) | Logs an error that occurred during watermarking. |
| **[warning](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger#warning(java.lang.String))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") message) | Logs a warning that occurred during watermarking. |
| **[trace](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger#trace(java.lang.String))**([String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html?is-external=true "class or interface in java.lang") message) | Logs an event occurred during watermarking. |

Here are the steps to receive the information via [ILogger](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger "interface in com.groupdocs.watermark.options") interface:

*   Implement the class with [ILogger](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger "interface in com.groupdocs.watermark.options") interface implementation;
*   Instantiate [Parser](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark/Watermarker) object with [`WatermarkerSettings`](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/WatermarkerSettings "class in com.groupdocs.watermark.options") object.

The following example shows how to receive the information via [ILogger](https://apireference.groupdocs.com/java/watermark/com.groupdocs.watermark.options/ILogger "interface in com.groupdocs.watermark.options") interface.

```java
try {
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
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Watermark for .NET examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-.NET)
    
*   [GroupDocs.Watermark for Java examples](https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java)
    
### Free online document watermarking App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to add watermark to PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, Emails and more with our free online [Free Online Document Watermarking App](https://products.groupdocs.app/watermark).
