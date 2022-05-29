class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode ans = new ListNode();
        ListNode min = ans;
        ListNode maxRoot = new ListNode();
        ListNode max = maxRoot;
        while(head != null){
            if(head.val < x){
                min.next = head;
                min = min.next;
            }else{
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        max.next = null;
        min.next = maxRoot.next;
        return ans.next;
    }
}