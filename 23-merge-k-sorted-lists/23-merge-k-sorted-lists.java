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
// ref : https://leetcode.com/problems/merge-k-sorted-lists/discuss/1761611/JAVA-multiple-approaches-merge-sort-priority-queue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {return null;}
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {return lists[start];}
        int mid = start + (end - start) / 2;

        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return merge2Lists(left, right);

    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                if (l2.val > l1.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
            }
            curr = curr.next;
        }
        return head.next;
    }
}