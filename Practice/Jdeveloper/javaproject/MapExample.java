package javaproject;

import java.lang.reflect.Array;


public class MapExample {
    public static void main(String[] args){
        MyMap<String,Integer> map = new MyMap<String,Integer>(10); 
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
    }
    
    static class MyMap<K,V>{
            int threshold;
            E[] bucket;
            int bucketSize;
            
            public MyMap(int size){
                    bucket = (E[])Array.newInstance(E.class, size);
                    this.threshold = size;
            }
            
            public void put(K key, V value){
                
                if(key == null){
                    if(bucket[bucketSize] == null){
                        bucket[bucketSize] = new E(bucketSize);
                    }
                    else{
                        E h = bucket[bucketSize];
                        while(h.next != null){
                            h = h.next;
                        }
                    }
                    bucket[bucketSize].data = 0;
                }
                else{
                    if(bucket[bucketSize] == null){
                        bucket[bucketSize] = new E(bucketSize);
                    }
                    
                        E h = bucket[bucketSize];
                        while(h.next != null){
                            h = h.next;
                        }
                        h = new E(value);
                    
                    bucket[bucketSize].data = hash(key); 
                }
            }
                    
            public void get(K key){
                    
            }
            
            private int hash(K key){
                    return key.hashCode() % threshold;
            }       
            
            class E<V>{
                    V data;
                    E next;
                    
                    E(V value){
                            this.data = value;
                    }
            }
    }
}
