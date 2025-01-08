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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        int counter = 0;
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else
            {
                if(st.isEmpty()) break;
                else
                {
                    root = st.pop();
                    // inorder.add(root.val);
                    counter++;
                    if(counter == k) return root.val;
                    root = root.right;
                }
            }
        }
        return 0;
        // return inorder.get(k-1);
    }
}