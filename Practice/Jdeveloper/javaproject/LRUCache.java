package javaproject;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map map = new HashMap();
    Node head;
    Node tail;
    int size;
    
    int capacity;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    class Node{
        Node previous;
        Node next;
        int value;
        
        public Node(int value){
            this.value = value;
        }
    }
    
    
    public void put(int key, int value){
        if(size == capacity){
          if(tail.previous != null)
            tail.previous.next = null;
          map.remove(tail.next.value);
          tail.next = null;
          size--;
        }
        else{
            if(!map.containsKey(key)){
                Node node = new Node(value);
                map.put(key, node);
                if(head == null){
                    head = node;
                    tail = node;
                }
                else{
                    node.next = head;
                    head.previous = node;
                    head = node;
                }
            }
            size++;
        }
        
    }
    
    public void get(int key){
        if(map.containsKey(key)){
            Node node = (Node)map.get(key);
            //delete the node
            node.previous.next = node.next;
            if(node.next != null)
                node.next.previous = node.previous;
            //add to the head
            node.previous = null;
            node.next = head;
            head.previous = node;
            head= node;
            System.out.println(head.value);
        }else{
            System.out.println("-1");
        }
    }
    
    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
    
}
