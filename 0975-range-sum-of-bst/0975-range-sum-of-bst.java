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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return findRangeSum(root, low, high);
    }

    public int findRangeSum(TreeNode root, int low, int high){

        if(root == null)
            return 0;
        
        int sum = 0;
        if(root.val >= low && root.val <= high)
            sum += root.val;

        sum += findRangeSum(root.left, low, high);
        sum += findRangeSum(root.right, low, high);

        return sum;
    }
}