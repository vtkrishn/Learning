package com.nasa.mars.processor;

import com.nasa.mars.deploy.RoverRobot;
import com.nasa.mars.util.NavigationConstants;

public class ProcessorContext implements CommandProcessor{
	
	private RoverRobot roverRobot;
	
	/**
	 * Constructor accepting Rover object
	 * @param robot
	 */
	public ProcessorContext(RoverRobot robot) {
		this.roverRobot = robot;
	}
	/**
	 * Process the instructions given to the Rover
	 * @param instructionSets
	 */
	public void processInstructionSets(String instructionSets){
		
		//loop through the length of the instructionSets 
		for(int i=0;i<instructionSets.length();i++){
			
			//Get the individual command
			char key = instructionSets.charAt(i);
			
			//Switch between the commands
			switch (key) {
			case NavigationConstants.LEFT:
				processLEFT();
				break;
			case NavigationConstants.RIGHT:
				processRIGHT();
				break;
			case NavigationConstants.MOVE:
				processMOVE();
				break;
			default:
				break;
			}
		}
		
	}
	
	/**
	 * Process the LEFT command
	 */
	public void processLEFT(){
		if(this.roverRobot.getFacingDirection() == NavigationConstants.NORTH){		// Left of NORTH is WEST
			this.roverRobot.setFacingDirection(NavigationConstants.WEST);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.WEST){	// Left of WEST is SOUTH
			this.roverRobot.setFacingDirection(NavigationConstants.SOUTH);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.SOUTH){	// Left of SOUTH is EAST
			this.roverRobot.setFacingDirection(NavigationConstants.EAST);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.EAST){	// Left of EAST is NORTH
			this.roverRobot.setFacingDirection(NavigationConstants.NORTH);
		}
		
		
	}
	
	/**
	 * Process the RIGHT command
	 */
	public void processRIGHT() {
		if(this.roverRobot.getFacingDirection() == NavigationConstants.NORTH){		// Right of NORTH is EAST
			this.roverRobot.setFacingDirection(NavigationConstants.EAST);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.EAST){	// Right of EAST is SOUTH
			this.roverRobot.setFacingDirection(NavigationConstants.SOUTH);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.SOUTH){	// Right of SOUTH is WEST
			this.roverRobot.setFacingDirection(NavigationConstants.WEST);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.WEST){	// Right of WEST is NORTH
			this.roverRobot.setFacingDirection(NavigationConstants.NORTH);
		}
		
	}
	
	/**
	 * Process the MOVE command
	 */
	public void processMOVE() {
		if(this.roverRobot.getFacingDirection() == NavigationConstants.NORTH){		//Moving towards NORTH increases Y Position
			this.roverRobot.setYPosition(this.roverRobot.getYPosition() + 1);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.SOUTH){	//Moving towards SOUTH decreases Y Position
			this.roverRobot.setYPosition(this.roverRobot.getYPosition() - 1);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.EAST){	//Moving towards EAST increases X Position
			this.roverRobot.setXPosition(this.roverRobot.getXPosition() + 1);
		}
		else if(this.roverRobot.getFacingDirection() == NavigationConstants.WEST){	//Moving towards WEST decreases X Position
			this.roverRobot.setXPosition(this.roverRobot.getXPosition() - 1);
		}
		
	}

}
