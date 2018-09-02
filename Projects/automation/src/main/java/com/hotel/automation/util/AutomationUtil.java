package com.hotel.automation.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hotel.automation.component.Sensor;
import com.hotel.automation.target.state.OFFState;
import com.hotel.automation.target.state.ONState;
import com.hotel.automation.target.state.State;
/**
 * Utility class for all automation tasks
 * @author vtkrishn
 *
 */
public class AutomationUtil {
	
	static {
		objectStore = new HashMap<String, Object>();
	}
		
		private static Map<String, Object> objectStore;
	
	/**
	 * Check if the time is valid to turn ON the lights in the main corridor
	 * @return
	 */
	public static boolean isValid() {
		final LocalDateTime now = LocalDateTime.now();
		final LocalDateTime minRange = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 18, 00); 
		LocalDateTime maxRange = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 6, 00); 
		maxRange = maxRange.plusDays(1); 
		return (now.isAfter(minRange) && now.isBefore(maxRange));
	}
	
	/**
	 * Get the scanner to get the input from the user
	 * @return
	 */
	public static Scanner getScanner() {
		Scanner scan = null;
		if(!objectStore.containsKey("SCANNER")) {
			scan = new Scanner(System.in);
		}
		else {
			scan = (Scanner)objectStore.get("SCANNER");
		}
		return scan;
	}
	/**
	 * Get the ON instance
	 * @return
	 */
	public static State getONState() {
		State state = null;
		if(!objectStore.containsKey(State.ON)) {
			state = new ONState();
		}
		else {
			state = (State)objectStore.get(State.ON);
		}
		return state;
	}
	
	/**
	 * Get OFF instance
	 * @return
	 */
	public static State getOFFState() {
		State state = null;
		if(!objectStore.containsKey(State.OFF)) {
			state = new OFFState();
		}
		else {
			state = (State)objectStore.get(State.OFF);
		}
		return state;
	}
	
	public static List<Sensor> getSensorInTheFloor(int floorNo, String sensorName, List<Sensor> controllerSensors){
		List<Sensor> sensors = new ArrayList<Sensor>();
		for(Sensor sensor : controllerSensors) {
			if(sensor.getName().contains(AutomationConstants.SUB) && sensor.getFloorNo() == floorNo && !sensor.getName().equals(sensorName)) {
				sensors.add(sensor);
			}
		}
		return sensors;
	}
}
