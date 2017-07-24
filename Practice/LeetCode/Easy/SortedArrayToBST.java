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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        int mid = nums.length/2;
        TreeNode head = sortedArrayToBST(nums, 0, nums.length-1);
        return head;
    }

    public TreeNode sortedArrayToBST(int[] num, int low, int high){
        if(low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, low, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1,high);
        return node;
    }

}
