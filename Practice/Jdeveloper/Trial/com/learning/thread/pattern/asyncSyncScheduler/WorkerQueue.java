package com.learning.thread.pattern.asyncSyncScheduler;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class WorkerQueue {
    //BlockingQueue queue = new ArrayBlockingQueue(100);
    NonBlockingDispatcher dispatcher;
    public WorkerQueue(NonBlockingDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
    
    public void submit(final int n) throws InterruptedException, ExecutionException {
       
        Runnable submission = new Runnable(){

                    public void run() {
                        //if queue is empty wait for the tasks
                        //while(queue.isEmpty())
                        //    ;    //awaiting tasks
                        
                        //create task schedulers
                        ExecutorService executorService = Executors.newSingleThreadExecutor();
                        
                        try{
                            
                            while(true){
                                //if(queue.isEmpty())
                                //    break;
                                Future future = executorService.submit(new Factorial(n));
//                                while(!future.isDone()){
//                                    ; // wait till the job completes
                                
                                //publish the result
                                dispatcher.onResult((Integer)future.get());
                            }
                        }
                        catch(InterruptedException  | ExecutionException e){
                            e.printStackTrace();
                        }
                        finally{
                            executorService.shutdown();
                        }
                    }
                };
        
        //create a thread in the constructor
        Thread t = new Thread(submission);
        t.start();
    }
}
