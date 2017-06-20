package javaproject;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution77 {
    public Solution77() {
        super();
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int data){
            this.value = data;
        }

    }

    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        printSpiral(n1);
    }

    public static void printSpiral(Node root){
        if(root == null)
            return;
        LinkedList q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = (Node)q.removeFirst();
            if(temp != null){
                System.out.println(temp.value);
                q.addLast(temp.left);
                q.addLast(temp.right);
            }
        }
    }
}
