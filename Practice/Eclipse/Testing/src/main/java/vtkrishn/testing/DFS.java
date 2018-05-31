package vtkrishn.testing;

import java.util.*;

public class DFS {
    static class TreeNode{
      TreeNode left;
      TreeNode right;
      int val;
      
      public TreeNode(int data){
        this.val = data; 
      }
    }
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      TreeNode left = new TreeNode(2);
      TreeNode right = new TreeNode(3);
      TreeNode leftleft = new TreeNode(4);
      TreeNode leftright = new TreeNode(5);
      TreeNode rightleft = new TreeNode(6);
      TreeNode rightright = new TreeNode(7);
      root.left = left;
      root.right = right;
      left.left = leftleft;
      left.right = leftright;
      right.left = rightleft;
      right.right = rightright;
      
//      Stack<TreeNode> stack = new Stack<TreeNode>();
//      TreeNode node = root;
//      while(node != null) {
//      	stack.push(node);
//      	node = node.left;
//      }
//      
//      while(stack.size() > 0 ){
//        node = stack.pop();
//        System.out.println(node.val);
//        if(node.right != null) {
//        	node = node.right;
//        
//        
//        while(node != null) {
//        	stack.push(node);
//        	node = node.left;
//        }
//        }
//      }
      
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      while(!queue.isEmpty()) {
    		int size = queue.size();
      TreeNode node = queue.poll();
      System.out.println(node.val);
    		for(int i=0;i<size;i++){
    			if(node.left != null)
    				queue.offer(node.left);
    			if(node.right != null)
    				queue.offer(node.right);	
    		}
    	}
    		
    }
}
