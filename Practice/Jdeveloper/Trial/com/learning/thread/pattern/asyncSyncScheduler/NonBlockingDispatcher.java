package com.learning.thread.pattern.asyncSyncScheduler;

import java.util.concurrent.ExecutionException;

public class NonBlockingDispatcher {
    private WorkerQueue queue;
    public NonBlockingDispatcher() {
        queue = new WorkerQueue(this);
    }
    
    
    public void dispatch(final int n){
        //dispatch a job as a separate thread
        Runnable job = new Runnable(){
            public void run() {
                try {
                    queue.submit(n);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread t = new Thread(job);
        t.start();
    }
    
    public void onResult(Integer n){
        System.out.println("Result is printed here ::" + n);
    }
}
