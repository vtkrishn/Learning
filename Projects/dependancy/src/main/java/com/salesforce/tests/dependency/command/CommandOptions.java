package com.salesforce.tests.dependency.command;

import java.util.LinkedList;
import java.util.Queue;

import com.salesforce.tests.dependency.Item;

public class CommandOptions {
	Queue<Item> item = new LinkedList<Item>();
	public void addItem(Item item) {
		this.item.offer(item);
	}
	public Queue<Item> getItem() {
		return item;
	}
	
	
}
