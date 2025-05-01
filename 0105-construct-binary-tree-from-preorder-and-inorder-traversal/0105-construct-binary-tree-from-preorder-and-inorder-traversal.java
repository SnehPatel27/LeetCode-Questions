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

//Initially when we are given a preorder and inorder. We know that the first guy in the preorder is the root and then we try to search that guy in the inorder. We can optimize that search using hashmap. We would store the values of the inorder along with the index in the hashMap so that we can easily search by values. Also the question says that the values can be unique so we can hash. Once we find the index of the root in the inorder traversal. We know that on the left of the root we have the new inorder for the left subtree. And on the right we have the new inorder for the right subtree. Assume there are x elements on the left of the root in the inorder so then we would take the first x elements in the preorder after the root and that would be my preorder for the left subtree and the rest(that would be the next element to the x till the end) would be my preorder for the right subtree. 
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