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
    int sum;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode root){
        if(root == null) return -1;
        int lh = dfs(root.left) + 1,rh = dfs(root.right) + 1;
        sum = Math.max(sum, lh+rh);
        return Math.max(lh,rh);
    }
}
