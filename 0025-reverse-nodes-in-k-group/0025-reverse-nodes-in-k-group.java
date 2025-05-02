/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //For test case [1,2,3,4,5] and k = 2. Output should be [2,1,4,3,5].
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head; // temp points to head (node 1)
        ListNode kthNode; // to store kth node
        ListNode nextNode; // to store next group start node
        ListNode prevNode = null; // previous group’s tail

        // First iteration
        while (temp != null) {
            kthNode = getKthNode(temp, k); // get 2nd node from temp → node 2
            if (kthNode == null) {
                // If group is smaller than k (not enough nodes), connect remaining as-is
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kthNode.next; // Store node 3 for next round
            kthNode.next = null; // Cut off at node 2 to isolate group [1,2]

            reverse(temp); // Reverse [1,2] → becomes [2,1]

            if (temp == head) {
                head = kthNode; // New head becomes node 2 (start of reversed group)
            } else {
                prevNode.next = kthNode; // Link last node of previous group to start of new
            }

            prevNode = temp; // prevNode is now node 1 (end of reversed group)
            temp = nextNode; // temp = node 3 → start of next group
        }

        return head; // Final reversed list: [2,1,4,3,5]
    }

    public ListNode getKthNode(ListNode temp, int k) {
        ListNode currentNode = temp;
        k--;

        while (k > 0 && currentNode != null) {
            currentNode = currentNode.next;
            k--;
        }

        return currentNode;
    }

    public ListNode reverse(ListNode temp) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode currentNode = temp;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }
}