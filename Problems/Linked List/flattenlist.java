package javaproject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Solution7{
    static class Node{
            Node left;
            Node right;
            Node up;
            Node down;
            int value;

            public Node(int val){
                    this.value = val;
            }
    }
	public static void main(String[] args){
		//create node
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);

		//link it
		one.right = two;

		two.right = three;
		two.left = one;
		two.down = five;

		three.right = four;
		three.left = two;

		four.left = three;
		four.down = seven;

		five.up = two;
		five.right = six;
		five.down = eight;

		six.right = seven;
		six.left = five;

		seven.left = six;
		seven.down = nine;

		eight.up = five;

		nine.up = seven;

		flattenList(one);
	}

	public static void flattenList(Node node){
		Node dummy = node;
		LinkedList<Node> queue = new LinkedList<Node>();
                Set<Integer> s = new HashSet<Integer>();
                while(dummy != null){
			queue.addLast(dummy);
			dummy =dummy.right;
		}

		while(!queue.isEmpty()){
			Node temp = queue.removeFirst();
                        s.add(temp.value);
			if(temp.down != null){
                                dummy = temp.down;
                                while(dummy != null){
					queue.addLast(dummy);
					dummy =dummy.right;
				}
			}
		}

                Iterator<Integer> itr = s.iterator();
                while(itr.hasNext()){
                 System.out.println(itr.next());
                }
	}
}
