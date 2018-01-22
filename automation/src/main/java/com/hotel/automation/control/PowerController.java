package com.hotel.automation.control;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hotel.automation.component.Sensor;
import com.hotel.automation.target.Pluggable;
import com.hotel.automation.util.AutomationConstants;
/**
 * Controller for the power
 * @author vtkrishn
 *
 */
public class PowerController extends Controller{
	
	/**
	 * Controller constructor taking no of floors and corridors
	 * @param floors
	 * @param mainCorridor
	 * @param subCorridor
	 */
	public PowerController(int floors, int mainCorridor, int subCorridor) {
		super(floors, mainCorridor, subCorridor);
	}
	
	
	/**
	 * implentation for printing the status of the controllers
	 */
	@Override
	public void printStatus() {
		String previousFloorName = "";
		for(Sensor sensor : getSensors()) {
			String[] sensorName = sensor.getName().split(AutomationConstants.COMMA);
			if(!previousFloorName.equals(sensorName[0])) {
				System.out.println(sensorName[0]);
				previousFloorName = sensorName[0];
			}
			System.out.println("\t"+sensorName[1]);
			for(Pluggable item  : sensor.getComponents())
				System.out.println("\t\t"+item.getName() + " : "+  item.getCurrentState());
		}
	}
	
	/**
	 * Process the input from the sensor
	 * @param input
	 */
	public void processInput(String input) {
		if(input.contains(AutomationConstants.COMMA)) {	
			String[] inputSplit = input.split(AutomationConstants.COMMA);
			String inputFloorName = inputSplit[0].trim();
			String inputCorridorName = inputSplit[1].trim();
			for(Sensor sensor  : getSensors()) {
				String[] sensorNameSplit = sensor.getName().split(AutomationConstants.COMMA);
				String sensorFloorName = sensorNameSplit[0].trim();
				String sensorCorridorName = sensorNameSplit[1].trim();
				if(sensorFloorName.equals(inputFloorName) && sensorCorridorName.equals(inputCorridorName)){
					for(Pluggable item : sensor.getComponents()) {
						if(item.getPowerUnit() == AutomationConstants.LIGHT_POWER_UNIT) {
							callExecutor(sensor, item);
						}
					}
				}
			}
		}
		
	}
	
	public void callExecutor(Sensor sensor, Pluggable item) {
		ExecutorService executorService = Executors.newFixedThreadPool(AutomationConstants.THREAD_POOL_SIZE);
		executorService.execute(new AutomationTimer(this, item, sensor));
		executorService.shutdown();
	}
	
}
