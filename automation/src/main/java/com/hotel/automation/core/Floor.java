package com.hotel.automation.core;

import java.util.ArrayList;
import java.util.List;

import com.hotel.automation.util.AutomationConstants;
/**
 * Get the floor information
 * @author vtkrishn
 *
 */
public class Floor {
	String name;
	int floorNumber;
	List<Corridor> corridors;
	/**
	 * set the name, floorNumber in this constructor
	 * @param floorNumber
	 */
	public Floor(int floorNumber) {
		this.name = AutomationConstants.FLOOR + AutomationConstants.SPACE + floorNumber;
		
		this.floorNumber = floorNumber;
		this.corridors = new ArrayList<Corridor>();
	}

	public void addCorridor(Corridor corridor) {
		this.corridors.add(corridor);
	}
}
