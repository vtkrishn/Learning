package com.hotel.automation.target;

import com.hotel.automation.control.Controller;
import com.hotel.automation.core.Corridor;
import com.hotel.automation.util.AutomationConstants;
/**
 * AC component
 * @author vtkrishn
 *
 */
public class AC extends Component{
	public AC(Corridor.Type type, Controller controller) {
		super(type,AutomationConstants.AC_POWER_UNIT,controller);
		this.name = AutomationConstants.AC;
	}
}
