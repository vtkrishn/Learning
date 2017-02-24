package com.concurrency.lock;

public class DecrementThread extends Thread{
    final private Counter counter;
    public DecrementThread(Counter c) {
        counter = c;
        this.setName("Decrement Thread");
    }
    
    public void run(){
        counter.decrement();
    }
}
