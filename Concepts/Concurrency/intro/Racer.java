package com.concurrency;

public class Racer implements Runnable{
    static String winner = null;
    public Racer() {
        super();
    }
    private void race(){
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName() +" -> "+ + i + " meters");  
            if(isRaceWon(i,Thread.currentThread().getName())){
                break;
            }
        }
    }
    private boolean isRaceWon(int i,String name){
            if(winner == null && i == 100){
                winner = name;
                System.out.println(winner + " winner");
                return true;
            }
            else if(winner == null){
                return false;
            }
            else if(winner != null){
                return true;
            }
            return false;
    }
    public void run() {
        race();
    }
}
