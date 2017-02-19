package javaproject;

import java.util.Stack;

public class TreeTraversal {
    public TreeTraversal() {
        super();
    }

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(8);
        right.left = rightLeft;
        right.right = rightRight;


        Stack<TreeNode> s= new Stack<TreeNode>();
        s.push(node);
        //add all left to the stack
        //now you iterate for checking the stack
        while(!s.isEmpty()){
            TreeNode top = s.peek();
            if(top.left != null){
                s.push(top.left);
                top.left = null;
            }
            else{
                System.out.println(top.value);
                s.pop();
                if(top.right != null){
                    s.push(top.right);
                }
            }
        }
    }

}
