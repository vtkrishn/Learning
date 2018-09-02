package com.salesforce.tests.dependency.command;

public class CommandFactory {
	
	public static Command getCommand(String input){
		Command command = null;
		switch(input) {
			case CommandList.DEPEND:
				command = new DEPENDCommand();
			break;
			case CommandList.INSTALL:
				command = new INSTALLCommand();
			break;
			case CommandList.REMOVE:
				command = new REMOVECommand();
			break;
			case CommandList.LIST:
				command = new LISTCommand();
			break;
			case CommandList.END:
				command = new ENDCommand();
			break;
			default:
				command = null;
			break;	
		}
		return command;
	}
}
