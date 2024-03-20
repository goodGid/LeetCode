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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode head2 = list2;
        
        while (head2.next != null) {
            head2 = head2.next;
        }
        
        for (int i=0; i<a-1; i++) {
            head = head.next;
        }
        
        ListNode head3 = head;
        
        for (int i=0; i<b-a+2; i++) {
            head3 = head3.next;
        }
        
        head2.next = head3;
        head.next = list2;
        
        return list1;
    }
}