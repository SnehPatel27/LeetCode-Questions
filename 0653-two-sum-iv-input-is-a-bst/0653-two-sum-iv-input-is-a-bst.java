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

    public boolean findTarget(TreeNode root, int k) {
        
        Stack<TreeNode> st = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        if(root != null) st.push(root);

        while(!st.isEmpty()){

            TreeNode node = st.pop();

            if(visited.contains(k - node.val))
                return true;

            visited.add(node.val);

            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }

        return false;
    }
}