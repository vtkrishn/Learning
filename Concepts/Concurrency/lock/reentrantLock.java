package com.concurrency.lock;

public class reentrantLock {
    private boolean isLocked = false;
    Thread lockedBy = null;
    int lockCount = 0;
    
    public reentrantLock() {
        super();
    }
    
    public synchronized void lock(){
        Thread callingThread = Thread.currentThread();
        while(isLocked && lockedBy != callingThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockCount++;
        lockedBy = callingThread;
    }
    
    public synchronized void unLock(){
        if(Thread.currentThread() == lockedBy){
            lockCount--;
        }
        
        if(lockCount==0){
            isLocked = false;
            notify();
        }
        
    }
}
