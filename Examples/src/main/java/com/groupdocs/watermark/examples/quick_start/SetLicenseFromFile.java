package com.groupdocs.watermark.examples.quick_start;

import java.io.File;

import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.licenses.License;

public class SetLicenseFromFile {
    /**
     * This example demonstrates how to set license from file.
     *
     * The SetLicense method attempts to set a license from several locations relative to the executable.
     * You can also use the additional overload to load a license from a stream,
     * this is useful for instance when the License is stored as an embedded resource.
     */
    public static void run() {
        File licenseFile = new File(Constants.LicenseFilePath);
        if (licenseFile.exists()) {
            License license = new License();
            license.setLicense(Constants.LicenseFilePath);

            System.out.println("License set successfully.");
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                                "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                                "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                                "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
