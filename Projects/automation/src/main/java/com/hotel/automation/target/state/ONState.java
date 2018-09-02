package com.hotel.automation.target.state;
/**
 * ON state
 * @author vtkrishn
 *
 */
public class ONState implements State{
	/*
	 * Set the action for the context
	 * @see com.hotel.automation.target.state.State#action(com.hotel.automation.target.state.StateContext)
	 */
	public void action(StateContext context) {
		context.setState(this);
	}
	
	public String toString(){
		return ON;
	}
}
