package javaproject.list;

import java.util.Random;

public class SkipList {
    
    private SkipNode head;
    private SkipNode tail;
    private int size;
    private int height;
    private Random x;
    
    public SkipList() {
       head = new SkipNode(Integer.MIN_VALUE);
       tail = new SkipNode(Integer.MAX_VALUE);
       head.right = tail;
       tail.left = head;
       size = 0;
       height = 0;
       x = new Random();
    }
    
    public void search(int key){
        SkipNode node = head;
        while(true){
            if(node.right.data < key)
                node = node.right;
            
            if(node.down != null)
                node = node.down;
            else
                break;
        }
    }
    
    static class SkipNode{
        SkipNode right;
        SkipNode left;
        SkipNode up;
        SkipNode down;
        
        int data;
        
        public SkipNode(int val){
            this.data = val;
        }
    }
    
    public static void main(String[] args){
        
    }
}
