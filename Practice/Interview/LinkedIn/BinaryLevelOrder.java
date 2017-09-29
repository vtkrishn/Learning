/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null)
            return result;

        q.offer(root);

        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0;i<levelNum;i++){
                TreeNode node = q.peek();
                    if(node.left != null)
                        q.offer(node.left);
                    if(node.right != null)
                        q.offer(node.right);
                    temp.add(q.poll().val);
            }
            result.add(temp);
        }
        return result;
    }
}
