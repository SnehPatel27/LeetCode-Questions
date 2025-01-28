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
    public int pairSum(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }        

        slowPointer = reverseLinkedList(slowPointer);

        ListNode firstHalf = head;
        ListNode secondHalf = slowPointer;

        int max = Integer.MIN_VALUE;

        while(secondHalf != null){
            max = Math.max(max, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return max;
    }

    public ListNode reverseLinkedList(ListNode head){

        ListNode previous = null;
        ListNode nextNode = null;
        ListNode current = head;

        while(current != null){
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}