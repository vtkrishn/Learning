package com.hotel.automation.target.state;
/**
 * Context for the States
 * @author vtkrishn
 *
 */
public class StateContext{
	State state;
	
	public StateContext() {
		state = null;
	}
	/**
	 * Get the state
	 * @return
	 */
	public State getState() {
		return state;
	}
	/**
	 * Set the state
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}
}
