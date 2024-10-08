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
    public boolean isPalindrome(ListNode head) {
        ListNode slowpointer = head;
        ListNode fastpointer = head;

        ListNode start = head;

        while(fastpointer.next != null && fastpointer.next.next != null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
        }

        slowpointer.next = reverse(slowpointer.next);
        slowpointer = slowpointer.next;

        while(slowpointer != null){
            if(slowpointer.val != start.val){
                return false;
            }
            slowpointer = slowpointer.next;
            start = start.next;
        }

        return true;
    }

    public ListNode reverse(ListNode temp){
        ListNode currentNode = temp;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }
}