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
    public int[] findMode(TreeNode root) {
        
        List<Integer> values = new ArrayList<>();
        dfs(root, values);

        List<Integer> ans = new ArrayList<>();
        int currentStreak = 0;
        int maxStreak = 0;
        int currNum = 0;

        for(int i : values){
            if(i == currNum){
                currentStreak++;
            } else {
                currentStreak = 1;
                currNum = i;
            }

            if(currentStreak > maxStreak){
                maxStreak = currentStreak;
                ans = new ArrayList<>();
            }

            if(currentStreak == maxStreak){
                ans.add(currNum);
            }
        }

        int a[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            a[i] = ans.get(i);
        }

        return a;
    }

    public void dfs(TreeNode root, List<Integer> values){

        if(root == null)
            return;

        dfs(root.left, values);
        values.add(root.val);
        dfs(root.right, values);
    }
}