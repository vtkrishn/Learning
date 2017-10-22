package com.nasa.mars.deploy;

import com.nasa.mars.exception.NasaException;
import com.nasa.mars.util.NavigationConstants;

public class OnBoardCamera {
	
	/*
	 * Strings holding Maximum Width and Height of the Plateau,
	 * Rover Attributes 
	 */
	 private String maxWidthAndHeight = null;
	 private String roverAttribute = null;
	
	/**
	 * Get the Maximum Height and Width of the Plateau
	 * @return
	 */
	public String getMaxWidthAndHeight() {
		return this.maxWidthAndHeight;
	}
	
	/**
	 * Set the Maximum Height and Width of the Plateau
	 * @param maxWidthAndHeight
	 */
	public void setMaxWidthAndHeight(String maxWidthAndHeight) {
		this.maxWidthAndHeight = maxWidthAndHeight;
	}

	/**
	 * Get the Rover Attribute
	 * @return
	 */
	public String getRoverAttribute() {
		return this.roverAttribute;
	}
	
	/**
	 * Set the Rover Attribute
	 * @param roverAttribute
	 */
	public void setRoverAttribute(String roverAttribute) {
		this.roverAttribute = roverAttribute;
	}

	/**
	 * Get the X coordinate from the user Input
	 * User Format corresponds to 'X Y'
	 * @return
	 * @throws NasaException 
	 */
	public int getMaxX() throws NasaException{
		
		int x = 0;
		
		try{
			x = Integer.valueOf(this.maxWidthAndHeight.substring(0,getMidValue())).intValue();
		}
		catch(NumberFormatException e){
			
			throw new NasaException("Please check the Format");
		}
		//return the substring from the 0 to the mid value
		return x;
	}
	
	/**
	 * Get the Y coordinate from the user Input
	 * User Format corresponds to 'X Y'
	 * @return
	 * @throws NasaException 
	 */
	public int getMaxY() throws NasaException{
		int y = 0;
		
		try{ 
			y = Integer.valueOf(this.maxWidthAndHeight.substring(getMidValue()+1, this.maxWidthAndHeight.length())).intValue();
		}
		catch(NumberFormatException e){
			
			throw new NasaException("Please check the Format");
		}
		//return the substring from the mid value + 1 to the length of the string
		return y;
	}
	
	/**
	 * Get the mid value of the user Input
	 * @return
	 */
	private int getMidValue(){
		
		//return the mid value of the user Input
		return this.maxWidthAndHeight.indexOf(NavigationConstants.SPACE);
	}
	
	/**
	 * Get the Current deployed X position of the Rover
	 * @return
	 * @throws NasaException
	 */
	public int getCurrentXPosition() throws NasaException{
		
		int x = 0;
		
		//Evaluate the substring from the 0 to the index of ' '
		try{
			x = Integer.valueOf(this.roverAttribute.substring(0,getIndexOfSpace())).intValue();
		}
		catch(NumberFormatException e){
			
			throw new NasaException("Please check the Format");
		}
		
		//Is current x position greater than plateau's width
		if(x>getMaxX())
			throw new NasaException("x is greater than the maximum width of the plateau");

		return x;
	}
	
	/**
	 * Get the Current deployed Y position of the Rover
	 * @return
	 * @throws NasaException
	 */
	public int getCurrentYPosition() throws NasaException{
		
		int y = 0;
		
		//Evaluate the substring from the index of ' ' + 1 to the previous index of Facing direction 
		try{
			y = Integer.valueOf(this.roverAttribute.substring(getIndexOfSpace() + 1, this.roverAttribute.indexOf(getCurrentFacingDirection())-1)).intValue();
		}
		catch(NumberFormatException e){
			throw new NasaException("Please check the Format");
		}
		
		//Is current y position greater than plateau's height
		if(y>getMaxY())
			throw new NasaException("y is greater than the maximum height of the plateau");
		
		return y;
	}
	
	/**
	 * Get the index space of ' '
	 * @return
	 */
	private int getIndexOfSpace(){
		
		//return the index of ' ' in user Input
		return this.roverAttribute.indexOf(NavigationConstants.SPACE);
	}
	
	/**
	 * Get the Current Facing direction of the Rover
	 * @return
	 */
	public char getCurrentFacingDirection(){
		
		//return the facing direction
		return this.roverAttribute.charAt(this.roverAttribute.length()-1);
	}
	
	
	
}
