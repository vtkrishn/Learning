package com.hotel.automation.target;

import com.hotel.automation.control.Controller;
import com.hotel.automation.core.Corridor;
import com.hotel.automation.util.AutomationConstants;
/**
 * Light as a component
 * @author vtkrishn
 *
 */
public class Light extends Component{
	public Light(Corridor.Type type, int index,Controller controller) {
		super(type,AutomationConstants.LIGHT_POWER_UNIT,controller);
		this.name = AutomationConstants.LIGHT + AutomationConstants.SPACE + index;
	}	
}
