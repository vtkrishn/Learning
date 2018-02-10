package com.salesforce.tests.dependency.command;

import java.util.Set;

import com.salesforce.tests.dependency.util.DependancyUtil;

public class LISTCommand implements Command{

	@Override
	public void execute(CommandOptions options) {
		Set<String> installedItem = DependancyUtil.getInstalledItem();
		for(String item : installedItem) {
			System.out.println(item);
		}
		
	}
}
