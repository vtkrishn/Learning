package javaproject;

import java.util.Stack;

public class TreeTraversal {
    public TreeTraversal() {
        super();
    }
    
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        TreeNode node = TreeNode.createTree(arr);
        
        Stack<TreeNode> s= new Stack<TreeNode>();
        //s.push(node);
        //add all left to the stack
        //now you iterate for checking the stack
//        while(!s.isEmpty()){
//            TreeNode top = s.peek();
//            if(top.left != null){
//                s.push(top.left);
//                top.left = null;
//            }
//            else{
//                System.out.println(top.value);
//                s.pop();
//                if(top.right != null){
//                    s.push(top.right);
//                }
//            }
//        }
    
        while(true){
            
            while(node != null){
                s.push(node);
                node = node.left;
            }
            
            if(s.isEmpty())
                return;
            
            node = s.pop();
            System.out.println(node.value);
            node = node.right;
        }
    }
    
}
