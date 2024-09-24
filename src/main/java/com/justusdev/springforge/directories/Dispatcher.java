package com.justusdev.springforge.directories;

import com.justusdev.springforge.directories.command_module.InitialCommand;

public class Dispatcher {

    public void dispatch(String commandName, String[] args) {

        switch (commandName.toLowerCase()) {

            case "init" :
                new InitialCommand().execute(args);
                break;
            case "help -all":
                System.out.println("All commands:");
                break;

            default:
                System.err.println("Unknown command: " + commandName);

                //TODO:: make sure here you tell use
                // that run this command to get list of commands you can run
                // and display them.
                System.err.println("Available commands: init");
                break;
        }
    }
}
