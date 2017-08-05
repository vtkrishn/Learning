package javaproject;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetKthMinimumElement {
    public GetKthMinimumElement() {
        super();
    }
    
    public static void main(String[] args){
        Thread t;
        Comp c = new Comp();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(c);//Collections.reverseOrder() / naturalOrder();
        int[] arr = {4,5,2,1,0,8,9};
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        
        int temp = 0;
        for(int i=0;i<arr.length;i++){
            temp = pq.poll();
            arr[i] = temp;
        }
        
        //Natural Ordering
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
        
        int k = 2;
        //Get the kth minimum element
        for(int i=0;i<k;i++){
            pq.remove(arr[i]);
        }
        System.out.println(pq.peek());
    }
    
    static class Comp implements Comparator{

        public int compare(Object o1, Object o2) {
            if(o1 instanceof Integer && o2 instanceof Integer){
                return ((Integer)o1).compareTo((Integer)o2);
            }
            return -1;
        }
    }
}
