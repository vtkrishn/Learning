package com.hotel.automation.component;

import java.util.List;

import com.hotel.automation.target.Pluggable;

/**
 * Abstract class for all the sensors
 * @author vtkrishn
 *
 */
public abstract class DefaultSensor implements Sensor{
	
	//0 to 1 range
	float pollFrequency = 0.9f;   
	// 0 to 1 range
	float precision = 0.5f; 
	// check if the Sensor is active or not
	boolean isActive; 
	// name of the sensor
	String name; 
	// list of components the sensor is observing
	List<Pluggable> components;
	int floorNumber;
	
	
	public int getFloorNo() {
		return this.floorNumber;
	}
	/*
	 * Get the name of the sensor
	 * @see com.hotel.automation.component.Sensor#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Start the sensor invoked by the controller
	 * @see com.hotel.automation.component.Sensor#start()
	 */
	public void start() {
		//set the sensor to active
		isActive = true;
		//set all the components default state
		for(Pluggable component :components)
			component.resetToDefault();
	}
	
	/*
	 * Stop the sensor invoked by the controller
	 * @see com.hotel.automation.component.Sensor#stop()
	 */
	public void stop() {
		//set the active state to false
		isActive = false;
		for(Pluggable component :components)
			unRegisterComponent(component);
	}
	
	/*
	 * Register the component which needs to be observed
	 * @see com.hotel.automation.component.Sensor#registerComponent(com.hotel.automation.target.Pluggable)
	 */
	public void registerComponent(Pluggable component) {
		this.components.add(component);
	}
	
	/*
	 * Un register the component for sensing
	 * @see com.hotel.automation.component.Sensor#unRegisterComponent(com.hotel.automation.target.Pluggable)
	 */
	public void unRegisterComponent(Pluggable component) {
		//this.components.remove(component);
	}
	
	/*
	 * Get list of the components observed by the sensor
	 * @see com.hotel.automation.component.Sensor#getComponents()
	 */
	public List<Pluggable> getComponents() {
		return this.components;
	}
}
