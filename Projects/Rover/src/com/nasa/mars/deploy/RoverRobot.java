package com.nasa.mars.deploy;

import com.nasa.mars.processor.ProcessorContext;

public class RoverRobot{
	
	/*
	 * Rover Attributes
	 */
	private  int xPosition;
	private  int yPosition;
	private  char facingDirection;
	
	/*
	 * Plateau and ProcessorContext reference object 
	 */
	private Plateau plateau;
	private ProcessorContext processorContext;
		
	/**
	 * Constructor to initialize the Rover Current(x,y) position
	 * and facing direction
	 * @param xPos
	 * @param yPos
	 * @param face
	 */
	public RoverRobot(int xPos, int yPos, char face){
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.facingDirection = face;
	}

	/**
	 * Get Rover X position
	 * @return
	 */
	public  int getXPosition() {
		return this.xPosition;
	}

	/**
	 * Set Rover X position
	 * @param position
	 */
	public  void setXPosition(int position) {
		this.xPosition = position;
	}

	/**
	 * Get Rover Y position
	 * @return
	 */
	public  int getYPosition() {
		return this.yPosition;
	}
	
	/**
	 * Get Rover Y position
	 * @param position
	 */
	public  void setYPosition(int position) {
		this.yPosition = position;
	}

	/**
	 * Get Rover Facing direction
	 * @return char
	 */
	public  char getFacingDirection() {
		return this.facingDirection;
	}

	/**
	 * Set Rover Facing direction
	 * @param facing
	 */
	public  void setFacingDirection(char facing) {
		this.facingDirection = facing;
	}
	
	/**
	 * Get the Plateau object
	 * @return
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * Set the Plateau object
	 * @param plateau
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	/**
	 * 
	 * @param instructionSets
	 */
	public void processMovement(String instructionSets){
		
		//Create the Processor context for this Rover object
		this.processorContext = new ProcessorContext(this);
		
		//Process Instructionsets for this Rover
		this.processorContext.processInstructionSets(instructionSets);
		
		//Check if the Rover has crossed the plateau boundaries
		processRoverBoundaries();
	}
	
	/**
	 * Check if the Rover has crossed the plateau boundaries
	 */
	private void processRoverBoundaries(){
		
		if(getXPosition() > this.plateau.getX() || getYPosition() > this.plateau.getY() || getXPosition() < 0 || getYPosition() < 0) {
			System.out.println("Rover Boundary Exceeding the plateau limit");
		}
		
	}
	

}
