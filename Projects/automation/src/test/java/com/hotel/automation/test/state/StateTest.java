package com.hotel.automation.test.state;

import com.hotel.automation.target.state.OFFState;
import com.hotel.automation.target.state.ONState;
import com.hotel.automation.target.state.State;
import com.hotel.automation.target.state.StateContext;

import junit.framework.TestCase;

public class StateTest extends TestCase {
	StateContext stateContext;
	
	public void setUp() {
		stateContext = new StateContext();
	}
	
	public void testONState() {
		setUp();
		ONState onState = new ONState();
		onState.action(stateContext);
		State result = stateContext.getState();
		assertNotNull(result);
		assertEquals("ON",result.toString());
		tearDown();
	}
	
	public void testOFFState() {
		setUp();
		OFFState offState = new OFFState();
		offState.action(stateContext);
		State result = stateContext.getState();
		assertNotNull(result);
		assertEquals("OFF",result.toString());
		tearDown();
	}
	
	public void tearDown() {
		stateContext = null;
	}
}
