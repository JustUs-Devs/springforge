package com.justusdev.springforge.file_module;

import com.justusdev.springforge.command_module.Command;
import com.justusdev.springforge.pom_module.PomDependencyManager;

import java.io.File;
import java.io.IOException;

public class SFFileExecutor implements Command {

    @Override
    public void execute(String[] args) {
        // Check if model name is provided
        if (args.length < 2) {
            System.err.println("Usage: java -jar springforge.jar create <ModelName>");
            return;
        }

        String modelName = args[1]; // Get the model name from arguments

        // Get the current working directory
        String currentDir = System.getProperty("user.dir");

        // Determine the package name based on the current directory
        String packagePath = currentDir.substring(currentDir.indexOf("src/main/java/") + "src/main/java/".length());
        String packageName = packagePath.replace(File.separator, "."); // Convert to package format

        // Check if the controllers directory exists
        File controllersDir = new File(currentDir  + "/controllers");
        File modelDir = new File(currentDir  + "/model");
        File mapperDir = new File(currentDir  + "/mappers");
        File repositoryDir = new File(currentDir  + "/repositories");
        File serviceDir = new File(currentDir  + "/services");
        String pomPath =  extractPathBeforeSrc(currentDir);

        // Ensure the correct construction of the controllers directory path
        if (!controllersDir.exists()) {
            System.err.println("Error: The controllers directory does not exist at " + controllersDir.getAbsolutePath());
            return;
        }

//        System.out.println("Current dir: " + currentDir);
//        System.out.println("Base directory: " + currentDir);
//        System.out.println("Package name: " + packageName);
//        System.out.println("Package path: " + packagePath);
//        System.out.println("Controller directory: " + controllersDir.getAbsolutePath());

        SFFile defineCreation = new SFFile();
        PomDependencyManager dependencyManager = new PomDependencyManager();

        try {
            defineCreation.createController(controllersDir.getAbsolutePath(), modelName, packageName);
            defineCreation.modelCreation(modelDir.getAbsolutePath(), modelName, packageName);
            defineCreation.mapperCreation(mapperDir.getAbsolutePath(), modelName, packageName);
            defineCreation.repositoryCreation(repositoryDir.getAbsolutePath(), modelName, packageName);
            defineCreation.serviceCreation(serviceDir.getAbsolutePath(), modelName, packageName);
            dependencyManager.addDependencies(pomPath);
        } catch (IOException e) {
            System.err.println("Error while executing this command: " + e.getMessage());
        }
    }

    public static String extractPathBeforeSrc(String fullPath) {
        // Find the index of "src"
        int index = fullPath.indexOf("/src");

        // If "src" is found, return the substring before it
        if (index != -1) {
            return fullPath.substring(0, index);
        }

        // Return the original path if "src" is not found
        return fullPath; // or return null if you prefer
    }
}
