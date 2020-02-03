package com.groupdocs.watermark.examples.quick_start;

import com.groupdocs.watermark.licensing.Metered;

public class SetMeteredLicense {
    public static void run() throws Exception {
        String publicKey = "*****";
        String privateKey = "*****";

        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);

        System.out.println("License set successfully.");
    }
}
