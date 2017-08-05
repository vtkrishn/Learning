package javaproject;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelDepthBFSDFS {
    public LevelDepthBFSDFS() {
        super();
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        TreeNode node = TreeNode.createTree(arr);
        int h = height(node);
        System.out.println("------ Level using DFS -----");
        for(int i=0;i<=h;i++){
            printLevel(node,i);
        }
        System.out.println("------ Level using BFS -----");
        printLevel(node);
    }
    
    public static int height(TreeNode node){
        if(node == null)
            return 0;
        int left = 1+ height(node.left);
        int right = 1+ height(node.right);
        return Math.max(left, right);
    }
    
    public static void printLevel(TreeNode node){
        if(node == null)
            return;
        Queue q = new ArrayDeque();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode n = (TreeNode)q.peek();
            System.out.println(n.value);
            if(n.left != null)
                q.add(n.left);
            if(n.right != null)
                q.add(n.right);
            q.poll();
        }
    }
    public static void printLevel(TreeNode node,int level){
        if(node == null)
            return;
        
        if(level == 1)
            System.out.println(node.value);
        else if(level > 1){
            printLevel(node.left,level-1);
            printLevel(node.right,level-1);
        }
        
    }   
}
