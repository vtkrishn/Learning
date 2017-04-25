package javaproject.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToPath {
    public PrintRootToPath() {
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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        List l = new ArrayList();
        printRootToLeaf(node1,l);
    }

    public static void printRootToLeaf(TreeNode root,List l){
        if(root == null)
            return;
        l.add(root.value);

        if(root.left == null && root.right == null)
            System.out.println(l);
        else{
            printRootToLeaf(root.left, l);
            printRootToLeaf(root.right, l);
        }
    }
}
fs
