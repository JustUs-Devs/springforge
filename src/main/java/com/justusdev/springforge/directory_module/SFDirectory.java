package com.justusdev.springforge.directory_module;

import com.justusdev.springforge.exceptions_module.SFException;
import com.justusdev.springforge.utils_module.templates.ForgeBaseEntityTemplate;
import com.justusdev.springforge.utils_module.templates.exception.ExceptionModelTemplate;
import com.justusdev.springforge.utils_module.templates.exception.ForgeGlobalExceptionHandlerTemplate;
import com.justusdev.springforge.utils_module.templates.exception.GlobalExceptionTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.justusdev.springforge.utils_module.PathUtil.getPackagePathFromWorkingDirectory;

/**
 * Utility class to create a predefined directory structure for a project.
 */
public class SFDirectory {

    /**
     * Creates the necessary directory structure within the specified base directory.
     *
     * @param baseDirectory the base directory where the structure will be created
     * @throws IOException if an error occurs while creating directories
     */
    public void createDirectories(String baseDirectory) throws IOException {

        File baseDir = new File(baseDirectory);

        // Check if the base directory exists, if not, attempt to create it
        if (!baseDir.exists()) {
            boolean created = baseDir.mkdirs();

            if (created) {
                System.out.println("Created directory: " + baseDir.getAbsolutePath());
            } else {
                throw new IOException("Failed to create directory: " + baseDir.getAbsolutePath());
            }
        } else if (!baseDir.isDirectory()) {
            throw new IOException("The provided path is not a directory: " + baseDir.getAbsolutePath());
        }

        String[] folders = {
                "controllers",
                "model/entity",
                "model/dto",
                "repositories",
                "mappers",
                "services",
                "utils/exceptions",
                "utils/responses",
                "utils/file-upload",
                "utils/requests",
                "utils/base"
        };

        for (String folder : folders) {
            // Using the File constructor for platform independence
            File dir = new File(baseDir, folder);

            if (!dir.exists()) {
                boolean isCreated = dir.mkdirs();
                if (isCreated) {
                    System.out.println("Created: " + dir.getAbsolutePath());
                } else {
                    throw new IOException("Failed to create: " + dir.getAbsolutePath());
                }
            }
        }

        // Create the template file in the utils/base directory
        createBaseEntityFile(new File(baseDir, "utils/base"));

        SFException exception = new SFException();
        exception.createSystemGlobalFile(new File(baseDir, "utils/exceptions"));

        System.out.println("This is basic directory" + baseDir);
    }

    private void createBaseEntityFile(File baseDir) throws IOException {

        String templateFileName = "BaseEntity.java";
        File templateFile = new File(baseDir, templateFileName);

        String packagePath = getPackagePathFromWorkingDirectory();

        String convertPath = String.valueOf(baseDir).replace("/",".");
        String replacement = packagePath+"."+convertPath;


        // Check if the file already exists
        if (!templateFile.exists()) {
            try (FileWriter writer = new FileWriter(templateFile)) {
                writer.write(ForgeBaseEntityTemplate.BASE_ENTITY_TEMPLATE
                        .replace("{packageName}", replacement ));
                System.out.println("Created template file: " + templateFile.getAbsolutePath());
            }
        } else {
            System.out.println("Template file already exists: " + templateFile.getAbsolutePath());
        }
    }




}
