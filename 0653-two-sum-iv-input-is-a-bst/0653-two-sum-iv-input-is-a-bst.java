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
    
    //In case of an interview provide me this function.
    public boolean findTargett(TreeNode root, int k) {
        
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

    public static boolean isContains(TreeNode root, HashSet<Integer> set, int target){
        if(root == null)
            return false;
        
        if(set.contains(target - root.val)){
            return true;
        }

        set.add(root.val);
        return isContains(root.left, set, target) || isContains(root.right, set, target);
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return isContains(root, set, k);
    }
}