package com.concurrency.lock;

public class IncrementThread extends Thread{
    final private Counter counter;
    public IncrementThread(Counter c) {
        counter = c;
        this.setName("Increment Thread");
    }
    
    public void run(){
        counter.increment();
    }
    
}
