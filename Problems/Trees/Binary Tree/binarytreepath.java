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
    StringBuilder s = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root != null)
            searchBT(root,"",list);
        return list;
    }

    public void searchBT(TreeNode root, String path, List list){
        if(root.left == null && root.right==null)
            list.add(path + root.val);
        if(root.left != null) searchBT(root.left,path + root.val + "->",list);
        if(root.right != null) searchBT(root.right,path + root.val + "->",list);
    }
}
