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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> res = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            res.put(inorder[i], i);
        }

        TreeNode root = generateTree(res, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        return root;
    }

    public TreeNode generateTree(HashMap<Integer, Integer> res, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){

        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int nums = res.get(node.val);
        int numsLeft = nums - inStart;

        node.left = generateTree(res, preorder, inorder, preStart + 1, preStart + numsLeft, inStart, nums - 1);

        node.right = generateTree(res, preorder, inorder, preStart + numsLeft + 1, preEnd, nums + 1, inEnd);

        return node; 

    }
}