/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(height(root) == -1)
            return false;
        return true;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh) > 1)
            return -1;
        if(lh == -1 || rh == -1)
            return -1;
        return Math.max(lh,rh) + 1;
    }

}
