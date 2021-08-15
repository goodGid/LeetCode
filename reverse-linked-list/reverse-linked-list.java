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
        
        ListNode first = null;
        ListNode second = null;
        ListNode third = null;
        
        if (head == null) {
            return null;
        }
        first = head;
        
        if (first.next == null) {
            return first;
        }
        second = first.next;
        first.next = null;
        
        if (second.next == null) {
            second.next = first;
            return second;
        }
        third = second.next;
            
        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = second.next;
        }
        
        second.next = first;
        
        ListNode temp = second;
        while (temp != null){
            print(temp);
            temp = temp.next;
        }
        return second;
    }
    
    private void print(ListNode node) {
        if (node == null) {
            System.out.println("=== null ===");
            return ;
        }
        System.out.println(node.val);
    }
}