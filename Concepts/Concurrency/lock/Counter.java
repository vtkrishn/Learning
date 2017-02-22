package com.concurrency.lock;

public class Counter {
    private int count;
    private myLock lock = new myLock();
    public Counter() {
        count = 0;
    }
    
    public int increment(){
        lock.lock();
        System.out.println("Got the lock ::" + Thread.currentThread().getName());
            int newCount = ++count;
        lock.unLock();
        System.out.println("Lock Released ::" + Thread.currentThread().getName());
        return newCount;
    }
    
    public int decrement(){
        lock.lock();
        System.out.println("Got the lock ::" + Thread.currentThread().getName());
           int newCount = --count;
        lock.unLock();
        System.out.println("Lock Released ::" + Thread.currentThread().getName());
        return newCount;
    }
    
    public int getCount(){
        return count;
    }
    
}
