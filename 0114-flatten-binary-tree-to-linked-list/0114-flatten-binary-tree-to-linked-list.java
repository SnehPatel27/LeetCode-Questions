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
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<TreeNode> ls = new ArrayList<>();

        if(root != null)
            st.push(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();

            ls.add(node);

            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
        }

        for(int i = 1; i < ls.size(); i++){
            root.left = null;
            root.right = ls.get(i);

            root = root.right;
        }
    }
}