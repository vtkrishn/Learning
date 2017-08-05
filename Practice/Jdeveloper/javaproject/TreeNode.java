package javaproject;

public class TreeNode {
    
    TreeNode left;
    TreeNode right;
    int value;
    
    public TreeNode(){
        
    }
    public TreeNode(int value){
        this.value = value;
    }
    
    public static TreeNode createTree(int[] values){
            TreeNode node = new TreeNode(values[0]);
            TreeNode left = new TreeNode(values[1]);
            TreeNode right = new TreeNode(values[2]);
            node.left = left;
            node.right = right;
            TreeNode leftLeft = new TreeNode(values[3]);
            TreeNode leftRight = new TreeNode(values[4]);
            left.left = leftLeft;
            left.right = leftRight;
//            TreeNode rightLeft = new TreeNode(values[5]);
//            TreeNode rightRight = new TreeNode(values[6]);
//            right.left = rightLeft;
//            right.right = rightRight;
//            TreeNode leftLeftLeft = new TreeNode(values[7]);
//            TreeNode leftLeftRight = new TreeNode(values[8]);
//            TreeNode leftRightLeft = new TreeNode(values[9]);    
//            TreeNode leftRightRight = new TreeNode(values[10]);
//            leftLeft.left = leftLeftLeft;
//            leftLeft.right = leftLeftRight;    
//            leftRight.left = leftRightLeft;
//            leftRight.right = leftRightRight;    
            return node;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
