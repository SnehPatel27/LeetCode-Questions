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

    public boolean isValidBST(TreeNode node) {

        return check(node, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean check(TreeNode node, long min, long max){
        if(node == null) return true;

        else if(node.val <= min || node.val >= max) return false;

        else return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
}