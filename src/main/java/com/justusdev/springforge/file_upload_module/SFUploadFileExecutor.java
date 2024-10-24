package com.justusdev.springforge.file_upload_module;

import com.justusdev.springforge.command_module.Command;

import java.io.File;
import java.io.IOException;

public class SFUploadFileExecutor implements Command {
    @Override
    public void execute(String[] args) throws IOException {

        // check if folder name is provided
        if (args.length < 2) {
            System.err.println("Usage: java -jar springforge.jar plod <folderName>");
            return;
        }

        String folderName = args[1];

        String currentDir = System.getProperty("user.dir");

        // Determine the package name based on the current directory
        String packagePath = currentDir.substring(currentDir.indexOf("src/main/java/") + "src/main/java/".length());
        String packageName = packagePath.replace(File.separator, "."); // Convert to package format

        File uploadingFolderName = new File(currentDir + folderName);

        // Ensure the correct construction of the controllers directory path
        if (uploadingFolderName.exists()) {
            System.err.println("Error: The uploading folder directory already exist at " + uploadingFolderName.getAbsolutePath());
            return;
        }

        SFUploadFile uploadFile = new SFUploadFile();

        try {
            uploadFile.createUploadFile(uploadingFolderName.getAbsoluteFile());
        } catch (IOException e) {
            System.err.println("Error while executing this command: " + e.getMessage());
        }
    }
}
