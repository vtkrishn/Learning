package openTable;

import java.time.LocalTime;

public class Reservation {
    public String name;
    public int partySize;
    public  LocalTime startTime;
    
    public Reservation(String name, int partySize, LocalTime  startTime){
        this.name = name;
        this.partySize = partySize;
        this.startTime = startTime;
    }
}
