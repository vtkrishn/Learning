package com.hotel.automation.core;

import com.hotel.automation.util.AutomationConstants;

public class MainCorridor extends Corridor{
	
	public MainCorridor(int index, Type type) {
		this.name = AutomationConstants.MAIN + AutomationConstants.SPACE + AutomationConstants.CORRIDOR + AutomationConstants.SPACE + index;
		this.corridorType = type;
	}
}
