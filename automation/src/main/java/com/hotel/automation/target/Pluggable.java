package com.hotel.automation.target;

import com.hotel.automation.target.state.State;
import com.hotel.automation.target.state.StateContext;
/**
 * Anything which is pluggable will implement this class
 * @author vtkrishn
 *
 */
public interface Pluggable{
	
	public void changeState(State state);
	public State getCurrentState();
	public void setPreviousState();
	public int getPowerUnit();
	public StateContext getContext();
	public void resetToDefault();
	public String getName();
}
