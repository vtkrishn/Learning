package com.learning.thread.pattern.asyncSyncScheduler;

public class Client {
    public Client() {
        super();
    }
    
    public static void main(String[] msg){
        NonBlockingDispatcher nbd = new NonBlockingDispatcher();
        String s;
        nbd.dispatch(10);
        nbd.dispatch(12);
        nbd.dispatch(15);
    }
}
