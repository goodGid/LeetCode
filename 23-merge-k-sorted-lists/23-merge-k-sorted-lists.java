class Solution {
    public ListNode mergeKLists(ListNode[] arrayLists) {

        ListNode ans = new ListNode();
        ListNode head = ans;

        List<ListNode> lists = new ArrayList<>();

        for (ListNode node : arrayLists) {
            if (node != null) {
                lists.add(node);
            }
        }

        while (lists.size() > 0) {
            int minNodeGroupNo = 0;
            int minValue = Integer.MAX_VALUE;
            int size = lists.size();

            for (int i = 0; i < size; i++) {
                int nodeValue = lists.get(i).val;

                if (minValue > nodeValue) {
                    minNodeGroupNo = i;
                    minValue = nodeValue;
                }
            }

            head.next = new ListNode(minValue);
            head = head.next;

            ListNode listNode1 = lists.get(minNodeGroupNo);
            lists.remove(minNodeGroupNo);
            listNode1 = listNode1.next;

            if (listNode1 != null) {
                lists.add(listNode1);
            }
        }

        return ans.next;
    }
}