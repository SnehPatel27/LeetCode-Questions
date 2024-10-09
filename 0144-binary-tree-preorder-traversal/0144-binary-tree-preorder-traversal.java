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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;
        if(root != null){
            st.add(root);
        }

        while(!st.isEmpty()){
            node = st.pop();
            preorder.add(node.val);

            if(node.right != null){
                st.add(node.right);
            }
            if(node.left != null){
                st.add(node.left);
            }
        }
        
        return preorder;
    }
}