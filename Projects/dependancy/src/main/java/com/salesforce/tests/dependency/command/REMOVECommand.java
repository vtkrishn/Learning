package com.salesforce.tests.dependency.command;

import java.util.List;
import java.util.Map;

import com.salesforce.tests.dependency.Item;
import com.salesforce.tests.dependency.util.DependancyUtil;

public class REMOVECommand implements Command{

	@Override
	public void execute(CommandOptions options) {
		if(options == null) {
			System.out.println("Provide some item");
			return;
		}
		Map<String, List<Item>> objectDependancy =  DependancyUtil.getDependancy();
		
		Item optionItem = options.getItem().poll();
		String keyName = optionItem.getName();
		
		for(Map.Entry<String, List<Item>> map : objectDependancy.entrySet()) {
			if(map.getValue().contains(keyName)) {
				System.out.println(keyName + " is still needed");	
			}
		}
		
		List<Item> keyList = objectDependancy.get(keyName);
		for(Item item : keyList) {
				String name = item.getName();
				if(!DependancyUtil.getRemovedItem().contains(name)) {
					System.out.println("Removing "+ name);
					DependancyUtil.addToRemovedList(name);
					DependancyUtil.getInstalledItem().remove(name);
				}
			}
		}
}
