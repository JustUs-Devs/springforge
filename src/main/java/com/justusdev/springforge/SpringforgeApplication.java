package com.justusdev.springforge;

import com.justusdev.springforge.utils_module.Dispatcher;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringforgeApplication {

	public static void main(String[] args) throws IOException {
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
