package javaproject.testing;

public class Consumer extends Thread{
    Buffer buf;
    public Consumer(Buffer bf) {
        this.buf = bf;
    }
    
    public void consume(){
        int x = buf.getFromBuffer();
        System.out.println("Consumed :: "+ x);
    }

    public void run() {
        if(buf.isEmpty())
            try {
                buf.wait();
            } catch (InterruptedException e) {
            }
        consume();
         //notify(); 
        }
}
