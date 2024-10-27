/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("n" + " ");
                continue;
            }
            res.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String values[] = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        if(values[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        q.offer(root);
        for(int i = 1; i < values.length; i++){
            TreeNode node = q.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.offer(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.offer(right);
            }
        }

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));