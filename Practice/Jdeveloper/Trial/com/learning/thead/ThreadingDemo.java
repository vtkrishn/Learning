package com.learning.thead;

public class ThreadingDemo {
    public ThreadingDemo() {
        super();
    }
    
    public static void main(String[] args){
        for(int i=0;i<2;i++){
            Printer p = new Printer();
            p.setName("T"+i);
            p.start();    
        }
    }
}
