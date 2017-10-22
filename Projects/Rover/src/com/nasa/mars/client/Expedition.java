package com.nasa.mars.client;

import com.nasa.mars.deploy.OnBoardCamera;
import com.nasa.mars.deploy.Plateau;
import com.nasa.mars.deploy.RoverRobot;
import com.nasa.mars.exception.NasaException;
import com.nasa.mars.util.ExplorationUtil;
import com.nasa.mars.util.NavigationConstants;

public class Expedition {
	
	public static void main(String[] args) {
		
		 // variable to count the no of rovers
		 int noOfRovers = 0;
		 Plateau plateau = null;
		 
		 // variable to store instructionSets
		 String instructionSets = null;
		 
		 //Do you want to continue?
		 String option = null;
		 
		 //Initialize the Camera
		 OnBoardCamera camera = new OnBoardCamera();
		
		 //Get the Upper Right Coordinates for the Plateau and store it in the camera
		 System.out.println("Enter the upper right Coordinates for the Plateau:(x y)");
		 camera.setMaxWidthAndHeight(ExplorationUtil.getUserCoOrdinates());
				
		 try{
			//Initialize the plateau with the data provided
			plateau = new Plateau(camera.getMaxX(),camera.getMaxY());
			
			//Construct the Plateau
			plateau.constructPlateau();
			System.out.println("Plateau Constructed");
			
			option = NavigationConstants.YES;
			 
		 }
		 catch(NasaException e){
			//log
		 }
		
		 //Deploy the Rover at the Coordinates provided - Number defaulted to 10
		 RoverRobot[] rover = new RoverRobot[10];
		
		 //If option is yes get deploy another rover
		 while(NavigationConstants.YES.equals(option)){
			
			try{
				
				//Process the Instructions for the Rover
				processProblem(camera, rover, plateau, instructionSets, noOfRovers);
			}
			catch(NasaException e){
				//log
			}
			//Get the Instruction sets to command the Rover
			System.out.println("Do you want to deploy another Rover(y/n)");
			option = ExplorationUtil.getUserCoOrdinates();
			
			//increment the count of rovers
			noOfRovers++;
			
			System.out.println("Number of rovers deployed: "+ noOfRovers);
			
			System.out.println("Processing the instruction Sets...");
		}
		
		
		
		//Display the rover and its current position
		for(int i = 0; i<noOfRovers; i++){
			
			//Display the Current position of the Rover
			System.out.println("Rover current position at ("+rover[i].getXPosition()+","+rover[i].getYPosition()+") facing "+rover[i].getFacingDirection());
		}
	}
	
	/**
	 * Process the problem of deploying the Rover in the given plateau
	 * @param camera
	 * @param rover
	 * @param plateau
	 * @param instructionSets
	 * @param no
	 * @throws NasaException
	 */
	private static void processProblem(OnBoardCamera camera,RoverRobot[] rover, Plateau plateau, String instructionSets, int noOfRovers) throws NasaException{
		
		//Get the Coordinates to deploy the Rover
		System.out.println("Enter the current deployed Coordinates for the Rover:(x y face)");
		camera.setRoverAttribute(ExplorationUtil.getUserCoOrdinates());
		
		//Initialize the Rover
		rover[noOfRovers] = new RoverRobot(camera.getCurrentXPosition(),camera.getCurrentYPosition(),camera.getCurrentFacingDirection());
		System.out.println("Robotic Rover deployed at ("+camera.getCurrentXPosition()+","+camera.getCurrentYPosition()+") facing "+ camera.getCurrentFacingDirection());
		
		//set the plateau for the rover
		rover[noOfRovers].setPlateau(plateau);
		
		//Get the Instruction sets to command the Rover
		System.out.println("Enter the instruction Sets");
		instructionSets = ExplorationUtil.getUserCoOrdinates();
		
		//Process the Instructions for the Rover
		rover[noOfRovers].processMovement(instructionSets);
	}
	
}
