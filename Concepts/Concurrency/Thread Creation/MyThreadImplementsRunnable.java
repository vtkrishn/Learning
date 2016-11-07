package com.vinod.concurrency;

public class MyThreadImplementsRunnable implements Runnable{

    public void run() {
        while(true){
         System.out.println(Thread.currentThread().getName()+ " Hi");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
