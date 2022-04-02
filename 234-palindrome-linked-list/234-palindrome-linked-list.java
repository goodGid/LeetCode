class Solution {

    boolean ans = true;
    ListNode head;
    
    public boolean isPalindrome(ListNode head) {
        this.head = head;
        solve(head);
        return ans;
    }

    private void solve(ListNode node) {
        if (node == null) {
            return;
        }
        
        solve(node.next);
        int val = node.val;
        check(val);
    }
    
    private void check(int val) {
        if (head.val != val) {
            ans = false;
        } else {
            head = head.next;
        }
    }
}