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
        ListNode answer = new ListNode();
        ListNode ans = answer;
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        Stack<ListNode> st3 = new Stack<>();
        
        while (l1 != null) {
            st1.add(l1);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            st2.add(l2);
            l2 = l2.next;
        }
        
        int over = 0;
        
        while (!st1.isEmpty() && !st2.isEmpty()) {
            ListNode node1 = st1.pop();
            ListNode node2 = st2.pop();
            
            int sum = node1.val + node2.val + over;
            st3.add(new ListNode(sum % 10));
            over = sum / 10;
        }
        
        while (!st1.isEmpty()) {
            ListNode node1 = st1.pop();
            int sum = node1.val + over;
            st3.add(new ListNode(sum % 10));
            over = sum / 10;
        }
        
        while (!st2.isEmpty()) {
            ListNode node2 = st2.pop();
            int sum = node2.val + over;
            st3.add(new ListNode(sum % 10));
            over = sum / 10;
        }
        
        if (over > 0) {
            st3.add(new ListNode(over));
        }
        
        while (!st3.isEmpty()) {
            ListNode node = st3.pop();
            ans.next = node;
            ans = ans.next;
        }
        
        
        return answer.next;
    }
}