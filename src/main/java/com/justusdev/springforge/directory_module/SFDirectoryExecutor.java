package com.justusdev.springforge.directory_module;

import com.justusdev.springforge.command_module.Command;

import java.io.File;
import java.io.IOException;

/**
 * Command to initialize the project directory structure.
 */
public class SFDirectoryExecutor implements Command {

    @Override
    public void execute(String[] args) {
        // Check if base directory is provided
        if (args.length < 1) {
            System.err.println("Usage: java -jar springforge.jar init <baseDirectory>");
            return;
        }

        String baseDir = args[1];

        // Get the current working directory
        String currentDir = System.getProperty("user.dir");
        String fullBaseDir = currentDir + "/";


        // Validate that the base directory is within 'src/main/java/'
        if (!fullBaseDir.contains("/src/main/java/com/")) {
            System.err.println("Error: The base directory must be within 'src/main/java/com/'.");
            return;
        }


        SFDirectory forgeInitCreator = new SFDirectory();

        try {
            forgeInitCreator.createDirectories(baseDir);
        } catch (IOException e) {
            System.err.println("Error while creating directories: " + e.getMessage());
        }
    }

    /**
     * Validates the provided base directory.
     *
     * @param baseDir the base directory to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidBaseDirectory(String baseDir) {
        File baseDirectory = new File(baseDir);
        return baseDirectory.exists() && baseDirectory.isDirectory() && baseDir.startsWith("src/main/java/");
    }


}
