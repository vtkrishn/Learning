package com.salesforce.tests.dependency.command;

public interface Command {
	
	public void execute(CommandOptions options);
}
