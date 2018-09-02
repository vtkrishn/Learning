package com.hotel.automation.core;

import com.hotel.automation.util.AutomationConstants;

public class SubCorridor extends Corridor{
	
	public SubCorridor(int index, Type type) {
		this.name = AutomationConstants.SUB + AutomationConstants.SPACE + AutomationConstants.CORRIDOR + AutomationConstants.SPACE + index;;
		this.corridorType = type;
	}
	
}
