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

        System.out.println(node.val);

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

/*
Since Node 1 is not cloned yet, create a clone for Node 1 and put (Node 1 → cloneNode 1) into the result map.

Now move to Node 1's neighbor, which is Node 2.

Since Node 2 is not cloned yet, create a clone for Node 2 and put (Node 2 → cloneNode 2) into the result map.

Now move to Node 2's neighbor, which is Node 1.

Node 1 is already cloned, so just use the clone from the map and add it to cloneNode 2’s neighbors.

Now move to Node 2's other neighbor, which is Node 3.

Since Node 3 is not cloned yet, create a clone for Node 3 and put (Node 3 → cloneNode 3) into the result map.

Now move to Node 3’s neighbor, which is Node 2.

Node 2 is already cloned, so just use the clone from the map and add it to cloneNode 3’s neighbors.

Now move to Node 3’s other neighbor, which is Node 4.

Since Node 4 is not cloned yet, create a clone for Node 4 and put (Node 4 → cloneNode 4) into the result map.

Now move to Node 4's neighbor, which is Node 1.

Node 1 is already cloned, so just use the clone from the map and add it to cloneNode 4’s neighbors.

Now move to Node 4's other neighbor, which is Node 3.

Node 3 is already cloned, so just use the clone from the map and add it to cloneNode 4’s neighbors.

Now all neighbors of Node 4 are processed. Go back to Node 3, add cloneNode 4 to cloneNode 3’s neighbors.

Then go back to Node 2, add cloneNode 3 to cloneNode 2’s neighbors.

Now back to Node 1, after handling Node 2, move to its other neighbor which is Node 4.

Node 4 is already cloned, so just use the clone from the map and add it to cloneNode 1’s neighbors.

Finally, return cloneNode 1. 
*/