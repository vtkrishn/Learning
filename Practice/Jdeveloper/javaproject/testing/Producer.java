package javaproject.testing;

public class Producer extends Thread{
    Buffer buf;
    public Producer(Buffer bf){
        this.buf = bf;
    }
    
    public void produce(){
        int x = (int)(Math.random() * 100)+1;
        System.out.println("Produced :: "+ x);
        buf.addToBuffer(x);
    }

    public void run() {
//        if(buf.isFull())
//            try {
//                wait();
//            } catch (InterruptedException e) {
//            }
        produce();
        //notify();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
