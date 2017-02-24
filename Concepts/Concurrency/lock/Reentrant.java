package com.concurrency.lock;

public class Reentrant {
    reentrantLock lock = new reentrantLock();
    public Reentrant() {
        super();
    }
    
    public void enter(){
        lock.lock();
        System.out.println("Got the lock");
        reenter();
        lock.unLock();
        System.out.println("Released the lock");
    }
    
    public void reenter(){
        lock.lock();
        System.out.println("Got the lock from Reenter");
        lock.unLock();
        System.out.println("Released the lock from Reenter");
    }
}
