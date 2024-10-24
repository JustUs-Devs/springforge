package com.justusdev.springforge.file_upload_module;

import com.justusdev.springforge.utils_module.templates.file_upload.ForgeFileUploadTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SFUploadFile {

    public void createUploadFile(File baseDir) throws IOException {

        String template = "FileUploadUtility.java";

        File templateFile = new File(baseDir, template);

        String convertPath = String.valueOf(baseDir).replace("/",".");
        String replacement = "com."+convertPath;

        if(!templateFile.exists()) {

            try(FileWriter writer = new FileWriter(templateFile)) {

                writer.write(ForgeFileUploadTemplate.FILE_UPLOAD_TEMPLATE
                        .replace("{packageName}", replacement));

                System.out.println("Created template files:");
                System.out.println(" - " + templateFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error writing template files: " + e.getMessage());
            }
        } else {
            System.out.println("Upload File  already exist:");
        }
    }
}
