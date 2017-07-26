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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        queue.offer(root);
        //int level = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> res = new ArrayList<Integer>();
            //System.out.println(level++);
            while(count > 0){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                count--;
            }
            result.add(0,res);
        }
        return result;
    }
}
