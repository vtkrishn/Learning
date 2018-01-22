package com.hotel.automation.target;

import com.hotel.automation.control.Controller;
import com.hotel.automation.core.Corridor;
import com.hotel.automation.target.state.State;
import com.hotel.automation.target.state.StateContext;
import com.hotel.automation.util.AutomationConstants;
import com.hotel.automation.util.AutomationUtil;
/**
 * Abstract component class
 * @author vtkrishn
 *
 */
public abstract class Component extends StateContext implements Pluggable{
	State defaultState;
	State previousState;
	State currentState;
	int powerUnit;
	StateContext context;
	String name;
	//List<ComponentObserver> observer;
	
	public Component(Corridor.Type type, int powerUnit,Controller controller) {
		this.powerUnit = powerUnit;
		this.context = new StateContext();
		//this.observer = new ArrayList<ComponentObserver>();
		
		//registerObserver(controller);
		
		setDefaultState(type);
	}
	
	private void setDefaultState(Corridor.Type type) {
		if(type == Corridor.Type.MAIN) {
			if(powerUnit == AutomationConstants.LIGHT_POWER_UNIT) {
					if(AutomationUtil.isValid()) {
						setState(AutomationUtil.getONState());
					}
					else {
						setState(AutomationUtil.getOFFState());
					}
			}
			else {
				setState(AutomationUtil.getONState());
			}
		}
		else {
			if(powerUnit == AutomationConstants.LIGHT_POWER_UNIT) 
				setState(AutomationUtil.getOFFState());
			else
				setState(AutomationUtil.getONState());
		}
	}
	
	public void changeState(State state) {
		this.previousState = this.currentState;
		this.currentState = state;
		
		//notifyObservers(state);
	}

	public State getCurrentState() {
		return currentState;
	}
	
	public int getPowerUnit(){
		return this.powerUnit;
	}
	public StateContext getContext() {
		return context;
	}
	
	public void resetToDefault() {
		this.defaultState = context.getState();
		this.previousState = this.currentState;
		this.currentState = this.defaultState;
	}
	public String getName() {
		return name;
	}
	public void setPreviousState() {
		State temp = this.previousState;
		this.previousState = this.currentState;
		this.currentState = temp;
	}
	
	public void setState(State state) {
		state.action(context);
		this.defaultState = context.getState();
	}
	
//	public void registerObserver(ComponentObserver o) {
//        observer.add(o);
//    }
 
//    public void unregisterObserver(ComponentObserver o) {
//    	observer.remove(observer.indexOf(o));
//    }
 
//    public void notifyObservers(State state)
//    {
//        for (Iterator<ComponentObserver> it =
//        		observer.iterator(); it.hasNext();)
//        {
//        	ComponentObserver o = it.next();
//            o.update(state);
//        }
//    }
	
}
