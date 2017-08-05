package openTable;

import java.time.Duration;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Booking rules:
// 1) Reservation could be made only when the Restaurant is open.
// 2) Only one Reservation can be seatted a Table at any time.
// 3) Reservation can be seatted only at a Table of the same or a bigger size.
// 4) Reservation should stay on the same Table for the whole Duration.
// 5) Reservation Duration is determined by PartySize.
public class Restraunt {
    public Restraunt() {
        super();
    }
    
    public List<Table> tables;
    public LocalTime openTime;
    public LocalTime closeTime;
    public Set<Integer> tableBooking;
        
    public Map<Integer,Duration> reservationDurationsPerPartySize;
    
    public Restraunt(LocalTime openTime, LocalTime closeTime,int maxOccupancy){
        this.openTime = openTime;
        this.closeTime = closeTime;
        //create the table list
        createTables(maxOccupancy);
    }
    
    private void createTables(int maxOccupancy){
        //int threshold = (int)(Math.random() * 6);
        //int maxTables = maxOccupancy / threshold;
        int tableNumber=1000;
        int tablesize = 0;
        int i=0;
        tables = new ArrayList<Table>();
        //while(i<maxTables){
        while(i<3){
             //tableNumber = (int)(Math.random() * maxTables);
             tableNumber++;
             tablesize = (int)(Math.random() * 6);
            if(tablesize > 2){
                tables.add(new Table(tableNumber,tablesize));
                i++;
            }
        }
        //all tables ready for booking
        tableBooking = new HashSet<Integer>();
        //
        reservationDurationsPerPartySize = new HashMap<Integer,Duration>();
    }
    public Table bookReservation(Reservation reservation){
        
        // 1) Reservation could be made only when the Restaurant is open.
        if(reservation.startTime.isBefore(openTime) || reservation.startTime.isAfter(closeTime)){
                System.out.println("Reservation cannot be booked at this time");
                return null;
        }
        
        // 2) Only one Reservation can be seatted a Table at any time.
        Iterator<Table> itr = tables.iterator();
        while(itr.hasNext()){
            Table table = itr.next();
            if(!tableBooking.contains(table.tableNumber)){
                //3) Reservation can be seatted only at a Table of the same or a bigger size.
                if(reservation.partySize <= table.maxPartySize){
                    tableBooking.add(table.tableNumber);
                    
                    // 5) Reservation Duration is determined by PartySize.
                    reservationDurationsPerPartySize.put(table.tableNumber, Duration.between(reservation.startTime, reservation.startTime.plusHours(reservation.partySize/2)));
                    return table;
                }
                else{
                    System.out.println("Reservation party size is more");
                    return null;
                }
            }
            else{
                if(tableBooking.size() == tables.size()){
                    System.out.println("Reservation full at this time");
                    return null;
                }
            }
        }
        
        return null;
    }
}
