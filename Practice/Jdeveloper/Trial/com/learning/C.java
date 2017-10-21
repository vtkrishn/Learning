package com.learning;

public class C {
    public C() {
        super();
    }
    
    public static void main(String[] args){
        A a = new B();
        a.test();
        ((B)a).test();
        A a1 = new A();
        a1.test();
        ((B)a1).test();
    }
}
