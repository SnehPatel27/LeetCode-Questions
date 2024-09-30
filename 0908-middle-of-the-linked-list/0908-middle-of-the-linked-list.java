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
//     public ListNode middleNode(ListNode head) {
//         ListNode currentNode = head;
//         int count = 0;
//         while(currentNode != null){
//             currentNode = currentNode.next;
//             count++;
//         }

//         int middle = count/2;
//         count = 0;
//         currentNode = head;
//         while(count < middle){
//             currentNode = currentNode.next;
//             count++;
//         }

//         return currentNode;
//     }
// }
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
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer.next!=null && fastPointer.next.next!=null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        if(fastPointer.next == null){
            return slowPointer;
        }else{
            return slowPointer.next;
        }
    }
}