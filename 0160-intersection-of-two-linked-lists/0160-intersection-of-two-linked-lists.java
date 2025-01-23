/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//In case of an interview there is a function down. please provide me that one getIntersectionNode() and not getIntersectionMode2().
public class Solution {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int listALength = 0;
        int listBLength = 0;

        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;

        boolean listALonger = false;

        while(headA != null){
            headA = headA.next;
            listALength++;
        }
        System.out.println(listALength);
        while(headB!= null){
            headB = headB.next;
            listBLength++;
        }

        if(currentNodeA == currentNodeB){
            return currentNodeA;
        }
        
        System.out.println(listBLength);

        if(listALength == listBLength && listALength == 1){
            return null;
        }

        if(listALength > listBLength) 
            listALonger = true;

        if(listALonger){
            while(listBLength != listALength){
                currentNodeA = currentNodeA.next;
                listALength--;
            }
        }else{
            while(listALength != listBLength){
                currentNodeB = currentNodeB.next;
                listBLength--;
            }
        }

        while(currentNodeA != null){
            if(currentNodeA == currentNodeB){
                return currentNodeA;
            }
            currentNodeA = currentNodeA.next;
            currentNodeB = currentNodeB.next;
        }

        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;

        while(currentNodeA != currentNodeB){
            currentNodeA = (currentNodeA == null) ? headB : currentNodeA.next;
            currentNodeB = (currentNodeB == null) ? headA : currentNodeB.next;

        }

        return currentNodeA;
    }
}