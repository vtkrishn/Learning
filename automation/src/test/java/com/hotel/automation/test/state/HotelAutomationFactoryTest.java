package com.hotel.automation.test.state;

import com.hotel.automation.main.HotelAutomationFactory;

import junit.framework.TestCase;

public class HotelAutomationFactoryTest  extends TestCase{
	HotelAutomationFactory automationfactory;
	public void setUp() {
		automationfactory = new HotelAutomationFactory();
	}
	
	public void testValidity() {
		setUp();
		assertNotNull(automationfactory);
		tearDown();
	}
	
	public void testCreateChain() {
		setUp();
		automationfactory.createChain("one", "two", "three");
		tearDown();
	}
	public void tearDown() {
		automationfactory = null;
	}
}
