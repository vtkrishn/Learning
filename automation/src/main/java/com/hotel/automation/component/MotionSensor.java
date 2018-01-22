package com.hotel.automation.component;

import java.util.ArrayList;

import com.hotel.automation.target.Pluggable;
/**
 * Sensor for motion
 * @author vtkrishn
 *
 */
public class MotionSensor extends DefaultSensor {
	/**
	 * Constructor taking the name of the sensor
	 * @param name
	 */
	public MotionSensor(int floorNo, String name) {
		this.floorNumber = floorNo;
		this.name = name;
		this.components = new ArrayList<Pluggable>();
	}
	
}
