---
id: evaluation-limitations-and-licensing
url: watermark/java/evaluation-limitations-and-licensing
title: Evaluation Limitations and Licensing
weight: 6
description: ""
keywords: 
productName: GroupDocs.Watermark for Java
hideChildren: False
---
{{< alert style="info" >}}You can use GroupDocs.Watermark without the license. The usage and functionalities are pretty much same as the licensed one but you will face few limitations while using the non-licensed API.{{< /alert >}}

# Evaluation version limitations

You can easily download GroupDocs.Watermark for evaluation. The evaluation download is the same as the purchased download. The evaluation version simply becomes licensed when you add a few lines of code to apply the license. You will face following limitations while using the API without the license.  

| API Feature | Limitation |
| --- | --- |
| Document loading | Only 10 documents can be loaded per application run.    |
| Watermark search/removing | Removing/replacing of document parts is not allowed in evaluation mode.  |
| Watermark adding | Only 1 watermark can be added to a document per editing session.  |
| Document saving | Evaluation warning watermark will be added to a document.  |

## Licensing

The license file contains details such as the product name, number of developers it is licensed to, subscription expiry date and so on. It contains the digital signature, so don't modify the file. Even inadvertent addition of an extra line break into the file will invalidate it. You need to set a license before utilizing GroupDocs.Watermark API if you want to avoid its evaluation limitations.   
The license can be loaded from a file or stream object.

### Setting license from file

The code below will explain how to [set](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/License#setLicense(java.lang.String)) product [license](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/License) from a file.

```csharp
// For complete examples and data files, please go to https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java
//initialize License
License lic = new License();

//Set license
lic.setLicense("GroupDocs.Watermark.lic");
```

### Setting license from stream

The following example shows how to [load](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/License#setLicense(java.io.InputStream)) a [license](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/License) from a stream.

```csharp
// For complete examples and data files, please go to https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java
Path fileLocation = Paths.get("GroupDocs.Watermark.lic");
try {
    byte[] data = Files.readAllBytes(fileLocation);
    ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
 
    License lic = new License();
    lic.setLicense(inputStream);
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

{{< alert style="info" >}}Calling License.setLicense multiple times is not harmful but simply wastes processor time. If you are developing a Windows or console application, call License.setLicense in your startup code, before using GroupDocs.Watermark classes.{{< /alert >}}

### Setting metered license

You can also set [Metered](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered) license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful for the customers who want to be billed based on the usage of the API features. For more details, please refer to [Metered Licensing FAQ](https://purchase.groupdocs.com/faqs/licensing/metered) section.

Here are the simple steps to use the [Metered](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered) class.

*       Create an instance of [Metered](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered) class.
*       Pass public & private keys to [setMeteredKey](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered#setMeteredKey(java.lang.String,%20java.lang.String)) method.
*       Do processing (perform task).
*       Call method [getConsumptionQuantity](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered#getConsumptionQuantity()) of the [Metered](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered) class.
*       It will return the amount/quantity of API requests that you have consumed so far.
*       Call method [getConsumptionCredit](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered#getConsumptionCredit()) of the [Metered](https://apireference.groupdocs.com/watermark/java/com.groupdocs.watermark.licensing/Metered) class.
*       It will return the credit that you have consumed so far.

Following is the sample code demonstrating how to set metered public and private keys.

```csharp
// For complete examples and data files, please go to https://github.com/groupdocs-watermark/GroupDocs.Watermark-for-Java
string PublicKey = ""; // Your public license key
string PrivateKey = ""; // Your private license key
Metered metered = new Metered();
try {
    metered.setMeteredKey(PublicKey, PrivateKey);
} catch (Exception e) {
    System.out.println(e.getMessage());
}

// Get amount (MB) consumed
double amountConsumed = Metered.getConsumptionQuantity();
 
// Get count of credits consumed
double creditsConsumed = Metered.getConsumptionCredit();
```
