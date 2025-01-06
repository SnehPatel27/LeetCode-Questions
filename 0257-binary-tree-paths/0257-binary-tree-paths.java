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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if(root == null) return paths;
        checkPaths(root, paths, "");
        return paths;
    }

    public void checkPaths(TreeNode root, List<String> paths, String path){

        if(root == null) return;
        
        path += root.val;

        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }

        path += "->";

        checkPaths(root.left, paths, path);
        checkPaths(root.right, paths, path);
    }
}