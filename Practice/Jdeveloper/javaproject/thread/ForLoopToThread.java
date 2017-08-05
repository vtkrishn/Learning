package javaproject.thread;

public class ForLoopToThread {
    public ForLoopToThread() {
        super();
    }
    
    public static void main(String[] args){
        printer p = new printer();
        p.start();
    }
    
    static class printer extends Thread{
        int i;
        public void run(){
            while(i<10)
                print();
        }
        public void print(){
            //for(int i=0;i<10;i++)
                System.out.println(i++); 
        }
    }
}
