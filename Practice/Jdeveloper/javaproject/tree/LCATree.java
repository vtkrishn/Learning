package javaproject.tree;

import java.util.ArrayList;
import java.util.List;

public class LCATree {
    public LCATree() {
        super();
    }
    
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;
        
        public TreeNode(int data){
            this.value = data;
        }
    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        System.out.println(LCA(node1,1,6).value);
    }
    public static TreeNode LCA(TreeNode root,int n1,int n2){
        if(root == null)
            return null;
        
        if(root.value > n1 && root.value > n2)
            return LCA(root.left,n1,n2);
        if(root.value < n1 && root.value < n2)
            return LCA(root.right,n1,n2);
        return root;
    }
}
