package com.learning.thread.pattern.asyncSyncScheduler;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialComputation {
    
    public static void main(String[] args){
        //this will create a task scheduler, allows only one single task/thread to execute
        ExecutorService ex = Executors.newSingleThreadExecutor();
        //Create three task, the output of the each of the tasks will be stored in Future object
        Future f1 = ex.submit(new Factorial(10));
        Future f2 = ex.submit(new Factorial(12));
        Future f3 = ex.submit(new Factorial(15));
        
        try {
            //blocking and will be printed only when the f1 is computed with result
            System.out.println("Factorial of 10 : " + f1.get());
            //blocking and will be printed only when the f2 is computed with result
            System.out.println("Factorial of 12 : " + f2.get());
            //blocking and will be printed only when the f3 is computed with result
            System.out.println("Factorial of 15 : " + f3.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //shutdown the scheduler
        ex.shutdownNow();
    }
}
