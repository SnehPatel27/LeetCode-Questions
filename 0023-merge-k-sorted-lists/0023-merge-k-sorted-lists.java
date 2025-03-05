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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = new ListNode(0);
        ListNode curr = mergedList;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            new Comparator<ListNode>(){
                @Override
                public int compare(ListNode o1, ListNode o2){
                    if(o1.val > o2.val){
                        return 1;
                    } else return -1;
                }
            }
        );

        for(ListNode node: lists){
            if(node != null)
                pq.offer(node);
        }

        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null)
                pq.offer(curr.next);
        }

        return mergedList.next;
    }
}