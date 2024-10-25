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

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.num = num;
        this.node = node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int last = 0;
            int first = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.peek().node;
                int current = q.peek().num - min;
                q.poll();
                if(i == 0) first = current;
                if(i == size - 1) last = current;
                if(node.left!=null) q.offer(new Pair(node.left, current*2 + 1));
                if(node.right!=null) q.offer(new Pair(node.right, current*2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}