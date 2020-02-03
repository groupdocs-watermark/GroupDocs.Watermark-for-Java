package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.common.FileType;

public class GetSupportedFileFormats {
    public static void run() {
        FileType[] fileTypes = FileType.getSupportedFileTypes();
        for(FileType fileType : fileTypes) {
            System.out.println(fileType);
        }
    }
}
