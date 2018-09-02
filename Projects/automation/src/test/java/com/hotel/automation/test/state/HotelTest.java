package com.hotel.automation.test.state;

import com.hotel.automation.control.PowerController;
import com.hotel.automation.core.Hotel;

import junit.framework.TestCase;

public class HotelTest extends TestCase {
	Hotel hotel;
	
	public void setUp() {
		hotel = new Hotel(1, "Test Hotel");
	}
	
	public void testValidity() {
		setUp();
		assertNotNull(hotel);
		tearDown();
	}
	
	public void testAddController() {
		setUp();
		hotel.addController(new PowerController(1,1,1));
		assertNotNull(hotel.getController());
		tearDown();
	}
	public void tearDown() {
		hotel = null;
	}
}
