package com.justusdev.springforge.directory_module;

import com.justusdev.springforge.utils_module.templates.ForgeBaseEntityTemplate;
import com.justusdev.springforge.utils_module.templates.exception.ExceptionModelTemplate;
import com.justusdev.springforge.utils_module.templates.exception.ForgeGlobalExceptionHandlerTemplate;
import com.justusdev.springforge.utils_module.templates.exception.GlobalExceptionTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        createSystemGlobalFile(new File(baseDir, "utils/exceptions"));

        System.out.println("This is basic directory" + baseDir);
    }

    private void createBaseEntityFile(File baseDir) throws IOException {

        String templateFileName = "BaseEntity.java";
        File templateFile = new File(baseDir, templateFileName);

        String convertPath = String.valueOf(baseDir).replace("/",".");
        String replacement = "com."+convertPath;


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

    private void createSystemGlobalFile(File baseDir) throws IOException {
        String templateFileName = "GlobalExceptionHandler.java";
        String templateFileName_2 = "ExceptionModel.java";
        String templateFileName_3 = "GlobalException.java";

        File templateFile = new File(baseDir, templateFileName);
        File templateFile_1 = new File(baseDir, templateFileName_2);
        File templateFile_2 = new File(baseDir, templateFileName_3);

        String convertPath = String.valueOf(baseDir).replace("/",".");
        String replacement = "com."+convertPath;



        // Check if any of the files already exist
        if (!templateFile.exists() && !templateFile_1.exists() && !templateFile_2.exists()) {
            try (FileWriter writer1 = new FileWriter(templateFile);
                 FileWriter writer2 = new FileWriter(templateFile_1);
                 FileWriter writer3 = new FileWriter(templateFile_2)) {

                writer1.write(ForgeGlobalExceptionHandlerTemplate.GLOBAL_EXCEPTION_HANDLER.replace("{packageName}", replacement ));
                writer2.write(ExceptionModelTemplate.EXCEPTION_MODEL_CLASS.replace("{packageName}", replacement ));
                writer3.write(GlobalExceptionTemplate.GLOBAL_EXCEPTION_CLASS.replace("{packageName}", replacement ));

                System.out.println("Created template files:");
                System.out.println(" - " + templateFile.getAbsolutePath());
                System.out.println(" - " + templateFile_1.getAbsolutePath());
                System.out.println(" - " + templateFile_2.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error writing template files: " + e.getMessage());
            }
        } else {
            System.out.println("One or more template files already exist:");
            if (templateFile.exists()) {
                System.out.println(" - " + templateFile.getAbsolutePath());
            }
            if (templateFile_1.exists()) {
                System.out.println(" - " + templateFile_1.getAbsolutePath());
            }
            if (templateFile_2.exists()) {
                System.out.println(" - " + templateFile_2.getAbsolutePath());
            }
        }
    }

}
