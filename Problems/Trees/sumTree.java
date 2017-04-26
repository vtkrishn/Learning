package javaproject.tree;

public class SumTree {
    public SumTree() {
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
        System.out.println(sumTree(node1));
    }
    public static int sumTree(TreeNode root){
        if(root == null)
            return 0;

        int oldData = root.value;
        root.value = sumTree(root.left) + sumTree(root.right);
        return root.value + oldData;
    }
}
