package com.hotel.automation.main;

import java.util.ArrayList;
import java.util.List;

import com.hotel.automation.component.Sensor;
import com.hotel.automation.component.SensorFactory;
import com.hotel.automation.control.Controller;
import com.hotel.automation.core.Corridor;
import com.hotel.automation.core.CorridorFactory;
import com.hotel.automation.core.Floor;
import com.hotel.automation.core.Hotel;
import com.hotel.automation.core.HotelChain;
import com.hotel.automation.target.ComponentFactory;
import com.hotel.automation.target.Pluggable;
import com.hotel.automation.util.AutomationConstants;


public class HotelAutomationFactory {
	HotelChain hotelChain;
	Hotel activeHotel;
	
	public Controller getController() {
		return this.activeHotel.getController();
	}
	
	private Hotel createHotel(int hotelId, String hotelName) {
		Hotel hotel = new Hotel(hotelId, hotelName);
    	return hotel;
	}

	public void createChain(String name, String owner, String hotelName) {
		if(this.hotelChain == null)
			this.hotelChain = new HotelChain(name, owner);
		Hotel hotel = createHotel(hotelChain.getNoOfHotels() + 1, hotelName);
		this.hotelChain.addHotel(hotel);
		if(this.hotelChain.getNoOfHotels() == 1)
			setActiveHotel(1);
	}
	
	public HotelChain getChain() {
		return this.hotelChain;
	}
	
	public Hotel getActiveHotel() {
		return this.activeHotel;
	}
	
	public void setActiveHotel(int hotelId) {
		if(getChain().getHotels().size() >= 1)
			activeHotel = getChain().getHotels().get(hotelId-1);
		if(activeHotel == null) {
			//log hotel not found error
		}
	}
	
	private Corridor createCorridor(Controller controller, int index, Corridor.Type type,int floorNo) {
		Corridor corridor =  CorridorFactory.createCorridor(index, type);
    	Sensor sensor = SensorFactory.createSensor(AutomationConstants.MOTION,floorNo , corridor.getName(), index); 
    	List<Pluggable> components = ComponentFactory.createComponents(controller, type, index);
    	
    	for(Pluggable item : components) {
    		sensor.registerComponent(item);
    	}
    	
    	controller.addSensor(sensor);
		return corridor;
	}
		
	public void createFloors() {
		Hotel hotel =getActiveHotel();
		Controller controller = getController();
		List<Floor> floors = new ArrayList<Floor>();
		hotel.addFloors(floors);
		
		//Create floor and add it to the hotel
    	for(int index = 1;index<=controller.getNoOfFloors();index++) {
    		Floor floor = new Floor(index);
    		floors.add(floor);
    		
    		//add sensors to the main corridors
    		for(int mainIndex = 1;mainIndex<=controller.getNoOfMainCorridor();mainIndex++) {
    			Corridor maincorridor = createCorridor(controller, mainIndex, Corridor.Type.MAIN, index);
    			floor.addCorridor(maincorridor);
    		}
    		//add sensors to the sub corridors
    		for(int subIndex = 1;subIndex<=controller.getNoOfSubCorridor();subIndex++) {
    			Corridor subcorridor = createCorridor(controller, subIndex, Corridor.Type.SUB, index);
    			floor.addCorridor(subcorridor);
    		}
    		
    	}
    	
	}
	
}
