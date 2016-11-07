
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyThreadImplementsRunnable());
        MyThreadExtendsThread mt = new MyThreadExtendsThread();
        //set the name for the threads
        t.setName("RunnableThread");
        mt.setName("ExtendedThread");
        //starting the threads
        t.start();
        mt.start();
        while(true){
            System.out.println(t.getState());
            System.out.println(mt.getState());
            t.interrupt();
            mt.interrupt();
        }
    }
}

-------------------
package com.vinod.concurrency;

public class MyThreadImplementsRunnable implements Runnable{

    public void run() {
        while(true){
         System.out.println(Thread.currentThread().getId() + " -- " + Thread.currentThread().getName()+ " Hi");
           // try {
                //Thread.sleep(5000);
                if(Thread.currentThread().isInterrupted())
                    return;
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }
    }
}


--------------------
package com.vinod.concurrency;

public class MyThreadExtendsThread extends Thread{
    public void run(){
        while(true){
            System.out.println(this.getId() + " -- " + Thread.currentThread().getName()+" Hi from extended thread");
            if(isInterrupted())
                return;
//                        try {
//                //Thread.sleep(7000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
