package javaproject.tree;

public class PrintAncestor {
    public PrintAncestor() {
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
        printAncestor(node1,6);
    }
    public static boolean printAncestor(TreeNode root,int n){
        if(root == null)
            return false;
        
        if(root.value == n)
            return true;
        
        if(printAncestor(root.left, n) || printAncestor(root.right, n)){
            System.out.println(root.value);
            return true;
        }
        return false;
    }
}
