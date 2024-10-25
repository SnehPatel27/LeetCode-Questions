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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = root.val;
        findMax(root, res);
        return res[0];
    }

    public int findMax(TreeNode root, int[] max){
        if(root == null) return 0;

        int leftmax = Math.max(0, findMax(root.left, max));
        int rightmax = Math.max(0, findMax(root.right, max));

        max[0] = Math.max(max[0], root.val + leftmax + rightmax);

        return (root.val + Math.max(leftmax, rightmax));
    }
}