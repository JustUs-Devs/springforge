package com.justusdev.springforge;

import com.justusdev.springforge.directories.Dispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringforgeApplication {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No command provided. Usage: java -jar springforge.jar <command> [options]");
			System.err.println("Run 'help' to see a list of available commands.");
			return;
		}

		String commandName = args[0];

		Dispatcher commandDispatcher = new Dispatcher();
		commandDispatcher.dispatch(commandName, args);
	}
}
