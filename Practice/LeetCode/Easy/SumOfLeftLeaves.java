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
        public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null)
                sum = sum + root.left.val;
            else
                sum = sum + sumOfLeftLeaves(root.left);
        }
        sum = sum + sumOfLeftLeaves(root.right);
        return sum;
    }
}
