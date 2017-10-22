package com.nasa.mars.test;

import com.nasa.mars.deploy.Plateau;

import junit.framework.TestCase;

public class TestPlateau extends TestCase {

	private Plateau plateau;
	
	protected void setUp() throws Exception {
		plateau = new Plateau(1,2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetX() {
	assertNotNull(plateau.getX());
	}

	public void testGetY() {
		assertNotNull(plateau.getY());
	}

}
