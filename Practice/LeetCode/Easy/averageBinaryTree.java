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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> result = new ArrayList<Double>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            double value = 0.0;
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                value = value + node.val;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(value/n);
        }
        return result;
    }
}
