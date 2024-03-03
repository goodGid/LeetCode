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
        ListNode ans = new ListNode();
        ListNode ptr = ans;
        ListNode sizePtr = head;
        
        int size = 0;
        while (sizePtr != null) {
            size ++;
            sizePtr = sizePtr.next;
        }
        
        // System.out.println(size);
        
        int idx = 0;
        while (head != null) {
            // System.out.println("idx : " + idx);
            if (idx == size - n) {
                
            } else {
                // System.out.println("head : " + head.val);
                ptr.next = new ListNode(head.val);
                ptr = ptr.next;
            }
            idx++;
            head = head.next;
        }
        
        
        return ans.next;
    }
}