package com.salesforce.tests.dependency;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.salesforce.tests.dependency.command.Command;
import com.salesforce.tests.dependency.command.CommandFactory;
import com.salesforce.tests.dependency.command.CommandList;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest{
	CommandFactory commandFactory;
	
	@Before
	public void setup() {
		commandFactory = new CommandFactory();
	}
	
	@After
	public void tearDown() {
		commandFactory = null;
	}
	
	
	@Test
	public void testObject() {
		assertNotNull(commandFactory);
	}
	
	@Test
	public void testCommand() {
		assertNotNull(CommandFactory.getCommand(CommandList.DEPEND));
		assertNotNull(CommandFactory.getCommand(CommandList.INSTALL));
		assertNotNull(CommandFactory.getCommand(CommandList.REMOVE));
		assertNotNull(CommandFactory.getCommand(CommandList.LIST));
		assertNotNull(CommandFactory.getCommand(CommandList.END));
	}
	
	@Test
	public void testDEPENDCommand() {
		Command command = CommandFactory.getCommand(CommandList.DEPEND);
	}
}
