/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Node, Node> result = new HashMap<>();   
        Node current = head;

        while(current != null){
            result.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        while(current != null){
            result.get(current).next = result.get(current.next);
            result.get(current).random = result.get(current.random);
            current = current.next;
        }

        return result.get(head);
    }
}