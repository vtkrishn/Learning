package com.hotel.automation.core;

import java.util.ArrayList;
import java.util.List;

import com.hotel.automation.control.Controller;
/**
 * Hotel object
 * @author vtkrishn
 *
 */
public class Hotel {
	
	int hotelId;
	String name;
	final int noOfRoomsPerFloor = 10;
	int noOfRooms;
	Controller controller;
	List<Floor> floors;
	/*
	 * get the controller responsible in the hotel
	 */
	public Controller getController() {
		return controller;
	}
	
	public Hotel(int id, String name) {
		this.hotelId = id;
		this.name = name;
		this.floors = new ArrayList<Floor>();
	}
	
	/*
	 * add controller to the hotel
	 */
	public void addController(Controller controller) {
		this.controller = controller;
	}
	
//	public String getName() {
//		return name;
//	}
//	
	private int getNoOfFloors() {
		return floors.size();
	}
	
//	public int getNoOfRooms() {
//		return noOfRooms;
//	}
	
	public void addFloors(List<Floor> floors) {
		this.floors = floors;
		this.noOfRooms = getNoOfFloors() * this.noOfRoomsPerFloor;
	}
	
}
