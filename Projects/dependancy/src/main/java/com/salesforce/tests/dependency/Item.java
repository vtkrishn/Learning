package com.salesforce.tests.dependency;

import java.util.ArrayList;
import java.util.List;

public class Item {
	public void setDependancy(List<Item> dependancy) {
		this.dependancy = dependancy;
	}

	private String name;
	private List<Item> dependancy;
	private boolean installed;
	
	public Item(String name) {
		this.name = name;
		this.dependancy = new ArrayList<Item>();
	}

	public List<Item> getDependancy() {
		return dependancy;
	}
	
	public String getName() {
		return this.name;
	}

	public boolean isInstalled() {
		return installed;
	}

	public void setInstalled(boolean installed) {
		this.installed = installed;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
}
