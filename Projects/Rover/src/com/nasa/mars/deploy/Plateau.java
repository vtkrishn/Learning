package com.nasa.mars.deploy;

public class Plateau {
	
	/*
	 * Width and Height of the plateau
	 */
	private int x;
	private int y;
	
	/**
	 * Constructor accepting width and height
	 */
	public Plateau(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
	}
	
	/**
	 * Get X
	 * @return
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Set X
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Get Y
	 * @return
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Set Y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Display the plateau
	 */
	public void constructPlateau(){
		
		if(getX() < 5 && getY() < 5){
			for(int i = getX();i>=0;i--){
				
				for(int j = 0; j<=getY();j++){
					
					System.out.print(j+" "+i);
					System.out.print("\t");
				}
				
				System.out.print("\n");
			}
		}
		else{
			
			System.out.println("Plateau is large enough to display");
		}
		
	}
}
