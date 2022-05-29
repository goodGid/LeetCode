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
    public ListNode partition(ListNode head, int x) {
        ListNode ans = new ListNode();
        ListNode min = ans;
        ListNode maxRoot = new ListNode();
        ListNode max = maxRoot;
        
        while (head != null) {
            if (head.val < x) {
                min.next = new ListNode(head.val);
                min = min.next;
            } else {
                max.next = new ListNode(head.val);
                max = max.next;
            }
            head = head.next;
        }
        
        min.next = maxRoot.next;
        
        return ans.next;
    }
}