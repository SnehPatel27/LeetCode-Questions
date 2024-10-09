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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        List<Integer> postorder = new ArrayList<>();

        if(root == null) return postorder;

        TreeNode node;
        st1.add(root);

        while(!st1.empty()){
            node = st1.pop();
            st2.add(node);

            if(node.left != null){
                st1.add(node.left);
            }
            if(node.right != null){
                st1.add(node.right);
            }

        }

        while(!st2.isEmpty()){
            postorder.add(st2.pop().val);
        }

        return postorder;
    }
}