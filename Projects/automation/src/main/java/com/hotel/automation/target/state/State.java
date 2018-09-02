package com.hotel.automation.target.state;
/**
 * State of the components
 * @author vtkrishn
 *
 */
public interface State {
	public String ON = "ON";
	public String OFF = "OFF";
	public void action(StateContext context);
}
