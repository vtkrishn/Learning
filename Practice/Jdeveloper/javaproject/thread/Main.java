package javaproject.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static int i = 0;
    public Main() {
        super();
    }
    
    public static synchronized void process(){
                if(i+1 != 10){
                    i++;
                }
                else{
                    i--;
                }
                
            System.out.println(Thread.currentThread().getName() + i);    
    }
    
    public static void main(String[] args){
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
    
    static class T1 extends Thread{
        
        public void run(){
            while(true){
               process(); 
            }
        }
    }
    
    static class T2 extends Thread{
        
        public void run(){
            while(true){
                process();
            }
        }
}
}
