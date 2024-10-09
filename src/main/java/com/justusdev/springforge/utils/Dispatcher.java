package com.justusdev.springforge.utils;

import com.justusdev.springforge.command_module.InitialCommand;
import com.justusdev.springforge.db.DatabaseInitializationCommand;
import com.justusdev.springforge.files.DefineCommand;

import java.io.IOException;

public class Dispatcher {

    public void dispatch(String commandName, String[] args) throws IOException {

        switch (commandName.toLowerCase()) {

            case "init":
                new InitialCommand().execute(args);
                break;
            case "define":
                new DefineCommand().execute(args);
                break;
            case "create":
                new DatabaseInitializationCommand().execute(args);
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
