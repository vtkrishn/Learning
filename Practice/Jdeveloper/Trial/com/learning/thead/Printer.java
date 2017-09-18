package com.learning.thead;

public class Printer extends Thread{
        
        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("My name is " + Thread.currentThread().getName());
            }
        }
    }
