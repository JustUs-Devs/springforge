package com.justusdev.springforge.utils_module;

import com.justusdev.springforge.directory_module.SFDirectoryExecutor;
import com.justusdev.springforge.database_module.SFDatabaseExecutor;
import com.justusdev.springforge.file_module.SFFileExecutor;

import java.io.IOException;

public class Dispatcher {

    public void dispatch(String commandName, String[] args) throws IOException {

        switch (commandName.toLowerCase()) {

            case "init":
                new SFDirectoryExecutor().execute(args);
                break;
            case "define":
                new SFFileExecutor().execute(args);
                break;
            case "create":
                new SFDatabaseExecutor().execute(args);
                break;
            case "help -all":
                System.out.println("All commands:");
                break;
            default:
                System.err.println("Unknown command: " + commandName);

                //TODO:: make sure here you tell user
                // that run this command to get list of commands you can run
                // and display them.
                System.err.println("Available commands: init");
                break;
        }
    }
}
