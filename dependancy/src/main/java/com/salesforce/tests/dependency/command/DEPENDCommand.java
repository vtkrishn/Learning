package com.salesforce.tests.dependency.command;

public class DEPENDCommand implements Command{
	
	@Override
	public void execute(CommandOptions options) {
		
//		Queue<Item> optionsItem = options.getItem();
//		List<Item> dependancy = null;
//		//take the first element in the queue
//		for(int i=0;i<=optionsItem.size();i++) {
//			Item item = optionsItem.poll();
//			if(i > 0) {
//				dependancy.add(item);
//			}
//			else {
//				dependancy = item.getDependancy();
//			}
//		}
		if(options == null) {
			System.out.println("Provide some item");
			return;
		}
	}
	
	//DEPEND NET TCP

}
