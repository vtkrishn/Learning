package javaproject.testing;

import java.util.ArrayDeque;
import java.util.Deque;

public class Buffer {
    Deque<Integer> array;
    public Buffer() {
        super();
        array = new ArrayDeque<Integer>();
    }
    
    public void addToBuffer(int value){
        array.push(value);
    }
    
    public int getFromBuffer(){
        return array.pop().intValue();
    }
    
    public boolean isEmpty(){
        return array.size() == 0;
    }
    
    public boolean isFull(){
        return array.size() == 5;
    }
}
