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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return head;
        }
    
        ListNode temp = new ListNode();
        temp.next = head;
        head = head.next;
        
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            
            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
            temp = temp.next.next;
        }
        
        
        return head;
        
    }
}