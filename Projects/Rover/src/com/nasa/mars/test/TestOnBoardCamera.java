package com.nasa.mars.test;

import com.nasa.mars.deploy.OnBoardCamera;
import com.nasa.mars.exception.NasaException;

import junit.framework.TestCase;

public class TestOnBoardCamera extends TestCase {
	
	private OnBoardCamera onBoardCamera;
	
	protected void setUp() throws Exception {
		onBoardCamera = new OnBoardCamera();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetMaxWidthAndHeight(){
		
		assertNull(onBoardCamera.getMaxWidthAndHeight());
		onBoardCamera.setMaxWidthAndHeight("5 5");
		assertNotNull(onBoardCamera.getMaxWidthAndHeight());
	}
	
	public void testGetMaxX() throws NasaException{
		
		onBoardCamera.setMaxWidthAndHeight("5 5");
		assertEquals(5, onBoardCamera.getMaxX());
		
		onBoardCamera.setMaxWidthAndHeight("51234 5");
		assertEquals(51234, onBoardCamera.getMaxX());
		
		onBoardCamera.setMaxWidthAndHeight("55 55");
		assertEquals(55, onBoardCamera.getMaxX());
		
		onBoardCamera.setMaxWidthAndHeight("5 5456");
		assertEquals(5, onBoardCamera.getMaxX());
		
		onBoardCamera.setMaxWidthAndHeight("51234 54567");
		assertEquals(51234, onBoardCamera.getMaxX());
		
		onBoardCamera.setMaxWidthAndHeight("51234    54567");
		assertEquals(51234, onBoardCamera.getMaxX());
	}
	
	public void testGetMaxY() throws NasaException{
		
		onBoardCamera.setMaxWidthAndHeight("5 5");
		assertEquals(5, onBoardCamera.getMaxY());
		
		onBoardCamera.setMaxWidthAndHeight("51234 5");
		assertEquals(5, onBoardCamera.getMaxY());
		
		onBoardCamera.setMaxWidthAndHeight("55 55");
		assertEquals(55, onBoardCamera.getMaxY());
		
		onBoardCamera.setMaxWidthAndHeight("5 5456");
		assertEquals(5456, onBoardCamera.getMaxY());
		
		onBoardCamera.setMaxWidthAndHeight("51234 54567");
		assertEquals(54567, onBoardCamera.getMaxY());
	}

	public void testGetRoverAttribute(){
		
		assertNull(onBoardCamera.getRoverAttribute());
		onBoardCamera.setRoverAttribute("5 5");
		assertNotNull(onBoardCamera.getRoverAttribute());
	}
	
	public void testGetCurrentXPosition() throws NasaException{
		
		onBoardCamera.setMaxWidthAndHeight("5 5");
		onBoardCamera.setRoverAttribute("1 2 N");
		assertEquals(1, onBoardCamera.getCurrentXPosition());
		
		onBoardCamera.setMaxWidthAndHeight("51234 5");
		onBoardCamera.setRoverAttribute("51234 5 N");
		assertEquals(51234, onBoardCamera.getCurrentXPosition());
		
		onBoardCamera.setMaxWidthAndHeight("51234 5");
		onBoardCamera.setRoverAttribute("55 55 N");
		assertEquals("x is greater than the maximum height of the plateau",55, onBoardCamera.getCurrentXPosition());
		
		onBoardCamera.setMaxWidthAndHeight("5 12345");
		onBoardCamera.setRoverAttribute("55 55 N");
		assertEquals("x is greater than the maximum height of the plateau",5, onBoardCamera.getCurrentXPosition());
		
		onBoardCamera.setMaxWidthAndHeight("51234 5");
		onBoardCamera.setRoverAttribute("5 5456 N");
		assertEquals(5, onBoardCamera.getCurrentXPosition());
		
		onBoardCamera.setMaxWidthAndHeight("51234 5");
		onBoardCamera.setRoverAttribute("51234 54567 N");
		assertEquals(51234, onBoardCamera.getCurrentXPosition());
	}
	
	public void testGetCurrentYPosition() throws NasaException{
	
	onBoardCamera.setMaxWidthAndHeight("5 5");
	onBoardCamera.setRoverAttribute("1 2 N");
	assertEquals(2, onBoardCamera.getCurrentYPosition());
	
	onBoardCamera.setMaxWidthAndHeight("51234 5");
	onBoardCamera.setRoverAttribute("51234 5 N");
	assertEquals(5, onBoardCamera.getCurrentYPosition());
	
	onBoardCamera.setMaxWidthAndHeight("51234 5");
	onBoardCamera.setRoverAttribute("55 55 N");
	assertEquals("y is greater than the maximum height of the plateau",5, onBoardCamera.getCurrentYPosition());
	
	onBoardCamera.setMaxWidthAndHeight("5 12345");
	onBoardCamera.setRoverAttribute("55 55 N");
	assertEquals("y is greater than the maximum height of the plateau",5, onBoardCamera.getCurrentYPosition());
	
	onBoardCamera.setMaxWidthAndHeight("51234 5");
	onBoardCamera.setRoverAttribute("5 5456 N");
	assertEquals(5456, onBoardCamera.getCurrentYPosition());
	
	onBoardCamera.setMaxWidthAndHeight("51234 5");
	onBoardCamera.setRoverAttribute("51234 54567 N");
	assertEquals(54567, onBoardCamera.getCurrentYPosition());
}

	public void testGetCurrentFacingDirection(){
		onBoardCamera.setRoverAttribute("1 2 N");
		assertEquals('N', onBoardCamera.getCurrentFacingDirection());
		
		onBoardCamera.setRoverAttribute("1 2 N N");
		assertEquals('N', onBoardCamera.getCurrentFacingDirection());
		
		onBoardCamera.setRoverAttribute("1 2E");
		assertEquals('E', onBoardCamera.getCurrentFacingDirection());
		
		onBoardCamera.setRoverAttribute("1 2 ");
		assertEquals(' ', onBoardCamera.getCurrentFacingDirection());
	}
}
