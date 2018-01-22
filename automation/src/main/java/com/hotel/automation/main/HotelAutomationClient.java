package com.hotel.automation.main;

import java.util.Scanner;

import com.hotel.automation.control.Controller;
import com.hotel.automation.control.PowerController;
import com.hotel.automation.core.Hotel;
import com.hotel.automation.util.AutomationConstants;
import com.hotel.automation.util.AutomationUtil;

public class HotelAutomationClient {
	
	public static void main( String[] args )
    {
    	//Create the hotel chain
		HotelAutomationFactory hotelFactory = new HotelAutomationFactory();
    	hotelFactory.createChain("Chain", "Owner", "Hotel");
    	//get the input from the user
    	Scanner scan = AutomationUtil.getScanner();
    	
		int noOfFloor = scan.nextInt();
		int noOfMainCorridor = scan.nextInt();
		int noOfSubCorridor = scan.nextInt();
		//instantiate the controller for the hotel
		System.out.println("----------- Starting the controller -----------");
		Controller controller = new PowerController(noOfFloor,noOfMainCorridor, noOfSubCorridor);
		Hotel hotel = hotelFactory.getActiveHotel();
		hotel.addController(controller);
		//create the floors
		hotelFactory.createFloors();
    	
		//set default state
		System.out.println("----------- Printing Initial State START -----------");
		controller.initialize();
    	System.out.println("----------- Printing Initial State END -----------");
    	//motion detection
    	System.out.println("----------- Getting Input from the Sensor START -----------");
    	System.out.println("Input Format : Floor <#>, [Main/Sub] Corridor <#>");
    	System.out.println("Sensor Input :: ");
    	//Get sensor inputs
    	String sensorInput = scan.nextLine(); //"Floor 1, Sub Corridor 2"  
		while(!sensorInput.equals(AutomationConstants.END)) {
			//process the sensor inputs
			controller.processInput(sensorInput);
	    	sensorInput = scan.nextLine();
		}
		System.out.println("----------- Getting Input from the Sensor END -----------");
    	controller.shutDown();
    	System.out.println("----------- Closing down the controller -----------");
    	scan.close();
    }
}
