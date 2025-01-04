/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Node, Node> result = new HashMap<>();

    public Node cloneGraph(Node node) {
        
        if(node == null)
            return node;

        if (result.containsKey(node))
            return result.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());
        result.put(node, cloneNode);

        for(Node neighbors: node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbors));
        }

        return cloneNode;
    }
}