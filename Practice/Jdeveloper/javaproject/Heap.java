package javaproject;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    public Heap() {
        super();
    }
    
    public static void main(String[] args){
        int[] arr = {7,2,13,54,15,96,37,88};
        PriorityQueue p = new PriorityQueue(20,Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            p.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(p.remove());
        }
        
    }
}
