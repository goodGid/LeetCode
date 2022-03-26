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
        ListNode temp = new ListNode();
        temp.next = head;
        
        ListNode node1 = temp;
        ListNode node2 = temp;
        
        for (int i=0; i<n; i++) {
            node2 = node2.next;
        }
        
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        node1.next = node1.next.next;
        
        return temp.next;
    }
}