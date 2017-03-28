package javaproject;

public class Depth {
    public Depth() {
        super();
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        TreeNode node = TreeNode.createTree(arr);
        System.out.println(depth(node,0));
    }

    public static int depth(TreeNode node,int depth){
        if(node == null)
            return -1;
        int left = 1+depth(node.left,depth);
        int right = 1+depth(node.right,depth);
        return Math.max(left,right);
    }
}
