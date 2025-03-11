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
class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int col, int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //TreeMap is taken because I want the node values to be inserted in the increasing manner of column values
        //So for instance the first key in the map would be the one with the least val of col. 
        //If we used hashmap it would store in unsorted manner. 
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tree = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        if(root != null){
            q.offer(new Tuple(root, 0, 0));
        }

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int col = tuple.col;
            int row = tuple.row;

            if(!tree.containsKey(col)){
                tree.put(col, new TreeMap<>());
            }
            if(!tree.get(col).containsKey(row)){
                tree.get(col).put(row, new PriorityQueue<>());
            }
            tree.get(col).get(row).add(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, col - 1, row + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> tm: tree.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq: tm.values()){
                while(!pq.isEmpty()){
                    list.get(list.size() - 1).add(pq.poll());
                }
            }
        } 

        return list;
    }
}