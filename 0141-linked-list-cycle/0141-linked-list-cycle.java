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

    public boolean hasCycle(ListNode head) {

        ListNode slowpointer = head;
        ListNode fastpointer = head;
        while(fastpointer!=null && fastpointer.next!=null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
            if(fastpointer == slowpointer){
                return true;
            }
        }
        return false;
    }
}