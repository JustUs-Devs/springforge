package com.justusdev.springforge.files;

import com.justusdev.springforge.utils.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.justusdev.springforge.utils.ForgeMapperTemplates.MAPPER_TEMPLATE;

public class DefineCreation {

    public void createController(String baseDirectory, String modelName, String packageName) throws IOException {
        // Ensure correct file path
        String path = baseDirectory + "/" + modelName + "Controller.java"; // Added '/' for proper path

        // Create the file object
        File controllerFile = new File(path);

        // Check if the file already exists
        if (controllerFile.exists()) {
            System.err.println("Error: The file " + controllerFile.getName() + " already exists.");
            return; // Exit if the file exists
        }

        System.out.println("file Created at: " + path);

        // Create the file and write the controller template
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(controllerFile))) {
            // Write the package declaration
            writer.write("package " + packageName + ".controllers;\n\n");

            // Write the controller methods with replacements
            writer.write(ForgeControllerTemplates.CONTROLLER_METHODS
                    .replace("{packageName}", packageName)
                    .replace("{ModelName}", modelName)
                    .replace("{modelNameLower}", modelName.toLowerCase()));

            // Log successful creation
            System.out.println("Successfully created: " + controllerFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public void modelCreation(String baseDirectory, String modelName, String packageName) {
        String entityPath = baseDirectory + "/entity/" + modelName + "Entity.java";
        String dtoPath = baseDirectory + "/dto/" + modelName + "Dto.java";

        File entityFile = new File(entityPath);
        File dtoFile = new File(dtoPath);

        if (entityFile.exists()) {
            System.err.println("Error: The file " + entityFile.getName() + " already exists.");
            return;
        } else if (dtoFile.exists()) {
            System.err.println("Error: The file " + dtoFile.getName() + " already exists.");
            return;
        }

        // Create directories if they do not exist
        new File(baseDirectory + "/entity/").mkdirs();
        new File(baseDirectory + "/dto/").mkdirs();

        // Create the entity file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile))) {
            writer.write(ForgeEntityTemplates.ENTITY_TEMPLATE
                    .replace("{packageName}", packageName)
                    .replace("{ModelName}", modelName)
                    .replace("{tableName}", modelName.toLowerCase() + "s_tb")); // Assuming plural table name
        } catch (IOException e) {
            System.err.println("Error writing entity file: " + e.getMessage());
        }

        // Create the DTO file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dtoFile))) {
            writer.write(ForgeDtoTemplates.DTO_TEMPLATE
                    .replace("{packageName}", packageName)
                    .replace("{ModelName}", modelName)
                    .replace("{modelNameLower}", modelName.toLowerCase()));
        } catch (IOException e) {
            System.err.println("Error writing DTO file: " + e.getMessage());
        }

        System.out.println("Successfully created: " + entityFile.getAbsolutePath());
        System.out.println("Successfully created: " + dtoFile.getAbsolutePath());
    }

    public void mapperCreation(String baseDirectory, String modelName, String packageName) {

        // Ensure correct file path
        String path = baseDirectory + "/" + modelName + "Mapper.java"; // Added '/' for proper path

        // Create the file object
        File controllerFile = new File(path);

        // Check if the file already exists
        if (controllerFile.exists()) {
            System.err.println("Error: The file " + controllerFile.getName() + " already exists.");
            return; // Exit if the file exists
        }

        System.out.println("file Created at: " + path);

        // Create the file and write the controller template
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(controllerFile))) {
            // Write the package declaration
            writer.write("package " + packageName + ".mappers;\n\n");

            // Write the controller methods with replacements
            writer.write(MAPPER_TEMPLATE
                    .replace("{packageName}", packageName)
                    .replace("{ModelName}", modelName)
                    .replace("{modelNameLower}", modelName.toLowerCase()));


            // Log successful creation
            System.out.println("Successfully created: " + controllerFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public void repositoryCreation(String baseDirectory, String modelName, String packageName) {
        // Ensure correct file path
        String path = baseDirectory + "/" + modelName + "Repository.java"; // Added '/' for proper path

        // Create the file object
        File controllerFile = new File(path);

        // Check if the file already exists
        if (controllerFile.exists()) {
            System.err.println("Error: The file " + controllerFile.getName() + " already exists.");
            return; // Exit if the file exists
        }

        System.out.println("file Created at: " + path);

        // Create the file and write the controller template
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(controllerFile))) {
            // Write the package declaration
            writer.write("package " + packageName + ".repositories;\n\n");

            // Write the controller methods with replacements
            writer.write(ForgeRepositoryTemplates.REPOSITORY_TEMPLATE
                    .replace("{packageName}", packageName)
                    .replace("{ModelName}", modelName)
                    .replace("{modelNameLower}", modelName.toLowerCase()));

            // Log successful creation
            System.out.println("Successfully created: " + controllerFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void serviceCreation(String baseDirectory, String modelName, String packageName) {
        // Ensure correct file path
        String path = baseDirectory + "/" + modelName + "Service.java"; // Added '/' for proper path

        // Create the file object
        File controllerFile = new File(path);

        // Check if the file already exists
        if (controllerFile.exists()) {
            System.err.println("Error: The file " + controllerFile.getName() + " already exists.");
            return; // Exit if the file exists
        }

        System.out.println("file Created at: " + path);

        // Create the file and write the controller template
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(controllerFile))) {
            // Write the package declaration
            writer.write("package " + packageName + ".services;\n\n");

            // Write the controller methods with replacements
            writer.write(ForgeServiceTemplates.SERVICE_TEMPLATE
                    .replace("{packageName}", packageName)
                    .replace("{ModelName}", modelName)
                    .replace("{modelNameLower}", modelName.toLowerCase()));

            // Log successful creation
            System.out.println("Successfully created: " + controllerFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    }
