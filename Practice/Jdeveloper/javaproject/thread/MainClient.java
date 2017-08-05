package javaproject.thread;

import java.util.Timer;
import java.util.concurrent.ExecutorService;

public class MainClient {
    public MainClient() {
        super();
    }
    static class T extends Thread{
        private boolean done = false;
        public void run(){
            while(!done){
                System.out.println(1);
            }
            
        }
        
        public void setDone(){
            this.done = true;
        }
    }
    public static void main(String[] args){
        T t1 = new T();
        T t2 = new T();
        t1.start();
        t2.start();
        try {
            t1.sleep(1);
            t1=null;
        } catch (InterruptedException e) {
        }
        t1.setDone();
        try {
            t2.sleep(1);
            t2 =null;
        } catch (InterruptedException e) {
        }
        t2.setDone();
    }
}
