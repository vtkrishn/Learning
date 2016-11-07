package com.vinod.concurrency;

public class Main {
    public static void main(String[] args){
        Thread t = new Thread(new MyThreadImplementsRunnable());
        MyThreadExtendsThread mt = new MyThreadExtendsThread();
        //set the name for the threads
        t.setName("RunnableThread");
        mt.setName("ExtendedThread");
        //starting the threads
        t.start();
        mt.start();
        try {
            //waits for the thread to die
            t.join();
            mt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
