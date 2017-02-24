package com.concurrency.lock;

public class useLock {
    public useLock() {
        super();
    }
    
    public static void main(String args[]){
        Counter c = new Counter();
        IncrementThread incr = new IncrementThread(c);
        DecrementThread decr = new DecrementThread(c);
        incr.start();
        decr.start();
        
        //Reentrant r = new Reentrant();
        //r.enter();
        
    }
}
