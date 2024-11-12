/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node current = head;

        Stack<Node> st = new Stack<>();

        while(current != null){
            if(current.child != null){
                if(current.next!=null) st.push(current.next);
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }
            else if(!st.isEmpty() && current.next == null){
                current.next = st.pop();
                if(current.next != null) current.next.prev = current;
            }
            current = current.next;
        }

        return head;
    }
}