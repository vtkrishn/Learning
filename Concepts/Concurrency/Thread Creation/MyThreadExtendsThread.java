package com.vinod.concurrency;

public class MyThreadExtendsThread extends Thread{
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName()+" Hi from extended thread");
            try {
                Thread.sleep(7000);
                //System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
