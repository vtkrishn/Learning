package javaproject.tree;

public class PrintKNode {
    public PrintKNode() {
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
        printKNode(node1,1);
    }
    public static void printKNode(TreeNode root,int k){
        if(root == null)
            return;

        if(k == 0)
            System.out.println(root.value);

        printKNode(root.left, k-1);
        printKNode(root.right, k-1);

    }
}
