package com.hotel.automation.target;

import java.util.ArrayList;
import java.util.List;

import com.hotel.automation.control.Controller;
import com.hotel.automation.core.Corridor;
/**
 * Factory class for creating the components for the corridor
 * @author vtkrishn
 *
 */
public class ComponentFactory {
	public static List<Pluggable> createComponents(Controller controller, Corridor.Type type, int index) {
		List<Pluggable> components = new ArrayList<Pluggable>();
		Pluggable light = new Light(type, index, controller);
    	Pluggable ac = new AC(type, controller);
    	components.add(light);
    	components.add(ac);
    	return components;
	}
}
