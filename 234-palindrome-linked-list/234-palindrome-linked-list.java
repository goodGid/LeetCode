class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true; // [1]
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // [2]
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedNode = reverse(slow.next);

        while (reversedNode != null) {
            if (reversedNode.val == head.val) {
                reversedNode = reversedNode.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode toBeCurrent = slow;
        ListNode toBePrev = null;

        // [3]
        while (toBeCurrent != null) {
            ListNode nextNode = toBeCurrent.next;
            toBeCurrent.next = toBePrev;
            toBePrev = toBeCurrent;
            toBeCurrent = nextNode;
        }
        return toBePrev;
    }
}