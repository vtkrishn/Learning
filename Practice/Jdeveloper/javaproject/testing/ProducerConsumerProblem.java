package javaproject.testing;

public class ProducerConsumerProblem {
    public static void main(String[] args){
        Buffer bf = new Buffer();
        Producer p = new Producer(bf);
        Consumer c = new Consumer(bf);
        c.start();
        p.start();
    }
}
