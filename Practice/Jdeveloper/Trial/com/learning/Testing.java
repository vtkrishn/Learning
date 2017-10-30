package com.learning;

public class Testing extends A{ 
    {
        System.out.println("inside Testing");
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }
    
    public Testing() {
        super();
    }
    
    public void m(){
        test();
    }
    public static void main(String[] args){
        int j =2;
        float one=j;
        System.out.println(one);
        int i = (int)one;
        System.out.println(i);
        
        class Local{
            {
                System.out.println("inside local");
                for(int i=0;i<10;i++){
                    System.out.println(i);
                }
            }
        }
        new Testing();
        new Local();
    }
}
