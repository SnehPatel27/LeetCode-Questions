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
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode dummy = new ListNode();
//         ListNode current = dummy;

//         if(list1 == null){
//             return list2;
//         }
//         if(list2 == null){
//             return list1;
//         }

//         while(list1!=null && list2!=null){
//             if(list1.val <= list2.val){
//                 current.next = list1;
//                 list1 = list1.next;
//                 current = current.next;
//             }else{
//                 current.next = list2;
//                 list2 = list2.next;
//                 current = current.next;
//             }
//         }

//         while(list1!=null){
//             current.next = list1;
//             list1 = list1.next;
//             current = current.next;
//         }
//         while(list2!=null){
//             current.next = list2;
//             list2 = list2.next;
//             current = current.next;
//         }

//         return dummy.next;
//     }
// }
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                result.next = list1;
                result = result.next;
                list1 = list1.next;
            }else{
                result.next = list2;
                result = result.next;
                list2 = list2.next;
            }
        }

        if(list1 != null) result.next = list1;
        else result.next = list2;

        return dummy.next;
   }
}