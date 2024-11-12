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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastpointer = head;
        ListNode slowpointer = head;

        while(n!=0){
            fastpointer = fastpointer.next;
            n--;
        }

        if(fastpointer==null){
            return head.next;
        }

        while(fastpointer.next!=null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next;
        }

        
        slowpointer.next = slowpointer.next.next;
        

        return head; 
    }
}