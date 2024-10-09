package com.justusdev.springforge.database_module;

import com.justusdev.springforge.command_module.Command;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SFDatabaseExecutor implements Command {


    @Override
    public void execute(String[] args) throws IOException {

        if (args.length !=3 || !args[1].equals("db:")) {
            System.out.println("Usage: create db:<database_type>");
            System.out.println("Supported databases: mysql, postgres, oracle");
            return;
        }

        checkCurrentPath(args[2]);
    }

    private static void checkCurrentPath(String dbType) throws FileNotFoundException {
        // Get the current working directory
        String currentPath = System.getProperty("user.dir");
        System.out.println("Current Path: " + currentPath);

        // Define the expected resources path
        String expectedPath = "src/main/resources";

        String propertiesPath = "application.properties";

        // Check if the current path contains the expected path
        if (!currentPath.endsWith(expectedPath)) {
            logError("Error: The command must be run in the src/main/resources directory.");
        } else {
            System.out.println("Command executed in the correct directory.");
            SFDatabase configGenerator = new SFDatabase();
            configGenerator.readProperties(propertiesPath, dbType);
        }
    }

    private static void logError(String message) {
        // Simple logging mechanism (you can replace this with a proper logging framework)
        System.err.println(message);
    }

}
