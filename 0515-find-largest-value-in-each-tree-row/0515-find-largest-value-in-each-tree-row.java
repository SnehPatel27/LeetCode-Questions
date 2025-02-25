/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //This solution uses BFS
    //Can also be done using DFS
    public List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(root != null)
            q.offer(root);
        
        while(!q.isEmpty()){

            int len = q.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                int val = node.val;
                max = Math.max(val, max);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            result.add(max);
        }
 
        return result;
    }
}