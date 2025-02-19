/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        Queue<Node> q = new LinkedList<>();
        if(root != null)
            q.offer(root);
        
        while(!q.isEmpty()){

            int size = q.size();
            Node prev = null;

            for(int i = 0; i < size; i++){
                
                Node temp = q.poll();

                if(prev != null){
                    prev.next = temp;
                }

                prev = temp;

                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            prev.next = null;            
        }

        return root;
    }
}