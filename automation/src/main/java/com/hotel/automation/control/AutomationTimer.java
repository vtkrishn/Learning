package com.hotel.automation.control;

import java.util.List;

import com.hotel.automation.component.Sensor;
import com.hotel.automation.target.Pluggable;
import com.hotel.automation.target.state.State;
import com.hotel.automation.util.AutomationConstants;
import com.hotel.automation.util.AutomationUtil;
/**
 * Timer to get asynchronous call for resetting the state of the component
 * @author vtkrishn
 *
 */
public class AutomationTimer implements Runnable{
	Pluggable item;
	Pluggable acItem;
	Controller controller;
	static int currentPower;
	Sensor sensor;
	//static Queue<Pluggable> queue;
//	static {
//		 queue = new PriorityBlockingQueue<Pluggable>();
//	}
	
	public AutomationTimer(Controller controller, Pluggable item,Sensor sensor) {
		this.item = item;
		this.controller = controller;
		this.sensor = sensor;
		currentPower = getThresholdLimit();
		
		//queue.offer(item);
	}
	/*
	 * Delay call to reset the component to previous state
	 * @see java.util.concurrent.Callable#call()
	 */
	public void run() {
		
			System.out.println("Changing State for :: " + sensor.getName() + " : " + item.getName());
			item.changeState(AutomationUtil.getONState());
			this.controller.printStatus();
			currentPower = currentPower + AutomationConstants.LIGHT_POWER_UNIT;
			
			maintainPowerConsumption();
			//sleep for the delay
			try {
				Thread.sleep(AutomationConstants.DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Pluggable item = queue.poll();
			
			System.out.println("Timer Ending for :: " + sensor.getName() + " : " + item.getName());
			item.setPreviousState();
			this.controller.printStatus();
			currentPower = currentPower - AutomationConstants.LIGHT_POWER_UNIT;
			
			System.out.println("Reverting Status for :: " + sensor.getName() + " : " + acItem.getName() +" to maintain the power consumption");
			acItem.setPreviousState();
			this.controller.printStatus();
			currentPower = currentPower + AutomationConstants.AC_POWER_UNIT;
		
	}
	
	/**
	 *  Get the maximum threashold limit
	 * @return
	 */
	public int getThresholdLimit() {
		return this.controller.getNoOfFloors() * (
				(this.controller.getNoOfMainCorridor() * (AutomationConstants.AC_POWER_UNIT + AutomationConstants.LIGHT_POWER_UNIT)) + 
				(this.controller.getNoOfSubCorridor() * AutomationConstants.AC_POWER_UNIT)
				);
	}
	
	/*
	 * maintain the power consumption
	 */
	private void maintainPowerConsumption(){
			List<Sensor> targetSensors = AutomationUtil.getSensorInTheFloor(sensor.getFloorNo(),sensor.getName(), this.controller.getSensors());
			if(targetSensors.size() == 0)
				targetSensors = this.controller.getSensors();
			for(Sensor sensor : targetSensors) {
				for(Pluggable item : sensor.getComponents()) {
						if(currentPower > getThresholdLimit()) {
							if(item.getPowerUnit() == AutomationConstants.AC_POWER_UNIT && item.getCurrentState().toString().equals(State.ON)) {
								System.out.println("Changing Status for :: " + sensor.getName() + " : " + item.getName() +" to maintain the power consumption");
								item.changeState(AutomationUtil.getOFFState());
								this.controller.printStatus();
								currentPower = currentPower - AutomationConstants.AC_POWER_UNIT;
								this.acItem = item;
							}
						}
					}
			}
		}
	
	
}
