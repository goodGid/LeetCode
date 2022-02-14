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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recur(l1,l2,0);
    }
    
    private ListNode recur(ListNode l1, ListNode l2, int prevSum) {
        if (l1 == null && l2 == null) {
            if (prevSum != 0) {
                return new ListNode(prevSum);
            }
            return null;
        } else if (l1 == null) {
            if (prevSum != 0) {
                l1 = new ListNode(prevSum);
                prevSum = 0;
            } else {
                return l2;
            }
        } else if (l2 == null) {
            if (prevSum != 0) {
                l2 = new ListNode(prevSum);
                prevSum = 0;
            } else {
                return l1;
            }
        }
        
        int sum = l1.val + l2.val + prevSum;
        l1.val = sum % 10;
        l1.next = recur(l1.next, l2.next, sum / 10);
        
        return l1;
    }
}