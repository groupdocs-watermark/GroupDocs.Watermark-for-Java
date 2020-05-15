package com.groupdocs.watermark.examples.basic_usage;

import com.groupdocs.watermark.Watermarker;
import com.groupdocs.watermark.examples.Constants;
import com.groupdocs.watermark.options.ICreatePageStream;
import com.groupdocs.watermark.options.IReleasePageStream;
import com.groupdocs.watermark.options.PreviewOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class GenerateDocumentPreview {
    /**
     * This example demonstrates how to generate preview for a document.
     */
    public static void run() {
        // Constants.InDiagramVdx is an absolute or relative path to your document. Ex: "C:\\Docs\\diagram.vdx"
        Watermarker watermarker = new Watermarker(Constants.InDiagramVsdx);
        
        String fileNameTemplate = new File(Constants.OutputPath, "page%s.png").getPath();
        ICreatePageStream createPageStream = new CreatePageStream(fileNameTemplate);
        
        IReleasePageStream releasePageStream = new ReleasePageStream();
        
        PreviewOptions previewOptions = new PreviewOptions(createPageStream, releasePageStream);
        
        watermarker.generatePreview(previewOptions);

        watermarker.close();
    }
    
    static class CreatePageStream implements ICreatePageStream {
        private final String _fileNameTemplate;
        
        public CreatePageStream(String fileNameTemplate) {
            _fileNameTemplate = fileNameTemplate;
        }
        
        @Override
        public java.io.OutputStream createPageStream(int pageNumber) {
            String fileName = String.format(_fileNameTemplate, pageNumber);
            try {
                return new FileOutputStream(fileName);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    static class ReleasePageStream implements IReleasePageStream {
        @Override
        public void releasePageStream(int pageNumber, OutputStream pageStream) {
            try {
                pageStream.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
