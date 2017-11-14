package com.learning;

public class Test {
    public Test() {
        super();
    }
    
//    public static void print(Integer i){
//        
//    }
//    public static void print(Long i){
//        
//    }
    public static void print(A i){
        System.out.println("Object " + i);
    }
    public static void print(B i){
        System.out.println("String " + i);
    }
    public static void main(String[] args){
        //print(null);
        xx lamp = s -> System.out.println(s);
        lamp.pp("vinod");
    }
   
  interface  xx{
   public void pp(String s);
   }
}
