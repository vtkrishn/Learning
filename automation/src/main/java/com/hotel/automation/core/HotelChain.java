package com.hotel.automation.core;

import java.util.ArrayList;
import java.util.List;

public class HotelChain {
	String hotelChainName;
	String ownerName;
	List<Hotel> hotels;
	
	public List<Hotel> getHotels() {
		return hotels;
	}

	public HotelChain(String name,String ownerName) {
		this.hotelChainName = name;
		this.ownerName = ownerName;
		
		hotels = new ArrayList<Hotel>();
	}
	
	public int getNoOfHotels() {
		return hotels.size();
	}
	
//	public void printHotelsOwned() {
//		for(Hotel hotel : hotels)
//			System.out.println(hotel.getName());
//	}
	
	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}
}
