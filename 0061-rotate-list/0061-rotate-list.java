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
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode current = head;

        int len = 0;

        if(head == null){
            return head;
        }

        while(current!=null){
            current = current.next;
            len++;
        }
        int start = (len - (k % len)); 

        if(k % len == 0) return head;

        current = head;
        
        while(start > 1){
            current = current.next;
            start--;
        }

        ListNode nextNode = current.next;
        ListNode newstart = nextNode;

        while(nextNode.next!=null){
            nextNode = nextNode.next;
        }

        nextNode.next = head;
        current.next = null;

        return newstart;
    }   
}