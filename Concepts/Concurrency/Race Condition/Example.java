package com.vinod.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger value = new AtomicInteger();
    //volatile int value;
    public Counter() {
        super();
    }

    synchronized void add(){
        value.incrementAndGet();
        //value++;
        System.out.println(value);
    }

}

---------------------------
package com.vinod.concurrency;

public class Thread1 extends Thread {
    Counter counter;
    public Thread1(Counter c) {
        this.counter = c;
    }

    public void run() {
        while(true){
            counter.increment();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

-----------------------
package com.vinod.concurrency;

public class Thread2 extends Thread {
    Counter counter;
    public Thread2(Counter c) {
        this.counter = c;
    }

    public void run(){
        while(true){
            counter.decrement();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
