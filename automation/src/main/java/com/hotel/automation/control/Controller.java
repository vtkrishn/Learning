package com.hotel.automation.control;

import java.util.ArrayList;
import java.util.List;

import com.hotel.automation.component.Sensor;
import com.hotel.automation.target.Pluggable;

public abstract class Controller{
	
	private int noOfFloors;
	private int noOfMainCorridor;
	private int noOfSubCorridor;
	
	private List<Sensor> sensors;
	
	//Abstract methods
	public abstract void printStatus();
	public abstract void processInput(String input);
	
	protected Controller(int floors, int mainCorridor, int subCorridor) {
		this.noOfFloors = floors;
		this.noOfMainCorridor= mainCorridor;
		this.noOfSubCorridor=subCorridor;
		this.sensors = new ArrayList<Sensor>();
	}
	public List<Sensor> getSensors() {
		return sensors;
	}
	
	/**
	 * controller initialize method
	 */
	public void initialize() {
		for(Sensor sensor : sensors)
			sensor.start();
		printStatus();
	}
	/**
	 * Shutdown the controller
	 */
	public void shutDown() {
		for(Sensor sensor : sensors)
			sensor.stop();
		printStatus();
	}
	
	/**
	 * Add a sensor to the controller
	 * @param sensor
	 */
	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}
	
//	public List<Sensor> getSensors() {
//		return sensors;
//	}
	
	/**
	 * Reset the sensors added to the controller
	 * @param sensor
	 */
//	public void reset(Sensor sensor) {
//		System.out.println("resetting the values");
//		for(Pluggable item : sensor.getComponents()) {
//			item.setPreviousState();
//			System.out.println(item.getName() + " : "+  item.getCurrentState());
//		}
//	}
	
	/**
	 * Get the no of floors
	 * @return
	 */
	public int getNoOfFloors() {
		return noOfFloors;
	}
	
	/**
	 * Get no of main corridors
	 * @return
	 */
	public int getNoOfMainCorridor() {
		return noOfMainCorridor;
	}
	
	/**
	 * Get no of sub corridors
	 * @return
	 */
	public int getNoOfSubCorridor() {
		return noOfSubCorridor;
	}
}
