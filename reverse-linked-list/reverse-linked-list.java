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
    public ListNode reverseList(ListNode head) {
        
        ListNode l = null;
        ListNode r = null;
        ListNode m = head;
        
        while (m != null) {
            r = m.next;
            m.next = l;
            l = m;
            m = r;
        }
        
        return l;
        
    }
}