package com.hotel.automation.component;

import com.hotel.automation.util.AutomationConstants;
/**
 * Factory for creating the sensor for the corridor
 * @author vtkrishn
 *
 */
public class SensorFactory {
	
	/**
	 * Method to create the sensor based on the inputs provided
	 * @param floorNo
	 * @param corridorName
	 * @param index
	 * @return
	 */
	public static Sensor createSensor(String sensorType, int floorNo, String corridorName, int index) {
		Sensor sensor = null;
		if(sensorType.equals(AutomationConstants.MOTION)) {
			sensor = new MotionSensor(floorNo, AutomationConstants.FLOOR + AutomationConstants.SPACE 
					+ floorNo + AutomationConstants.COMMA + corridorName + AutomationConstants.COMMA 
					+ AutomationConstants.SENSOR + AutomationConstants.SPACE + index);
		}
		
		return sensor;
	}
	
}
