package javaproject.tree;

public class SubTree {
    public SubTree() {
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
        TreeNode node11 = new TreeNode(5);
        TreeNode node33 = new TreeNode(6);
        node11.right = node33;
        System.out.println(subTree(node1,node33));
    }
    public static boolean subTree(TreeNode root1,TreeNode sub){
        if(root1 == null)
            return false;

        if(sub == null)
            return true;

        if(isSame(root1,sub))
            return true;

        return subTree(root1.left, sub.left) && subTree(root1.right, sub.right);
    }

    public static boolean isSame(TreeNode root1,TreeNode sub){
        if(root1 == null || sub == null)
            return false;

        if(root1 == null && sub == null)
            return true;

        return root1.value == sub.value && isSame(root1.left,sub.left) && isSame(root1.right,sub.right);
    }
}
