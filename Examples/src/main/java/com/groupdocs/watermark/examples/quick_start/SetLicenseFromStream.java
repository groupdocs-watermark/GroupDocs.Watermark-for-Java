package com.groupdocs.watermark.examples.quick_start;

import java.io.File;
import java.io.FileInputStream;

import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.licenses.License;

public class SetLicenseFromStream {
    /**
     * This example demonstrates how to set license from stream.
     */
    public static void run() throws Exception {
        File licenseFile = new File(Constants.LicenseFilePath);
        if (licenseFile.exists()) {
            FileInputStream stream = new FileInputStream(licenseFile);
            License license = new License();
            license.setLicense(stream);
            stream.close();

            System.out.println("License set successfully.");
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                                "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                                "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                                "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
