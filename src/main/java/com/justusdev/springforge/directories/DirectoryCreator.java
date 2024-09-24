package com.justusdev.springforge.directories;

import java.io.File;
import java.io.IOException;

/**
 * Utility class to create a predefined directory structure for a project.
 */
public class DirectoryCreator {

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
    }
}
