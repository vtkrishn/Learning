package com.hotel.automation.target.state;
/**
 * OFF state
 * @author vtkrishn
 *
 */
public class OFFState implements State{
	/*
	 * Set the off state for the context
	 * @see com.hotel.automation.target.state.State#action(com.hotel.automation.target.state.StateContext)
	 */
	public void action(StateContext context) {
		context.setState(this);
	}
	
	public String toString(){
		return OFF;
	}

}
