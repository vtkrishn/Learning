package com.hotel.automation.test.state;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hotel.automation.component.DefaultSensor;
import com.hotel.automation.component.MotionSensor;


import junit.framework.TestCase;

public class DefaultSensorTest extends TestCase{
DefaultSensor defaultSensor;
	
	@Before
	public void setUp() {
		defaultSensor = new MotionSensor(1, "Sensor 1");
	}
	
	@Test
	public void testValidity() {
		assertNotNull(defaultSensor);
	}
	
	@Test
	public void testName() {
		setUp();
		assertNotNull(defaultSensor.getName());
		tearDown();
	}
	@After
	public void tearDown() {
		defaultSensor = null;
	}
}
