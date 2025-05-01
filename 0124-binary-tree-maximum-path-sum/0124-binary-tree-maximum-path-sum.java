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
        int[] res = new int[1];         // Array to store the result since Java is pass-by-value for primitives
        res[0] = root.val;              // Initialize with the root value (in case all nodes are negative)

        findMax(root, res);             // Start the postorder traversal
        return res[0];                  // Return the maximum path sum found
    }

    // Helper function that returns the max path sum *starting* from current node and going down one side
    public int findMax(TreeNode root, int[] max){
        if (root == null) return 0;     // Base case: null node contributes 0 to path sum

        // Recursively find max path sum from left and right children (ignore negative paths)
        int leftmax = Math.max(0, findMax(root.left, max));     // only consider if > 0
        int rightmax = Math.max(0, findMax(root.right, max));

        // Case 1: Max path through this node (as a "peak"): left + node + right
        max[0] = Math.max(max[0], root.val + leftmax + rightmax);

        // Case 2: Return max path *starting* from this node going downward to one child
        return root.val + Math.max(leftmax, rightmax);
    }
}

//Time Complexity - Every node is visited only once. So the complexity is O(n).
//Space Complexity - Recursive stack space that is O(h).