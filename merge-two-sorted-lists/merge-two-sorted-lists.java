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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode root = ans;

        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                ans.next = new ListNode(l1.val);
                ans = ans.next;
                ans.next = new ListNode(l2.val);
                ans = ans.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val > l2.val) {
                ans.next = new ListNode(l2.val);
                ans = ans.next;
                l2 = l2.next;
            } else {
                ans.next = new ListNode(l1.val);
                ans = ans.next;
                l1 = l1.next;
            }
        }

        if (l1 == null) {
            ans.next = l2;
        }

        if (l2 == null) {
            ans.next = l1;
        }

        return root.next;
    }
}