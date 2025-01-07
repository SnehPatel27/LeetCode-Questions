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

    public void checkParents(TreeNode root, Map<TreeNode, TreeNode> parents){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current = q.poll();

            if(current.left != null){
                q.offer(current.left);
                parents.put(current.left, current);
            }

            if(current.right != null){
                q.offer(current.right);
                parents.put(current.right, current);
            }
        }
    }

    public TreeNode findStartNode(TreeNode root, int start){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.val == start) return node;

            if(node.left != null){
                q.offer(node.left);
            }

            if(node.right != null){
                q.offer(node.right);
            }
        }

        return null;
    }


    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        checkParents(root, parents);

        TreeNode startNode = findStartNode(root, start);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(startNode);
        visited.put(startNode, true);

        int currTime = 0;

        while(!q.isEmpty()){
            
            int qSize = q.size();

            for(int i = 0; i < qSize; i++){
                
                TreeNode current = q.poll();

                if(current.left != null && visited.get(current.left) == null){
                    visited.put(current.left, true);
                    q.offer(current.left);
                }

                if(current.right != null && visited.get(current.right) == null){
                    visited.put(current.right, true);
                    q.offer(current.right);
                }

                if(parents.get(current) != null && visited.get(parents.get(current)) == null){
                    visited.put(parents.get(current), true);
                    q.offer(parents.get(current));
                }
            }

            if(!q.isEmpty()) currTime++;
        }

        return currTime;
    }
}