package com;

import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Example<T> {
    public Example() {
        super();
        Stack<T> stack = new Stack<T>();
        stack.push((T)"one");
        while(!stack.isEmpty()){
            T s = stack.pop();
            System.out.println(s);
        }
    }
    
    public static void main(String[] args){
        Example<String> e = new Example<String>();
        Stack s;
    }
}
