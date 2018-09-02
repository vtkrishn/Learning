package com.salesforce.tests.dependency.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.salesforce.tests.dependency.Item;

public class DependancyUtil {
	static Map<String, List<Item>> objectStore;
	static Set<String> installedList;
	static Set<String> removedList;
	static {
		objectStore = new HashMap<String, List<Item>>(); 
		installedList = new LinkedHashSet<String>();
		removedList = new LinkedHashSet<String>();
	}
	public static List<Item> addItem(String key) {
		List<Item> dependancy = null;
		if(!objectStore.containsKey(key)) {
			dependancy = new ArrayList<Item>();
			objectStore.put(key, dependancy);
		}
		else {
			dependancy = objectStore.get(key);
		}
		return dependancy;
	}
	
	public static Map<String, List<Item>> getDependancy() {
		return objectStore;
	}
	
	public static void addToInstalledList(String itemName) {
		installedList.add(itemName);
	}
	
	public static Set<String> getInstalledItem() {
		return installedList;
	}
	
	public static void addToRemovedList(String itemName) {
		removedList.add(itemName);
	}
	
	public static Set<String> getRemovedItem() {
		return removedList;
	}
}
