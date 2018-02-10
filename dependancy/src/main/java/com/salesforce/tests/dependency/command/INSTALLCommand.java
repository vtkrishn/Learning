package com.salesforce.tests.dependency.command;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.salesforce.tests.dependency.Item;
import com.salesforce.tests.dependency.util.DependancyUtil;

public class INSTALLCommand implements Command{

	@Override
	public void execute(CommandOptions options) {
		if(options == null) {
			System.out.println("Provide some item");
			return;
		}
			
		Map<String, List<Item>> objectDependancy =  DependancyUtil.getDependancy();
		Item optionItem = options.getItem().poll();
		String keyName = optionItem.getName();
		List<Item> keyList = objectDependancy.get(keyName);
		if(keyList.size() == 0) {
			if(!DependancyUtil.getInstalledItem().contains(keyName)) {
				System.out.println("Installing "+ keyName);
				DependancyUtil.addToInstalledList(keyName);
			}
		}
		else {
			for(Item item : keyList) {
				Set<String> set = DependancyUtil.getInstalledItem();
					String name = item.getName();
					if(!DependancyUtil.getInstalledItem().contains(name)) {
						System.out.println("Installing "+ name);
						DependancyUtil.addToInstalledList(name);
					}
			}
		}
			
	}
}
