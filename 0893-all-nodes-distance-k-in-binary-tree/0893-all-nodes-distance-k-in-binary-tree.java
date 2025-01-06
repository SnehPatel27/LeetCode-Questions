/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void checkParents(Map<TreeNode, TreeNode> parents, TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(node.left != null){
                q.offer(node.left);
                parents.put(node.left, node);
            }

            if(node.right != null){
                q.offer(node.right);
                parents.put(node.right, node);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        checkParents(parents, root);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        q.offer(target);
        visited.put(target, true);

        int current_distance = 0;

        while(!q.isEmpty()){

            int q_size = q.size();

            if(current_distance == k) break;
            current_distance++;

            for(int i = 0; i < q_size; i++){

                TreeNode current = q.poll();

                if(current.left != null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left, true);
                }

                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }

                if(parents.get(current) != null && visited.get(parents.get(current)) == null){
                    q.offer(parents.get(current));
                    visited.put(parents.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            result.add(node.val);
        }

        return result;
    }
}