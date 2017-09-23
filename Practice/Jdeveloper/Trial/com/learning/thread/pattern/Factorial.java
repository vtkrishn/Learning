package com.learning.thread.pattern;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    private int number;
    
    public Factorial(int number) {
        this.number = number;
    }
    
    //compute factorial of a number
    private int factorial(int n) throws InterruptedException {
        if(n < 2)
            return 1;
        Thread.sleep(100);
        return n * factorial(n-1);
    }

    //asynchronous call function to compute factorial and the result will be stored in respective future object
    public Integer call() throws InterruptedException {
        return factorial(this.number);
    }
}
