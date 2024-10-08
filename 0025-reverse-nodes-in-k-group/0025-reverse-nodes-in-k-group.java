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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode kthNode; 
        ListNode nextNode;
        ListNode prevNode = null;

        while(temp != null){
            kthNode = getKthNode(temp, k);

            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode getKthNode(ListNode temp, int k){
        ListNode currentNode = temp;
        k--;

        while(k > 0 && currentNode!=null){
            currentNode = currentNode.next;
            k--;
        }

        return currentNode;
    }

    public ListNode reverse(ListNode temp){
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode currentNode = temp;
        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }
}