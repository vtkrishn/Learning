package com.concurrency.lock;

public class myLock {
    
    private boolean isLocked = false;
    public myLock() {
        super();
    }
    
    public synchronized void lock(){
        while(isLocked){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }
    
    
    public synchronized void unLock(){
        isLocked = false;
        notify();
    }
}
