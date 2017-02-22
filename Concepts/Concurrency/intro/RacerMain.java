package com.concurrency;

public class RacerMain {
    public RacerMain() {
        super();
    }
    
    public static void main(String args[]){
        Racer r = new Racer();
        Thread tortoise = new Thread(r,"Tortoise");
        Thread hare = new Thread(r,"Hare");
        
        hare.start();
        tortoise.start();
        
    }
}
