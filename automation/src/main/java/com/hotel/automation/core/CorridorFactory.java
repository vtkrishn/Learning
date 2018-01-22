package com.hotel.automation.core;

/**
 * Create the corridor using this factory class
 * @author vtkrishn
 *
 */
public class CorridorFactory {
	
	/**
	 * Create the corridor by passing the type
	 * @param index
	 * @param type
	 * @return
	 */
	public static Corridor createCorridor(int index, Corridor.Type type){
		Corridor corridor = null;
		if(type.equals(Corridor.Type.MAIN))
			corridor =  new MainCorridor(index, type);
		else if(type.equals(Corridor.Type.SUB))
			corridor =  new SubCorridor(index, type);
		return corridor;
	}
}
