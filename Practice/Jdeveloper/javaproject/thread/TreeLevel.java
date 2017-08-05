package javaproject.thread;

import javaproject.TreeNode;

public class TreeLevel {
    public TreeLevel() {
        super();
    }
    public static void main(String[] args){
        TreeNode t = new TreeNode();
        int[] a = {1,2,3,4,5};
        TreeNode root = t.createTree(a);
        print(root);
    }
    
    public static int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.getLeft()) + 1;
        int right = height(root.getRight()) + 1;
        
        return Math.max(left,right);
    }
    public static void print(TreeNode root){
        int h= height(root);
        printHelper(root,h,0);
        printHelper(root,h,h);
    }
    
    public static void printHelper(TreeNode root,int h, int level){
        if(root == null){
            return;
        }
        
        System.out.println(root.getValue());
        if(level < h){
            printHelper(root.getLeft(), h, level+1);
            //printHelper(root.getRight(), h, level+1);
        }
        else{
            printHelper(root.getRight(), h, level-1);
            //printHelper(root.getLeft(), h, level-1);
        }
    }
}
