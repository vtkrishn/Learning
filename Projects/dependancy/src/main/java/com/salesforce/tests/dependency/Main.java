package com.salesforce.tests.dependency;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.salesforce.tests.dependency.command.Command;
import com.salesforce.tests.dependency.command.CommandFactory;
import com.salesforce.tests.dependency.command.CommandOptions;
import com.salesforce.tests.dependency.util.DependancyConstants;
import com.salesforce.tests.dependency.util.DependancyUtil;

/**
 * The entry point for the Test program
 */
public class Main {
	
	Set<Item> itemPool = new HashSet<Item>();
    public static void main(String[] args) {

        //read input from stdin
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {
                break;
            }

            //Please provide your implementation here
            Command command = identifyCommand(line);
            CommandOptions options = identifyOptions(line);
            if(command != null)
				command.execute(options);
        }

    }
    
    
    private static Command identifyCommand(String input) {
		String[] splitInput = input.split(DependancyConstants.SPACE);
		String commandString = splitInput[0];
		Command command = CommandFactory.getCommand(commandString);
		return command;
	}
    
    private static CommandOptions identifyOptions(String input) {
		String[] splitInput = input.split(DependancyConstants.SPACE);
		CommandOptions options = null;
		if(splitInput.length > 1) {
			options = new CommandOptions();
			List<Item> items = null;
			for(int i=1;i<splitInput.length;i++) {
				Item item = new Item(splitInput[i]);
				options.addItem(item);
				if(i == 1)
					items = DependancyUtil.addItem(item.getName());
				else
					items.add(item);
			}
		}
		return options;
	}
}