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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        ListNode dummy = result;
        int ans = 0;
        int carryover = 0;
        while(l1!=null && l2!=null){
            ans = l1.val + l2.val + carryover;
            System.out.println(ans);
            carryover = 0;
            if(ans < 10){
                dummy.next = new ListNode(ans);
            }else{
                carryover = 1;
                dummy.next = new ListNode(ans%10);
            }
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }   

        while(l1!=null){
            ans = l1.val + 0 + carryover;
            System.out.println(ans);
            carryover = 0;
            if(ans < 10){
                dummy.next = new ListNode(ans);
            }else{
                carryover = 1;
                dummy.next = new ListNode(ans%10);
            }
            dummy = dummy.next;
            l1 = l1.next;
        }

        while(l2!=null){
            ans = 0 + l2.val + carryover;
            System.out.println(ans);
            carryover = 0;
            if(ans < 10){
                dummy.next = new ListNode(ans);
            }else{
                carryover = 1;
                dummy.next = new ListNode(ans%10);
            }
            dummy = dummy.next;
            l2 = l2.next;
        }

        if(carryover == 1){
            dummy.next = new ListNode(1);
        }
        return head.next;
    }
}