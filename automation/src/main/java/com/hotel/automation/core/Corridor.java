package com.hotel.automation.core;
/**
 * Corridor as an abstract class
 * @author vtkrishn
 *
 */
public abstract class Corridor{
	String name;
	Type corridorType;
	
	/**
	 * Get the name of the corridor
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Enum for the type [ MAIN and SUB]
	 * @author vtkrishn
	 *
	 */
	public enum Type {
		MAIN, SUB
	}
	
}
