/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowpointer = head;
        ListNode fastpointer = head;
        boolean cycledetected = false;

        if(head == null){
            return null;
        }

        while(fastpointer.next!= null && fastpointer.next.next!=null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;

            if(slowpointer == fastpointer){
                cycledetected = true;
                break;
            }
        }

        if(!cycledetected){
            return null;
        }

        slowpointer = head;

        while(slowpointer != fastpointer){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next;
        }

        return slowpointer;
    }
}