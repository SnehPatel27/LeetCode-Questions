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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;

        while(!q.isEmpty()){
            int s = q.size();

            for(int i = 0; i < s; i++){
                
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                    count++;
                }
                if(curr.right != null){
                    q.offer(curr.right);
                    count++;
                }
            }
        }

        return count;        
    }
}